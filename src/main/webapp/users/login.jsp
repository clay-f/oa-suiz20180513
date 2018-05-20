<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>register</title>
    <jsp:include page="/public/head.jsp"/>
</head>
<body>
<section>
    <p>${message}</p>
</section>
<section>
    <form:form action="/users/doLogin" method="post" modelAttribute="user">
        Name:
        <form:input path="name" required="true"/>
        <br>
        Password:
        <form:password path="passwd" required="true"/>
        <br>
        <input type="submit" value="login">
    </form:form>
</section>
<jsp:include page="/public/footer.jsp"/>
</body>
</html>