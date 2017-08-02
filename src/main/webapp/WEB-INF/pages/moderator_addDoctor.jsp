<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">
    <div >
        <div class="container" style="width: 30%; float: left">
            <div class="row row-content">
                <div class="list-group doc-menu">
                    <a href="/moderator/cabinet" class="list-group-item ">
                        <spring:message code="messages.clinic" />
                    </a>
                    <a href="/moderator/cabinet/doctors" class=" list-group-item ">
                        <spring:message code="messages.doctors" /><span class="badge">${doctors.size()}</span>
                    </a>
                    <a href="/moderator/cabinet/add/doctor" class="list-group-item navbar-inverse">
                        <spring:message code="messages.addDoctors" />
                    </a>
                </div>
            </div>
        </div>
    </div>
    <div>
        <div class="container" style="width: 70%; float: right">
            <div class="row row-content">
<form:form action="/moderator/add/doctor" method="post" modelAttribute="doctorForm">
    <div class="form-group">
        <label class="col-lg-3 control-label"><spring:message code="messages.userFirstname"/>:</label>
        <div class="col-lg-7">
            <form:errors path="firstname"></form:errors>
            <form:input type="text" class="form-control" path="firstname"/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-lg-3 control-label"> <spring:message code="messages.userLastname"/>:</label>
        <div class="col-lg-7">
            <form:errors path="lastname"></form:errors>
            <form:input type="text" class="form-control" path="lastname"/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-lg-3 control-label"><spring:message code="messages.userEmail"/>:</label>
        <div class="col-lg-7">
            <form:errors path="email"></form:errors>
            <form:input type="text" class="form-control" path="email" disabled="false" />
        </div>
    </div>
    <div class="form-group">
        <label class="col-lg-3 control-label"><spring:message code="messages.password"/>:</label>
        <div class="col-lg-7">
            <form:errors path="password"></form:errors>
            <form:input type="text" class="form-control d" path="password" />
        </div>
    </div>
    <div class="form-group">
        <label class="col-lg-3 control-label"><spring:message code="messages.confirmPassword"/>:</label>
        <div class="col-lg-7">
            <form:errors path="matchingPassword"></form:errors>
            <form:input type="text" class="form-control" path="matchingPassword"/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-lg-3 control-label">Specialization:</label>
        <div class="col-lg-7">
            <form:errors path="specialization"></form:errors>
            <form:input type="text" class="form-control" id="autocomplete-spec" path="specialization"/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-lg-3 control-label">Clinic name:</label>
        <div class="col-lg-7">
            <form:errors path="clinic"></form:errors>
            <form:input type="text" value="${moderator.clinics.clinic_name}" class="form-control" path="clinic" />
        </div>
    </div>
    <div class="form-group">
        <label class="col-lg-3 control-label">Description:</label>
        <div class="col-lg-7">
            <form:errors path="description"></form:errors>
            <form:input type="text" class="form-control" path="description"/>
        </div>
    </div>
         <div class="form-group">
            <label class="col-md-3 control-label"></label>
            <div class="col-md-7">
                <form:button class="btn btn-facebook"><spring:message code="messages.saveChanges"/></form:button>
                <span></span>
                <input type="reset" class="btn btn-default" value="<spring:message code="messages.cancel"/>"/>
            </div>
        </div>

</form:form>
            </div>
            </div>
    </div>
</div>