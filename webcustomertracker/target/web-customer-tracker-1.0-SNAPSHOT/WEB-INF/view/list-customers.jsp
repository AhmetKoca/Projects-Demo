<%--
  Created by IntelliJ IDEA.
  User: ahmet
  Date: 8/26/2018
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Customer List</title>

        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

    </head>
    <body>
        Csutomer List

        <div id="wrapper">
            <div id="header">
                <h1>This is the header</h1>
            </div>

            <div id="container">
                <div id="content">

                    <input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false"
                    class="add-button"/>

                    <table>
                        <tr>
                            <th>First name</th>
                            <th>Last name</th>
                            <th>Email</th>
                            <th>Action</th>
                        </tr>

                        <c:forEach var="tempCust" items="${customers}">
                            <c:url var="updateLink" value = "/customer/showFormForUpdate">
                                <c:param name="customerID" value="${tempCust.id}"/>
                            </c:url>

                            <c:url var="deleteLink" value="/customer/deleteCustomer">
                                <c:param name="customerID" value="${tempCust.id}"/>
                            </c:url>
                            <tr>
                                <td>${tempCust.firstName}</td>
                                <td>${tempCust.lastName}</td>
                                <td>${tempCust.email}</td>
                                <td>
                                    <a href="${updateLink}">Update</a>
                                    |
                                    <a href="${deleteLink}"
                                        onclick="var del;
                                                del = confirm('Are you sure to delete');
                                                return del;"
                                    > Delete </a>
                                </td>

                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
