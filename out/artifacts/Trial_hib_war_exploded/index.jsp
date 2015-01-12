<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <h1 align="center"> Welcome to login/signup module </h1>
    <style>
        #demo
        {
            margin-left: 550px;
            margin-top : 100px;
            margin-right: auto;
            margin-bottom: 30px;
        }
    </style>
</head>
<body>
<div id="demo">
    <form action="login.html" method="post">

        Username <br>
        <input type ="text" name="username"><br>
        Password <br>
        <input type ="password" name ="password"><br>
        <br>
        <input type="submit" value="Login">
        <a align="center" href="signup.jsp">   Register </a>
    </form>
</div>
</body>
</html>
