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
        <div><!-- 	头的开始布局 -->
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
<%	if(session.getAttribute("personid")!=null){		//老师文件上传，显示老师之前的文件，添加文件的表单
%>
			<div style="float:left;background-color:#99ccff;height:700px;width:300px;">
				<form action="UploadServlet" method="post" enctype="multipart/form-data">  
    			user name<input type="text" name="username"/> <br/>  
  				请选择上传文件:<input type="file" name="f1"/><br/>  
    				<input type="file" name="f2"/><br/>  
    				<input type="submit" value="save"/>  
  				</form>
			</div>
<%
	}
%>		
<%	 if(session.getAttribute("personid")==null&&session.getAttribute("stuid")==null){		//老师文件上传，显示老师之前的文件，添加文件的表单
%>
			<div style="float:left;background-color:#99ccff;height:700px;width:300px;">
				<br>
				<br>
				<br>
				<br>
			</div>

			
<%
	}
%>	

					
			
    	</div><!-- 	头的结尾布局 -->
        
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
