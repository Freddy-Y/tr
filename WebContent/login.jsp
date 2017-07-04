<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
<%@ page import="java.util.*" %>


<html>
<head>
	<title>登陆</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
		
	<div>
<%	
		request.setCharacterEncoding("utf-8"); 
%>
<%
		List<String> info=(List<String>)session.getAttribute("info");
		if(info!=null){
			Iterator<String> iter=info.iterator();
			while(iter.hasNext()){
				String errorinfo=iter.next();

%>
			<h2 style="color:red"><%= errorinfo %>!</h2>
<%
				}
			}
%>
	</div>
	<div style="text-align:left">
		<form action="SLoginServlet" method="post" name="login">
			用户名：<input type="text" name="userid" ><br>
			密&nbsp&nbsp码：<input type="password" name="passwd"><br>
			用户类型:<input type="radio" name="style" value="学生">学生
			<input type="radio" name="style" value="教师">教师<br>
			<input type="submit" value="登陆" >&nbsp&nbsp
			<input type="reset" value="重置" >
		</form>
	</div>

		<a href=""></a>
	
</body>
</html>