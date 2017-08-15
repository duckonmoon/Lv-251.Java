<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>


<div class="container">
    <%--Search--%>
    <div class="row" style="margin-top: 50px">
        <p id="clinic" style="display: none"><spring:message code="messages.searchClinics"/></p>
        <p id="doctor" style="display: none"><spring:message code="messages.searchDoctors"/></p>
        <p id="docByspec" style="display: none"><spring:message code="messages.doctorsSearchBySpec"/></p>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-form " style="width: 95%">
                    <div class="form-group" style="width: 90%">
                        <select class="selectpicker form-control" style="width:18% " id="selectDocOrClinic">
                            <option id="option-clinic" value="0"><spring:message
                                    code="messages.clinicsSearch"/></option>
                        </select>
                        <div class="input-group " style="width: 60%">
                            <span class="input-group-addon" id="sizing-addon1" style="width: 8%"><i
                                    class="fa fa-ambulance change"
                                    aria-hidden="true"
                                    style="color: #226ed9"></i></span>
                            <input type="text" class="form-control " id="autocomplete"
                                   placeholder='<spring:message code="messages.searchClinics"/>'
                                   aria-describedby="sizing-addon1">
                        </div>
                        <input id="autocomplete-districts" type="text" class="form-control " style="width: 20%"
                               placeholder='<spring:message code="messages.district"/>'>
                    </div>
                    <a href="/">
                        <button id="main-search-btn" class="btn btn-facebook"><spring:message
                                code="messages.search"/></button>
                    </a>
                </div>
            </div>
        </nav>
    </div>
    <%-----------------------------------------------------%>
    <div class="container col-lg-8">
        <%--Pagination--%>
        <%-----------------------------------------------------%>
        <div class="content">
            <div class="text-center">
                <ul class="pagination">
                    <c:if test="${current>1}">
                        <li id="previous" class="page-item"><a class="page-link" href="${current-1}">&laquo;</a></li>
                    </c:if>
                    <c:forEach begin="1" end="${numberChain}" varStatus="loop">
                        <c:if test="${numberChain>1}">
                            <li id="current" class="${current == loop.index ? 'page-item active': 'page-item'}"><a
                                    class="page-link"
                                    href="/clinics/${loop.index}">${loop.index}</a>
                            </li>
                        </c:if>
                    </c:forEach>
                    <c:if test="${current < numberChain}">
                        <li id="next" class="page-item"><a class="page-link" href="${current+1}">&raquo;</a></li>
                    </c:if>
                </ul>
            </div>
            <%-----------------------------------------------------%>
            <%--list of clinics--%>
            <c:forEach items="${getClinics}" var="clinic">
                <a href="clinic/${clinic.id}">
                    <div class="row row-content">
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-xs-6 col-md-3">
                                    <a href="#" class="thumbnail">
                                        <img width="200" height="200" src="data:image/jpeg;base64,${clinic.photo}"
                                             alt="...">
                                    </a>
                                </div>
                                <a href="details/${clinic.id}" class="btn-link">
                                    <span class="doc-name"> ${clinic.clinic_name}</span>
                                </a>
                                <p><spring:message code="messages.clinicPhone"/>: ${clinic.contact.firstPhone}</p>
                                <hr>
                                <p><spring:message
                                        code="messages.clinicAddress"/>: ${clinic.contact.city}, ${clinic.contact.address}</p>
                                <p><spring:message
                                        code="messages.clinicDistrict"/>: ${clinic.contact.district.name}</p>
                            </div>
                        </div>
                    </div>
                </a>
            </c:forEach>
            <%-----------------------------------------------------%>
            <%--Pagination--%>
            <%-----------------------------------------------------%>
            <div class="text-center">
                <ul class="pagination ">
                    <c:if test="${current>1}">
                        <li id="previous" class="page-item "><a class="page-link" href="${current-1}">&laquo;</a></li>
                    </c:if>
                    <c:forEach begin="1" end="${numberChain}" varStatus="loop">
                        <c:if test="${numberChain>1}">
                            <li id="current" class="${current == loop.index ? 'page-item active': 'page-item'}"><a
                                    class="page-link"
                                    href="/clinics/${loop.index}">${loop.index}</a>
                            </li>
                        </c:if>
                    </c:forEach>
                    <c:if test="${current < numberChain}">
                        <li id="next" class="page-item"><a class="page-link" href="${current+1}">&raquo;</a></li>
                    </c:if>
                </ul>
            </div>
            <%-----------------------------------------------------%>
        </div>
    </div>
    <%--google map--%>
    <aside class="container col-lg-4 hidden-xs hidden-sm" style="overflow: inherit">
        <div style="width: 25em; height: 30em; position:fixed">
            <div id="map" style="width: 100%; height: 100%"/>
        </div>
    </aside>
    <%-----------------------------------------------------%>
</div>

<script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/js/map.js"/>"></script>
<script src="https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/markerclusterer.js">
</script>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDVONjkQbC8wtyxPapK8TvGe8IbIYfIIEA&callback=initMap">
</script>





