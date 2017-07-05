<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*,vo.Massage" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<h2 style="color:white;">查看留言</h2>
	<form action="${pageContext.request.contextPath}/MassageSelectServlet" method="post">
		<input type="hidden" name="start" value="1">
		<input type="submit" value="查看所有留言信息">
	</form>
	<!-- ========================================================== -->
	<%
	List<Massage> all=new ArrayList();
	if(request.getAttribute("allmassage0")!=null){
		all=(List<Massage>) request.getAttribute("allmassage0");
		Iterator<Massage> iter=all.iterator();
%>		
		<table border="1" width="80%" bgcolor="white">
			<tr>
				<td>留言编号</td>
				<td>留言信息</td>
				<td>留言日期</td>
				<td>留言用户</td>
			</tr>
<%
		while(iter.hasNext()){
			Massage massage=iter.next();
			
%>
			<tr>
				<td><%= massage.getMassageid() %></td>
				<td><textarea rows="2" cols="100" disable="disadle" style="resize:none;width: 100%;padding:0px;"><%= massage.getMcontent() %></textarea></td>
				<td><%= massage.getDate() %></td>
				<td><%= massage.getUserid() %></td>
			</tr>
<%
			
		}
%>
			
		</table>
	
<%
	}
%>
	<!-- ===================================rows="2" cols="40" ======================= -->
</center>
</body>
</html>