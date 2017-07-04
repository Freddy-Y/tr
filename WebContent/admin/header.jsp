<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>


<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">

</head>
<body>
<%
	String adminname=(String) session.getAttribute("adminname"); 
%>


<div id="header" style="float:center;" >
	<div id="logo">
		<h1>管理员用户</h1>
		<h2>欢迎<%=adminname %>管理员光临</h2>
	</div>
		<!-- ========================================================= -->
	<!-- ========================================================= -->

	
</div>




</body>
</html>
