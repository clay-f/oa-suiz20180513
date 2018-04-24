<%--
  Created by IntelliJ IDEA.
  User: f
  Date: 4/24/18
  Time: 09:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit voucher</title>
</head>
<body>
<header>/vouchers/edit.jsp</header>
${voucher.item}
<section>
    <form method="post" action="/vouchers/${voucher.id}">
        <input type="hidden" name="_method" value="put">
        <input type="submit">
    </form>
</section>
</body>
</html>
