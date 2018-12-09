<%--
  Created by IntelliJ IDEA.
  Date: 8/19/2018
  Time: 4:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Student Confirmation</title>
    </head>
    <body>
        The student is confirmed: ${theStudent.firstName} ${theStudent.lastName}
        <br><br>
        Country of student: ${theStudent.country}
        <br><br>
        Favorite language: ${theStudent.favoriteLanguage}
        <br><br>
        Operating Systems:
        <ul>
            <c:forEach var="temp" items="${theStudent.operatingSystems}">

                <li>${temp}</li>
            </c:forEach>
        </ul>

        Course Code: ${theStudent.courseCode}
        <br><br>
    </body>
</html>
