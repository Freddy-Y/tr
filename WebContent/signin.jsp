<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css"> 
	.log { 
		position: absolute;     
		top:20%;   left:20%;  
		margin-left:-101px;   
		margin-top:-101px;
		background-color: #777777;
		text-align:center
	} 
</style> 
</head>
<body class="log">
	<div  style="background-color: #BBBBBB;width:1300px;height:550px">
	<h2 style="color:#000000;margin-top:50px;">添加用户</h2>
	<div>
		<form action="${pageContext.request.contextPath}/SigninServlet" method="post" >
			账&nbsp&nbsp号：<input type="text" name="userid"><br><br>
			姓&nbsp&nbsp名：<input type="text" name="name" ><br><br>
			密&nbsp&nbsp码：<input type="password" name="passwd" ><br><br>
			用户类型：<input type="radio" name="style" value="学生">学生&nbsp&nbsp
				<input type="radio" name="style" value="教师">教师<br><br>
			学&nbsp&nbsp院：<select name="college">
					<option value="信息学院">信息科学与工程学院</option>
					<option value="机械学院">机械学院</option>
					<option value="外语学院">外语学院</option>
					<option value="文法学院">文法学院</option>
					<option value="车辆学院">车辆学院</option>
					<option value="环化学院">环化学院</option>
					<option value="建工学院">建工学院</option>
			</select><br><br>
			电&nbsp&nbsp话：<input type="text" name="telephone"><br><br>
			<input type="submit" value="注册">&nbsp&nbsp
			<input type="reset" value="重置" >
		</form>
	</div>
	</div>
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