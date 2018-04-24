<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: f
  Date: 4/24/18
  Time: 09:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>show voucher</title>
</head>
<body>
<header>/vouchers/show.jsp</header>
<main>
    <p>
        ${voucher.item}
        ${voucher.account}
        ${voucher.checkOutStateId}
    </p>
</main>

<section>
    <a href="/vouchers/${voucher.id}/edit">edit</a>
    <a href="/vouchers/delete/${voucher.id}">delete</a>
</section>
</body>
</html>
