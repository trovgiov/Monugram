<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Monugram - Upload Photos</title>
    <meta http-equiv="refresh" content="300;url=teststatusManager.action" />

    <!-- Google Fonts -->
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900' rel='stylesheet' type='text/css'>

    <!-- Custom Stylesheet -->
    <link rel="stylesheet" href="../assets/css/upload_style.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>

</head>

<body>

<s:div class="forms"> <h3>OK, <s:property value="name"></s:property>, upload or take your photo at  <s:property value="monument"></s:property>!</h3>


<s:form action="userImage" method="post" enctype="multipart/form-data" class="forms">


    <s:file name="userImage" accept="image/*" id="capture" capture="camera" />

    <s:hidden value="monument"/>

    <s:div><button type="submit" id="button"><img src="../images/camera.png" alt="up icon" value="Upload" style="width:80px;height:80px;border:0;"/><br/>Upload</button></s:div>

</s:form>
</s:div>
</body>
</html>