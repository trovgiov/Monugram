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



    <script type = "text/javascript" src="try.js"></script>
 </head>

<body>
<s:div class="container">
    <s:div class="top">
        <h1 id="title" class="hidden"><span id="logo">Monu<span>GRAM</span></span></h1>
    </s:div>
    <s:div class="login-box animated fadeInUp">
        <s:div class="box-header">
            <h2>Log In</h2>

        </s:div>
            <s:form action="loginprocess">
                <s:textfield name="email" label="Email"></s:textfield>
                <br/>
                <s:password name="password" label="Password"></s:password>
                <br/>
                <s:submit value="Login"></s:submit>
                <br/>
            </s:form>

        <a href="./facebook.html"><p class="small">LOGIN WITH FACEBOOK</p></a>

        <a href="#"><p class="small">Forgot your password?</p></a>
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