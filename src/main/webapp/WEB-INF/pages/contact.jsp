<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
            <h4 class="modal-title"><spring:message code="messages.contactUs"/></h4>
        </div>
        <div class="modal-body">
            <c:if test="${message != null}"><div role="alert" class="${classCss}">${message}</div></c:if>
            <form:form method="POST" commandName="contactDTO">
                <div class="form-group">
                    <spring:message code="messages.contactName" var="name"/>
                    <form:input placeholder="${name}" type="text" class="form-control" path="name"/>
                    <form:errors path="name" cssClass="text-danger"/>
                </div>
                <div class="form-group">
                    <spring:message code="messages.contactEmail" var="email"/>
                    <form:input type="email" class="form-control"
                           placeholder="${email}" path="email"/>
                    <form:errors path="email" cssClass="text-danger"/>
                </div>
                <div class="form-group">
                    <spring:message code="messages.contactMobile" var="phone"/>
                    <form:input type="text" class="form-control"
                           placeholder="${phone}" path="phone"/>
                    <form:errors path="phone" cssClass="text-danger"/>
                </div>
                <div class="form-group">
                    <spring:message code="messages.contactSubject" var="subject"/>
                    <form:input type="text" class="form-control"
                           placeholder="${subject}" path="subject"/>
                    <form:errors path="subject" cssClass="text-danger"/>
                </div>
                <div class="form-group">
                    <spring:message code="messages.contactMessage" var="message"/>
                    <form:textarea class="form-control" rows="13"
                              placeholder="${message}" path="message"/>
                    <form:errors path="message" cssClass="text-danger"/>
                </div>
                <div class="form-group">
                    <button class="btn btn-info pull-right"><spring:message code="messages.contactButton"/></button>
                </div>
                <br>
            </form:form>
        </div>
    </div>
</div>
