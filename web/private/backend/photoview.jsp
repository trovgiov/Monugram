
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>


<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="../../assets_back/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="../../assets_back/img/favicon.png">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>HeGO - Photo Managment</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />



    <!-- jTable metro styles. -->
    <link href="/css/metro/darkorange/jtable.css" rel="stylesheet" type="text/css" />
    <link href="/css/jquery-ui-1.10.3.custom.css" rel="stylesheet"
          type="text/css" />


    <!-- User defined Jtable js file -->
     <!-- Bootstrap core CSS     -->
    <link href="../../assets_back/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="../../assets_back/css/animate.min.css" rel="stylesheet"/>

    <!--  Paper Dashboard core CSS    -->
    <link href="../../assets_back/css/paper-dashboard.css" rel="stylesheet"/>

    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="../../assets_back/css/demo.css" rel="stylesheet" />

    <!--  Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <link href="../../assets_back/css/themify-icons.css" rel="stylesheet">

    <!-- ACCORDION CODE -->
    <link rel="stylesheet" href="../../assets_back/css/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="../../assets_back/css/jquery-ui.js"></script>
    <script>
        $(function() {
            $("#accordion" ).accordion({
                collapsible: true,
                heightStyle: "content"
            });
        });

    </script>


</head>
<body>

<div class="wrapper">
	<div class="sidebar" data-background-color="white" data-active-color="danger">

    <!--
		Tip 1: you can change the color of the sidebar's background using: data-background-color="white | black"
		Tip 2: you can change the color of the active button using the data-active-color="primary | info | success | warning | danger"
	-->


        <div class="sidebar-wrapper">
            <div class="logo">
                He<em>GO</em>
            </div>

            <ul class="nav">
                <li>
                    <a href="<s:url action="home_back"/>">
                        <i class="ti-panel"></i>
                        <p>Dashboard</p>
                    </a>
                </li>
                <li>
                    <a href="<s:url action="users"/>">
                        <i class="ti-user"></i>
                        <p>Utenti</p>
                    </a>
                </li>
                <li class="active">
                    <a href="<s:url action="photoview"/>">
                        <i class="ti-gallery"></i>
                        <p>Foto</p>
                    </a>
                </li>
                <li>
                    <a href="<s:url action="monumentview"/>">
                        <i class="ti-location-pin"></i>
                        <p>Monumenti</p>
                    </a>
                </li>

            </ul>
        </div>
    </div>

    <div class="main-panel">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar bar1"></span>
                        <span class="icon-bar bar2"></span>
                        <span class="icon-bar bar3"></span>
                    </button>
                    <a class="navbar-brand" href="#">Dashboard</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="ti-bell"></i>
                                <p class="notification">5</p>
                                <p>Notifiche</p>
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Notifica 1</a></li>
                                <li><a href="#">Notifica 2</a></li>
                                <li><a href="#">Notifica 3</a></li>
                                <li><a href="#">Notifica 4</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="/public/frontend/login.jsp">
                                <i class="ti-power-off"></i>
                                <p>Logout</p>
                            </a>
                        </li>
                    </ul>

                </div>
            </div>
        </nav>


        <div class="content">


            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">


                        <div class="card">
                            <div class="header">
                                <h4 class="title">Foto</h4>
                             </div>
                            <div id="accordion">
                                <h3>Foto Non Approvate</h3>
                                <div style="height: auto">
                                    <p>
                                        <div id="PhotoTableContainer"></div>
                                    </p>
                                </div>
                                <h3>Foto Approvate</h3>
                                <div style="height: auto">
                                    <p>
                                        <div id="PhotoCheckedTableContainer"></div>
                                    </p>
                                </div>
                                <h3>Foto Ignorate</h3>
                                <div style="height: auto">
                                    <p>
                                        <h3>Qui Andranno le foto ignorate</h3>
                                    </p>
                                </div>
                            </div>

                            </div>
                        </div>
                    </div>




                </div>
            </div>
        </div>

        <footer class="footer">
            <div class="container-fluid">
                <nav class="pull-left">
                    <ul>

                        <li>
                            <a href="http://www.creative-tim.com">
                                Creative Tim
                            </a>
                        </li>
                        <li>
                            <a href="http://blog.creative-tim.com">
                               Blog
                            </a>
                        </li>
                        <li>
                            <a href="http://www.creative-tim.com/license">
                                Licenses
                            </a>
                        </li>
                    </ul>
                </nav>
				<div class="copyright pull-right">
                    &copy; <script>document.write(new Date().getFullYear())</script>, made with <i class="fa fa-heart heart"></i> by Giovanni, Enea e Addolorata
                </div>
            </div>
        </footer>


    </div>
</div>


</body>

    <!--   Core JS Files   -->
    <script src="../../assets_back/js/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="../../assets_back/js/bootstrap.min.js" type="text/javascript"></script>

	<!--  Checkbox, Radio & Switch Plugins -->
	<script src="../../assets_back/js/bootstrap-checkbox-radio.js"></script>

	<!--  Charts Plugin -->
	<script src="../../assets_back/js/chartist.min.js"></script>

    <!--  Notifications Plugin    -->
    <script src="../../assets_back/js/bootstrap-notify.js"></script>

    <!--  Google Maps Plugin    -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js"></script>

    <!-- Paper Dashboard Core javascript and methods for Demo purpose -->
	<script src="../../assets_back/js/paper-dashboard.js"></script>

	<!-- Paper Dashboard DEMO methods, don't include it in your project! -->
	<script src="../../assets_back/js/demo.js"></script>
<!-- jTable script file. -->
 <script src="/js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="/js/jquery.jtable.js" type="text/javascript"></script>
<script src="/js/photolist.js" type="text/javascript"></script>
<script src="/js/photochecked.js" type="text/javascript"></script>

</html>
