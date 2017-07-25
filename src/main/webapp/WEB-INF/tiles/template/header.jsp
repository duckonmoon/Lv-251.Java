<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
    Author: Vitaliy Kovalevskyy
    Last updated by: Vitaliy Kovalevskyy
--%>
<!--NAVBAR***************************************************************************************************************************************-->
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">
                <img src="${pageContext.request.contextPath}/resources/img/heartbeat2.png" height=35 width=100>
            </a>
        </div>

        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="${pageContext.request.contextPath}/"><span class="glyphicon glyphicon-home"></span> <spring:message code="messages.home" />
                </a></li>
                <li>
                    <a href="${pageContext.request.contextPath}/clinics/all">
                        <span class="glyphicon glyphicon-plus-sign"></span><spring:message code="messages.clinics" />
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/allDoctors">
                        <span class="glyphicon glyphicon-user"></span><spring:message code="messages.doctors" />
                    </a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-envelope-o"></i> <spring:message code="messages.contact" />
                    </a>
                </li>
                <li>
                    <a class="navbar-brand pull-right" href="${pageContext.request.contextPath}">
                        <img src="${pageContext.request.contextPath}/resources/img/heartbeat2.png" height=35 width=100>
                    </a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="nav navbar-nav flags">
                    <a class="" href="#" style="padding: 20px 0 ; float: left">
                        <img src="${pageContext.request.contextPath}/resources/img/flag-gb.png" class="flag flag-gb"
                             alt="Great Britain"/>
                    </a>
                    <a class="" href="#" style="padding: 20px 3px ; float: left ">
                        <img src="${pageContext.request.contextPath}/resources/img/flag-ua.png" class="flag flag-ua"
                             alt="Ukraine"/>
                    </a>
                </li>
                <li><a type="button" id="loginBtn" data-toggle="modal" data-target="#loginModal" style="cursor:pointer;">
                    <span class="glyphicon glyphicon-log-in"></span> <spring:message code="messages.login"/> </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
