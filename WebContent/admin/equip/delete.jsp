<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<center>
<%
	String equipid=request.getParameter("equipid");
	String name=request.getParameter("name");
	String build=request.getParameter("build");
	String state=request.getParameter("state");
	String time=request.getParameter("time");
 %>
	<h2 style="color:white;">删除设备</h2>
	<form action="<%= request.getContextPath()%>/EquipDeleteServlet" method="post">
	<input type="hidden" name="equipid" value="<%=equipid %>">
	<table>
		<tr>
			<td>设备信息:</td>
		</tr>
		<tr>
			<td>设备编号:</td>
			<td><%=equipid %></td>
		</tr>
		<tr>
			<td>设备型号:</td>
			<td><%=name %></td>
		</tr>
		<tr>
			<td>设备单位:</td>
			<td><%=build %></td>
		</tr>
		<tr>
			<td>设备状态:</td>
			<td><%=state %></td>
		</tr>
		<tr>
			<td>登记时间:</td>
			<td><%=time %></td>
		</tr>
		<tr>
			
			<td><input type="submit" value="确认删除"></td>
		</tr>
	</table>
	</form>
<%
	String info=(String)request.getAttribute("deleteinfo");
 %>
 
 <%
	if(info!=null||"".equals(info)){
%>
	<script type="text/javascript">
		alert("<%=info%>");	
		window.location.href="${pageContext.request.contextPath}/admin/equip/select.jsp";
	</script>	
<%
	}
 %>
	</center>
</body>
</html>