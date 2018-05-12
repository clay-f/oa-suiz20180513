<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: f
  Date: 4/24/18
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>new</title>
</head>
<body>
<section>
    <form:form modelAttribute="voucher" action="/vouchers/create">
        <p>
            <label>Item</label>
            <form:input path="item"/>
        </p>
        <p>
            <label>Account</label>
            <form:input path="account"/>
        </p>
        <input type="submit">
    </form:form>
</section>
</body>
</html>
