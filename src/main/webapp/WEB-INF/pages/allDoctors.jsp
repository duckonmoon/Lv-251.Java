<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${doctors.size()>0}">
        ...<div class="container">
        <c:forEach items="${doctors}" var="doctor">
            <a href="doctor/${doctor.id}">
                <div class="row row-content">
                    <div class="container-fluid">
                        <p>${doctor.firstname} ${doctor.lastname} ${doctor.middlename}</p>
                        <p>Specialization:${doctor.specialization.name}</p>
                        <img class="show-logo" alt="logo" src="resources/img/clinic_logo.png">
                    </div>
                </div>
            </a>
        </c:forEach>
        </div>
    </c:when>
    <c:otherwise>
        <div class="container">
        <div class="row row-content">
            <div class="container-fluid">
               There are no doctors in database
            </div>
        </div>
        <div class="row row-content">
            <div class="container-fluid">
                There are no doctors in database
            </div>
        </div><div class="row row-content">
        <div class="container-fluid">
            There are no doctors in database
        </div>
    </div><div class="row row-content">
        <div class="container-fluid">
            There are no doctors in database
        </div>
    </div><div class="row row-content">
        <div class="container-fluid">
            There are no doctors in database
        </div>
    </div><div class="row row-content">
        <div class="container-fluid">
            There are no doctors in database
        </div>
    </div>
        <div class="row row-content">
            <div class="container-fluid">
                There are no doctors in database
            </div>
        </div>
        <div class="row row-content">
            <div class="container-fluid">
                There are no doctors in database
            </div>
        </div>

        <div class="row row-content">
            <div class="container-fluid">
                There are no doctors in database
            </div>
        </div>
        <div class="row row-content">
            <div class="container-fluid">
                There are no doctors in database
            </div>
        </div>
        <div class="row row-content">
            <div class="container-fluid">
                There are no doctors in database
            </div>
        </div>
        <div class="row row-content">
            <div class="container-fluid">
                There are no doctors in database
            </div>
        </div>





    </c:otherwise>
</c:choose>
