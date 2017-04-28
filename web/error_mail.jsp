<%--
    Document   : message
    Created on : Sep 18, 2012, 7:31:39 PM
    Author     : Sudhanshu
--%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Result</title>
            <style>
              .msg1
    {
                       background-color: cornsilk;
                       font-family: verdana;
                       font-weight: lighter;
                       margin:0 25% 0 25%;
    }
            </style>
        </head>
    <body>
        <div class="msg1">
                <s:a href="back to Email">Back</s:a>
                <%
                if(session.getAttribute("sms")!=null){
                %>
                <s:property value="#session.sms"/>
                <%
                }
                %>
           
        </body>
</html>