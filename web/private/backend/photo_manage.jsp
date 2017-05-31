<%--
  Created by IntelliJ IDEA.
  User: GiovanniTrovini
  Date: 16/05/17
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>

    <script src="http://d3js.org/d3.v3.min.js" language="JavaScript"></script>
    <script src="/js/liquidFillGauge.js" language="JavaScript"></script>
    <style>
        .liquidFillGaugeText { font-family: Helvetica; font-weight: bold; }
    </style>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="assets_back/img/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96" href="assets_back/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

    <title>MonuGRAM Dashboard</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="/assets_back/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="/assets_back/css/animate.min.css" rel="stylesheet"/>

    <!--  Paper Dashboard core CSS    -->
    <link href="/assets_back/css/paper-dashboard.css" rel="stylesheet"/>


    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="/assets_back/css/demo.css" rel="stylesheet" />


    <!--  Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <link href="/assets_back/css/themify-icons.css" rel="stylesheet">

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
                Monugram
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
                        <p>Users</p>
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
                    <a class="navbar-brand" href="/private/backend/dashboard.jsp">Dashboard</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="ti-panel"></i>
                                <p>Stats</p>



                            </a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="ti-bell"></i>
                                <p class="notification">5</p>
                                <p>Notifiche</p>
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Notification 1</a></li>
                                <li><a href="#">Notification 2</a></li>
                                <li><a href="#">Notification 3</a></li>
                                <li><a href="#">Notification 4</a></li>
                                <li><a href="#">Another notification</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="/public/frontend/login.jsp">
                                <i class="ti-shift-left "></i>
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
                                <h4 class="title">Foto: <s:property value ="idreceived"></s:property></h4>
                                <p class="category">Stato Foto: <s:property value ="statoFoto"></s:property> -  Monumento: <s:property value ="monu"></s:property></p>
                            </div>
                                    <img id="image-original" src="/Monumenti/<s:property value="monu"/>/<s:property value="photoname"/>" alt="Photo" style="width:100%;height:100%; display: none">
                                    <img id="image-reset" src="" style="width:100%;height:100%">
                                </div>
                                <div class="footer">
                                    <hr>
                                    <div class="stats">
                                        <i class="ti-reload"></i> Aggiornato 3 ore fa
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="row">
                    <div class="col-lg-3 col-sm-6">
                        <div class="card">
                            <div class="content">
                                <div class="row">
                                    <div class="col-xs-5">
                                        <div class="icon-big icon-warning text-center">
                                            <a href="<s:url action="updateStatus"/>?idPhoto=<s:property value="idreceived"></s:property> "><img src="/images/OK.png" alt="Users" style="width:60px;height:60px;"></a>
                                        </div>
                                    </div>
                                    <div class="col-xs-7">
                                        <div class="numbers">
                                            <p>Approva Foto</p>

                                        </div>
                                    </div>
                                </div>
                                <div class="footer">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="card">
                            <div class="content">
                                <div class="row">
                                    <div class="col-xs-5">
                                        <div class="icon-big icon-success text-center">
                                            <a href="<s:url action="home_back"/>"><img src="/images/no.png" alt="Users" style="width:60px;height:60px;"></a>
                                        </div>
                                    </div>
                                    <div class="col-xs-7">
                                        <div class="numbers">
                                            <a href="<s:url action="photo_ignore"/>?idPhoto=<s:property value="idreceived"></s:property> "><p>Rifiuta Foto</p></a>

                                        </div>
                                    </div>
                                </div>
                                <div class="footer">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="card">
                            <div class="content">
                                <div class="row">
                                    <div class="col-xs-5">
                                        <div class="icon-big icon-info text-center">
                                            <img src="/images/mail_icon.png" alt="Users" style="width:70px;height:50px;">
                                        </div>
                                    </div>
                                    <div class="col-xs-7">
                                        <div class="numbers">
                                            <p>Contatta l'utente</p>

                                        </div>
                                    </div>
                                </div>
                                <div class="footer">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="card">
                            <div class="content">
                                <div class="row">
                                    <div class="col-xs-5">
                                        <div class="icon-big icon-danger text-center">
                                            <a href="<s:url action="delete_photo"/>?idPhoto=<s:property value="idreceived"></s:property> ">

                                            <img src="/images/delete.png" alt="Users" style="width:60px;height:60px;">

                                            </a>
                                        </div>
                                    </div>
                                    <div class="col-xs-7">
                                        <div class="numbers">
                                            <p>Cancella la foto</p>

                                        </div>
                                    </div>
                                </div>
                                <div class="footer">
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
                                monuGRAM TEAM
                            </a>
                        </li>
                        <li>
                            <a href="http://google.com">
                                Blog
                            </a>
                        </li>
                        <li>
                            <a href="http://www.google.it">
                                Licenze
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

<script>
    function resetOrientation(srcBase64, srcOrientation, callback) {
        var img = new Image();

        img.onload = function() {
            var width = img.width,
                height = img.height,
                canvas = document.createElement('canvas'),
                ctx = canvas.getContext("2d");

            // set proper canvas dimensions before transform & export
            if ([5,6,7,8].indexOf(srcOrientation) > -1) {
                canvas.width = height;
                canvas.height = width;
            } else {
                canvas.width = width;
                canvas.height = height;
            }
            // transform context before drawing image
            switch (srcOrientation) {
                case 2:
                    // horizontal flip
                    ctx.translate(width, 0)
                    ctx.scale(-1, 1)
                    break
                case 3:
                    // 180° rotate left
                    ctx.translate(width, height)
                    ctx.rotate(Math.PI)
                    break
                case 4:
                    // vertical flip
                    ctx.translate(0, height)
                    ctx.scale(1, -1)
                    break
                case 5:
                    // vertical flip + 90 rotate right
                    ctx.rotate(0.5 * Math.PI)
                    ctx.scale(1, -1)
                    break
                case 6:
                    // 90° rotate right
                    ctx.rotate(0.5 * Math.PI)
                    ctx.translate(0, -height)
                    break
                case 7:
                    // horizontal flip + 90 rotate right
                    ctx.rotate(0.5 * Math.PI)
                    ctx.translate(width, -height)
                    ctx.scale(-1, 1)
                    break
                case 8:
                    // 90° rotate left
                    ctx.rotate(-0.5 * Math.PI)
                    ctx.translate(-width, 0)
                    break
            }

            // draw image
            ctx.drawImage(img, 0, 0);

            // export base64
            callback(canvas.toDataURL());
        };

        img.src = srcBase64;
    }

    var originalImage = document.getElementById("image-original"),
        resetImage = document.getElementById("image-reset");

    resetOrientation(originalImage.src, 5, function(resetBase64Image) {
        resetImage.src = resetBase64Image;
    });
</script>

<!--   Core JS Files   -->
<script src="/assets_back/js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="/assets_back/js/bootstrap.min.js" type="text/javascript"></script>

<!--  Checkbox, Radio & Switch Plugins -->
<script src="/assets_back/js/bootstrap-checkbox-radio.js"></script>

<!--  Charts Plugin -->
<script src="/assets_back/js/chartist.min.js"></script>

<!--  Notifications Plugin    -->
<script src="/assets_back/js/bootstrap-notify.js"></script>

<!-- Paper Dashboard Core javascript and methods for Demo purpose -->
<script src="/assets_back/js/paper-dashboard.js"></script>

<!-- Paper Dashboard DEMO methods, don't include it in your project! -->
<script src="/assets_back/js/demo.js"></script>



</html>
