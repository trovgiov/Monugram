<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<script type='text/javascript'>
    window.onunload = function(){
        window.opener.location.reload();}
</script>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HeGO - Upload Result</title>
    <meta http-equiv="refresh" content="300;url=teststatusManager.action" />

    <!— Google Fonts —>
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>

    <!— Custom Stylesheet —>
    <link rel="stylesheet" href="./assets/css/upload_style.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>

</head>

<body>
<s:div class="logo"><img src="./images/success.png" alt="success" style="width:82px;height:82px;"></s:div><p></p>
<s:div class="forms"><h3>Well Done! Your photo was successfully uploaded!!</h3>
<p></p>

    <!-- ON DESKTOP-->
<div class="button_dsk" onclick="window.close();"><img src="/images/home_icon.png" alt="success" style="width:60px;height:60px;">BACK TO HOME</div></s:div>

<!-- ON MOBILE-->
<s:div class="button_mbl"><a href="<s:url action="home"/>"><img src="../../images/home_icon.png" style="width:50px; height:50px;">BACK TO HOME</a></s:div>



</body>
</html>