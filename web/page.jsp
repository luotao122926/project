<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/16
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function Update(goodsinfoName){
            window.location.href="goodsinfoLoadDataServlet?goodsinfoName=" + goodsinfoName;
        }
    </script>
</head>
<body>
<a href="#">添加</a>
        <table border="1">
            <thead>
                <tr>
                    <th>商品名字</th>
                    <th>商品图片</th>
                    <th>商品价格</th>
                    <th>商品简介</th>
                    <th>商品库存</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="goodsinfo" varStatus="s">
                    <tr>
                        <td>${goodsinfo.goodsinfoName}</td>
                        <td>${goodsinfo.goodsinfoPic}</td>
                        <td>${goodsinfo.goodsinfoPrice}</td>
                        <td>${goodsinfo.goodsinfoDescription}</td>
                        <td>${goodsinfo.goodsinfoStock}</td>
                        <td>
                            <input type="submit" value="修改" onclick="Update('${goodsinfo.goodsinfoName}')"/>
                            <input type="submit" value="删除"/>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
</body>
</html>
