<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>users index</title>
    <jsp:include page="/public/head.jsp"/>
</head>
<body>
<nav>
    <c:out value="${currentUser.name}"></c:out>
    <a href="/users/logout">注销</a>
</nav>
<p>welcome users index.jsp</p>
<ul>
    <c:forEach var="item" items="${userList}">
        <li><c:out value="${item.name}"/></li>
    </c:forEach>
</ul>
${message}
<jsp:include page="/public/footer.jsp"/>
</body>
</html>