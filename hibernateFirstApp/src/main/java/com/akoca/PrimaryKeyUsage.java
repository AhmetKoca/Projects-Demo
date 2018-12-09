package com.akoca;

import com.akoca.mvc.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyUsage {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("conf/hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student student1 = new Student("Akoca1" , "Koca1" , "some1@email.com");
            Student student2 = new Student("Akoca2" , "Koca2" , "some2@email.com");
            Student student3 = new Student("Akoca3" , "Koca3" , "some3@email.com");
            Student student4 = new Student("Akoca4" , "Koca4" , "some4@email.com");
            Student student5 = new Student("Akoca5" , "Koca5" , "some5@email.com");

            session.beginTransaction();

            session.save(student1);
            session.save(student2);
            session.save(student3);
            session.save(student4);
            session.save(student5);

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
