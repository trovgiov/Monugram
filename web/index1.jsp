<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <style type="text/css">
        .error {
                background-color:#FFDDCC;
                border:1px solid #CC0011;
                width:260px;
        }
        .error li{
                list-style: none;
        }
    </style>
</head>
<body>
    <h3>Struts2 Action Error</h3>
    
    <s:form action="register">
            <s:textfield name="email" label="Enter your name" />
            <s:submit />
        </s:form>
    
    <s:if test="hasActionErrors()">
            <div class="error">
                <s:actionerror />
            </div>
        </s:if>
</body>
</html>