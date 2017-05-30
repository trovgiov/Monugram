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

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
    <script type="text/javascript" src="/js/exif.js"></script>

</head>


<body>

<s:div class="forms"> <h3>OK, <s:property value="name"></s:property>, upload or take your photo at  <s:property value="monument"></s:property>!</h3>


    <s:form action="userImage" method="post" enctype="multipart/form-data" class="login">
        <s:hidden value="monument"/>
        <s:div class="forms"><s:file name="userImage" accept="image/*" class="image-button" id="capture" capture="camera"/></s:div>
        <s:submit value="submit" name="UPLOAD" id="button"/>

    </s:form>

</s:div>
</body>


<script language="JavaScript">
     $('#capture').onloadend = function() {

        var exif = EXIF.readFromBinaryFile(new BinaryFile(this.result));

        switch (exif.Orientation) {

            case 8:
                ctx.rotate(90 * Math.PI / 180);
                break;
            case 3:
                ctx.rotate(180 * Math.PI / 180);
                break;
            case 6:
                ctx.rotate(-90 * Math.PI / 180);
                break;


        }

    };

</script>
</html>