<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <script type ="text/javascript">
            window.onload=function(){
                var typeSelect = document.getElementById("typeSelect");
                typeSelect.onchange = function(){
                    window.location.href="selectCommodity?tid="+this.value;
                }
            }
        </script>
    </head>
    <body>
        ***欢迎进入未来购物系统***<br>
        <select id="typeSelect" name="type">
            <option>====请选择商品类型===</option>
                <c:forEach var="type" items="${sessionScope.allType}">
                    out.write("<option value="${type.getTid()}">${type.getTname()}</option>");
                </c:forEach>"
        </select>
    </body>
</html>
