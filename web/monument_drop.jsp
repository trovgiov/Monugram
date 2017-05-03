<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Monugram - Chose your monument</title>
    <meta http-equiv="refresh" content="300;url=teststatusManager.action" />

    <!-- Google Fonts -->
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900' rel='stylesheet' type='text/css'>

    <!-- Custom Stylesheet -->
    <link rel="stylesheet" href="./assets/css/upload_style.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>

</head>

<body>
<s:div class="forms"><img src="./images/mon_icon.png" alt="monument icon" style="width:92px;height:92px;"><h3>Chose your monument!</h3>
<s:form action="resultAction" class="forms">
    <s:select name="monument"
              list="list"/>

    <s:submit value="submit" name="submit" />
</s:form></s:div>
</body>
</html>