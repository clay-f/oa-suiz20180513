<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: f
  Date: 4/24/18
  Time: 09:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit voucher</title>
</head>
<body>
<header>/vouchers/edit.jsp</header>
<section>
    <form:form action="/vouchers/${voucher.id}" modelAttribute="voucher">
        <input type="hidden" name="_method" value="put">
        Item
        <form:input path="item"/>
        <br>
        Account
        <form:input path="account"/>
        <input type="submit">
    </form:form>
</section>
</body>
</html>
