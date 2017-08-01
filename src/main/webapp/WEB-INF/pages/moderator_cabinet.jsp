<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<div class="container">
    <tiles:insertAttribute name="menu"/>

    <tiles:insertAttribute name="body"/>
</div>