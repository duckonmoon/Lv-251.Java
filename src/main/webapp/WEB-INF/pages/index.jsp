<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<div class="container">
    <div class="row" style="margin-top: 50px">

        <nav class="navbar navbar-inverse">
            <div  class="container-fluid">

                    <div class="navbar-form " >
                        <div class="form-group">

                                        <select class="selectpicker form-control"style="width:210px " id="selectDocOrClinic">
                                            <option id="option-clinic" value="0"><spring:message code="messages.clinicsSearch"/></option>
                                            <option  id="option-doc" value="1"><spring:message code="messages.doctorsSearch"/></option>
                                        </select>
                            <div class="input-group ">
                            <span class="input-group-addon" id="sizing-addon1"><i class="fa fa-ambulance change" aria-hidden="true" style="color: #226ed9"></i></span>
                            <input type="text" class="form-control " id="autocomplete" style="width: 550px" placeholder="Search"aria-describedby="sizing-addon1">
                            </div>
                                <input type="text" class="form-control " style="width: 210px" placeholder='<spring:message code="messages.distinct"/>' >
                        </div>
                        <button id="main-search-btn" class="btn btn-facebook"><spring:message code="messages.search"/></button>
                    </div>

                </div>

        </nav>

<div class="content" id="content"></div>

    </div>
</div>