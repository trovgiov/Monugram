<%--
 Created by IntelliJ IDEA.
 User: GiovanniTrovini
 Date: 21/04/17
 Time: 11:16
 To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title> </title>




</head>

<body>

Utente Loggato :  Nome : <s:property value="nome"/>


<p>Capture Image: <input type="file" accept="image/*" id="capture" capture="camera">



</body>
</html>