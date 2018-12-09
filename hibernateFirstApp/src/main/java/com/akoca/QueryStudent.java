package com.akoca;

import com.akoca.mvc.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudent {

    public static void main(String[] args) {

        List<Student> students = null;
        String queryStr = "from com.akoca.mvc.entity.Student s where s.email like '%@email.com'";
        SessionFactory factory = new Configuration()
                .configure("conf/hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            students = session.createQuery(queryStr , Student.class).getResultList();

            session.getTransaction().commit();
        } finally {
            factory.close();

            if(null != students) {
                for (Student s : students) {
                    System.out.println("Student is: " + s);
                }
            }
        }
    }
}
