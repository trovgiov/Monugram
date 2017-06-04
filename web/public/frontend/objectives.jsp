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

        #svg-container
        {
            display: flex;
            align-items: center;
            height: 100%;
        }

        #fillgauge1
        {
            margin: 0 auto;
            display: block;
        }


    </style>

</head>

<body>

<h1 id="title" class="hidden"><img src="../../images/hego_logo.png" alt="logo" style="width:60px;height:60px;border:0;"></br> CONSTRUCTION PROGRESS OF <s:property value="monumento"></s:property></h1>

<div id="svg-container"><svg id="fillgauge1" height="350px" width="350px"></svg></div>

<p><p><p></p>
<div class="textarea"><img src="/Monumenti/<s:property value="monumento"/>/<s:property value="monumento"/>.jpg" style="width:400px; height:224px;">

    <p><p></p>
    <a href="<s:action name=""/>"><img src="../../images/back.png" style="width:120px;height:60px;"></a>

</div>


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
