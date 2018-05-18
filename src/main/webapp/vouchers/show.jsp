<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>show voucher</title>
</head>
<body>
<header>/vouchers/show.jsp</header>
<article>
    <p>
        事件名称: ${voucher.item}
    </p>
    <p>
        金额: ${voucher.account}
    </p>
    <p>
        报销状态:
        <c:choose>
            <c:when test="${voucher.checkOutStateId == 2}">
                未报销
            </c:when>
            <c:otherwise>
                已报销
            </c:otherwise>
        </c:choose>
    </p>
    <p>
        审批状态:
        <c:choose>
            <c:when test="${voucher.checkResult.stateId == 2}">
                未通过
            </c:when>
            <c:otherwise>
                通过
            </c:otherwise>
        </c:choose>
    </p>
    <details>
        <p>
            详细信息: ${voucher.voucherDetail.des}
        </p>
    </details>
</article>

<section>
    <a href="/vouchers/${voucher.id}/edit">edit</a>
    <a href="/vouchers/delete/${voucher.id}">delete</a>
</section>
</body>
</html>
