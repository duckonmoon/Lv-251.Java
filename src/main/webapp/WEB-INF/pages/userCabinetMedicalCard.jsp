<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<link href="<c:url value="/resources/css/medicalCard.css"/>" rel="stylesheet">

<div class="container">
    <div>
        <div class="container" style="width: 30%; float: left">
            <div class="row row-content">
                <div class="list-group doc-menu">
                    <a href="<c:url value="/user/cabinet"/>" class="list-group-item">
                        <spring:message code="messages.profile"/>
                    </a>
                    <a href="#" class="list-group-item">
                        <spring:message code="messages.doctors"/>
                    </a>
                    <a href="<c:url value="/user/medicalcard"/>" class="list-group-item">
                        <spring:message code="messages.medicalCard"/>
                    </a>
                    <a href="<c:url value="/user/appointments"/>" class="active list-group-item">
                        <spring:message code="messages.appointments"/>
                    </a>
                </div>
            </div>
        </div>

        <div class="container" style="width: 70%; float: right">
            <div class="row row-content">

                <div class="container-fluid">
                    <div class="row content">
                        <br>
                        <div id="menu_mcard">
                            <ul>
                                <li><a href="#" class="active list-group-item" style="height: 61px">Appointments history</a></li>
                                <li><a href="#" class="list-group-item" style="height: 61px">Pending appointments</a></li>
                            </ul>
                        </div>

                        <div class="col-sm-9" style="width: 100%">
                        <c:choose>
                            <c:when test="${listAppointments.size() == 0}">
                                <div class="well" id="mcard_content">
                                    <div class="col-sm-6" style="width: 100%">
                                        <h2 class="media-heading"><c:out value="You have no appointments yet"/></h2>
                                    </div>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <c:forEach items="${listAppointments}" var="appointment" varStatus="loop">
                                    <div class="well" id="mcard_content">
                                        <div class="col-sm-6" style="width: 100%">
                                            <div class="medical-card">
                                                <div class="media">
                                                    <div class="media-left">
                                                        <img class="media-object img-circle profile-img" src="http://s3.amazonaws.com/37assets/svn/765-default-avatar.png">
                                                    </div>
                                                    <div class="media-body">
                                                        <h2 class="media-heading"><c:out value="${appointment.doctorLastName} ${appointment.doctorFirstName}"/></h2>
                                                        <div class="specialization"><c:out value="${appointment.doctorSpecialisation}"/></div>
                                                        <div class="diagnosis"><c:out value="${appointment.duration}"/></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>

                            <%--<div class="well" id="mcard_content">
                                <div class="col-sm-6" style="width: 100%">
                                    <div class="medical-card">
                                        <div class="media">
                                            <div class="media-left">
                                                <img class="media-object img-circle profile-img" src="http://s3.amazonaws.com/37assets/svn/765-default-avatar.png">
                                            </div>
                                            <div class="media-body">
                                                <h2 class="media-heading">Daniel Duplo</h2>
                                                <div class="specialization">Proktolog</div>
                                                <div class="diagnosis">Gemor</div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>--%>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%--<div class="container-fluid">
    <div class="row content">
        <br>
        <div id="menu_mcard">
            <ul>
                <li><a href="#" class="active list-group-item" style="height: 61px">Appointments history</a></li>
                <li><a href="#" class="list-group-item" style="height: 61px">Pending appointments</a></li>
            </ul>
        </div>

        <div class="col-sm-9">
            <div class="well" id="mcard_content">
                <div class="col-sm-6">
                    <div class="medical-card">
                        <div class="media">
                            <div class="media-left">
                                <img class="media-object img-circle profile-img" src="http://s3.amazonaws.com/37assets/svn/765-default-avatar.png">
                            </div>
                            <div class="media-body">
                                <h2 class="media-heading">Daniel Duplo</h2>
                                <div class="specialization">Proktolog</div>
                                <div class="diagnosis">Gemor</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>--%>
