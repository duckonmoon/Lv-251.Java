<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
                    <form action="upload" method="post" enctype="multipart/form-data">
                    <input class="btn btn-default" type="file"  />
                    <input type="submit"  class="btn btn-default"/>
                    </form>

                    <%--<div class="fileupload fileupload-new" data-provides="fileupload">--%>
                        <%--<span class="btn btn-primary btn-file"><span class="fileupload-new">Select file</span>--%>
                        <%--<span class="fileupload-exists">Change</span>--%>
                        <%--<input type="file"/></span>--%>
                        <%--<span class="fileupload-preview"></span>--%>
                        <%--<a href="#" class="close fileupload-exists" data-dismiss="fileupload" style="float: none">×</a>--%>
                    <%--</div>--%>
                </div>
            </div>
        </div>

        <!-- edit form column -->
        <div class="col-md-7 personal-info">
            <div class="alert alert-info alert-dismissable">
                <a class="panel-close close" data-dismiss="alert">×</a>
                <i class="fa fa-coffee"></i>
                This is an <strong>.alert</strong>. Use this to show important messages to the user.
            </div>
            <h3>Personal info</h3>

            <form class="form-horizontal" role="form">
                <div class="form-group">
                    <label class="col-lg-3 control-label">First name:</label>
                    <div class="col-lg-7">
                        <input class="form-control" type="text" value="${userObject.firstname}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-3 control-label">Last name:</label>
                    <div class="col-lg-7">
                        <input class="form-control" type="text" value="${userObject.lastname}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-3 control-label">Email:</label>
                    <div class="col-lg-7">
                        <input class="form-control" type="text" value="${userObject.email}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label">Password:</label>
                    <div class="col-md-7">
                        <input class="form-control" type="password" value="">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label">Confirm password:</label>
                    <div class="col-md-7">
                        <input class="form-control" type="password" value="">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label"></label>
                    <div class="col-md-7">
                        <input type="button" class="btn btn-primary" value="Save Changes">
                        <span></span>
                        <input type="reset" class="btn btn-default" value="Cancel">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</div>
<hr>