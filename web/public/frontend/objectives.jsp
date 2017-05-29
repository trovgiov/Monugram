<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HeGO - Monument Progress</title>

    <!-- Google Fonts -->
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>

    <!-- Custom Stylesheet -->
    <link rel="stylesheet" href="./assets/css/upload_style.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="http://d3js.org/d3.v3.min.js" language="JavaScript"></script>
    <script src="/js/liquidFillGauge.js" language="JavaScript"></script>
    <style>
        .liquidFillGaugeText { font-family: 'Muli', Arial, sans-serif;}
    </style>

</head>

<body>

<h1 id="title" class="hidden"><img src="../../images/hego_logo.png" alt="logo" style="width:60px;height:60px;border:0;"></br> CONSTRUCTION PROGRESS OF <s:property value="monumento"></s:property></h1>

<svg id="fillgauge1" width="97%" height="250"></svg>

<script language="JavaScript">

    var value = '<s:property value="progress"/>';
    var gauge1 = loadLiquidFillGauge("fillgauge1", value);
    var config1 = liquidFillGaugeDefaultSettings();
    config1.circleColor = "#FFF";
    config1.textColor = "#FFF";
    config1.waveTextColor = "#FFF";
    config1.waveColor = "#FFF";
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
