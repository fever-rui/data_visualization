<%--
  Created by IntelliJ IDEA.
  User: fever
  Date: 2017/3/15
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World! test</h2>
<c:forEach items="${users}" var="user">
    ${user.id}: ${user.name}<br/>
</c:forEach>
</body>
</html>