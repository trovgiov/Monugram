<%--
  Created by IntelliJ IDEA.
  User: GiovanniTrovini
  Date: 21/05/17
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%><html>
<head>
    <title>Title</title>

    <script src="http://d3js.org/d3.v3.min.js" language="JavaScript"></script>
    <script src="/js/liquidFillGauge.js" language="JavaScript"></script>
    <style>
        .liquidFillGaugeText { font-family: Helvetica; font-weight: bold; }
    </style>
</head>
<body>


<s:property value="monumento"></s:property>

<svg id="fillgauge1" width="97%" height="250"></svg>






<script language="JavaScript">

var value = '<s:property value="progress"/>';
    var gauge1 = loadLiquidFillGauge("fillgauge1", value);
    var config1 = liquidFillGaugeDefaultSettings();
    config1.circleColor = "#FF7777";
    config1.textColor = "#FF4444";
    config1.waveTextColor = "#FFAAAA";
    config1.waveColor = "#FFDDDD";
    config1.circleThickness = 0.2;
    config1.textVertPosition = 0.2;
    config1.waveAnimateTime = 1000;


    function NewValue(){
    if(Math.random() > .5){
    return Math.round(Math.random()*100);
    } else {
    return (Math.random()*100).toFixed(1);
    }
    }
    </script>
</body>
</html>
