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
                    <th><spring:message code="tutorials.name"/></th>
                    <th><spring:message code="technologies.title"/></th>
                    <th><spring:message code="levels.title"/></th>
                    <th><spring:message code="author.title"/></th>
                </tr>
                </thead>
                <tbody>
                <%--@elvariable id="tutorialsList" type="java.util.List"--%>
                <%--@elvariable id="tutorial" type="com.justcode.model.Tutorial"--%>
                <c:forEach items="${tutorialsList}" var="tutorial">
                    <tr>
                        <td class="user-name"><a
                            href="<c:url value="/viewTutorial.html?tutorialName=${tutorial.name}"/>">${tutorial.name}</a>
                        </td>
                        <td class="user-email">${tutorial.technology.toString()}</td>
                        <td class="user-phone"><spring:message code="${tutorial.level.toString()}"/></td>
                        <td class="user-mobile">${tutorial.author.username}</td>
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
