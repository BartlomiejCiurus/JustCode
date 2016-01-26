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
    <script type="text/javascript">
        window.onload = function(){
            //Get submit button
            var submitbutton = document.getElementById("tfq");
            //Add listener to submit button
            if(submitbutton.addEventListener){
                submitbutton.addEventListener("click", function() {
                    if (submitbutton.value == '<spring:message code="user.search"/>'){
                        submitbutton.value = '';
                    }
                });
            }
        }
    </script>
    <style type="text/css">
        #tfnewsearch{
            float:right;
            padding:20px;
        }
        .tftextinput2{
            margin: 0;
            padding: 5px 15px;
            font-family: Arial, Helvetica, sans-serif;
            font-size:14px;
            color:#666;
            border:1px solid #0076a3; border-right:0px;
            border-top-left-radius: 5px 5px;
            border-bottom-left-radius: 5px 5px;
        }
        .tfbutton2 {
            margin: 0;
            padding: 5px 7px;
            font-family: Arial, Helvetica, sans-serif;
            font-size:14px;
            font-weight:bold;
            outline: none;
            cursor: pointer;
            text-align: center;
            text-decoration: none;
            color: #ffffff;
            border: solid 1px #0076a3; border-right:0px;
            background: #0095cd;
            background: -webkit-gradient(linear, left top, left bottom, from(#00adee), to(#0078a5));
            background: -moz-linear-gradient(top,  #00adee,  #0078a5);
            border-top-right-radius: 5px 5px;
            border-bottom-right-radius: 5px 5px;
        }
        .tfbutton2:hover {
            text-decoration: none;
            background: #007ead;
            background: -webkit-gradient(linear, left top, left bottom, from(#0095cc), to(#00678e));
            background: -moz-linear-gradient(top,  #0095cc,  #00678e);
        }
        /* Fixes submit button height problem in Firefox */
        .tfbutton2::-moz-focus-inner {
            border: 0;
        }
        .tfclear{
            clear:both;
        }
    </style>
</head>
<body style="background: url(../../assets/images/bg_main.png) repeat-x top left #1f2331 !important;">
<%@include file="header.jsp" %>
<div id="wrapper" style="background: none !important;">
    <div
            style="margin-top: 15px;">
        <div class="clearfix">
            <div id="tfheader">
                <form id="tfnewsearch" method="get" action="<c:url value="/rankingSearch.html"/>">
                    <input type="text" id="tfq" class="tftextinput2" name="searchUsername" size="21" maxlength="120" value="<spring:message code="user.search"/>">
                    <input type="submit" value=">" class="tfbutton2">
                </form>
                <div class="tfclear"></div>
            </div>
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
