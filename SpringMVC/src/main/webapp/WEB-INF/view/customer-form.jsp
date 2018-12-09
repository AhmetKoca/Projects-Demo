<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  Date: 8/20/2018
  Time: 11:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Customer Form</title>

        <style>
            .error {
                color: red;
                background-color: black;
                border-radius: 5px;
                border-color: blue;
                border-style: solid;
            }
        </style>
<!--
        This does not work , FIX IT
        <link type="text/css" rel="stylesheet" href="../../resources/ErrorAttributes.css">
-->
    </head>
    <body>

        Fill the form please:

        <form:form action="processCustomerForm" modelAttribute="theCustomer">

            First Name: <form:input path="firstName" />
            <br><br>

            Last Name:(*) <form:input path="lastName" />
            <form:errors path="lastName" cssClass="error"/>
            <br><br>

            Free Passes: <form:input path="freePasses" />
            <form:errors path="freePasses" cssClass="error" />
            <br><br>

            Postal Code: <form:input path="postalCode" />
            <form:errors path="postalCode" cssClass="error" />
            <br><br>

            Send: <input type="submit" value="Submit" />
        </form:form>
    </body>
</html>
