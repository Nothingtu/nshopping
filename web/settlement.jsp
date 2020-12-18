<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
         <form  action="" method="">
            <table border="1" align="center" width="60%"height="60%">
                <tr>
                    <th>商品名称</th><th>商品单价</th>
                </tr>
                <c:forEach var="commodity" items="${sessionScope.shoppingCar}">
                    <tr>
                        <td>${commodity.getCname()}</td>
                        <td>${commodity.getCprice()}</td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="2">
                        <input class="button" value="确认结算" style="text-align:center">
                        ：${sessionScope.sumPrice}元
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
