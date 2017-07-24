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

<c:if test="${!empty listClinics}">
    <table class="tg">

        <c:forEach items="${listClinics}" var="clinic">

            <div class="card">
                <div class="card-block">
                    <h4 class="card-title">${clinic.clinic_name}</h4>
                    <%--<h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>--%>
                    <p class="card-text">${clinic.description}</p>

                    <a href="#" class="card-link">More details</a>
                </div>
            </div>


        </c:forEach>
    </table>
</c:if>

</body>
</html>
