<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <title>教学资源</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="css/reset.css" type="text/css" media="screen">
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
    <link rel="stylesheet" href="css/grid.css" type="text/css" media="screen">   
    <script src="js/jquery-1.6.3.min.js" type="text/javascript"></script>
    <script src="js/cufon-yui.js" type="text/javascript"></script>
    <script src="js/cufon-replace.js" type="text/javascript"></script>
    <script src="js/FF-cash.js" type="text/javascript"></script>
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
<body>
	
   	<!--==============================header=================================-->
        <div>
        	<jsp:include page="header.jsp" flush="true"/>
        	<div class="right">   <!--右面登陆界面-->
            	<div class="right" style="padding-top:45px;">
            	<% if(session.getAttribute("stuid")==null){	%>
            	
            		<jsp:include page="login.jsp" flush="true"/>
            		
            	<% 	}else{	%>
            		<jsp:include page="SLoginSuccess.jsp" flush="true"/>        

            	
            	<%	}	%>
            	
           		</div>
        	</div><!--右面登陆界面-->
    	</div>
        
    <!--==============================content================================-->
      
        <div><!--正中-->
        	<div class="left"><!--左边正文-->
        	</div><!--左边正文-->
        	
        </div><!--正中-->
   
	
	<!--==============================footer=================================-->
    <%@ include file="foot.jsp"%>
	<script type="text/javascript"> Cufon.now(); </script>
</body>
</html>
