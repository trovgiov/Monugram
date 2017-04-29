<%--
  Created by IntelliJ IDEA.
  User: GiovanniTrovini
  Date: 29/04/17
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="/struts-tags" prefix="s" %>



Buonaseeeeraaaaaaaaaaaaaaaaa <s:property value="name"></s:property>

Fai una foto :

<s:form action="userImage" method="post" enctype="multipart/form-data">


    <s:file name="userImage" accept="image/*" id="capture" capture="camera" />
     <s:submit value="Upload" align="center" />
</s:form>