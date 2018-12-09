<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ahmet
  Date: 8/28/2018
  Time: 12:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Customer Form</title>

        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
    </head>
    <body>
        <div id="wrapper">
            <div id="container">

                <form:form action="saveCustomer" modelAttribute="theCustomer" method="post">

                    <form:hidden path="id"/>
                    <table>
                        <tbody>
                            <tr>
                                <td><label>First name</label></td>
                                <td><form:input path="firstName"/></td>
                            </tr>

                            <tr>
                                <td><label>Last name</label></td>
                                <td><form:input path="lastName"/></td>
                            </tr>

                            <tr>
                                <td><label>email</label></td>
                                <td><form:input path="email"/></td>
                            </tr>

                            <tr>
                                <td><input type="submit" value="Save" class="save"/></td>
                            </tr>
                        </tbody>
                    </table>
                </form:form>

                <p>
                    <a href="${pageContext.request.contextPath}/customer/list">Back to list</a>
                </p>
            </div>
        </div>
    </body>
</html>
