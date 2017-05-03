<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<body>
<h1>JavaBeat - Struts 2 Select Tag Demo</h1>
<s:form action="resultAction">
    <s:select name="monument"
              list="list"/>

    <s:submit value="submit" name="submit" />
</s:form>
</body>
</html>