package com.akoca;

import com.akoca.mvc.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudent {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("conf/hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            Student student = session.get(Student.class , 10);
            System.out.println("Got student: " + student);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
