
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <style>
        #demo2
        {
            margin-left: 10px;
            margin-top : 10px;
            margin-right: auto;
            margin-bottom: 30px;
        }
    </style>
    <script language="JavaScript" >
        function fun(){
            var name = document.getElementById("name")
            var username=document.getElementById("username");
            var password=document.getElementById("password");
            var cnf_password=document.getElementById("cnf_password");
            if(name.value=="" || username.value=="" || password.value=="" || cnf_password.value==""){
                alert("Fields can't be left blank");
                return false;
            }
            if(password.value!= cnf_password.value){
                alert("Passwords don't match");
                return false;
            }

        }
    </script>
</head>
<body>
<form action="register.html" method="post" onsubmit="return fun()">
    <table>
        <tr>
            <td>
                Name:
            </td>
            <td>
                <input type="text" name="Name" id="name">
            </td>
        </tr>
        <tr>
            <td>
                Username :
            </td>
            <td>
                <input type="text" name="Username" id="username">
            </td>
        </tr>
        <tr>
            <td>
                Password :
            </td>
            <td>
                <input type="password" name="Password" id="password">
            </td>
        </tr>
        <tr>
            <td>
                Confirm Password :
            </td>
            <td>
                <input type="password" name="Confirm_Password" id="cnf_password">
            </td>
        </tr>
    </table>
    <input type="submit" value="Register"><br>
</form>

</body>
</html>
