<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>


<div class="container" style="width: 70%; float: right">
    <div class="row row-content">
        <hr>
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



            <!-- edit form column -->
            <div class="col-md-7 personal-info">
                <div class="alert alert-info alert-dismissable">
                    <a class="panel-close close" data-dismiss="alert">×</a>
                    <i class="fa fa-coffee"></i>
                    This is an <strong>.alert</strong>. Use this to show important messages to the user.
                </div>
                <h3><spring:message code="messages.personalInfo"/></h3>
                <form:form method="POST" modelAttribute="userObject" action="/user/cabinet">
                    <div class="form-group">
                        <label class="col-lg-3 control-label"><spring:message code="messages.userFirstname"/>:</label>
                        <div class="col-lg-7">
                            <form:input type="text" class="form-control" path="firstname"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label"> <spring:message code="messages.userLastname"/>:</label>
                        <div class="col-lg-7">
                            <form:input type="text" class="form-control" path="lastname"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label"><spring:message code="messages.userEmail"/>:</label>
                        <div class="col-lg-7">
                            <form:input type="email" class="form-control" path="email"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label"></label>
                        <div class="col-md-7">
                            <input type="submit" class="btn btn-primary" value="<spring:message code="messages.saveChanges"/>">
                            <span></span>
                            <input type="reset" class="btn btn-default" value="<spring:message code="messages.cancel"/>">
                        </div>
                    </div>
                </form:form>
                    <hr>
                    <h3>Change Password</h3>
                    <div class="form-group">
                        <label class="col-md-3 control-label"><spring:message code="messages.userPassword"/>:</label>
                        <div class="col-md-7">
                            <input class="form-control" type="password" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label"><spring:message code="messages.userConfirmPassword"/>:</label>
                        <div class="col-md-7">
                            <input class="form-control" type="password" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label"></label>
                        <div class="col-md-7">
                            <input type="submit" class="btn btn-primary" value="<spring:message code="messages.saveChanges"/>"/>
                            <span></span>
                            <input type="reset" class="btn btn-default" value="<spring:message code="messages.cancel"/>"/>
                        </div>
                    </div>
            </div>
        </div>
    </div>
</div>
