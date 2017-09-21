<%-- 
    Document   : login
    Created on : Sep 21, 2017, 2:07:12 PM
    Author     : 677571
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="post">
            Username: <input type="text" name="username"><br>
            Password: <input type ="password" name="password"><br>
            <input type="submit" value="Login">
        </form>
        ${returnMessage}
    </body>
</html>
