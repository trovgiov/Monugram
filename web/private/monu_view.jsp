<%--
  Created by IntelliJ IDEA.
  User: GiovanniTrovini
  Date: 14/05/17
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title><s:property value="monumento"></s:property></title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <!--[if lte IE 8]><script src="assets_mon/js/ie/html5shiv.js"></script><![endif]-->
    <link rel="stylesheet" href="assets_mon/css/main.css" />
    <!--[if lte IE 9]><link rel="stylesheet" href="assets_mon/css/ie9.css" /><![endif]-->
    <!--[if lte IE 8]><link rel="stylesheet" href="assets_mon/css/ie8.css" /><![endif]-->


</head>
<body>

<!-- Wrapper -->
<div id="wrapper">

    <!-- Header -->
    <header id="header">
        <h1><strong><s:property value="monumento"></s:property></strong> - MONUgram</h1>
        <nav>
            <ul>
                <li><a href="<s:url action="home"/> " class="icon fa-info-circle">Home</a></li>
            </ul>
        </nav>
    </header>

    <!-- Main -->
    <div id="main">



        <s:iterator value="lista">
        <article class="thumb">




         <a href="/Monumenti/<s:property value="monument"/>/<s:property value="title"/>" class="image">

             <s:div id="test">
            <img src="/Monumenti/<s:property value="monument"/>/<s:property value="title"/>"   width="480" height="294" />
             </s:div>
         </a>


            <h2></h2>

            <p>Taken by  <s:property value="nome"/> <s:property value="cognome"/></p>
        </article>

        </s:iterator>
    </div>



</div>

<!-- Scripts -->
<script src="assets_mon/js/jquery.min.js"></script>
<script src="assets_mon/js/jquery.poptrox.min.js"></script>
<script src="assets_mon/js/skel.min.js"></script>
<script src="assets_mon/js/util.js"></script>
<!--[if lte IE 8]><script src="assets_mon/js/ie/respond.min.js"></script><![endif]-->
<script src="assets_mon/js/main.js"></script>




</body>
</html>

