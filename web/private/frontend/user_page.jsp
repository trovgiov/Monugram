<%@ page import="static org.apache.struts2.ServletActionContext.getServletContext" %>
<%@ taglib uri="/struts-tags" prefix="s" %>



<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<!--
Helios by HTML5 UP
html5up.net | @ajlkn
Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
    <title>Monugram User Page</title>
    <meta http-equiv="refresh" content="300;url=teststatusManager.action" />
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->


    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/main.css"/>

  <!--  <link rel="stylesheet" href="assets/css/main.css" /> -->
    <!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
</head>
<body class="homepage">
<div id="page-wrapper">

    <!-- Header -->
    <s:div id="header">

        <!-- Inner -->
        <s:div class="inner">
            <header>
                <h1><img src="../../images/logo_w.png" alt="Monugram logo" style="width:82px;height:106px;"><a href="user_page.jsp" id="logo"> WELCOME INTO MONUgram!</a></h1>
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
                <s:div><a href="/Monumenti/<s:property value="monument"/>/<s:property value="title"/>" class="image featured"></s:div><img src="/Monumenti/<s:property value="monument"/>/<s:property value="title"/>"  width="336" height="189" alt="" /></a>
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
                <h2><a href="#">What's MONUgram</a></h2>
                <p>
                    MONUgram is a mobile, desktop, and internet-based photo-sharing application and service that allows users to share pictures
                    either publicly or privately.
                </p>
            </header>
            <p>
                It was created by developers Giovanni Trovini, Addolorata Montaquila and Enea Marinelli, and launched in June 2017 as a free mobile app
                and a web application.
                MONUgram lets registered users upload monuments photos to the service. Users can connect their account to Facebook social profiles,
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
        <div class="container">
            <s:div class="row">

                <!-- Tweets -->
                <section class="4u 12u(mobile)">
                    <header>
                        <h2 class="icon fa-twitter circled"><span class="label">Tweets</span></h2>
                    </header>
                    <ul class="divided">
                        <li>
                            <article class="tweet">
                                Amet nullam fringilla nibh nulla convallis tique ante sociis accumsan.
                                <span class="timestamp">5 minutes ago</span>
                            </article>
                        </li>
                        <li>
                            <article class="tweet">
                                Hendrerit rutrum quisque.
                                <span class="timestamp">30 minutes ago</span>
                            </article>
                        </li>
                        <li>
                            <article class="tweet">
                                Curabitur donec nulla massa laoreet nibh. Lorem praesent montes.
                                <span class="timestamp">3 hours ago</span>
                            </article>
                        </li>
                        <li>
                            <article class="tweet">
                                Lacus natoque cras rhoncus curae dignissim ultricies. Convallis orci aliquet.
                                <span class="timestamp">5 hours ago</span>
                            </article>
                        </li>
                    </ul>
                </section>

                <!-- Posts -->
                <section class="4u 12u(mobile)">
                    <header>
                        <h2 class="icon fa-file circled"><span class="label">Posts</span></h2>
                    </header>
                    <ul class="divided">
                        <li>
                            <article class="post stub">
                                <header>
                                    <h3><a href="#">Nisl fermentum integer</a></h3>
                                </header>
                                <span class="timestamp">3 hours ago</span>
                            </article>
                        </li>
                        <li>
                            <article class="post stub">
                                <header>
                                    <h3><a href="#">Phasellus portitor lorem</a></h3>
                                </header>
                                <span class="timestamp">6 hours ago</span>
                            </article>
                        </li>
                        <li>
                            <article class="post stub">
                                <header>
                                    <h3><a href="#">Magna tempus consequat</a></h3>
                                </header>
                                <span class="timestamp">Yesterday</span>
                            </article>
                        </li>
                        <li>
                            <article class="post stub">
                                <header>
                                    <h3><a href="#">Feugiat lorem ipsum</a></h3>
                                </header>
                                <span class="timestamp">2 days ago</span>
                            </article>
                        </li>
                    </ul>
                </section>

                <!-- Photos -->
                <section class="4u 12u(mobile)">
                    <header>
                        <h2 class="icon fa-camera circled"><span class="label">Photos</span></h2>
                    </header>
                    <s:div class="row 25%">
                        <s:div class="6u">
                            <a href="#" class="image fit"><img src="images/pic10.jpg" alt="" /></a>
                        </s:div>
                        <s:div class="6u$">
                            <a href="#" class="image fit"><img src="images/pic11.jpg" alt="" /></a>
                        </s:div>
                        <s:div class="6u">
                            <a href="#" class="image fit"><img src="images/pic12.jpg" alt="" /></a>
                        </s:div>
                        <s:div class="6u$">
                            <a href="#" class="image fit"><img src="images/pic13.jpg" alt="" /></a>
                        </s:div>
                        <s:div class="6u">
                            <a href="#" class="image fit"><img src="images/pic14.jpg" alt="" /></a>
                        </s:div>
                        <s:div class="6u$">
                            <a href="#" class="image fit"><img src="images/pic15.jpg" alt="" /></a>
                        </s:div>
                    </s:div>
                </section>

            </s:div>
            <hr />
            <s:div class="row">
                <s:div class="12u">

                    <!-- Contact -->
                    <section class="contact">
                        <header>
                            <h3>Do you like this project? Have you some suggestions?</h3>
                        </header>
                        <p>Keep in touch with MONUgram!</p>
                        <ul class="icons">
                            <li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
                            <li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
                            <li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
                            <li><a href="#" class="icon fa-pinterest"><span class="label">Pinterest</span></a></li>
                            <li><a href="#" class="icon fa-dribbble"><span class="label">Dribbble</span></a></li>
                            <li><a href="#" class="icon fa-linkedin"><span class="label">Linkedin</span></a></li>
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

</body>
</html>