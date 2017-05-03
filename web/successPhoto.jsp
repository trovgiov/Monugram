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
    <title>Monugram - Upload Result</title>
    <meta http-equiv="refresh" content="300;url=teststatusManager.action" />

    <!-- Google Fonts -->
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900' rel='stylesheet' type='text/css'>

    <!-- Custom Stylesheet -->
    <link rel="stylesheet" href="./assets/css/upload_style.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>

</head>

<body>
<s:div class="logo"><img src="./images/success.png" alt="success" style="width:82px;height:82px;"></s:div>
<s:div class="forms"><h3>Well Done! Your photo was successfully uploaded!!</h3>

<button type="button" id="button" onclick="window.open('', '_self', ''); window.close();"><img src="./images/close.png" alt="success" style="width:192px;height:79px;"></button></s:div>

<s:if test="hasActionMessages()">
    <s:div class="mex">
        <s:actionmessage/>
    </s:div>
</s:if>

</body>
</html>
