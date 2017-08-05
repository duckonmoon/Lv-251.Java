<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<link href="<c:url value="/resources/css/medicalCard.css"/>" rel="stylesheet">

<div class="container-fluid">
    <div class="row content">
        <br>
        <div <%--class="list-group doc-menu"--%> id="menu_mcard">
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
</div>
