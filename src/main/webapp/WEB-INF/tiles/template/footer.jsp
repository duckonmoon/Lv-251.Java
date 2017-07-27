<%--
      Author: Vitaliy Kovalevskyy
      Last updated by: Vitaliy Kovalevskyy
--%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!-- FOOTER*****************************************************************************************************************************************-->


<div class="container">
    <div class="row row-footer">
        <div class="col-xs-5 col-offset-1 col-sm-2 col-sm-offset-1">
            <h5><spring:message code="messages.links"/></h5>
            <ul class="list-unstyled">
                <li><a href="${pageContext.request.contextPath}/"><spring:message code="messages.home" /></a></li>
                <li><a href="${pageContext.request.contextPath}/clinics/details"><spring:message code="messages.clinics" /></a></li>
                <li><a href="${pageContext.request.contextPath}/allDoctors"><spring:message code="messages.doctors"/> </a></li>
                <li><a href="#"><spring:message code="messages.contact"/></a></li>
            </ul>
        </div>
        <div class="col-xs-6 col-sm-5">
            <h5><spring:message code="messages.ourAdress"/></h5>
            <address>
                <spring:message code="messages.Fedkovucha"/><br>
                <spring:message code="messages.Lviv"/><br>
                <spring:message code="messages.Ukraine"/><br>
                <i class="fa fa-phone"></i>: +382 1234 5678<br>
                <i class="fa fa-fax"></i>: +382 8765 4321<br>
                <i class="fa fa-envelope"></i>:<a href="mailto:confusion@food.net">heartbeat@clinic.net</a>
            </address>
        </div>
        <div class="col-xs-12 col-sm-4">
            <div class="nav navbar-nav" style="padding: 40px 10px;">
                <a class="btn btn-social-icon btn-facebook" href="http://www.facebook.com/profile.php?id="><i
                        class="fa fa-facebook"></i></a>
                <a class="btn btn-social-icon btn-linkedin" href="http://www.linkedin.com/in/"><i
                        class="fa fa-linkedin"></i></a>
                <a class="btn btn-social-icon btn-twitter" href="http://twitter.com/"><i class="fa fa-twitter"></i></a>
                <a class="btn btn-social-icon btn-youtube" href="http://youtube.com/"><i class="fa fa-youtube"></i></a>
            </div>
        </div>
        <div class="col-xs-12">
            <p style="padding:10px;"></p>
            <p align="center">© Copyright 2017 SoftServe Inc.</p>
        </div>
    </div>
</div>

