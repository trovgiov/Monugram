<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Monugram - Register</title>

    <!-- Google Fonts -->
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" href="../assets/css/animate.css">
    <!-- Custom Stylesheet -->
    <link rel="stylesheet" href="../assets/css/style.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>



    <script type = "text/javascript" src="../js/facebook_login.js"></script>


    <style>

        .msg{
            max-height: 200px;
            min-height: 200px;
            max-width: 500px;
            min-width: 500px;
            background-color: aqua;
        }
        #text{
            font-family: verdana;
            font-size: smaller;
            font-weight: lighter;
            margin:0 25% 0 25%;
        }
    </style>

</head>

<body>
<!-- ATTENTION! THIS CODE IS FOR BACKGROUND VIDEO! -->
<video poster="../images/photo_bg.jpg" id="bgvid" playsinline autoplay muted loop>
    <!-- WCAG general accessibility recommendation is that media such as background video play through only once. Loop turned on for the purposes of illustration; if removed, the end of the video will fade in the same way created by pressing the "Pause" button  -->
    <source src="../images/videobg_hd.mp4" type="video/mp4">
</video>
<!-- ATTENTION! THIS CODE IS FOR BACKGROUND VIDEO! -->

<s:div class="container">
    <s:div class="top">
        <h1 id="title" class="hidden"><span id="logo">Monu<span>GRAM</span></span></h1><br>
    </s:div>
    <s:div class="login-box animated fadeInUp">
        <s:div class="box-header">
            <h2>Recover your password</h2>
        </s:div>
        <s:form method="post" action="sendemail" class="forms">
            <s:label value="Your Email"></s:label>
            <s:textfield name="to" required="true"></s:textfield>

            <s:submit value="SEND PASSWORD"></s:submit>
        </s:form>

        <a href="../public/frontend/login.jsp"><p class="small">Back to LOGIN</p></a>
    </s:div>
</s:div>
</body>

<script>
    $(document).ready(function () {
        $('#logo').addClass('animated fadeInDown');
        $("input:text:visible:first").focus();
    });
    $('#username').focus(function() {
        $('label[for="username"]').addClass('selected');
    });
    $('#username').blur(function() {
        $('label[for="username"]').removeClass('selected');
    });
    $('#m_password').focus(function() {
        $('label[for="m_password"]').addClass('selected');
    });
    $('#m_password').blur(function() {
        $('label[for="m_password"]').removeClass('selected');
    });
</script>

</html>