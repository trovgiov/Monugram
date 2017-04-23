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

    <link rel="stylesheet" href="css/animate.css">
    <!-- Custom Stylesheet -->
    <link rel="stylesheet" href="css/style.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>



    <script type = "text/javascript" src="js/facebook_login.js"></script>
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
    <s:div><h3>The world at your fingertips!</h3></s:div>
    <s:div class="login-box animated fadeInUp">
        <s:div class="box-header">
            <h2>Log In</h2>
        </s:div>
            <s:form action="loginprocess" class="forms">
                <s:label value="Email"></s:label>
                <s:textfield name="email"></s:textfield>

                <s:label value="Password"></s:label>
                <s:password name="password"></s:password>

                <s:submit value="Login"></s:submit>
            </s:form>

        <a href="./facebook.html"><img src="../images/facebook-login-blue.png" alt="Facebook Login" style="width:152px;height:42px;border:0;"></a>

        <a href="#"><p class="small">Forgot your password?</p></a>
        <a href="./register.jsp"><p class="small">Are you not registered? LOG ON!</p></a>
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
    $('#password').focus(function() {
        $('label[for="password"]').addClass('selected');
    });
    $('#password').blur(function() {
        $('label[for="password"]').removeClass('selected');
    });
</script>

</html>