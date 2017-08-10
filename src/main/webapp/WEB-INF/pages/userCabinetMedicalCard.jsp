<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                    <a href="<c:url value="/user/medicalcard"/>" class="active list-group-item">
                        <spring:message code="messages.medicalCard"/>
                    </a>
                    <a href="<c:url value="/user/appointments"/>" class="list-group-item">
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
                            <div id="menu_mcard" style="cursor: pointer">
                                <ul>
                                    <li><a id="appointmentsHistoryLink" class="active list-group-item">Appointments history</a></li>
                                    <li><a id="pendingAppointmentsLink" class="list-group-item">Pending appointments</a></li>
                                </ul>
                            </div>
                        <div class="col-sm-9" style="width: 100%">
                            <c:choose>
                                <c:when test="${listAppointments.size() == 0}">
                                    <div class="well mcard_content">
                                        <div class="col-sm-6" style="width: 100%">
                                            <h2 class="media-heading"><c:out value="You have no appointments yet"/></h2>
                                        </div>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <c:set var="listPastAppointmentsLength" value="0"/>
                                    <c:set var="listPendingAppointmentsLength" value="0"/>
                                    <c:forEach items="${listAppointments}" var="appointment" varStatus="loop">
                                        <fmt:formatDate var="aDate" pattern = 'dd-MM-yyyy HH:mm' value='${appointment.appointmentDate}'/>
                                        <c:choose>
                                            <c:when test="${appointment.appointmentDate < date}">
                                                <c:set var="showAppointmentClass" value="appointmentsHistory"/>
                                                <c:set var="listPastAppointmentsLength" value="${listPastAppointmentsLength + 1}"/>
                                            </c:when>
                                            <c:when test="${appointment.appointmentDate >= date}">
                                                <c:set var="showAppointmentClass" value="pendingAppointments"/>
                                                <c:set var="listPendingAppointmentsLength" value="${listPendingAppointmentsLength + 1}"/>
                                            </c:when>
                                            <c:when test="${appointment.appointmentDate > date && !appointment.isApproved}">
                                                <c:set var="cssClass" value="active"/>
                                            </c:when>
                                            <c:when test="${appointment.appointmentDate > date && appointment.isApproved}">
                                                <c:set var="cssClass" value="success"/>
                                            </c:when>
                                            <c:when test="${appointment.appointmentDate < date && appointment.isApproved}">
                                                <c:set var="cssClass" value="info"/>
                                            </c:when>
                                            <c:otherwise>
                                                <c:set var="cssClass" value="danger"/>
                                            </c:otherwise>
                                        </c:choose>
                                        <div class="${showAppointmentClass}">
                                            <div class="well mcard_content">
                                                <div class="col-sm-6" style="width: 100%">
                                                    <div class="medical-card">
                                                        <div class="media">
                                                            <div class="media-left">
                                                                <img class="media-object img-circle profile-img" src="http://s3.amazonaws.com/37assets/svn/765-default-avatar.png">
                                                            </div>
                                                            <div class="media-body">
                                                                <h2 class="media-heading"><c:out value="${appointment.doctors.lastname} ${appointment.doctors.lastname}"/></h2>
                                                                <div class="specialization"><c:out value="${appointment.doctors.specialization}"/></div>
                                                                <div class="diagnosis"><c:out value="${appointment.description}"/></div>
                                                                <div class="diagnosis"><c:out value="${aDate}"/></div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                    <div class="appointmentsHistoryListIsEmpty">
                                        <div class="well mcard_content">
                                            <div class="col-sm-6" style="width: 100%">
                                                <h2 class="media-heading"><c:out value="You have no appointments yet"/></h2>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="pendingAppointmentsListIsEmpty">
                                        <div class="well mcard_content">
                                            <div class="col-sm-6" style="width: 100%">
                                                <h2 class="media-heading"><c:out value="You have no pending appointments"/></h2>
                                            </div>
                                        </div>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                            <script>

                                var listPastAppointmentsLength = "${listPastAppointmentsLength}";
                                var listPendingAppointmentsLength = "${listPendingAppointmentsLength}";

                                var showAppointmentHistory = function () {
                                    $(".appointmentsHistory").show();
                                    $(".pendingAppointments").hide();
                                    $("#appointmentsHistoryLink").addClass("active");
                                    $("#pendingAppointmentsLink").removeClass("active");
                                    if (listPastAppointmentsLength == 0) {
                                        $(".appointmentsHistoryListIsEmpty").css("visibility", "visible").height("inherit");
                                        $(".pendingAppointmentsListIsEmpty").css("visibility", "hidden").height(0);
                                    } else {
                                        $(".appointmentsHistoryListIsEmpty").css("visibility", "hidden").height(0);
                                        $(".pendingAppointmentsListIsEmpty").css("visibility", "hidden").height(0);
                                    }
                                };

                                var showPendingAppointments = function () {
                                    $(".appointmentsHistory").hide();
                                    $(".pendingAppointments").show();
                                    $("#pendingAppointmentsLink").addClass("active");
                                    $("#appointmentsHistoryLink").removeClass("active");
                                    if (listPendingAppointmentsLength == 0) {
                                        $(".pendingAppointmentsListIsEmpty").css("visibility", "visible").height("inherit");
                                        $(".appointmentsHistoryListIsEmpty").css("visibility", "hidden").height(0);
                                    } else {
                                        $(".appointmentsHistoryListIsEmpty").css("visibility", "hidden").height(0);
                                        $(".pendingAppointmentsListIsEmpty").css("visibility", "hidden").height(0);
                                    }
                                };

                                $("#appointmentsHistoryLink").click(showAppointmentHistory);

                                $("#pendingAppointmentsLink").click(showPendingAppointments);

                            </script>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

