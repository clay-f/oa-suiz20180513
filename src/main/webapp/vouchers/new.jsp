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
    <title>new</title>
    <jsp:include page="/public/head.jsp"/>
</head>
<body>
<nav>
    <c:out value="${currentUser.name}"></c:out>
    <a href="/users/logout">注销</a>
</nav>
<section>
    <form:form modelAttribute="voucher" action="/vouchers/create">
        <div class="form-group">
            <label>Item</label>
            <form:input path="item" cssClass="form-control"/>
        </div>
        <div class="form-group">
            <label>Account</label>
            <form:input path="account"/>
        </div>
        <div class="form-group">
            <label>Detail</label>
            <form:input path="voucherDetail.des"/>
        </div>
        <input type="submit">
    </form:form>
</section>
<jsp:include page="/public/footer.jsp"/>
</body>
</html>