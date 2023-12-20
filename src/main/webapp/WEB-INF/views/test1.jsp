<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix='form' uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

<%--<form:form modelAttribute="dataBean" action='result'>
    <form:select path="a1">
        <form:option value="data1">항목1</form:option>
        <form:option value="data2">항목2</form:option>
        <form:option value="data3">항목3</form:option>
    </form:select>
</form:form>--%>

<%--<form:form modelAttribute="dataBean" action='result'>
    <form:select path="a1">
        <form:options items="${requestScope.data_list1}"/>
    </form:select>
</form:form>--%>



<form:form modelAttribute="dataBean" action='result'>
    <form:checkbox path="a5" value="data1"/> 항목1
    <form:checkbox path="a5" value="data2"/> 항목2
    <form:checkbox path="a5" value="data3"/> 항목3
</form:form>

</body>
</html>