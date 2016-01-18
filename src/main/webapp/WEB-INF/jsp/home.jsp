<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>JustCode Main Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" type="text/css" href="../../assets/css/index.css"/>
</head>
<body>
<%@include file="header.jsp" %>
<div id="welcomeMessage">
    <h1><spring:message code="welcome.message"/> <span style="color: #006eab">${user}</span>!</h1>

    <p><span>JustCode.com </span><spring:message code="page.description"/></p>

    <p>Lorem ipsum dolor sit amet, consectetur adip, <span>JustCode.com</span> amet dui gravida pulvinar lacinia, diam
        ut nibh</p>
</div>
<div id="wrapper">
    <div id="secWrapper">
        <div id="container" class="clearfix">
            <div id="mainCol" class="clearfix">
                <h3 id="why"><spring:message code="home.question"/></h3>
                <ul id="maincon">
                    <li class="clearfix"><img src="../../assets/images/image1.jpg" alt=""/>

                        <h2><spring:message code="home.services.answer"/></h2>

                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                            labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                            laboris nisi ut aliquip ex ea commodo consequat. Lorem ipsum dolor sit amet, consectetur
                            adipisicing elit, sed do eiusmod tempor.</p>
                    </li>
                    <li class="clearfix"><img src="../../assets/images/image2.jpg" alt=""/>

                        <h2><spring:message code="home.value.answer"/></h2>

                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                            labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                            laboris nisi ut aliquip ex ea commodo consequat. Lorem ipsum dolor sit amet, consectetur
                            adipisicing elit, sed do eiusmod tempor.</p>
                    </li>
                    <li class="clearfix"><img src="../../assets/images/image3.jpg" alt=""/>

                        <h2><spring:message code="home.support.answer"/></h2>

                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                            labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                            laboris nisi ut aliquip ex ea commodo consequat. Lorem ipsum dolor sit amet, consectetur
                            adipisicing elit, sed do eiusmod tempor.</p>
                    </li>
                    <li class="clearfix last"><img src="../../assets/images/image4.jpg" alt=""/>

                        <h2><spring:message code="home.team.answer"/></h2>

                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                            labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                            laboris nisi ut aliquip ex ea commodo consequat. Lorem ipsum dolor sit amet, consectetur
                            adipisicing elit, sed do eiusmod tempor.</p>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>
