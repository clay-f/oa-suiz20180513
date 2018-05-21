<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="/users/index">users<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/vouchers/index">vouchers</a>
            </li>
            <c:if test="${currentUser != null}">
                <li class="nav-item">
                    <a href="#" class="nav-link">${currentUser.name}</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/users/logout">logout</a>
                </li>
            </c:if>
        </ul>
    </div>
</nav>