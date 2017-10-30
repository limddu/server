<%--
  Created by IntelliJ IDEA.
  User: rnjsw
  Date: 2017-10-14
  Time: 오후 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>강의목록</title>
</head>
<body>
<h1>강의목록</h1>
<table>
    <c:forEach var="course" items="${course_list}">
        ${course.name}
    </c:forEach>
</table>
</body>
</html>
