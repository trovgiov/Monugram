<%@taglib uri="/struts-tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body onload="window.resizeTo(320,250)"></body>
    <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Mail Sent to User successfully</title>
            <style>
            body {
                margin: 0;
                background: darkgrey;
                font-family: 'Muli', Arial, sans-serif;
                }
              .msg1
    {
                       background-color: grey;
                       font-family: verdana;
                       font-weight: lighter;
                       margin:0 25% 0 25%;
    }
            </style>
        </head>
    <body>
        <div class="msg1">
                <a href="<s:action name="home_back"/>"><img src="/images/back.png" width="200" height="120"></a>
                <%
                if(session.getAttribute("sms")!=null){
                %>
                <s:property value="#session.sms"/>
                <%
                }
                %>
           
        </body>
</html>