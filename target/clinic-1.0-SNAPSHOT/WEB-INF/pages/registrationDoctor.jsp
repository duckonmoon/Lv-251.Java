<%--
* Added by Pavlo Kuchereshko.
* Registration page.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!--REGISTER MODAL________________________________________________________________________________________________________________________________________-->
<div id="registerModal">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title"><spring:message code="messages.createDoctorAccount"/></h4>
            </div>
            <div class="modal-body">
                <form:form method="POST" modelAttribute="doctorForm" enctype="multipart/form-data" id="regiastration">
                    <spring:bind path="firstName">
                        <div class="form-group">
                            <label class="sr-only" for="firstName"><spring:message code="messages.firstName" var="firstNameMess"/></label>
                            <form:input type="text" id="firstName" path="firstName"
                                        name="firstName" class="form-control" placeholder="${firstNameMess}" autofocus="true"/>
                            <form:errors path="firstName"/>
                        </div>
                    </spring:bind>
                    <spring:bind path="lastName">
                        <div class="form-group">
                            <label class="sr-only" for="lastName"><spring:message code="messages.lastName" var="lastNameMess"/></label>
                            <form:input type="text" id="emailReg" path="lastName" name="lastName"
                                        class="form-control" placeholder="${lastNameMess}" autofocus="true"/>
                            <form:errors path="lastName"/>
                        </div>
                    </spring:bind>
                    <spring:bind path="email">
                        <div class="form-group">
                            <label class="sr-only" for="emailReg"><spring:message code="messages.email" var="emailRegMess"/></label>
                            <form:input type="text" id="emailReg" path="email"
                                        name="emailReg" class="form-control" placeholder="${emailRegMess}" autofocus="true"/>
                            <form:errors path="email"/>
                        </div>
                    </spring:bind>
                    <spring:bind path="password">
                        <div class="form-group">
                            <label class="sr-only" for="passwordReg"><spring:message code="messages.password" var="passwordRegMess"/></label>
                            <form:input type="password" id="passwordReg" path="password"
                                        name="passwordReg" class="form-control" placeholder="${passwordRegMess}"/>
                            <form:errors path="password"/>
                        </div>
                    </spring:bind>
                    <spring:bind path="matchingPassword">
                        <div class="form-group">
                            <label class="sr-only" for="passwordConfirmReg"><spring:message code="messages.password" var="passwordConfirmRegMess"/></label>
                            <form:input type="password" id="passwordConfirmReg" path="matchingPassword"
                                        name="passwordConfirm" class="form-control" placeholder="${passwordConfirmRegMess}"/>
                            <form:errors path="matchingPassword"/>
                        </div>
                    </spring:bind>
                    <spring:bind path="specialization">
                        <div class="form-group">
                            <label class="sr-only" for="specialization"><spring:message code="messages.specialization" var="specializationMess"/></label>
                            <form:input type="text" id="specialization" path="specialization"
                                        name="specialization" class="form-control" placeholder="${specializationMess}" autofocus="true"/>
                            <form:errors path="specialization"/>
                        </div>
                    </spring:bind>
                    <spring:bind path="description">
                        <div class="form-group">
                            <label class="sr-only" for="description"><spring:message code="messages.Description" var="descriptionMess"/></label>
                            <form:input type="text" id="description" path="description"
                                        name="description" class="form-control" placeholder="${descriptionMess}" autofocus="true"/>
                            <form:errors path="description"/>
                        </div>
                    </spring:bind>
                    <spring:bind path="clinic">
                        <div class="form-group">
                            <label class="sr-only" for="firstName"><spring:message code="messages.clinic" var="clinicMess"/></label>
                            <form:input type="text" id="clinic" path="clinic"
                                        name="clinic" class="form-control" placeholder="${clinicMess}" autofocus="true"/>
                            <form:errors path="clinic"/>
                        </div>
                    </spring:bind>
                    <spring:bind path="multipartFile">
                        <div class="form-group">
                            <label class="sr-only" for="firstName"><spring:message code="messages.photo" var="photoMess"/></label>
                            <form:input type="file" id="photo" path="multipartFile"
                                        name="multipartFile" class="form-control" placeholder="${photoMess}" autofocus="true"/>
                            <form:errors path="multipartFile"/>
                        </div>
                    </spring:bind>
                    <div class="form-group">
                        <button class="btn btn-info"><spring:message code="messages.register"/></button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>


