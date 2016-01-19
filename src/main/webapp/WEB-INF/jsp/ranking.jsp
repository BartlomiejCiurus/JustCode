<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>JustCode Main Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" type="text/css" href="../../assets/css/index.css"/>
    <link rel="stylesheet" type="text/css" href="../../assets/css/normalize.css"/>
    <link rel="stylesheet" type="text/css" href="../../assets/css/component.css"/>
</head>
<body style="background: url(../../assets/images/bg_main.png) repeat-x top left #1f2331 !important;">
<%@include file="header.jsp" %>
<div id="wrapper" style="background: none !important;">
    <div
            style="margin-top: 15px;">
        <div class="clearfix">
            <table style="font-size: 15px;">
                <thead>
                <tr>
                    <th><spring:message code="position"/></th>
                    <th><spring:message code="placeholder.username"/></th>
                    <th><spring:message code="placeholder.email"/></th>
                    <th><spring:message code="points.title"/></th>
                </tr>
                </thead>
                <tbody>
                <%--@elvariable id="usersList" type="java.util.List"--%>
                <%--@elvariable id="user" type="com.justcode.model.User"--%>
                <% int i = 1; %>
                <c:forEach items="${usersList}" var="user">
                    <tr>
                        <td class="user-name"><%= i++ %></td>
                        <td class="user-name"><a href="<c:url value="/viewProfile.html?username=${user.username}"/>">${user.username}</a></td>
                        <td class="user-email">${user.email}</td>
                        <td class="user-phone">${user.points}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>
