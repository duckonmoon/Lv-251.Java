<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 01.08.2017
  Time: 0:26
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>


<div class="container" style="width: 30%; float: left">
    <div class="row row-content">
        <div class="list-group doc-menu">
            <a href="#" class= 'list-group-item active'>
                <spring:message code="messages.schedule" />
            </a>
            <a href="#" class="list-group-item">
                <spring:message code="messages.patients" />
            </a>
        </div>
    </div>
</div>