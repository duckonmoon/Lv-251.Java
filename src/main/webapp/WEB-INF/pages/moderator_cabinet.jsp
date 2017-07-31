<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container">
    <div >
        <div class="container" style="width: 30%; float: left">
            <div class="row row-content">
                <div class="list-group doc-menu">
                    <a href="/moderator/cabinet" class="list-group-item navbar-inverse active">
                        <spring:message code="messages.clinic" />
                    </a>
                    <a href="/moderator/cabinet/doctors" class="list-group-item">
                        <spring:message code="messages.doctors" /><span class="badge">${doctorsSize}</span>
                    </a>
                    <a href="/moderator/cabinet/add/doctor" class="list-group-item">
                        <spring:message code="messages.addDoctors" />
                    </a>
                </div>
            </div>
        </div>
    </div>

    <div>
        <div class="container" style="width: 70%; float: right">
            <div class="row row-content">
                <h3 class="text-center">${moderator.clinics.clinic_name}</h3>
                <hr>
                <div class="row">
                    <!-- left column -->
                    <div class="col-md-3 col-md-offset-1">
                        <div>
                            <img src="/resources/img/User_Default.png" width="100" class="avatar img-circle" alt="avatar">
                            <p>Change photo</p>
                        </div>
                    </div>
                    <div>${moderator.clinics.description}</div>
                </div>
            </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>