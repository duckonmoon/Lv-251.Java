<%--
  Created by IntelliJ IDEA.
  User: maria
  Date: 26.07.2017
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<script src="<c:url value="/resources/js/jquery.1.10.2.min.js"/>"></script>
<script>
    document.getElementById('wrongReg').innerHTML= '<spring:message code="messages.invalidLoginOrPassword"/>';
    jQuery(window).load(function(){
        jQuery('#loginModal').modal('show')
    });
</script>
