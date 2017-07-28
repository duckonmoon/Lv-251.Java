<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<div class="container">
    <div class="row" style="margin-top: 50px">

        <nav class="navbar navbar-inverse">
            <div  class="container-fluid">

                    <div class="navbar-form " >
                        <div class="form-group">

                                        <select class="selectpicker form-control"style="width:210px " id="selectDocOrClinic">
                                            <option id="option-clinic" value="0">Clinic search</option>
                                            <option  id="option-doc" value="1">Doctors search</option>
                                        </select>


                            <input type="text" class="form-control " id="autocomplete" style="width: 570px" placeholder="Search">

                                <input type="text" class="form-control " style="width: 210px" placeholder="Enter Distinct" >
                        </div>
                        <button id="main-search-btn" class="btn btn-facebook">Submit</button>
                    </div>

                </div>

        </nav>

<div class="content" id="content">dd</div>

    </div>
</div>