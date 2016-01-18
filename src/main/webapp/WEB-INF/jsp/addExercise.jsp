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
    <script type="text/javascript" src="../../assets/ckeditor/ckeditor.js"></script>
</head>
<body style="background: url(../../assets/images/bg_main.png) repeat-x top left #1f2331 !important;">
<%@include file="header.jsp" %>
<div id="wrapper" style="background: none !important;">
    <div id="secWrapper"
         style="margin-top: 15px; background: url(../images/content_top.png) no-repeat top left !important;">
        <div id="container" class="clearfix" style="min-height: 800px; background: none !important;">
            <form:form class="form-labels-on-top" action="/addExercise.html" method="POST" commandName="exercise">

                <div class="form-title-row">
                    <h1><spring:message code="exercises.create"/></h1>
                    <c:if test="${not empty errorMessage}">
                        <h2 style="color: #aa1111">${errorMessage}</h2>
                    </c:if>
                </div>

                <div class="form-row">
                    <label>
                        <span><spring:message code="exercises.name"/></span>
                        <input
                            <c:if test="${not empty exercise and not empty exercise.name}">
                                value="${exercise.name}"
                            </c:if>
                                style="width: 100% !important;" type="text" name="name">
                    </label>
                </div>

                <div class="form-row">
                    <label>
                        <span><spring:message code="levels.title"/></span>
                        <select style="width: 100% !important;" name="level">
                            <c:forEach items="${levelsList}" var="level">
                                <option value="${level}"><spring:message code="${level.toString()}"/></option>
                            </c:forEach>
                        </select>
                    </label>
                </div>

                <div class="form-row">
                    <label>
                        <span><spring:message code="technologies.title"/></span>
                        <select style="width: 100% !important;" name="technology">
                            <c:forEach items="${technologiesList}" var="technology">
                                <option value="${technology}">${technology.toString()}</option>
                            </c:forEach>
                        </select>
                    </label>
                </div>

                <div class="form-row">
                    <label>
                        <span><spring:message code="points.title"/></span>
                        <input style="width: 100% !important;" type="number" value="10" min="1" name="points">
                    </label>
                </div>

                <div class="form-row">
                    <label>
                        <span><spring:message code="description.title"/></span>
                    </label>
                </div>

                <label for="description"></label>
                <textarea cols="80" rows="10" id="description" name="description">
                    <c:if test="${not empty exercise and not empty exercise.description}">
                        ${exercise.description}
                    </c:if>
                </textarea>

                <script type="text/javascript">
                    CKEDITOR.replace('description');
                </script>

                <div class="form-row">
                    <button type="submit"><spring:message code="add.message"/></button>
                </div>
            </form:form>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>
