<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登陆成功</title>
</head>
<body>

<%	
		request.setCharacterEncoding("utf-8"); 
		
%>
<%
		
		String stuname=(String)session.getAttribute("stuname");
		String personname=(String)session.getAttribute("personname");
		String type=null;
		String name=null;
		if(stuname!=null||"".equals(stuname)){
			name=stuname;
			type="同学";
		}
		if(personname!=null||"".equals(personname)){
			name=personname;
			type="老师";
		}
			
%>		

<div style="font-color:red;"><h1>欢迎<%= name%><%= type%>光临！</h1></div>
				
</body>
</html>