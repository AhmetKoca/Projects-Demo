package com.akoca;

import com.akoca.mvc.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class OneToOneCreate {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("conf/hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(InstructorDetails.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        Session session = sessionFactory.getCurrentSession();

        try {
            int id = 1;
            int detailsID = 2;

            session.beginTransaction();

            Student student = session.get(Student.class , id);

            session.delete(student);

            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
