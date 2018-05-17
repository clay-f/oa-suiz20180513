<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>voucher index</title>
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
        <th>state</th>
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
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>