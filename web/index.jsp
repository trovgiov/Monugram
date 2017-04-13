<%--
  Created by IntelliJ IDEA.
  User: GiovanniTrovini
  Date: 30/03/17
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Hello World Maia </title>
</head>
<body>
<s:form action="HelloWorld" >
  <s:textfield name="userName" label="User Name" />
  <s:submit />
</s:form>
</body>
</html>
