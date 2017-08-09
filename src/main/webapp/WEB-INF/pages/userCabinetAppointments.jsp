<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>


<div class="container">
    <div>
        <div class="container" style="width: 30%; float: left">
            <div class="row row-content">
                <div class="list-group doc-menu">
                    <a href="/user/cabinet" class="list-group-item">
                        <spring:message code="messages.profile"/>
                    </a>
                    <a href="#" class="list-group-item">
                        <spring:message code="messages.doctors"/>
                    </a>
                    <a href="#" class="list-group-item">
                        <spring:message code="messages.medicalCard"/>
                    </a>
                    <a href="/user/appointments" class="active list-group-item">
                        <spring:message code="messages.appointments"/>
                    </a>
                </div>
            </div>
        </div>

        <div class="container" style="width: 70%; float: right">
            <div class="row row-content">

                <table class="table table-sm table-inverse">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th><spring:message code="messages.doctorsName"/></th>
                        <th><spring:message code="messages.doctorsSpecialization"/></th>
                        <th><spring:message code="messages.dateApppointment"/></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listAppointmens}" var="appointment" varStatus="loop">
                        <fmt:formatDate var="aDate" pattern = 'dd-MM-yyyy HH:mm' value='${appointment.appointmentDate}'/>
                        <c:choose>
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
                        <tr class="${cssClass}">
                            <td>${loop.index+1}</td>
                            <td>
                                <c:out value="${appointment.doctors.firstname} ${appointment.doctors.lastname}"/>
                            </td>
                            <td>
                                <c:out value="${appointment.doctors.specialization.name}"/>
                            </td>
                            <td>
                                <c:out value="${aDate}"/>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>


