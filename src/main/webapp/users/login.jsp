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
<div class="container">
    <section>
        <form:form action="/users/doLogin" method="post" modelAttribute="user">
            <div class="form-group">
                <label for="name">Name</label>
                <form:input path="name" required="true" id="name" cssClass="form-control"/>
            </div>
            <div class="form-group">
                <label for="passwd">Password</label>
                <form:password path="passwd" required="true" id="passwd" cssClass="form-control"/>
            </div>
            <input type="submit" value="login" class="btn btn-primary">
        </form:form>
    </section>
</div>
<jsp:include page="/public/footer.jsp"/>
<script>

</script>
</body>
</html>