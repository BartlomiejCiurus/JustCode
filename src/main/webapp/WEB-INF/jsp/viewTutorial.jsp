<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>JustCode Main Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" type="text/css" href="../../assets/css/index.css"/>
    <link rel="stylesheet" type="text/css" href="../../assets/css/form-labels-on-top.css"/>
</head>
<body style="background: url(../../assets/images/bg_main.png) repeat-x top left #1f2331 !important;">
<%@include file="header.jsp" %>
<div id="wrapper">
    <div id="secWrapper"
         style="margin-top: 15px; background: url(../images/content_top.png) no-repeat top left !important;">
        <div id="container" class="clearfix" style="min-height: 800px; font-size: 14px">
            <% if (request.isUserInRole("ADMIN")) { %>
            <form:form action="/deleteTutorial.html"  commandName="tutorialName" method="post" class="form-labels-on-top"
                       style="box-shadow: none !important; padding: 0 0 0 0 !important; display: initial !important;">

                <label>
                    <input style="display: none" type="text" name="tutorialName" value="${tutorial.name}">
                </label>

                <div class="form-row" style="display: initial !important;">
                    <button type="submit" style="background-color: #aa1111 !important;"><spring:message code="delete"/></button>
                </div>

            </form:form>
            <form method="get" action="/editTutorial.html" class="form-labels-on-top"
                       style="box-shadow: none !important; padding: 0 0 0 0 !important; display: initial !important;">
                <label>
                    <input style="display: none" type="text" name="tutorialName" value="${tutorial.name}">
                </label>

                <div class="form-row" style="display: initial !important;">
                    <button type="submit"><spring:message code="edit"/></button>
                </div>
            </form>
            <% } %>

            <form class="form-labels-on-top" style="box-shadow: none !important;">

                <div class="form-title-row">
                    <h1>${tutorial.name}</h1>
                    <h2><spring:message code="by"/> ${tutorial.author.username}</h2>
                </div>

                ${tutorial.content}
            </form>


        </div>
    </div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>
