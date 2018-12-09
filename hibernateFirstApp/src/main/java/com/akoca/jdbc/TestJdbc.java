package com.akoca.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {

        String connectionUrl = "jdbc:mysql://localhost:3306/hibernate-one-to-one-uni?useSSL=false&serverTimeZone=UTC";
        String userName = "akocaHibernate";
        String password = "Y40gg.Y4gg0.";

        try {
            Connection conn = DriverManager.getConnection(connectionUrl , userName , password);

            System.out.println("Connection success");

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
