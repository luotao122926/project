<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/17
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>goodsinfoUpdate</title>
</head>
<body>
<form action="goodsinfoUpdateServlet" method="post">
    <input type="hidden" name="id" value="${id}"/>
    <table border="1">
        <tr>
            <td>商品名称</td>
            <td><input type="text" name="goodsinfoName" value="${goodsinfo.goodsinfoName}"/></td>
        </tr>
        <tr>
            <td>商品图片</td>
            <td><input type="text" name="goodsinfoPic" value="${goodsinfo.goodsinfoPic}"/></td>
        </tr>
        <tr>
            <td>商品价格</td>
            <td><input type="text" name="goodsinfoPrice" value="${goodsinfo.goodsinfoPrice}"/></td>
        </tr>
        <tr>
            <td>商品详细信息</td>
            <td><input type="text" name="goodsinfoDescription" value="${goodsinfo.goodsinfoDescription}"/></td>
        </tr>
        <tr>
            <td>商品库存</td>
            <td><input type="text" name="goodsinfoStock" value="${goodsinfo.goodsinfoStock}"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="保存"/></td>
        </tr>
    </table>
</form>
</body>
</html>
