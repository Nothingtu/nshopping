<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>

        <style type="text/css">
            td{text-align: center}
        </style>
        <script type="text/javascript">
            window.onload=function(){
                var buttonElements = document.getElementsByClassName("button");
                for(var i =0;i<buttonElements.length;i++){
                    buttonElements[i].onclick=function(){
                        var hiddenElement = document.getElementById("hidden");
                        hiddenElement.value=this.value;
                        var formElement = document.getElementById("form");
                        formElement.submit();
                    }
                }
            }
        </script>
    </head>
    <body>

        <form id="form" action="shoppingCar" method="post">
            <input id="hidden" type ="hidden" name="flag" value="">
            <table border="1" align="center" width="60%"height="60%">
                <tr>
                    <th></th><th>商品名称</th><th>商品单价</th>
                </tr>
                <c:forEach var="commodity" items="${requestScope.commodityList}">
                    <tr>
                        <td><input type="checkbox" name="result" value="${commodity.getCid()}"></td>
                        <td>${commodity.getCname()}</td>
                        <td>${commodity.getCprice()}</td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="3">
                        <input class="button" value="继续购物" style="text-align:center">

                        <input class="button" value="结算清单" style="text-align:center" >
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
