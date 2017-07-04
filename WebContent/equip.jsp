<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <title>设备报修</title>
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
        	<div class="left" style="width:600px;height:600px;margin-top:200px;margin-left:800px;text-align:center"><!--左边正文-->
        		<form action="RepairAddServlet" method="post">
        			<table style="cellspacing:10px;width:400px;height:400px;text-align:left">
        				<tr>
        					<td>请输入日期</td>
        					<td><input type="text" name="repairid"></td>
        				</tr>
        				<tr>
        					<td>请输入报修教室</td>
        					<td><input type="text" name="roomid"></td>
        				</tr>
        				<tr>
        					<td>请选择报修教室</td>
        					<td>
        						<select name="building">
        							<option value="">--请选择所属教学楼--</option>
        							<option value="一教">一教</option>
        							<option value="二教">二教</option>
        							<option value="三教">三教</option>
        							<option value="四教">四教</option>
        						</select>
        					</td>
        				</tr>
        				<tr>
        					<td>请输入详细信息</td>
        					<td style="height:300px"><textarea rows="10" cols="30" name="repairmass"></textarea></td>
        				</tr>
        				<tr>
        					<td><input type="submit" value="提交"></td>
        					<td><input type="reset" value="重置"></td>
        				</tr>
        			</table>
        		</form>
        	</div><!--左边正文-->
        	
        </div><!--正中-->
    
<%
	String info=(String)request.getAttribute("repairinfo");
 %>
 
 <%
	if(info!=null||"".equals(info)){
%>
	<script type="text/javascript">
		alert("<%=info%>");	
		window.location.href="equip.jsp";
	</script>	
<%
	}
 %>
	<!--==============================footer=================================-->
     <%@ include file="foot.jsp"%>
	<script type="text/javascript"> Cufon.now(); </script>
</body>
</html>
