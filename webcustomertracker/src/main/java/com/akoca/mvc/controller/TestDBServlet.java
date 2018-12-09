package com.akoca.mvc.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/TestDB")
public class TestDBServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        String userID = "akocaHibernate";
        String password = "Y40gg.Y4gg0.";
        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";

        String driver = "com.mysql.cj.jdbc.Driver";

        Connection conn;

        try {
            PrintWriter out = response.getWriter();

            out.println("Connecting to: " + jdbcUrl);

            Class.forName(driver);

            conn = DriverManager.getConnection(jdbcUrl , userID , password);

            out.println("Conn success");

            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
