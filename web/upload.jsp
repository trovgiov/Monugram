<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Monugram - Upload Photos</title>

    <!-- Google Fonts -->
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900' rel='stylesheet' type='text/css'>

    <!-- Custom Stylesheet -->
    <link rel="stylesheet" href="./assets/css/upload_style.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>

</head>

<body>

<s:div class="forms"> <h3>OK, <s:property value="name"></s:property>, upload or take your photo!</h3>

<s:form action="userImage" method="post" enctype="multipart/form-data" class="forms">


    <s:file name="userImage" accept="image/*" id="capture" capture="camera" />
     <s:submit value="Upload" align="center" />
</s:form>
</s:div>

</body>

</html>