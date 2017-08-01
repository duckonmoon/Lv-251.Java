<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>


<div class="container">
    <div class="text-center">
        <ul class="pagination">
            <c:if test="${current>1}">
                <li id="previous" class="page-item"><a class="page-link" href="${current-1}">&laquo;</a></li>
            </c:if>
            <c:forEach begin="1" end="${numberChain}" varStatus="loop">
                <li id="current" class="${current == loop.index ? 'page-item active': 'page-item'}"><a class="page-link"
                                                                                                       href="/clinics/${loop.index}">${loop.index}</a>
                </li>
            </c:forEach>
            <c:if test="${current < numberChain}">
                <li id="next" class="page-item"><a class="page-link" href="${current+1}">&raquo;</a></li>
            </c:if>
        </ul>
    </div>

    <c:forEach items="${getClinics}" var="clinic">
    <a href="clinic/${clinic.id}">
        <a href="clinics/details/${clinic.id}">
            <div class="row row-content">
                <div class="container-fluid">
                    <p>${clinic.clinic_name}</p>
                    <img class="show-logo" alt="logo" src="<c:url value="/resources/img/clinic_logo.png"/>">
                </div>
            </div>
        </a>
        </c:forEach>

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
</div>






