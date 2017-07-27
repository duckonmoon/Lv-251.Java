<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<div class="card">
    <div class="card-block">
        <c:if test="${doctor!=null}">
            <img class="show-logo" alt="logo" src="<c:url value="/resources/img/clinic_logo.png"/>">
            <h4>${doctor.firstname} ${doctor.lastname} ${doctor.middlename}</h4>
            <p>Specialization:${doctor.specialization.name}</p>
        </c:if>
    </div>
</div>
<div class="card">
    <div class="card-block">
        <c:if test="${doctor!=null}">
            <p>${doctor.description}</p>
        </c:if>
    </div>
</div>
