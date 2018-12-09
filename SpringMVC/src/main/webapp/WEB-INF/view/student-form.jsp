<%--
  Created by IntelliJ IDEA.
  User: ahmet
  Date: 8/19/2018
  Time: 4:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Student Form</title>

        <style>
            .error {
                color: red;
                background-color: black;
                border-radius: 5px;
                border-color: blue;
                border-style: solid;
            }
        </style>
    </head>

    <body>
        <form:form action="processStudentForm" modelAttribute="theStudent">

            First Name: <form:input path="firstName"/>
            <br><br>

            Last Name: <form:input path="lastName"/>
            <br><br>

            Country:
            <form:select path="country">
                <!--changed-->
                <form:options items="${theCountryOptions}" />
            </form:select>
            <br><br>

            Favorite Language:
                Java <form:radiobutton path="favoriteLanguage" value="Java"/>
                PHP <form:radiobutton path="favoriteLanguage" value="PHP" />
                C# <form:radiobutton path="favoriteLanguage" value="C#" />
                Ruby <form:radiobutton path="favoriteLanguage" value="Ruby" />
            <br><br>

            Operating Systems:
            <form:checkboxes items="${theOSOptions}" path="operatingSystems" />
            <br><br>

            Course Code:
            <form:input path="courseCode" />
            <form:errors path="courseCode" cssClass="error" />
            <br><br>

            Send: <input type="submit" value="Submit"/>
        </form:form>

    </body>
</html>
