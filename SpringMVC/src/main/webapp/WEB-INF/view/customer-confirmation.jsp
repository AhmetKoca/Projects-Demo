<%--
  Created by IntelliJ IDEA.
  User: ahmet
  Date: 8/21/2018
  Time: 12:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Customer Confirmation</title>
    </head>
    <body>
        The Customer First Name: ${theCustomer.firstName}
        <br><br>
        The Customer Last Name: ${theCustomer.lastName}
        <br><br>
        The Customer Free Passes: ${theCustomer.freePasses}
        <br><br>
        The Customer Postal Code: ${theCustomer.postalCode}
    </body>
</html>
