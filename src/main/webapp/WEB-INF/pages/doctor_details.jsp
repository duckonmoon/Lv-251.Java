<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<div class="card">
    <div class="card-block">

            <img class="show-logo" alt="logo" src="data:image/jpeg;base64,${doctor.photo}">
            <h4>${doctor.firstname} ${doctor.lastname} ${doctor.middlename}</h4>
            <p>Specialization:${doctor.specialization.name}</p>
    </div>
</div>
<div class="card">
    <div class="card-block">
            <p>${doctor.description}</p>
    </div>
</div>
