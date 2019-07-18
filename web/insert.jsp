<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/17
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>GoodsinfoInsert</title>
</head>
<body>
    <form action="goodsinfoInsertServlet" method="post">
        <input type="hidden" name="id"/>
        <table border="1">
            <tr>
                <td>商品名称</td>
                <td><input type="text" name="goodsinfoName" /></td>
            </tr>
            <tr>
                <td>商品图片</td>
                <td><input type="file" name="goodsinfoPic" /></td>
            </tr>
            <tr>
                <td>商品价格</td>
                <td><input type="text" name="goodsinfoPrice" /></td>
            </tr>
            <tr>
                <td>商品详细信息</td>
                <td><input type="text" name="goodsinfoDescription" /></td>
            </tr>
            <tr>
                <td>商品库存</td>
                <td><input type="text" name="goodsinfoStock" /></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center"><input type="submit" value="保存"/></td>
            </tr>
        </table>
    </form>
</body>
</html>
