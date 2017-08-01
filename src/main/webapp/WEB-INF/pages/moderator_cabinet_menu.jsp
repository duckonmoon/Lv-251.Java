<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div >
    <div class="container" style="width: 30%; float: left">
        <div class="row row-content">
            <div class="list-group doc-menu">
                <a href="/moderator/cabinet" class="list-group-item navbar-inverse ${current=='moderator/cabinet'? 'active':''}">
                    <spring:message code="messages.clinic" />
                </a>
                <a href="/moderator/cabinet/doctors" class="list-group-item ${current=='moderator/cabinet/doctors'? 'active':''}">
                    <spring:message code="messages.doctors" /><span class="badge">${doctors.size()}</span>
                </a>
                <a href="/moderator/cabinet/add/doctor" class="list-group-item ${current=='moderator/cabinet/add/doctor'? 'active':''}">
                    <spring:message code="messages.addDoctors" />
                </a>
            </div>
        </div>
    </div>
</div>
