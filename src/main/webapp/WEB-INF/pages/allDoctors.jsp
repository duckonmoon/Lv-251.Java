<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>




<link href="<c:url value="/resources/css/search.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-datetimepicker.css"/>" rel="stylesheet">
<div class="container">

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

    <%--Pagination--%>
    <%------------------------------------------------%>
    <div class="text-center">
        <ul class="pagination">
            <c:if test="${current>1}">
                <li id="previous" class="page-item"><a class="page-link" href="${current-1}">&laquo;</a></li>
            </c:if>
            <c:forEach begin="1" end="${numberChain}" varStatus="loop">
                <li id="current" class="${current == loop.index ? 'page-item active': 'page-item'}"><a class="page-link"
                                                                                                       href="/allDoctors/${loop.index}">${loop.index}</a>
                </li>
            </c:forEach>
            <c:if test="${current < numberChain}">
                <li id="next" class="page-item"><a class="page-link" href="${current+1}">&raquo;</a></li>
            </c:if>
        </ul>
    </div>
    <%------------------------------------------------%>

    <c:choose>
        <c:when test="${getDoctors.size()>0}">
            <div class="container">
                <c:forEach items="${getDoctors}" var="doctor">
                    <a href="doctors/${doctor.id}">
                        <div class="row row-content">
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-xs-6 col-md-3">
                                        <a href="#" class="thumbnail">
                                            <img width="200" height="200" src="data:image/jpeg;base64,${doctor.photo}" alt="...">
                                        </a>
                                    </div>
                                    <a href="/doctors/${doctor.id}" class="btn-link">
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

                    <!--Modal-->
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
                                    <div class="form-group" style="text-align: center;  margin-bottom: 10pt; margin-top: 10pt">
                                        <div class="input-append date form_datetime" id="date-div">
                                            <label for="first-date" style="margin-left: 5pt"><spring:message code="messages.date"/></label>
                                            <input type="text" value="" readonly id="first-date" name="datetime">
                                            <span class="add-on"><i class="icon-remove fa fa-times"></i></span>
                                            <span class="add-on"><i class="icon-calendar fa fa-calendar"></i></span>
                                        </div>
                                    </div>
                                    <input name="doctorId" value="${doctor.id}" style="display: none">
                                    <input name="current" value="${current}" style="display: none">
                                    <div style="text-align: center">
                                        <button class="btn btn-primary" style="width: 50%; margin: 5pt auto;">
                                            <spring:message code="messages.approve"/>
                                        </button>
                                    </div>
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

<%--Pagination--%>
<%------------------------------------------------%>
<div class="text-center">
    <ul class="pagination">
        <c:if test="${current>1}">
            <li id="previous" class="page-item"><a class="page-link" href="${current-1}">&laquo;</a></li>
        </c:if>
        <c:forEach begin="1" end="${numberChain}" varStatus="loop">
            <li id="current" class="${current == loop.index ? 'page-item active': 'page-item'}"><a class="page-link"
                                                                                                   href="/allDoctors/${loop.index}">${loop.index}</a>
            </li>
        </c:forEach>
        <c:if test="${current < numberChain}">
            <li id="next" class="page-item"><a class="page-link" href="${current+1}">&raquo;</a></li>
        </c:if>
    </ul>
</div>
<%------------------------------------------------%>





<script src="<c:url value="/resources/js/jquery.1.10.2.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap-datetimepicker.min.js"/>"></script>

<script type="text/javascript">
    $(".form_datetime").datetimepicker({
        format: "dd/mm/yyyy - hh:ii",
        autoclose: true,
        todayBtn: true,
        minuteStep: 10
    });
</script>

<c:if test="${flag}">
    <c:set var="docId" value="${doc}"/>
    <script>
        document.getElementById('wrong-date').innerHTML= '<spring:message code="messages.invalidDate"/>';
        jQuery(window).load(function(){
            jQuery('#modal_${docId}').modal('show')
        });
    </script>
</c:if>