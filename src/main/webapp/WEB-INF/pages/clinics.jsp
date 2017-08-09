<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>


<div class="container">
    <div class="row" style="position: relative">

        <div class="container col-md-8">

            <%--Pagination--%>
            <%-----------------------------------------------------%>
            <div class="text-center">
                <ul class="pagination">
                    <c:if test="${current>1}">
                        <li id="previous" class="page-item"><a class="page-link" href="${current-1}">&laquo;</a></li>
                    </c:if>
                    <c:forEach begin="1" end="${numberChain}" varStatus="loop">
                        <li id="current" class="${current == loop.index ? 'page-item active': 'page-item'}"><a
                                class="page-link"
                                href="/clinics/${loop.index}">${loop.index}</a>
                        </li>
                    </c:forEach>
                    <c:if test="${current < numberChain}">
                        <li id="next" class="page-item"><a class="page-link" href="${current+1}">&raquo;</a></li>
                    </c:if>
                </ul>
            </div>
            <%-----------------------------------------------------%>


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
                                    <span class="doc-name">${clinic.clinic_name}</span>
                                </a>
                            </div>
                        </div>
                    </div>
                </a>
            </c:forEach>


            <%--Pagination--%>
            <%-----------------------------------------------------%>
            <div class="text-center">
                <ul class="pagination ">
                    <c:if test="${current>1}">
                        <li id="previous" class="page-item "><a class="page-link" href="${current-1}">&laquo;</a></li>
                    </c:if>
                    <c:forEach begin="1" end="${numberChain}" varStatus="loop">
                        <li id="current" class="${current == loop.index ? 'page-item active': 'page-item'}"><a
                                class="page-link"
                                href="/clinics/${loop.index}">${loop.index}</a>
                        </li>
                    </c:forEach>
                    <c:if test="${current < numberChain}">
                        <li id="next" class="page-item"><a class="page-link" href="${current+1}">&raquo;</a></li>
                    </c:if>
                </ul>
            </div>
            <%-----------------------------------------------------%>
        </div>

        <div class="container col-md-4" style="overflow: inherit">
            <div style="width: 100%; height: 100%; position: fixed">
                <div>
                    <div >
                        <div id="map" style="width: 100%; height: 100%"/>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>


<script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/js/map.js"/>"></script>
<script src="https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/markerclusterer.js">
</script>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDVONjkQbC8wtyxPapK8TvGe8IbIYfIIEA&callback=initMap">
</script>





