<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<div class="container">
    <div class="row" style="margin-top: 50px">

        <p id="clinic" style="display: none"><spring:message code="messages.searchClinics" /></p>
        <p id="doctor"  style="display: none"><spring:message code="messages.searchDoctors" /></p>
        <p id="docByspec" style="display: none"><spring:message code="messages.doctorsSearchBySpec" /></p>


        <nav class="navbar navbar-inverse">
            <div class="container-fluid">

                <div class="navbar-form " style="width: 95%">
                    <div class="form-group" style="width: 90%">

                        <select class="selectpicker form-control" style="width:18% " id="selectDocOrClinic">
                            <option id="option-clinic" value="0"><spring:message
                                    code="messages.clinicsSearch"/></option>
                            <option id="option-doc" value="1"><spring:message code="messages.doctorsSearch"/></option>
                            <option id="option-doc-spec" value="2"><spring:message
                                    code="messages.doctorsSearchBySpec"/></option>
                        </select>
                        <div class="input-group " style="width: 60%">
                            <span class="input-group-addon" id="sizing-addon1"><i class="fa fa-ambulance change"
                                                                                  aria-hidden="true"
                                                                                  style="color: #226ed9 " ></i></span>
                            <input type="text" class="form-control " id="autocomplete"
                                   placeholder='<spring:message code="messages.searchClinics"/>'
                                   aria-describedby="sizing-addon1">
                        </div>
                        <input id="autocomplete-districts" type="text" class="form-control " style="width: 20%"
                               placeholder='<spring:message code="messages.district"/>'>
                    </div>
                    <a href="/">
                        <button id="main-search-btn" class="btn btn-facebook" style="width: 8%"><spring:message
                                code="messages.search"/></button>
                    </a>
                </div>

            </div>

        </nav>

        <div class="content" id="content"></div>

    </div>
</div>