<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <style type="text/css" >
          td{text-align: center}
      </style>
  </head>
  <body>
    <c:if test="${sessionScope.result !=null}">
        ${sessionScope.result}
    </c:if>
    <form action="login" method="post">
        请输入账号：<input type="text" name="uname" value=""><br>
        请输入密码：<input type="password" name="upassword" value=""><br>
        <input type="submit" value="登录">
    </form>

  </body>
</html>
