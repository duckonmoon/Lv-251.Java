<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>




<link href="<c:url value="/resources/css/search.css"/>" rel="stylesheet">
<div class="container">
    <%--<div class="row">--%>
        <%--<h2></h2>--%>
        <%--<div id="custom-search-input">--%>

            <%--<div class="input-group col-md-12">--%>
                <%--<input type="text" id="autocomplete" name="search" class="  search-query form-control" placeholder='<spring:message code="messages.searchDoctors"/>' />--%>
                <%--<span class="input-group-btn">--%>
                                    <%--<button class="btn btn-danger" onclick="task2()"  id="search-doctor">--%>
                                        <%--<span class=" glyphicon glyphicon-search"></span>--%>
                                    <%--</button>--%>

                                <%--</span>--%>
            <%--</div>--%>

        <%--</div>--%>
    <%--</div>--%>
        <div class="container">
            <div class="row" style="margin-top: 50px">

                <nav class="navbar navbar-inverse">
                    <div  class="container-fluid">
                        <p id="p-doctor" style="display: none"><spring:message code="messages.searchDoctors" /></p>
                        <p id="p-doc-by-spec" style="display: none"><spring:message code="messages.doctorsSearchBySpec" /></p>
                        <div class="navbar-form " >
                            <div class="form-group">

                                <select class="selectpicker form-control"style="width:210px " id="selectDocOrClinic">
                                    <option  value="3"><spring:message code="messages.chooseSearch"/></option>
                                    <option  value="1"><spring:message code="messages.doctorsSearch"/></option>
                                    <option   value="2"><spring:message code="messages.doctorsSearchBySpec"/></option>
                                </select>
                                <div class="input-group ">
                                    <span class="input-group-addon" id="sizing-addon1"><i class="fa fa-ambulance change" aria-hidden="true" style="color: #226ed9"></i></span>
                                    <input type="text" class="form-control " id="autocomplete" style="width: 530px" placeholder=''aria-describedby="sizing-addon1">
                                </div>
                                <input id="autocomplete-districts" type="text" class="form-control " style="width: 210px" placeholder='<spring:message code="messages.district"/>' >
                            </div>
                            <a href="/allDoctors"><button id="main-search-btn" class="btn btn-facebook"><spring:message code="messages.search"/></button></a>
                        </div>

                    </div>

                </nav>



            </div>
        </div>
</div>
<div id="content">



<c:choose>
    <c:when test="${doctors.size()>0}">
        <div class="container">
        <c:forEach items="${doctors}" var="doctor">
            <a href="doctors/${doctor.id}">
                <div class="row row-content">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-xs-6 col-md-3">
                                <a href="#" class="thumbnail">
                                    <img width="200" height="200" src="/resources/img/User_Default.png" alt="...">
                                </a>
                            </div>
                            <a href="doctors/${doctor.id}" class="btn-link">
                                <span class="doc-name">${doctor.firstname} ${doctor.lastname} ${doctor.middlename}</span>
                            </a>
                            <p><spring:message code="messages.specialization"/>:${doctor.specialization.name}</p>
                            <button  class="btn btn-facebook" style="margin-top: 10%;margin-left: 55%" data-toggle="modal" data-target="#modal_${doctor.id}">
                                <spring:message code="messages.addAppointment"/>
                            </button >
                        </div>

                    </div>
                </div>
            </a>

            <div id="modal_${doctor.id}" class="modal fade" role="dialog">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <div class="row">
                                <div class="col-xs-6 col-md-9 col-lg-9">
                                    <div class="row">
                                        <div class="col-xs-6 col-md-3 col-lg-2">
                                            <img width="200" height="200" src="/resources/img/User_Default.png" alt="...">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-6 col-md-3 col-lg-3">
                                    <div class="row">
                                        <h4 class="form-heading"><spring:message code="messages.appointmentTo"/></h4>
                                    </div>
                                    <div class="row">
                                        <span class="doc-name">${doctor.lastname}</span>
                                    </div>
                                    <div class="row">
                                        <span class="doc-name">${doctor.firstname} ${doctor.middlename}</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-content">
                        <form action="${pageContext.request.contextPath}/user/addAppointment" method="post">
                            <div class="form-group">
                                    <label for="first-date" style="margin-left: 5pt"><spring:message code="messages.date"/></label>
                                    <input type="datetime-local" class="form-control" id="first-date" name="datetime">
                                    <input name="doctorId" value="${doctor.id}" style="display: none">
                            </div>
                            <button class="btn btn-lg btn-primary btn-block">
                                <spring:message code="messages.approve"/>
                            </button>
                            <h5 style="color: red; text-align: center" id="wrong-date"></h5>
                        </form>
                    </div>
                </div>
            </div>

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
        </div>
    </c:otherwise>
</c:choose>
</div>

<script src="<c:url value="/resources/js/jquery.1.10.2.min.js"/>"></script>


<c:if test="${flag}">
<c:set var="docId" value="${doc}"/>
    <script>
    document.getElementById('wrong-date').innerHTML= '<spring:message code="messages.invalidDate"/>';
    jQuery(window).load(function(){
        jQuery('#modal_${docId}').modal('show')
    });
</script>
</c:if>
