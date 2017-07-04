<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
    <title></title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
  
 <body>
<% 
	String userid=request.getParameter("userid");
	String type=request.getParameter("type");
	String password=request.getParameter("password");
	String name=request.getParameter("name");
	String college=request.getParameter("college");
	String telephone=request.getParameter("telephone");
%><center>
   <form action="${pageContext.request.contextPath}/UserDeleteServlet" method="post">
   	<input type="hidden" name="userid" value="<%= userid %>">
   	<input type="hidden" name="type" value="<%= type %>">
   	<table>
		<tr>
			<td>设备信息:</td>
		</tr>
		<tr>
			<td>用户账号:</td>
			<td><%=userid %></td>
		</tr>
		<tr>
			<td>用户密码:</td>
			<td><%=password %></td>
		</tr>
		<tr>
			<td>用户姓名:</td>
			<td><%=name %></td>
		</tr>
		<tr>
			<td>用户学院:</td>
			<td><%=college %></td>
		</tr>
		<tr>
			<td>用户类型:</td>
			<td><%=type %></td>
		</tr>
		<tr>
			<td>用户电话:</td>
			<td><%=telephone %></td>
		</tr>
		<tr>
			<td><input type="submit" value="确认删除"></td>
		</tr>
	</table>
	</center>
   </form>
 <%
	String info=(String)request.getAttribute("deleteinfo");
 %>
 
 <%
	if(info!=null||"".equals(info)){
%>
	<script type="text/javascript">
		alert("<%=info%>");	
		window.location.href="${pageContext.request.contextPath}/admin/user/select.jsp";
	</script>	
<%
	}
 %>
 </body>
</html>
