<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <jsp:include page="/public/head.jsp"/>
    <title>voucher index</title>
</head>
<body>
<jsp:include page="/public/navbar.jsp"/>
<table class="table">
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">事项</th>
        <th scope="col">价格</th>
        <th scope="col">报销状态</th>
        <th scope="col">批准状态</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${voucherList}" var="item">
        <tr scope="row">
            <td><a href="/vouchers/<c:out value="${item.id}"/>"><c:out value="${item.id}"/></a></td>
            <td><c:out value="${item.item}"/></td>
            <td><c:out value="${item.account} "/></td>
            <td>
                <c:choose>
                    <c:when test="${item.checkOutStateId == 2}">
                        <i class="fas fa-times"></i>
                    </c:when>
                    <c:otherwise><i class="fas fa-check"></i></c:otherwise>
                </c:choose>
            </td>
            <td>
                <c:choose>
                    <c:when test="${item.checkResult.stateId == 2}">
                        <i class="fas fa-times"></i>
                    </c:when>
                    <c:otherwise><i class="fas fa-check"></i></c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<jsp:include page="/public/footer.jsp"/>
<script>
    {
        var search_val = location.search.split();
        if (search_val.length > 0 && parseInt(search_val[0].split('=')[1]) == 1) {
            toastr.success("login success", "welcome jboa");
        }
    }
</script>
</body>
</html>