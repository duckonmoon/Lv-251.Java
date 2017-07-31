<%--
* Added by Pavlo Kuchereshko.
* Registration page.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!--REGISTER ________________________________________________________________________________________________________________________________________-->
<div class="modal-dialog">
            <div class="row">
                <div class="modal-content">
                    <div class="modal-header">

                <form:form method="POST" modelAttribute="userForm" id="registration">
                    <spring:bind path="firstName">
                        <div class="form-group">
                            <label class="sr-only" for="firstName"><spring:message code="messages.firstName" var="firstNameMess"/></label>
                            <form:input type="text" id="firstName" path="firstName"
                                        name="firstName" class="form-control" placeholder="${firstNameMess}" autofocus="true"/>
                            <form:errors path="firstName"/>
                            <span class="strengthPsw" id="firstNameWarn" style="pointer-events:none; float:left; white-space: pre;"></span>
                        </div>
                    </spring:bind>
                    <spring:bind path="lastName">
                        <div class="form-group">
                            <label class="sr-only" for="lastName"><spring:message code="messages.lastName" var="lastNameMess"/></label>
                            <form:input type="text" id="lastName" path="lastName" name="lastName"
                                        class="form-control" placeholder="${lastNameMess}" autofocus="true"/>
                            <form:errors path="lastName"/>
                            <span class="strengthPsw" id="lastNameWarn" style="pointer-events:none; float:left; white-space: pre;"></span>
                        </div>
                    </spring:bind>
                    <spring:bind path="email">
                        <div class="form-group">
                            <label class="sr-only" for="emailReg"><spring:message code="messages.email" var="emailRegMess"/></label>
                            <form:input type="text" id="emailReg" path="email"
                                        name="emailReg" class="form-control" placeholder="${emailRegMess}" autofocus="true"/>
                            <form:errors path="email"/>
                            <span class="strengthPsw" id="emailWarn" style="pointer-events:none; float:left; white-space: pre;"></span>
                        </div>
                    </spring:bind>
                    <spring:bind path="password">
                        <div class="form-group" id="eye_wrapper">

                            <label class="sr-only" for="passwordReg"><spring:message code="messages.password" var="passwordRegMess"/></label>
                            <form:input type="password" id="passwordReg" path="password"
                                        name="passwordReg" class="form-control" placeholder="${passwordRegMess}" cssStyle="background-color: inherit; z-index: -1"/>
                            <form:errors path="password"/>

                            <div class="password-background" style="z-index: 0; pointer-events:none;"></div>
                            <div id="eye_button">
                                <button type="button" id="eye" style="z-index: 0;">
                                    <img src="<c:url value="/resources/img/eye.png"/>" alt="eye" />
                                </button>
                            </div>
                                <span class="strengthPsw" id="lengthWarn" style="pointer-events:none; float:left;"></span>
                                <span class="strengthPsw" id="strengthPswId" style="pointer-events:none; float:left; white-space: pre; display: block"></span>
                        </div>
                        <%--<div class="form-group">
                            <div style="pointer-events:none; /*float:left;*/ /*display:inline-block;*/">
                                <span class="strengthPsw" id="strengthPswId" style="pointer-events:none; float:left; /*white-space: pre;*/"></span>
                            </div>
                        </div>--%>
                    </spring:bind>
                    <spring:bind path="matchingPassword">
                        <div class="form-group">
                            <label class="sr-only" for="passwordConfirmReg"><spring:message code="messages.confirmPassword" var="passwordConfirmRegMess"/></label>
                            <form:input type="password" id="passwordConfirmReg" path="matchingPassword" cssStyle="z-index: 0"
                                        name="passwordConfirm" class="form-control" placeholder="${passwordConfirmRegMess}"/>
                            <form:errors path="matchingPassword"/>
                            <span id="matchPsw"></span>
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
