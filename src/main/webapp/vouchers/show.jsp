<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<nav>
    <c:out value="${currentUser.name}"></c:out>
    <a href="/users/logout">注销</a>
</nav>
<header>/vouchers/show.jsp</header>
<article>
    <p>
        事件名称: ${voucher.item}
    </p>
    <p>
        金额: ${voucher.account}
    </p>
    <p>
        发票: ${voucher.checkOutStateId}
    </p>
    <p>
        详细信息: ${voucher.voucherDetail.des}
    </p>
</article>

<section>
    <a href="/vouchers/${voucher.id}/edit">edit</a>
    <a href="/vouchers/delete/${voucher.id}">delete</a>
</section>
</body>
</html>
