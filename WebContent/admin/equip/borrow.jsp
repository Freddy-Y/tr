<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h2 style="color:white;">借取设备</h2>
<%
	String equipid=(String)request.getParameter("equipid");
	String name=(String)request.getParameter("name");
	request.setAttribute("borrowid",equipid);
	request.setAttribute("borrowname",name);
	String info=(String) request.getAttribute("info");
 %>
 
<center>
	<h2>操作设备编号为<%= equipid %></h2>
	<h2>操作设备类型为<%= name %></h2>
	<hr>
	<form action="<%= request.getContextPath()%>/BorrowCreateServlet" method="post">
					<input type="hidden" name="equipid" value=<%=equipid %>>
					<input type="hidden" name="equipname" value=<%=name %>>
		请输入借记用户的账号:<input type="text" name="userid">
		请选择借记用户的类型:<select name="type">
						<option value="person">教师</option>
						<option value="student">学生</option>
						</select>
						<input type="submit" name="借取" value="借取">
						<input type="reset" name="重置" value="重置">
	</form>
</center>
<%
	if(info!=null||"".equals(info)){
%>
	<script type="text/javascript">
		alert("<%=info%>");	
	</script>	
<%
	}
 %>

</body>
</html>