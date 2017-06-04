<%@ page import="static org.apache.struts2.ServletActionContext.getServletContext" %>
<%@ taglib uri="/struts-tags" prefix="s" %>



<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE HTML>

<html>
<head>
    <title>HeGO User Page</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->

    <!-- USED FONT -->
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/main.css"/>
    <script src="/js/exif.js"></script>

  <!--  <link rel="stylesheet" href="assets/css/main.css" /> -->
    <!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
    <link href="assets_back/css/themify-icons.css" rel="stylesheet">
</head>
<body class="homepage">
<div id="page-wrapper">

    <!-- Header -->
    <s:div id="header">

        <!-- Inner -->
        <s:div class="inner">
            <header>
                <h1><img src="../../images/hego_logo.png" alt="logo" style="width:110px;height:110px;"></br><a href="user_page.jsp" id="logo"> WELCOME TO He<em>GO</em>!</a></h1>
                <hr />
                <p>Hi, <s:property value="nome"/>, let's start to capture or upload your FANTASTIC monument photos!</p>
            </header>
            <footer>
                <a href="<s:url action="monument_drop"/> " class="button circled scrolly" target="popup" onclick="window.open(this.href,'Upload','width=450,height=400'); return false;">Start</a>
                <!-- #banner -->
            </footer>
        </s:div>

        <!-- Nav -->
        <nav id="nav">
            <ul>
                <li><a href="<s:url action="home"/>">Home</a></li>
                <li>
                    Monuments
                    <ul>
                        <s:iterator value="lista_mon">
                        <li><a href="<s:url action="monuview"/>?monumento=<s:property value="monument"/>"><s:property value="monument"></s:property></a></li>
                        </s:iterator>

                    </ul>
                </li>

                <li> My Photos
                <ul>
                <li><a href="<s:url action="monuuserview"/>?status=checked">Checked</a></li>
                <li><a href="<s:url action="monuuserview"/>?status=unchecked">Unchecked</a></li>
                </ul>

                </li>



                <li><a href="#contact">Contact Us</a></li>
                <li> <a href="<s:url action="login"/>"> <i class="ti-power-off"></i> Logout </a></li>
            </ul>
        </nav>

    </s:div>

    <!-- Banner -->
    <section id="banner">
        <header>
            <h2><!--[--><s:property value="nome"/>, take a look at <strong>our new photos</strong>.<!--]-->

                <s:set var="path" value=" " />

                <s:property value="path"></s:property>

            </h2>
        </header>
    </section>



         <!--
        <a href="#" class="image featured"><img src="./images/pic07.jpg" alt="" /></a>
        <header>
        <h3><a href="#">Pulvinar sagittis congue</a></h3>
        </header>
        <p>Commodo id natoque malesuada sollicitudin elit suscipit magna.</p>

        -->



    <!--<img src="/Users/GiovanniTrovini/Desktop/01%20-%20Università/01%20-%20Magistrale/02%20ANNO/Secondo%20semestre/Monugram/out/artifacts/Progetto_war_exploded/Monumenti/Colosseo/GiovanniTrovini0.jpg"  width="100" height="100"/> -->
   <!-- <img src="/Monumenti/Colosseo/GiovanniTrovini0.jpg"  width="100" height="100"/> -->
    <!-- Carousel -->
    <section class="carousel">
        <s:div class="reel">



            <!--
            <article>
                <s:iterator value="lista_foto">


                     <header>
                    <h3> <s:property value="filepath" /><s:property value="monument" />/<s:property value="title" /></h3>
                    </header>
                    <p>Commodo id natoque malesuada sollicitudin elit suscipit magna.</p>


                    <br>

                </s:iterator>

            </article>

-->
            <s:iterator value="lista_foto">
            <article>
                <s:div><a href="/Monumenti/<s:property value="monument"/>/<s:property value="title"/>" class="image featured"></s:div>
                    <img src="/Monumenti/<s:property value="monument"/>/<s:property value="title"/>"   style="width:336px; height:200px;" />
                 </a>

                <header>
                    <h3><a href="<s:url action="monuview"/>?monumento=<s:property value="monument"/>"> <s:property value="monument"/> </a></h3>
                </header>
                <p>Taken by : <s:property value="nome"></s:property>  <s:property value="cognome"></s:property>  </p>
            </article>

            </s:iterator>


        </s:div>
    </section>

    <!-- Main -->
    <s:div class="wrapper style2">
        <a href="#" class="image featured"><img src="/images/wim.jpg" alt="" /></a>
        <article id="main" class="container special">
            <header>
                <h2><a href="#">What's He<em>GO</em></a></h2>
                <p>
                    He<em>GO</em> is a mobile, desktop, and internet-based photo-sharing application and service that allows users to share pictures
                    either publicly or privately.
                </p>
            </header>
            <p>
                It was created by developers Giovanni Trovini, Addolorata Montaquila and Enea Marinelli, and launched in June 2017 as a free mobile app
                and a web application.
                He<em>GO</em> lets registered users upload monuments photos to the service. Users can connect their account to Facebook social profiles,
                enabling them to share photos to those profiles as well. In June 2017, an "Explore" tab was introduced in the mobile apps,
                showing users a variety of media, including (but not limited to) popular photos and photos taken at nearby locations,
                trending tags and places, channels for recommended videos, and curated content.
            </p>
            <footer>
                <a href="<s:url action="monument_drop"/>" class="button"target="popup" onclick="window.open(this.href,'Upload','width=450,height=400'); return false;">Start taking your photos!</a>
            </footer>
        </article>

    </s:div>

    <!-- Features
    <s:div class="wrapper style1">

        <section id="features" class="container special">
            <header>
                <h2>Morbi ullamcorper et varius leo lacus</h2>
                <p>Ipsum volutpat consectetur orci metus consequat imperdiet duis integer semper magna.</p>
            </header>
            <div class="row">
                <article class="4u 12u(mobile) special">
                    <a href="#" class="image featured"><img src="images/pic07.jpg" alt="" /></a>
                    <header>
                        <h3><a href="#">Gravida aliquam penatibus</a></h3>
                    </header>
                    <p>
                        Amet nullam fringilla nibh nulla convallis tique ante proin sociis accumsan lobortis. Auctor etiam
                        porttitor phasellus tempus cubilia ultrices tempor sagittis. Nisl fermentum consequat integer interdum.
                    </p>
                </article>
                <article class="4u 12u(mobile) special">
                    <a href="#" class="image featured"><img src="images/pic08.jpg" alt="" /></a>
                    <header>
                        <h3><a href="#">Sed quis rhoncus placerat</a></h3>
                    </header>
                    <p>
                        Amet nullam fringilla nibh nulla convallis tique ante proin sociis accumsan lobortis. Auctor etiam
                        porttitor phasellus tempus cubilia ultrices tempor sagittis. Nisl fermentum consequat integer interdum.
                    </p>
                </article>
                <article class="4u 12u(mobile) special">
                    <a href="#" class="image featured"><img src="images/pic09.jpg" alt="" /></a>
                    <header>
                        <h3><a href="#">Magna laoreet et aliquam</a></h3>
                    </header>
                    <p>
                        Amet nullam fringilla nibh nulla convallis tique ante proin sociis accumsan lobortis. Auctor etiam
                        porttitor phasellus tempus cubilia ultrices tempor sagittis. Nisl fermentum consequat integer interdum.
                    </p>
                </article>
            </div>
        </section>

    </s:div>

    -->

    <!-- Footer -->
    <s:div id="footer">
            <s:div class="row">
                <s:div class="12u">

                    <!-- Contact -->
                    <section class="contact">
                        <header>
                            <h3>Do you like this project? Have you some suggestions?</h3>
                        </header>
                        <p>Keep in touch with He<em>GO</em>!</p>
                        <ul class="icons">
                            <li><a href="#" class="ti-twitter"><span class="label"></span></a></li>
                            <li><a href="#" class="ti-facebook"><span class="label"></span></a></li>
                            <li><a href="#" class="ti-instagram"><span class="label"></span></a></li>
                            <li><a href="#" class="ti-pinterest"><span class="label"></span></a></li>
                            <li><a href="#" class="ti-dribbble"><span class="label"></span></a></li>
                            <li><a href="#" class="ti-linkedin"><span class="label"></span></a></li>
                        </ul>
                    </section>

                    <!-- Copyright -->
                    <s:div class="copyright">
                        <ul class="menu">
                            <li>&copy; Untitled. All rights reserved.</li><li>Developed by: G. Trovini, E. Marinelli and A.Montaquila</li>
                        </ul>
                    </s:div>

                </s:div>

            </s:div>
        </div>
    </s:div>

</div>

<!-- Scripts -->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/jquery.dropotron.min.js"></script>
<script src="assets/js/jquery.scrolly.min.js"></script>
<script src="assets/js/jquery.onvisible.min.js"></script>
<script src="assets/js/skel.min.js"></script>
<script src="assets/js/util.js"></script>
<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
<script src="assets/js/main.js"></script>

<script>
    function RefreshPage()
    {
        window.document.forms[0].submit();
    }</script>


<script>




    function resetOrientation(srcBase64, srcOrientation, callback) {
        var img = new Image();

        img.onload = function () {
            var width = img.width,
                height = img.height,
                canvas = document.createElement('canvas'),
                ctx = canvas.getContext("2d");
            // set proper canvas dimensions before transform & export
            if ([5, 6, 7, 8].indexOf(srcOrientation) > -1) {
                canvas.width = height;
                canvas.height = width;
            }

            else {
                canvas.width = width;
                canvas.height = height;
            }

            // transform context before drawing image
            console.log("Orientamento" + srcOrientation);
            switch (srcOrientation) {
                case 2:
                    ctx.transform(-1, 0, 0, 1, width, 0);
                    break;
                case 3:
                    ctx.transform(-1, 0, 0, -1, width, height);
                    break;
                case 4:
                    ctx.transform(1, 0, 0, -1, 0, height);
                    break;
                case 5:
                    ctx.transform(0, 1, 1, 0, 0, 0);
                    break;
                case 6:
                    ctx.transform(0, 1, -1, 0, height, 0);
                    break;
                case 7:
                    ctx.transform(0, -1, -1, 0, height, width);
                    break;
                case 8:
                    ctx.transform(0, -1, 1, 0, 0, width);
                    break;
                case 0:
                    ctx.transform(1, 0, 0, 1, 0, 0);
            }

            // draw image
            ctx.drawImage(img, 0, 0);

            // export base64
            callback(canvas.toDataURL());
        };

        img.src = srcBase64;
    };

    var originalImage = document.getElementById("image-original"),
        resetImage = document.getElementById("image-reset");



    var target_image = document.getElementById("image-original");

    var mario=0;
    EXIF.getData(target_image, function() {
        mario= EXIF.getTag(this, "Orientation");

        resetOrientation(originalImage.src, mario, function (resetBase64Image) {
            resetImage.src = resetBase64Image;
        });
    });



</script>

</body>
</html>