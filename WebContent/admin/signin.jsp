<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
	<title>管理员注册</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<script type="text/javascript">
		function check(){
			if (domcument.login.userid==NULL) {
				alert("请输入用户名");
			};
			if (domcument.login.userid==NULL) {
				alert("请输入密码");
			};

		}
		
		
	</script>
	<style type="text/css"> 
	.log { 
		position: absolute;     
		top:50%;   left:50%;  
		margin-left:-101px;   
		margin-top:-101px;
		background-color: #007799;
		text-align:left;
	} 
</style> 
</head>
<body class="log">
	<div >
		<div sytle="text-align:center;">
		<h2>管理员注册</h2>
		</div>
		<form action="<%= request.getContextPath()%>/ASignServlet" method="post" name="signin">
			账&nbsp&nbsp号：<input type="text" name="userid"><br><br>
			姓&nbsp&nbsp名：<input type="text" name="name" ><br><br>
			密&nbsp&nbsp码：<input type="password" name="passwd" ><br><br>
			学&nbsp&nbsp院：<select name="num">
					<option value="一教">一教</option>
					<option value="二教">二教</option>
					<option value="三教">三教</option>
					<option value="四教">四教</option>
					
			</select><br><br>
			电&nbsp&nbsp话：<input type="text" name="telephone"><br><br>
			<input type="submit" value="注册">&nbsp&nbsp
			<input type="reset" value="重置" >
		</form>
		
		<%
			String info1=(String)request.getAttribute("signinfo"); 
			if(!(info1==null||"".equals(info1))){
		%>
		<script type="text/javascript">
			alert("<%=info1%>");
		</script>
			
			
		<%
			}
		%>
	
</body>
</html>