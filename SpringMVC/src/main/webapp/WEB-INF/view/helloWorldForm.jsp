<%--
  Created by IntelliJ IDEA.
  User: ahmet
  Date: 8/19/2018
  Time: 12:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello World Form</title>
</head>
<body>
<!--
    <form action="sendHelloWorldPage" method="get" >
        Name: <input type="text" name="userName"/>
        Surname: <input type="text" name="userSurname"/>
        <i>Send:</i> <input type="submit"/>
    </form>
-->
    <form action="processFormUsingModelUseRequestParam" method="get" >
        Name: <input type="text" name="userName"/>
        Surname: <input type="text" name="userSurname"/>
        <i>Send:</i> <input type="submit"/>
    </form>

</body>
</html>
