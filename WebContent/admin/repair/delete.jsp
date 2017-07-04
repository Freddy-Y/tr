<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
	String repairid=request.getParameter("repairid");
	String userid=request.getParameter("userid");
	String roomid=request.getParameter("roomid");
	String repairmass=request.getParameter("repairmass");
%>

<center>
	<div style="text-align:left;margin-top:10%;margin-left:40%">
		<form action="${pageContext.request.contextPath}/RepairDeleteServlet" method="post">
		<input type="hidden" name="repairid" value="<%=repairid %>">
		<h3>维修编号:<%=repairid %></h3>
		<h3>用户账号:<%=userid %></h3>
		<h3>教室账号:<%=roomid %></h3>
		<textarea readonly="value"><%=repairmass %></textarea>
		<input type="submit" value="清除该维修信息">
		</form>
	</div>
<%
String info=(String) request.getAttribute("deleteinfo");
if(info!=null||"".equals(info)){
%>
	<script type="text/javascript">
 			alert("<%=info%>");
 			window.location.href="${pageContext.request.contextPath}/admin/repair/select.jsp";
 	</script>
	
<%
}
%>
	
</center>

</body>
</html>