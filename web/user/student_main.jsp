<%--
  Created by IntelliJ IDEA.
  User: rnjsw
  Date: 2017-10-14
  Time: 오후 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>이의제기 상태확인</title>
</head>
<body>
<table>
    <tr>
        <th width="70%">강의제목</th>
        <th width="30%">상태</th>
    </tr>
    <c:forEach var="objection" items="${objectionList}">
        <tr>
            <td>${objection.subject_name}</td>
            <td>${objection.detail_status}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
