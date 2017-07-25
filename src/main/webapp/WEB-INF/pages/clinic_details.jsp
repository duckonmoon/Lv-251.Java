<%--
  Created by IntelliJ IDEA.
  User: Taras
  Date: 25.07.2017
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
            <h4><spring:message code="messages.contacts"></spring:message></h4>
            <p class="card-text">${clinics.contact.address}</p>
            <p class="card-text">${clinics.contact.district}</p>
            <p class="card-text">${clinics.contact.city}</p>
            <p class="card-text">${clinics.contact.zipCode}</p>
            <p class="card-text">${clinics.contact.firstPhone}</p>
            <p class="card-text">${clinics.contact.secondPhone}</p>
            <p class="card-text">${clinics.contact.thirdPhone}</p>
            <p class="card-text">${clinics.contact.email}</p>

        </div>
    </div>

</div>
