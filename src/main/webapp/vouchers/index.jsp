<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <jsp:include page="/public/head.jsp"/>
    <title>voucher index</title>
    <jsp:include page="/public/head.jsp"/>
</head>
<body>
<nav>
    <c:out value="${currentUser.name}"></c:out>
    <a href="/users/logout">注销</a>
</nav>
<table>
    <thead>
    <tr>
        <th>id</th>
        <th>item</th>
        <th>account</th>
        <th>报销状态</th>
        <th>批准状态</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${voucherList}" var="item">
        <tr>
            <td><a href="/vouchers/<c:out value="${item.id}"/>"><c:out value="${item.id}"/></a></td>
            <td><c:out value="${item.item}"/></td>
            <td><c:out value="${item.account} "/></td>
            <td>
                <c:choose>
                    <c:when test="${item.checkOutStateId == 2}">
                        false
                    </c:when>
                    <c:otherwise>true</c:otherwise>
                </c:choose>
            </td>
            <td>
                <c:choose>
                    <c:when test="${item.checkResult.stateId == 2}">
                        false
                    </c:when>
                    <c:otherwise>true</c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<jsp:include page="/public/footer.jsp"/>
</body>
</html>