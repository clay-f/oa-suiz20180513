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
<nav>
    <c:out value="${currentUser.name}"></c:out>
    <a href="/users/logout">注销</a>
</nav>
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
        <p>
            <label>Detail</label>
            <form:input path="voucherDetailService.des"/>
        </p>
        <input type="submit">
    </form:form>
</section>
</body>
</html>
