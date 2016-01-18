<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>JustCode Login Page</title>
    <link rel="stylesheet" type="text/css" href="../../assets/css/main.css" />
    <link rel="stylesheet" type="text/css" href="../../assets/css/login.css" />
</head>

<body onload='document.loginForm.username.focus();'>
<div class="body"></div>
<div class="grad"></div>
<div class="login" style="transform: translate(-50%, -150%);">
    <form:form  method="post" action="/register.html" commandName="registerData" name="loginForm">
        <img style="margin-bottom: 15px" width="290px" src="../../assets/images/logo.png">
        <c:if test="${not empty errorMessageContent}">
            <span style="display: flex" class="errorBlock">${errorMessageContent}</span>
        </c:if>
        <input type="text"  placeholder="<spring:message code="placeholder.username"/>" name="username"/>
        <input type="email"  placeholder="<spring:message code="placeholder.email"/>" name="email"/>
        <input type="password" placeholder="<spring:message code="placeholder.password"/>" name="password"/>
        <input type="password" placeholder="<spring:message code="placeholder.password.repeat"/>" name="repeatedPassword"/>
        <input type="submit" value="<spring:message code="placeholder.signup"/>" class="loginBut"/>
    </form:form>
    <form action="<c:url value="/loginPage.html"/>" method="get">
        <input style="margin-top: 0 !important;" type="submit" value="<spring:message code="placeholder.login.return"/>"/>
    </form>
    <a href="<c:url value="/register.html?lang=pl"/>"><img width="50" src="../../assets/images/poland.png"/></a>
    <a href="<c:url value="/register.html?lang=en"/>"><img width="50" src="../../assets/images/united_states.png"/></a>
</div>
</body>


</html>