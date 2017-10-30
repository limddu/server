<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2017-10-18
  Time: 오후 4:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>로그인</title>
    <script type="text/javascript" src="../script/user.js"></script>
</head>
<body>
<h2>로그인</h2>
<form action="/manage.do" method="post" name="frm">
    <input type="hidden" name="command" value="login">
    <table>
        <tr>
            <td>아이디: </td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td>비밀번호: </td>
            <td><input type="password" name="pwd"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="로그인" onclick="return loginCheck()">&nbsp;&nbsp;
                <input type="reset" value="취소">&nbsp;&nbsp;
            </td>
        </tr>
        <tr>
            <td colspan="2">${msg}</td>
        </tr>
    </table>
</form>
</body>
</html>
