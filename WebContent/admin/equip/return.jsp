<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="vo.Borrow" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<h2 style="color:white;">设备归还</h2>
<%
	String equipid=(String)request.getParameter("equipid");
	String name=(String)request.getParameter("name");
 %>
 <% if(request.getAttribute("borrows")==null&&request.getAttribute("inforeturn")==null){ %>
 
 	<h3><%= equipid %></h3>
 	<h3><%= name %></h3>
 <% }%>
 	<hr>
 	<form action="<%= request.getContextPath()%>/BorrowDeleteServlet" method="post" >
 		<input type="hidden" name="use1" value="look">
 		<input type="hidden" name="equipid" value="<%=equipid %>">
 		<input type="submit" value="查看借用信息">
 	</form>
 <%
 	if(request.getAttribute("borrows")!=null){
 		Borrow borrow=(Borrow)request.getAttribute("borrows");
 %>	
 		<h3>借用人账号：<%=borrow.getPrincipalid() %></h3>
 		<h3>借用人姓名：<%=borrow.getUsername() %></h3>
 		<h3>借用设备编号：<%=borrow.getEquipnum() %></h3>
 		<h3>借用设备型号：<%=borrow.getEquipname() %></h3>
 		<h3>用户类型：<%=borrow.getType() %></h3>
 		<h3>借用日期：<%=borrow.getDate() %></h3>
 <%
 	}
  %>
 	<hr>
 	<hr>
 	<form action="<%= request.getContextPath()%>/BorrowDeleteServlet" method="post" >
 		<input type="hidden" name="use2" value="delete">
 		<input type="hidden" name="equipid" value="<%=equipid %>">
 		<input type="submit" value="归还">
 	</form>
 		
 <%
 	if(request.getAttribute("inforeturn")!=null){
 		String inforeturn=(String) request.getAttribute("inforeturn");
 %>	
 		<script type="text/javascript">
 			alert("<%=inforeturn%>");
 			window.location.href="${pageContext.request.contextPath}/admin/equip/select.jsp";
 		</script>
 <%
 	}
  %>
 </center>
</body>
</html>