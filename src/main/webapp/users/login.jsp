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
<div class="container">
    <section>
        <form action="/users/doLogin" method="post">
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" id="name"  name="name" class="form-control" required/>
            </div>
            <div class="form-group">
                <label for="passwd">Password</label>
                <input type="password" id="passwd" name="passwd" class="form-control" required/>
            </div>
            <input type="submit" value="login" class="btn btn-primary">
        </form>
    </section>
</div>
<jsp:include page="/public/footer.jsp"/>
</body>
</html>