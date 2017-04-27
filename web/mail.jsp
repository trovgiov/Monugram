<%--

    Document   : index

    Created on : Sep 18, 2012, 4:36:50 PM

Author     : Sudhanshu

--%>

<%@taglib uri="/struts-tags" prefix="s" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>


<html>


<head>


    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


    <title>Struts2Mail System</title>

    <style>

        .msg{
            max-height: 200px;
            min-height: 200px;
            max-width: 500px;
            min-width: 500px;
            background-color: aqua;
        }
        #text{
            font-family: verdana;
            font-size: smaller;
            font-weight: lighter;
            margin:0 25% 0 25%;
        }
    </style>
</head>
<body>
<div id="text">
    <h1>My Mailing System</h1>
    <s:form method="post" action="sendemail">
        <s:textfield name="to" label="Your Email" maxLength="40" size="80" required="true"/>
        <s:submit value="Send"/>
    </s:form>

</body>
</html>