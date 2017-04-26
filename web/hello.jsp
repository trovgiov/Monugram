<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>

    <style type="text/css">
        .message {
                background-color:#EFFFEE;
                border:1px solid #009911;
                width:260px;
        }
        .message li{
                list-style: none;
        }
    </style>

</head>
<body>
    <h3>Struts2 Action Message</h3>
    
    <s:if test="hasActionMessages()">
            <div class="message">
                <s:actionmessage />
            </div>
        </s:if>
</body>
</html>