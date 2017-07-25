<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Home</title>

    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap-theme.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/font-awesome.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap-social.css"/>" rel="stylesheet">

</head>
<body>
<!--REGISTER MODAL________________________________________________________________________________________________________________________________________-->
<div id="registerModal">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Create Account</h4>
            </div>
            <div class="modal-body">
                <form:form class="form-inline" method="POST" modelAttribute="userForm">
                    <spring:bind path="firstName">
                        <div class="form-group">
                            <label class="sr-only" for="firstName">First name</label>
                            <form:input type="text" id="firstName" path="firstName"
                                        name="firstName" class="form-control" placeholder="First name" autofocus="true"/>
                            <form:errors path="firstName"/>
                        </div>
                    </spring:bind>
                    <spring:bind path="lastName">
                        <div class="form-group">
                            <label class="sr-only" for="lastName">Last name</label>
                            <form:input type="text" id="emailReg" path="lastName" name="lastName"
                                        class="form-control" placeholder="Last name" autofocus="true"/>
                            <form:errors path="lastName"/>
                        </div>
                    </spring:bind>
                    <spring:bind path="email">
                        <div class="form-group">
                            <label class="sr-only" for="emailReg">Email address</label>
                            <form:input type="text" id="emailReg" path="email"
                                        name="emailReg" class="form-control" placeholder="Email" autofocus="true"/>
                            <form:errors path="email"/>
                        </div>
                    </spring:bind>
                    <spring:bind path="password">
                        <div class="form-group">
                            <label class="sr-only" for="passwordReg">Password</label>
                            <form:input type="password" id="passwordReg" path="password"
                                        name="passwordReg" class="form-control" placeholder="Password"/>
                            <form:errors path="password"/>
                        </div>
                    </spring:bind>
                    <spring:bind path="matchingPassword">
                        <div class="form-group">
                            <label class="sr-only" for="passwordConfirmReg">Password</label>
                            <form:input type="password" id="passwordConfirmReg" path="matchingPassword"
                                        name="passwordConfirm" class="form-control" placeholder="Confirm your password"/>
                            <form:errors path="matchingPassword"/>
                        </div>
                    </spring:bind>
                    <div class="form-group">
                        <button class="btn btn-info">Register</button>
                    </div>

                </form:form>
            </div>
        </div>
    </div>
</div>

<!-- FOOTER*****************************************************************************************************************************************-->
<footer>
    <div class="container">
        <div class="row row-footer">
            <div class="col-xs-5 col-offset-1 col-sm-2 col-sm-offset-1">
                <h5>Links</h5>
                <ul class="list-unstyled">
                    <li><a href=<c:url value="/index"/>>Home</a></li>
                    <li><a href="#">Clinics</a></li>
                    <li><a href="#">Doctors</a></li>
                    <li><a href="#">Contact</a></li>
                </ul>
            </div>
            <div class="col-xs-6 col-sm-5">
                <h5>Our Address</h5>
                <address>
                    Fedkovycha street, 60<br>
                    Lviv<br>
                    Ukraine<br>
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
</footer>

<script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</body>
</html>


