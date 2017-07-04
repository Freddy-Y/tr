<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
    <title>首页</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="css/reset.css" type="text/css" media="screen">
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
    <link rel="stylesheet" href="css/grid.css" type="text/css" media="screen">   
    <script src="js/jquery-1.6.3.min.js" type="text/javascript"></script>
    <script src="js/cufon-yui.js" type="text/javascript"></script>
    <script src="js/cufon-replace.js" type="text/javascript"></script>
    <script src="js/FF-cash.js" type="text/javascript"></script>
    <script src="js/jquery.featureCarousel.js" type="text/javascript"></script>     
    <script type="text/javascript">
      $(document).ready(function() {
        $("#carousel").featureCarousel({
			autoPlay:3000,
			trackerIndividual:false,
			trackerSummation:false,
			topPadding:50,
			smallFeatureWidth:.9,
			smallFeatureHeight:.9,
			sidePadding:0,
			smallFeatureOffset:0
		});
      });
    </script>
	
    <script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"9148",secure:"9157"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);
    </script>
    <style type="text/css">
            .right{width:300px; height: 18000;float:right; text-align:left;height:auto ;border-style:dashed; }
            .left{width:300px;float:left; text-align:left;height:auto ;border-style:dashed; }
            title1{
                font-size: 45;
            }
            title2{
                font-size: 20;
            }
            h1{
                font-size: 30px;
            }
            h2{
                 font-size: 15px;
            }
    </style>
</head>
<!--
<body id="page1" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-2" data-genuitec-path="/teachingresource/WebRoot/index.jsp">
-->
<body>
<!--
	<div class="extra" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-2" data-genuitec-path="/teachingresource/WebRoot/index.jsp">
    
-->
<%
	//List<String> info=(List<String>)request.getAttribute("info");
%>


    <div>
        <jsp:include page="header.jsp" flush="true"/>
        <div style="float:right">   <!--右面登陆界面-->
            <div class="right" style="padding-top:45px;">
            	<% if(session.getAttribute("stuid")!=null||session.getAttribute("personid")!=null){	%>
            	
            		<jsp:include page="SLoginSuccess.jsp" flush="true"/>  
            		
            	<% 	}else{	%>
            		
            		<jsp:include page="login.jsp" flush="true"/>     
            	
            	<%	}	%>
            	
            	
            	
                
            </div>
        </div>
    </div>
    
    <!-- <div> -->
        <div class="extra" style="text-align:center"><!--做种-->
            <div>   <!--css轮番显示 class="row-bot"-->
                <div>
                    <div class="carousel-container">
                        <div id="carousel"><!--fanzhuan -->
                            <div class="carousel-feature">
                                <img class="carousel-image" alt="" src="images/gallery-img1.png">                         
                            </div>
                            <div class="carousel-feature">
                                <img class="carousel-image" alt="" src="images/gallery-img3.png">
                            </div>
                            <div class="carousel-feature">
                                <img class="carousel-image" alt="" src="images/gallery-img2.png">
                            </div>
                        </div>
                    </div> 
                </div>
            </div><!--css轮番显示-->


            <div class="left" style="border: 2px dotted blue;height:600px;width:900px"><!--简介-->
                <div class="left">
                        <h1>燕山大学</h1>
                        <h1>Yanshan University</h1><br><br><br><br><br><br><br><br><br>
                        <h2>燕山大学（Yanshan University）简称“燕大”（YSU），坐落于河北省秦皇岛市，北依燕山，南临渤海，故得名燕山大学，燕山大学源于哈尔滨工业大学，始建于1920年。1958年哈尔滨工业大学重型机械系及相关专业成建制迁至工业重镇齐齐哈尔市富拉尔基区，组建了哈尔滨工业大学重型机械学院。1960年独立办学，定名为东北重型机械学院。1978年被确定为全国重点高等院校。1985年至1997年学校整体南迁秦皇岛市。1997年1月经原国家教委批准，更名为燕山大学。1998年，由原机械工业部划到河北省，实行中央与地方共建，以河北省管理为主。2016年，作为教育部选定的两所高校之一，学校的工程专业国家认证接受了《华盛顿协议》国际专家的观摩考察，支撑了我国正式加入《华盛顿协议》国际工程教育组织。截至2016年6月，燕山大学设有11个博士后流动站，11个博士学位授予权一级学科；有28个硕士学位授予权一级学科，10个硕士专业学位授权类别（工程硕士授权领域17个）；有9个学科门类的本科专业62个。工程学、材料科学2个学科进入ESI排名全球前1%。</h2>
                </div>
                <div style="margin-top:30px">
                        <a href="http://www.ysu.edu.cn/"><img src="images/logo3.jpg"></a>
                </div>  
            </div>

            <div class="right" style="border: 2px dotted blue;height:600px;width:550px">   <!--通知栏显示-->
                <h1>通知：</h1>
            </div>
        </div>
            

            


        
        
        
        
        
    <!--</div>  -->
   
	<!--==============================footer=================================-->
    <div>
        <%@ include file="foot.jsp"%>
    </div>
	
<!--------------------------------------------------------------------------- -->
	<script type="text/javascript"> Cufon.now(); </script>
</body>
</html>
