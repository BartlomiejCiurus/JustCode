<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>JustCode Login Page</title>
    <link rel="stylesheet" type="text/css" href="../../assets/css/main.css"/>
    <link rel="stylesheet" type="text/css" href="../../assets/css/login.css"/>
</head>

<body onload='document.loginForm.username.focus();'>
<div class="body"></div>
<div class="grad"></div>
<div class="login" style="transform: translate(-50%, -150%);">
    <form name="loginForm" action="/login" method="POST">
        <img style="margin-bottom: 15px" width="290px" src="../../assets/images/logo.png">
        <c:if test="${not empty errorMessage}">
            <span style="display: flex" class="errorBlock"><spring:message code="errors.bad.credentials"/></span>
        </c:if>
        <input type="text" placeholder="<spring:message code="placeholder.username"/>" name="username"/>
        <input type="password" placeholder="<spring:message code="placeholder.password"/>" name="password"/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="<spring:message code="placeholder.login"/>" class="loginBut"/>
    </form>
    <form action="<c:url value="/register.html"/>" method="get">
        <input style="margin-top: 0 !important;" type="submit" value="<spring:message code="placeholder.signup"/>"/>
    </form>
    <a href="<c:url value="/loginPage.html?lang=pl"/>"><img width="50" src="../../assets/images/poland.png"/></a>
    <a href="<c:url value="/loginPage.html?lang=en"/>"><img width="50" src="../../assets/images/united_states.png"/></a>
</div>
</body>


</html>