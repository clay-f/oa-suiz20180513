<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<nav>
    <c:out value="${currentUser.name}"></c:out>
    <a href="/users/logout">注销</a>
</nav>
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
        <c:if test="${currentUser.oaPositionId == 2 || currentUser.oaPositionId == 3}">
            <form:input path="checkResult.stateId"/>
        </c:if>
        <p>
            <label for="detail">详细信息</label>
            <form:input path="voucherDetail.des" id="detail"/>
        </p>
        <input type="submit" value="更新发票">
    </form:form>
</section>
</body>
</html>
