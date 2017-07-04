<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*,vo.Person,vo.Student" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<center>
	<h2 style="color:white;">查询用户</h2>
	<form action="${pageContext.request.contextPath}/UserSelectServlet" method="post">
		请选择要查询的用户类型:
		<select name="type">
			<option value="">--请选择用户类型--</option>
			<option value="student">学生</option>
			<option value="person">教师</option>
		</select>
		<input type="submit" value="确认查询">
	</form>
	
	<table border="1" width="80%" bgcolor="white">
		<tr>
			<td>账号:</td>
			<td>姓名:</td>
			<td>密码:</td>
			<td>学院:</td>
			<td>电话:</td>
			<td>操作:</td>
		</tr>
<%
if(request.getAttribute("allperson")!=null){
	String type=(String) request.getAttribute("type");
	List<Person> allperson=(List<Person>)request.getAttribute("allperson");
	//List<Student> allstudent=(List<Student>)request.getAttribute("allstudent");
	Iterator<Person> iterperson=allperson.iterator();
	//Iterator<Student> iterstudent=allstudent.iterator();
%>
<%
	if(type=="person"||"person".equals(type)){
	while(iterperson.hasNext()){
		Person person=iterperson.next();
%>
		<tr>
			<td><%= person.getPersonid() %></td>
			<td><%= person.getPassword() %></td>
			<td><%= person.getName() %></td>
			<td><%= person.getCollege() %></td>
			<td><%= person.getTelephone() %></td>
			<td><a href="${pageContext.request.contextPath}/admin/user/delete.jsp?userid=<%=person.getPersonid()%>&type=<%=type %>&password=<%= person.getPassword() %>&name=<%= person.getName() %>&college=<%= person.getCollege() %>&telephone=<%= person.getTelephone() %>">删除该用户</a></td>
		</tr>
<%
	}}}

if(request.getAttribute("allstudent")!=null){
	String type=(String) request.getAttribute("type");
	List<Student> allstudent=(List<Student>)request.getAttribute("allstudent");
	Iterator<Student> iterstudent=allstudent.iterator();
	if(type=="student"||"student".equals(type)){
	while(iterstudent.hasNext()){
		Student student =iterstudent.next();
 %>	
		<tr>
			<td><%= student.getSid() %></td>
			<td><%= student.getPassword() %></td>
			<td><%= student.getName() %></td>
			<td><%= student.getCollege() %></td>
			<td><%= student.getTelephone() %></td>
			<td><a href="${pageContext.request.contextPath}/admin/user/delete.jsp?userid=<%=student.getSid()%>&type=<%=type %>&password=<%= student.getPassword() %>&name=<%= student.getName() %>&college=<%= student.getCollege() %>&telephone=<%= student.getTelephone() %>">删除该用户</a></td>
		</tr>	
	
<%
	}}}
%>
	
	</table>
	
	
	</center>
</body>
</html>