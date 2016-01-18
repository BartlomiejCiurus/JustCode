<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="header"><a style="align-items: center" href="<c:url value="/home.html"/>"><img
    style="width: 260px; vertical-align: top" src="../../assets/images/logo.png" id="logo" alt=""/></a>
    <ul id="navigation">
        <li><a href=""><spring:message code="tutorials.title"/> &raquo;</a>
            <ul>
                <li><a href="<c:url value="/addTutorial.html"/>"><spring:message code="tutorials.create"/></a></li>
                <li><a href="<c:url value="/searchTutorial.html"/>"><spring:message code="tutorials.search"/></a></li>
            </ul>
        </li>
        <li><a href=""><spring:message code="exercises.title"/> &raquo;</a>
            <ul>
                <li><a href="<c:url value="/addExercise.html"/>"><spring:message code="exercises.create"/></a></li>
                <li><a href="<c:url value="/searchExercise.html"/>"><spring:message code="exercises.search"/></a></li>
            </ul>
        </li>
        <li><a href="<c:url value="/profile.html"/>"><spring:message code="profile.title"/></a></li>
        <li><a href="<c:url value="/ranking.html"/>">Ranking</a></li>
        <li><a href="<c:url value="/contact"/>"><spring:message code="contact.title"/></a></li>
        <li><a href="<c:url value="/logout.html"/>"><spring:message code="logout.title"/></a></li>
    </ul>
</div>