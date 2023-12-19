<%--
  Created by IntelliJ IDEA.
  User: peter
  Date: 2023-12-19
  Time: PM 1:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Form Tag</title>
</head>
<body>
    <h3>회원가입</h3>
    <form:form modelAttribute="member" method="post">
        <p>아이디 : <form:input path="id" name="id"/> </p>
        <p>비밀번호 : <form:input path="password" name="password"/> </p>
        <p>거주지 : <form:select path="city" />
        </p>


    </form:form>
</body>
</html>
