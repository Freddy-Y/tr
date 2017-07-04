<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*,vo.Repair"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<h2 style="color:white;">查看维修信息</h2>
	<form action="${pageContext.request.contextPath}/RepairSelectServlet" method="post">
		<input type="hidden" name="state" value="1">
		<input type="submit" value="查看所有维修信息">
	</form>
<%
	List<Repair> all=new ArrayList();
	if(request.getAttribute("all")!=null){
		all=(List<Repair>) request.getAttribute("all");
		Iterator<Repair> iter=all.iterator();
%>		
		<table>
			<tr>
				<td>信息编号(日期)</td>
				<td>报修用户账号</td>
				<td>教室编号</td>
				<td>查看详细信息</td>
			</tr>
<%
		while(iter.hasNext()){
			Repair repair=iter.next();
			
%>
			<tr>
				<td><%=repair.getRepairid() %></td>
				<td><%=repair.getUserid() %></td>
				<td><%=repair.getRoomid() %></td>
				<td><%=repair.getRepairmass() %></td>
				<td><a href="${pageContext.request.contextPath}/admin/repair/delete.jsp?&repairid=<%=repair.getRepairid() %>&userid=<%=repair.getUserid() %>&roomid=<%=repair.getRoomid() %>&repairmass=<%=repair.getRepairmass() %>">查看详细信息</a></td>
			</tr>
<%
			
		}
%>
			
		</table>
	
<%
	}
%>
</center>
	
</body>
</html>