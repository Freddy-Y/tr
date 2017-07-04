		<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*,vo.Equip"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>123</title>
</head>
<body>
	<center>
	<h2 style="color:white;">设备状态</h2>&nbsp&nbsp
	<form action="<%= request.getContextPath()%>/ESelectServlet" method="post" name="form1">
		<select name="abc" id="state">
			<option value="">---选择设备状态---</option>
			<option value="0">显示当前借出设备</option>
			<option value="1">显示当前空闲设备</option>
		</select>
		<input type="submit" value="提交" onclick=check()>
	</form>
<%
	if(request.getAttribute("all")!=null){
	List<Equip> all=(List<Equip>)request.getAttribute("all");
	Iterator<Equip> iter=all.iterator();
 %>	
 
 	<table border="1" width="80%" bgcolor="white">
 		<tr>
 			<td>设备编号</td>
 			<td>设备型号</td>
 			<td>所属教学楼</td>
 			<td>当前状态</td>
 			<td>录入日期</td>
 			<td>操作该设备</td>
 		</tr>
<%
	while(iter.hasNext()){
		Equip equip=iter.next();
%>


		<tr>
			<td><%= equip.getEquipid() %></td>
			<td><%= equip.getName() %></td>
			<td><%= equip.getBuild() %></td>
			<td><%= equip.getState() %></td>
			<td><%= equip.getTime() %></td>
<%
	int bbbttt=(int)request.getAttribute("bbbttt");
	if(bbbttt==0){
 %>
			<td><a href="${pageContext.request.contextPath}/admin/equip/return.jsp?equipid=<%=equip.getEquipid()%>&name=<%= equip.getName() %>">归还该设备</a></td>
<%
	}
	if(bbbttt==1){
 %>	
 
 			<td><a href="${pageContext.request.contextPath}/admin/equip/borrow.jsp?equipid=<%=equip.getEquipid()%>&name=<%= equip.getName() %>">借取该设备</a></td>
 <% 
 	}
 %>
 			<td><a href="${pageContext.request.contextPath}/admin/equip/delete.jsp?equipid=<%= equip.getEquipid()%>&name=<%= equip.getName()%>&build=<%= equip.getBuild()%>&state=<%= equip.getState()%>&time=<%= equip.getTime()%>">删除该设备</a></td>
		</tr>
<%	
	}
	}
%>
 		
 <%String infoborrow=(String) request.getAttribute("infoborrow");%>
 <%
	if(infoborrow!=null||"".equals(infoborrow)){
%>
	<script type="text/javascript">
		alert("<%=infoborrow %>");	
	</script>	
<%
	}
 %>		
 
 	</table>
 </center>
</body>
</html>