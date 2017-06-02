<%--

    Document   : index

    Created on : Sep 18, 2012, 4:36:50 PM
   
Author     : Sudhanshu

--%>

<%@taglib uri="/struts-tags" prefix="s" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>


<html>
   
<head>
      
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     
    <title>HeGO Mail User</title>

            <style>
                body {
                    margin: 0;
                    background: darkgrey;
                    font-family: 'Muli', Arial, sans-serif;
                    }
                forms {
                    text-align:center;
                    margin: 10px auto;
                    position: relative;
                }

            </style>
        </head>
    <body>
        <div id="text">
            <h1>Send Email to: </h1>
    <s:form action="sendusermail" class="forms">
                    <s:textfield name="to" label="To" maxLength="40" size="80" required="true"/>
                <s:textfield name="subject" label="Soggetto" maxLength="40" size="80"/>
                <s:textarea name="message" label="Messaggio" cssClass="msg" required="true"/>
                <s:submit value="Invia Email"/>
    </s:form>
</div>
           
        </body>
</html>