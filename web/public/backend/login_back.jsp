<%--
  Created by IntelliJ IDEA.
  User: GiovanniTrovini
  Date: 16/05/17
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%><html>
<head>
    <title>Title</title>
</head>
<body>


<s:form action="loginback" class="forms">
    <s:label value="Username"></s:label>
    <s:textfield name="username" required="true"></s:textfield>

    <s:label value="Password"></s:label>
    <s:password name="password" required="true"></s:password>

    <s:submit value="Login"></s:submit>
</s:form>


</body>
</html>
