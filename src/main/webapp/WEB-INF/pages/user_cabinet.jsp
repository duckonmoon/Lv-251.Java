<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>


<div class="container">
    <div class="row row-content">
        <div class="list-group col-sm-3 doc-menu">
            <a href="#" class="list-group-item active">
                <spring:message code="messages.profile" />
            </a>
            <a href="#" class="list-group-item">
                <spring:message code="messages.doctors" />
            </a>
            <a href="#" class="list-group-item">
                <spring:message code="messages.medicalCard" />
            </a>
        </div>
    </div>
</div>