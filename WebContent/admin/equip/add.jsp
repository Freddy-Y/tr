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
	<h2 style="color:white;">设备添加</h2>
	<form action="<%= request.getContextPath()%>/EquipAddServlet" method="post">
		<table>
			<tr>
				<td>设备编号:</td>
				<td><input type="text" name="equipid"></td>
			</tr>
			<tr>
				<td>设备型号:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td><input type="submit" value="确认"></td>
				<td><input type="reset" name="重置"></td>
			</tr>
			
		</table>
	</form>
<%
	String info=(String)request.getAttribute("addinfo");
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