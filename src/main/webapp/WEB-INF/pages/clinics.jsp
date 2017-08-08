<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>


<div class="container">

    <%--Pagination--%>
    <%-----------------------------------------------------%>
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
                            <a href="#" class="btn-link">
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
                    <li id="current" class="${current == loop.index ? 'page-item active': 'page-item'}"><a class="page-link"
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






