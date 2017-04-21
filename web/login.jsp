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
    <title>Login.jsp</title>




</head>

<body>

<s:form action="loginprocess">
    <header>Login</header>
    <s:textfield name="email" label="Email"></s:textfield>
    <s:password name="password" label="Password"></s:password>
    <s:submit value="login"></s:submit>
</s:form>


</body>
</html>
