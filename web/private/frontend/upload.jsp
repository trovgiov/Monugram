<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HeGO - Upload Photos</title>

    <!-- Google Fonts -->
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>

    <!-- Custom Stylesheet -->
    <link rel="stylesheet" href="./assets/css/upload_style.css">
    <link rel="stylesheet" href="/css/adblock.css">

    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
    <script type="text/javascript" src="/js/exif.js"></script>

</head>


<body>

<s:div class="forms"> <h3>OK, <s:property value="name"></s:property>, upload or take your photo at  <s:property value="monument"></s:property>!</h3>


    <s:form action="userImage" method="post" enctype="multipart/form-data" class="login">
        <s:hidden value="monument"/>

        <label for="captures" class="custom-file-upload">
            <i class="fa fa-camera"></i> TAKE A PICTURE
        </label>


        <s:div class="forms"><s:file name="userImage" accept="image/*" id="captures" capture="camera" /></s:div>
         <label for="submit" class="custom-file-upload">
            <i class="fa fa-institution"></i> SUBMIT
        </label>
        <s:submit value="submit" name="UPLOAD" id="submit"/>

        <br>
        <p>*  Per una migliore qualità della foto, si consiglia di scattare la foto ponendo il dispositivo
           in posizione orizzontale
        <br>
        <p>** For better photo quality, it is recommended that you take the photo by placing the device horizontally
         (landscape mode) </p>

        <img src="/images/land.png" style="width:50%; height: 50%">



    </s:form>

</s:div>
</body>





</html>