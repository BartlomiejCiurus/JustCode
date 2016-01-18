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
<div id="wrapper" style="background: none !important;">
    <div id="secWrapper"
         style="margin-top: 15px; background: url(../images/content_top.png) no-repeat top left !important;">
        <div id="container" class="clearfix" style="min-height: 800px; background: none !important;">
            <form:form method="post" class="form-labels-on-top" action="/solvedExercise.html"
                       commandName="resolvedExercise">
                <div class="form-title-row">
                    <h1>${exercise.name}</h1>

                    <h2><spring:message code="by"/> ${exercise.author.username}</h2>
                </div>

                <label style="display: none">
                    <input name="exerciseName" value="${exercise.name}">
                </label>

                <div class="form-row">
                    <label>
                        <span><spring:message code="points.title"/>: ${exercise.points}</span>
                    </label>
                </div>

                <div class="form-row">
                    <label>
                        <span><spring:message code="description.title"/></span>
                            ${exercise.description}
                    </label>
                </div>

                <div class="form-row">
                    <label>
                        <span><spring:message code="solution.title"/></span>
                        <textarea style="width: 100% !important; resize: vertical; min-height: 300px"
                                  name="solution"></textarea>
                    </label>
                </div>

                <div class="form-row">
                    <button type="submit"><spring:message code="solved.message"/></button>
                </div>
            </form:form>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>
