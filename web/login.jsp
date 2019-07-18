<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/15
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>login</title>
    <script type="text/javascript">
        function verification(){
            var username = document.getElementsByName("username")[0];
            var password = document.getElementsByName("password")[0];
            if(username.value == null || "" == username.value) {
                alert("账户不能为空");
                return false
            }
            else if(password.value == null || "" == password.value){
                alert("密码不能为空");
                return false
            }else{
                return true
            }
        }
        function register(){
            window.location.href="register.jsp";
        }
    </script>
</head>
<body>
    ${msg}
    <form action="loginServlet" method="post" onsubmit="return verification()">
        <table border="1">
            <tr>
                <td>用户名:</td>
                <td>
                    <input type="text" name="username" value="${user.username}">
                </td>
            </tr>
            <tr>
                <td>密码:</td>
                <td>
                    <input type="password" name="password" value="${user.password}">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="登录">&nbsp
                    <input type="button" value="注册" onclick="register()">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
