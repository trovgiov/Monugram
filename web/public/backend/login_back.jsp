<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HeGO - Administration Log IN</title>
    <!-- Google Fonts -->
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" href="../../assets/css/animate.css">
    <!-- Custom Stylesheet -->
    <link rel="stylesheet" href="../../assets/css/style.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
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
<!-- ATTENTION! THIS CODE IS FOR BACKGROUND! -->
<video poster="../../images/admin_bg.jpg" id="bgvid" playsinline autoplay muted loop></video>
<!-- ATTENTION! THIS CODE IS FOR BACKGROUND! -->

<s:div class="container">
    <s:div class="top">
        <h1 id="title" class="hidden"><span id="logo">He<span><em>GO</em></span></span></h1><br>
    </s:div>
    <s:div><h3>Administration Login Panel!</h3></s:div>
    <s:div class="login-box animated fadeInUp">
        <s:div class="box-header">
        </s:div>
        <s:form action="loginback" class="forms">
            <s:label value="Username"></s:label>
            <s:textfield name="username" required="true"></s:textfield>

            <s:label value="Password"></s:label>
            <s:password name="password" required="true"></s:password>

            <s:submit value="Login"></s:submit>
        </s:form>
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