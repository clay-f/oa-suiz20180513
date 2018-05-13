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
        <p>
            <label for="item">事件名称:</label>
            <form:input path="item" id="item"/>
        </p>
        <p>
            <label for="account">金额</label>
            <form:input path="account" id="account"/>
        </p>
        <p>
            <label for="checkout_state">发票检查状态:</label>
            <form:input path="checkOutStateId" id="checkout_state" readonly="true"/>
        </p>
        <input type="submit" value="更新发票">
    </form:form>
</section>
</body>
</html>
