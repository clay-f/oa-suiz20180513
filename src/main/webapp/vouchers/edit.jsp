<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>edit voucher</title>

</head>
<body>
<jsp:include page="/public/navbar.jsp"/>
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
        <c:if test="${currentUser.oaPositionId == 4}">
            报销状态 <form:input path="checkOutStateId"/>
            <blockquote>(1: 同意, 2: 不同意)</blockquote>
        </c:if>
        </p>
        <p>
            审批状态
            <c:choose>
            <c:when test="${currentUser.oaPositionId == 2 || currentUser.oaPositionId == 3}">
                <form:input path="checkResult.stateId"/>
            </c:when>
            <c:otherwise>
                <form:input path="checkResult.stateId" readonly="true"/>
            </c:otherwise>
            </c:choose>
        <blockquote>(1: 通过, 2: 不通过)</blockquote>
        </p>
        <p>
            <label for="detail">详细信息</label>
            <form:input path="voucherDetail.des" id="detail"/>
        </p>
        <input type="submit" value="更新发票" class="btn btn-success">
    </form:form>
</section>
</body>
</html>
