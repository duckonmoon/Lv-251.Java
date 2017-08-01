<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <div class="container" style="width: 70%; float: right">
        <div class="row row-content">
            <h3 class="text-center">${moderator.clinics.clinic_name}</h3>
            <hr>
            <div class="row">
                <c:choose>
    <c:when test="${doctors.size()>0}">
        <c:forEach items="${doctors}" var="doctor">
                <div class="col-xs-6 col-sm-6 col-md-10 col-lg-10 col-md-offset-1 ">
                    <div class="row">
                        <div class="col-xs-6 col-md-3 col-lg-2">
                            <img src="/resources/img/User_Default.png" width="100" class="avatar img-circle" alt="avatar">
                        </div>
                        <div class="col-md-1 col-lg-1"></div>
                        <div class="col-xs-6 col-md-8 col-lg-9">
                            <div class="row">
                                <div> ${doctor.firstname}  ${doctor.lastname}</div>
                                <p>Specialization: ${doctor.specialization.name}</p>
                            </div>
                            <div class="row">
                                <a href="/moderator/cabinet/doctors/edit/${doctor.id}"><button  class="btn btn-facebook " >Edit doctor</button ></a>
                                <a href="/moderator/cabinet/doctors/delete/${doctor.id}"><button  class="btn btn-facebook" >Delete doctor</button ></a>
                            </div>
                            <hr>
                        </div>
                    </div>


                </div>
        </c:forEach>
    </c:when>
                <c:otherwise>
                    <div class="col-md-3 col-md-offset-1" style="background-color: #1ab7ea;width: 80% ;margin-top: 5%>
                            There no doctors in clinic
                    </div>
                </c:otherwise>
                </c:choose>
            </div>
        </div>

    </div>
</div>