<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="footer">
    <ul>
        <li><a href="<c:url value="/home.html?lang=pl"/>"><img width="50" src="../../assets/images/poland.png"/></a></li>
        <li><a href="<c:url value="/home.html?lang=en"/>"><img width="50" src="../../assets/images/united_states.png"/></a></li>
    </ul>
    <br/>
    <ul>
        <li><a href="https://www.facebook.com/"><img style="padding-right: 5px" width="37" src="../../assets/images/facebook-icon.png"/></a></li>
        <li><a href="https://twitter.com/"><img style="padding-right: 5px" width="37" src="../../assets/images/twitter-ico.png"/></a></li>
        <li><a href="https://youtube.com/"><img style="padding-right: 5px" width="37" src="../../assets/images/youtube-ico.png"/></a></li>
        <li><a href="https://linkedin.com/"><img width="37" src="../../assets/images/linkedin-ico.png"/></a></li>
    </ul>
    <p><spring:message code="copyrights.title" /></p>
</div>