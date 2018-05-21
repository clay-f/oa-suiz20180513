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
<jsp:include page="/public/navbar.jsp"/>
<section>
    <form:form method="post" action="/users/doRegister" modelAttribute="user">
        <form:label path="name">Name</form:label>
        <form:input path="name" id="name" required="true"/>
        <br>
        <form:label path="passwd">Password</form:label>
        <form:password path="passwd" id="passwd" required="true"/>
        <br>
        <form:select path="oaPositionId">
            <form:options items="${oaList}" itemValue="id" itemLabel="name"/>
        </form:select>
        <br>
        <form:select path="departmentId" items="${departmentList}" itemValue="id" itemLabel="name"/>
        <br>
        <input type="submit" value="register">
    </form:form>
</section>
<jsp:include page="/public/footer.jsp"/>
<script>
    toastr.info("please register before login");
</script>
</body>
</html>