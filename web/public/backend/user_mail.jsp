<%--


--%>

<%@taglib uri="/struts-tags" prefix="s" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    <title>Elegant Contact Form</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">


    <link rel="stylesheet" href="/css/email/stylemail.css">


</head>

<body>
<h1>Invia una mail all'utente</h1>


<s:form  action="usermail" class="cf">
                <s:textfield name="subject" id="input-subject" placeholder="Oggetto"/>
                <s:textarea name="message" d="input-message" placeholder="Message"/>
                <s:submit value="Invia Email" id="input-submit"/>
</s:form>


<!--
<form class="cf">
    <input type="text" id="input-subject" placeholder="Oggetto">
    <textarea name="message" type="text" id="input-message" placeholder="Message"></textarea>
    <div class="half right cf"> </div>
    <input type="submit" value="Submit" id="input-submit">
</form>
-->

</body>
</html>






<!--
<!DOCTYPE html>


<html>
   
<head>
      
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     
    <title>HeGO Mail Utente</title>

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
            <h1>Invia Email a: <s:property value="userMail"/> </h1>
    <s:form  action="usermail" class="forms">
                    <s:textfield name="subject" label="Soggetto" maxLength="40" size="80"/>
                    <s:textarea name="message" label="Messaggio" cssClass="msg" required="true"/>
                    <s:submit value="Invia Email"/>
    </s:form>

</div>
           
        </body>
</html>


-->