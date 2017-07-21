<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Home</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/bootstrap-social.css" rel="stylesheet">

</head>
<body>
<!--NAVBAR***************************************************************************************************************************************-->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.html">
                <img src="img/heartbeat2.png" height=35 width=100>
            </a>
        </div>

        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="index.html"><span class="glyphicon glyphicon-home"
                                                              aria-hidden="true"></span> Home</a></li>
                <li>
                    <a href="#">
                        <span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
                        Clinics</a>
                </li>
                <li>
                    <a href="#">
                        <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                        Doctors</a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-envelope-o"></i> Contact</a>
                </li>
                <li>
                    <a class="navbar-brand pull-right" href="index.html">
                        <img src="img/heartbeat2.png" height=35 width=100>
                    </a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a type="button" id="loginBtn" data-toggle="modal" data-target="#loginModal">
                    <span class="glyphicon glyphicon-log-in"></span> Login</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!--LOGIN MODAL________________________________________________________________________________________________________________________________________-->
<div id="loginModal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Login</h4>
            </div>
            <div class="modal-body">
                <form class="form-inline">
                    <div class="form-group">
                        <label class="sr-only" for="email">Address Email</label>
                        <input type="email" class="form-control" id="email" name="email" placeholder="Email">
                    </div>
                    <div class="form-group">
                        <label class="sr-only" for="password">Password</label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                    </div>
                    <div class="checkbox">
                        <label>
                            <input type="checkbox"> Remember me
                        </label>
                    </div>
                    <div class="form-group">
                        <button type="sign-in" class="btn btn-info">Sign in</button>
                        <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Cancel</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- CONTAINER*****************************************************************************************************************************************-->
<div class="container">

    <div class="row row-content">
        <div class="container-fluid">
            HERE GOES THE SEARCH BOX
        </div>
    </div>

    <div class="row row-content">
        <div class="container-fluid">
            HERE GOES THE CONTENT
            <img class="show-logo" alt="logo" src="./img/clinic_logo.png">
        </div>
    </div>

</div>


<!-- FOOTER*****************************************************************************************************************************************-->
<footer>
    <div class="container">
        <div class="row row-footer">
            <div class="col-xs-5 col-offset-1 col-sm-2 col-sm-offset-1">
                <h5>Links</h5>
                <ul class="list-unstyled">
                    <li><a href="index.html">Home</a></li>
                    <li><a href="#">Clinics</a></li>
                    <li><a href="#">Doctors</a></li>
                    <li><a href="#">Contact</a></li>
                </ul>
            </div>
            <div class="col-xs-6 col-sm-5">
                <h5>Our Address</h5>
                <address>
                    Fedkovycha street, 60<br>
                    Lviv<br>
                    Ukraine<br>
                    <i class="fa fa-phone"></i>: +382 1234 5678<br>
                    <i class="fa fa-fax"></i>: +382 8765 4321<br>
                    <i class="fa fa-envelope"></i>:<a href="mailto:confusion@food.net">heartbeat@clinic.net</a>
                </address>
            </div>
            <div class="col-xs-12 col-sm-4">
                <div class="nav navbar-nav" style="padding: 40px 10px;">
                    <a class="btn btn-social-icon btn-facebook" href="http://www.facebook.com/profile.php?id="><i
                            class="fa fa-facebook"></i></a>
                    <a class="btn btn-social-icon btn-linkedin" href="http://www.linkedin.com/in/"><i
                            class="fa fa-linkedin"></i></a>
                    <a class="btn btn-social-icon btn-twitter" href="http://twitter.com/"><i class="fa fa-twitter"></i></a>
                    <a class="btn btn-social-icon btn-youtube" href="http://youtube.com/"><i class="fa fa-youtube"></i></a>
                </div>
            </div>
            <div class="col-xs-12">
                <p style="padding:10px;"></p>
                <p align="center">© Copyright 2017 SoftServe Inc.</p>
            </div>
        </div>
    </div>
</footer>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>