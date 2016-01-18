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
            <form:form class="form-labels-on-top" action="/editTutorial.html" method="POST" commandName="tutorial">

                <div class="form-title-row">
                    <h1><spring:message code="tutorials.edit"/></h1>
                </div>

                <label>
                    <input style="display: none" type="text" name="name" value="${tutorial.name}"/>
                </label>

                <div class="form-row">
                    <label>
                        <span><spring:message code="levels.title"/></span>
                        <select required style="width: 100% !important;" name="level">
                            <option value="NONE"
                            <c:forEach items="${levelsList}" var="level">
                                <option value="${level}"
                                <c:if test="${tutorial.level.toString().equals(level.toString())}">
                                    selected
                                </c:if>
                                ><spring:message code="${level.toString()}"/></option>
                            </c:forEach>
                        </select>
                    </label>
                </div>

                <div class="form-row">
                    <label>
                        <span><spring:message code="technologies.title"/></span>
                        <select required style="width: 100% !important;" name="technology">
                            <c:forEach items="${technologiesList}" var="technology">
                                <option value="${technology}"
                                        <c:if test="${tutorial.technology.toString().equals(technology.toString())}">
                                            selected
                                        </c:if>
                                >${technology.toString()}</option>
                            </c:forEach>
                        </select>
                    </label>
                </div>

                <div class="form-row">
                    <label>
                        <span><spring:message code="content.title"/></span>
                    </label>
                </div>

                <label for="content"></label>
                <textarea cols="80" rows="10" id="content" name="content">
                    ${tutorial.content}
                </textarea>

                <script type="text/javascript">
                    CKEDITOR.replace('content');
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
