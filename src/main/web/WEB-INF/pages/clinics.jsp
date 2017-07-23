<title>Clinics Page</title>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
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

<h1>Clinics List</h1>

<c:if test="${!empty listClinics}">
    <table class="tg">
        <tr>
            <th width="10">ID</th>
            <th width="40">Name</th>
            <th width="70">Decryption</th>
        </tr>
        <c:forEach items="${listClinics}" var="clinic">
            <tr>
                <td>${clinic.id}</td>
                <td>${clinic.clinic_name}</td>
                <td>${clinic.description}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<div align="center">
    <form id="back_form" >
        <button id="back_button" type="button" class="button" name="back"
                onclick="location.href='<c:url value="/index.jsp"/>'">Back</button>
    </form>
</div>
<!-- FOOTER*****************************************************************************************************************************************-->
<footer>
    <div class="container">
        <div class="row row-footer">
            <div class="col-xs-5 col-offset-1 col-sm-2 col-sm-offset-1">
                <h5>Links</h5>
                <ul class="list-unstyled">
                    <li><a href=<c:url value="/index.jsp"/>>Home</a></li>
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

<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
