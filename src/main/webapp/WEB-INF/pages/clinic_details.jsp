<%--
  Created by IntelliJ IDEA.
  User: Taras
  Date: 25.07.2017
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<div class="container">

    <div class="card">
        <div class="card-block">
            <h4 class="card-title">${clinic.clinic_name}</h4>
            <p class="card-text">${clinic.description}</p>
            <a href="#" class="btn btn-primary">Go somewhere</a>
        </div>
    </div>
    <div class="card">
        <div class="card-block">
            <h4><spring:message code="messages.contact"/></h4>
            <p class="card-text">${clinic.contact.address}</p>
            <p class="card-text">${clinic.contact.district}</p>
            <p class="card-text">${clinic.contact.city}</p>
            <p class="card-text">${clinic.contact.zipCode}</p>
            <p class="card-text">${clinic.contact.firstPhone}</p>
            <p class="card-text">${clinic.contact.secondPhone}</p>
            <p class="card-text">${clinic.contact.thirdPhone}</p>
            <p class="card-text">${clinic.contact.email}</p>
        </div>
    </div>

</div>
