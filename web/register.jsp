<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/15
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>register</title>
    <script type="text/javascript">
        function register() {
            var username = document.getElementsByName("username")[0];//获得的是数组，需要获得第一个值需要下角标
            var password = document.getElementsByName("password")[0];
            var confirmPsd = document.getElementsByName("confirmPassword")[0];
            if(!username.value){
                alert("用户名不能为空");
                return false
            }
            if(!password.value){
                alert("密码不能为空");
                return false
            }
            if(!confirmPsd.value){
                alert("确认密码不能为空");
                return false
            }
            return true;
        }
    </script>
</head>
<body>
    ${msg}
    <form action="registerServlet" method="post" onsubmit="return register()">
        <table border="1">
            <tr>
                <td>用户名：</td>
                <td>
                    <input type="text" name="username" value="${user.username}"/>
                </td>
            </tr>
            <tr>
                <td>密码：</td>
                <td>
                    <input type="password" name="password" value="${user.password}"/>
                </td>
            </tr>
            <tr>
                <td>确认密码：</td>
                <td>
                    <input type="password" name="confirmPassword"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="注册" onclick="register()">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
