<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<div class="container" style="width: 30%; float: left">
    <div class="row row-content activeList">
        <div class="list-group doc-menu">
            <a href="#" class="active list-group-item">
                <spring:message code="messages.profile"/>
            </a>
            <a href="#" class="list-group-item">
                <spring:message code="messages.doctors"/>
            </a>
            <a href="#" class="list-group-item">
                <spring:message code="messages.medicalCard"/>
            </a>
            <a href="/user/appointments" class="list-group-item">
                <spring:message code="messages.appointments"/>
            </a>
        </div>
    </div>
</div>

<script src="<c:url value="/resources/js/jquery.1.10.2.min.js"/>"></script>
<script src="<c:url value="/resources/js/activeClass.js"/>"></script>