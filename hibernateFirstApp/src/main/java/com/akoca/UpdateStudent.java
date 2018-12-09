package com.akoca;

import com.akoca.mvc.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudent {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("conf/hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            int studentID = 8;

            session.beginTransaction();

            Student student = session.get(Student.class , studentID);
            student.setLastName("updated");

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
