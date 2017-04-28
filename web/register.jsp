<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Monugram - Sign In</title>

    <!-- Google Fonts -->
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" href="css/animate.css">
    <!-- Custom Stylesheet -->
    <link rel="stylesheet" href="css/style.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>



    <script type = "text/javascript" src="js/facebook_login.js"></script>

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
    <!--<source src="../images/videobg_hd.mp4" type="video/mp4">-->
</video>
<!-- ATTENTION! THIS CODE IS FOR BACKGROUND VIDEO! -->


<s:div class="container">

    <s:div class="login-box animated fadeInUp">
        <s:div class="box-header">
            <h2>REGISTER</h2>
        </s:div>
        <s:form action="register" class="forms">

            <s:label value="Name"></s:label>
            <s:textfield name="nome" required="true"></s:textfield>

            <s:label value="Surname"></s:label>
            <s:textfield name="cognome" required="true"></s:textfield>

            <s:label value="Email"></s:label>
            <s:textfield name="email"></s:textfield>

            <s:label value="Password"></s:label>
            <s:password name="password1"></s:password>

            <s:label value="Confirm your Password"></s:label>
            <s:password name="password2"></s:password>

            <s:submit value="REGISTER"></s:submit>
        </s:form>

        <a href="./facebook.html"><img src="../images/facebook-login-blue.png" alt="Facebook Login" style="width:152px;height:42px;border:0;"></a>

        <a href="./login.jsp"><p class="small">Already registered? SIGN IN</p></a>
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