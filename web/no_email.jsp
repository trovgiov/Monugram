<%--
  Created by IntelliJ IDEA.
  User: GiovanniTrovini
  Date: 20/04/17
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User</title>
</head>
<body>

<br/>

<s:form action="register_mail" class="forms">

<s:label value="Email"></s:label>
<s:textfield name="email"></s:textfield>

    <s:hidden name="nome"></s:hidden>
    <s:hidden name="cognome"></s:hidden>


    <s:submit value="Invia"></s:submit>

</s:form>


</body>
</html>
