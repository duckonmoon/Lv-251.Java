<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container">
    <div >
        <div class="container" style="width: 30%; float: left">
            <div class="row row-content">
                <div class="list-group doc-menu">
                    <a href="/moderator/cabinet" class="list-group-item navbar-inverse">
                        <spring:message code="messages.clinic" />
                    </a>
                    <a href="/moderator/cabinet/doctors" class=" list-group-item ">
                        <spring:message code="messages.doctors" /><span class="badge">${doctors.size()}</span>
                    </a>
                    <a href="/moderator/cabinet/add/doctor" class="list-group-item">
                        <spring:message code="messages.addDoctors" />
                    </a>
                </div>
            </div>
        </div>
    </div>
    <div>
        <div class="container" style="width: 70%; float: right">
            <div class="row row-content">
                <h3 class="text-center na">${moderator.clinics.clinic_name}</h3>
                <hr>
                <div class="row">
                    <div class="row">
                        <!-- left column -->
                        <div class="col-md-3 col-md-offset-1">
                            <div class="text-center">
                                <img src="data:image/jpeg;base64,${photo}" class="avatar img-circle" alt="avatar" width="100"
                                     height="100">
                                <h6>Upload a different photo...</h6>
                                <%--<form action="upload" method="post" enctype="multipart/form-data">--%>
                                <%--<input class="btn btn-default" type="file"/>--%>
                                <%--<input type="submit" class="btn btn-default"/>--%>
                                <%--</form>--%>
                            </div>
                        </div>
                        <div class="col-md-7 personal-info">
                    <form:form method="POST" modelAttribute="clinicDTO" action="/moderator/cabinet">
                    <div class="form-group">
                        <label class="col-lg-3 control-label"><spring:message code="messages.userFirstname"/>:</label>
                        <div class="col-lg-7">
                            <form:input type="text" class="form-control" path="clinic_name"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label"> <spring:message code="messages.userLastname"/>:</label>
                        <div class="col-lg-7">
                            <form:textarea cssClass="form-control" path="description" value="${clinicDTO.description}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label"><spring:message code="messages.userEmail"/>:</label>
                        <div class="col-lg-7">
                            <form:input type="text" class="form-control" path="email" value="${clinic.contact.email}" disabled="false" cssStyle="background-color: #72d9b9;"/>
                        </div>
                    </div>



                    <div class="form-group">
                        <label class="col-lg-3 control-label"><spring:message code="messages.userAddress"/>:</label>
                        <div class="col-lg-7">
                            <form:input type="text" class="form-control d" path="address" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label"><spring:message code="messages.userCity"/>:</label>
                        <div class="col-lg-7">
                            <form:input type="text" class="form-control" path="city"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label"><spring:message code="messages.userZipcode"/>:</label>
                        <div class="col-lg-7">
                            <form:input type="text" class="form-control" path="zipCode"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label"><spring:message code="messages.userFirstPhone"/>:</label>
                        <div class="col-lg-7">
                            <form:input type="text" class="form-control" path="firstPhone"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label"><spring:message code="messages.userSecondPhone"/>:</label>
                        <div class="col-lg-7">
                            <form:input type="text" class="form-control" path="secondPhone"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label"><spring:message code="messages.userThirdPhone"/>:</label>
                        <div class="col-lg-7">
                            <form:input type="text" class="form-control" path="thirdPhone"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label"></label>
                        <div class="col-md-7">
                            <input type="submit" class="btn btn-primary"
                                   value="<spring:message code="messages.saveChanges"/>">
                            <span></span>
                            <input type="reset" class="btn btn-default"
                                   value="<spring:message code="messages.cancel"/>">
                        </div>
                    </div>
                </form:form>
                        </div>
                </div>
            </div>

        </div>
    </div>
</div>
</div>