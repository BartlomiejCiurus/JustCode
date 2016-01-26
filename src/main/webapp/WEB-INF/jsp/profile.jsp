<%--@elvariable id="user" type="com.justcode.model.User"--%>
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
    <link href="../../assets/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="../../assets/css/font-awesome.css" rel="stylesheet">
    <link href="../../assets/css/pro-bars.css" rel="stylesheet" type="text/css" media="all"/>
    <link id="switcher" href="../../assets/css/themes/default-theme.css" type="text/css" rel="stylesheet"
          media="screen,projection"/>
    <link href="../../assets/css/profileStyle.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script type="text/javascript" src="../../assets/ckeditor/ckeditor.js"></script>
</head>
<body style="background: url(../../assets/images/bg_main.png) repeat-x top left #1f2331 !important;">
<%@include file="header.jsp" %>
<div id="wrapper" style="background: none !important; min-height: 600px !important;">
    <div id="secWrapper"
         style="margin-top: 15px; background: url(../images/content_top.png) no-repeat top left !important;">
        <div id="container" class="clearfix" style="min-height: 800px; background: none !important;">
            <div class="main-wrapper">
                <main role="main">

                    <section id="about">
                        <div class="container">
                            <div class="row">
                                <div class="col s12">
                                    <div class="about-inner">
                                        <div class="row">
                                            <div class="col s12 m4 l3">
                                                <div class="about-inner-left">
                                                    <img class="profile-img"
                                                         src="../../assets/images/default-avatar.png"
                                                         alt="Profile Image">
                                                </div>
                                            </div>
                                            <div class="col s12 m8 l9">
                                                <div class="about-inner-right">
                                                    <h3><spring:message code="about.me"/></h3>
                                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
                                                        eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
                                                        enim ad minim veniam, quis nostrud exercitation ullamco laboris
                                                        nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor
                                                        in reprehenderit in voluptate velit esse cillum dolore eu fugiat
                                                        nulla pariatur.</p>
                                                    <div style="width: 100% !important;"
                                                         class="personal-information col s12 m12 l6">
                                                        <h3><spring:message code="information"/></h3>
                                                        <ul>
                                                            <li><span><spring:message
                                                                    code="placeholder.username"/>: </span>${user.username}
                                                            </li>
                                                            <li><span><spring:message
                                                                    code="placeholder.email"/>: </span>${user.email}
                                                            </li>
                                                            <li><span><spring:message
                                                                    code="points.title"/>: </span>${user.points}</li>
                                                            <li><span><spring:message
                                                                    code="tutorials.added"/>: </span><a
                                                                    href="<c:url value="/searchTutorialBy.html?username=${user.username}"/>"> ${tutorialsCreated}</a>
                                                            </li>
                                                            <li><span><spring:message
                                                                    code="exercises.added"/>: </span><a
                                                                    href="<c:url value="/searchExerciseBy.html?username=${user.username}"/>"> ${exercisesCreated}</a>
                                                            </li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>

                </main>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>
