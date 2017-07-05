<%@ page language="java" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
<title>login.jsp</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<style type="text/css">
body {
	margin-left: 0px;
	background-image: url(bhj.jpg);
}

.style2 {
	color: #990000
}

.input2 {
	font-size: 12px;
	border: 3px double #A8D0EE;
	color: #344898;
}

.submit1 {
	border: 3px double #416C9C;
	height: 22px;
	width: 45px;
	background-color: #F2F2F2;
	font-size: 12px;
	padding-top: 1px;
	background-image: url(bt.gif);
	cursor: hand;
}

.STYLE12 {
	font-family: Georgia, "Times New Roman", Times, serif
}

.STYLE13 {
	color: #316BD6;
}

.STYLE15 {
	color: #fdsere;
	font-size: 9pt;
}
</style>

<script language="javascript">
 function check1()
 {                                                                                         
     if(document.ThisForm.userName.value=="")
	 {
	 	alert("请输入用户名");
		document.ThisForm.userName.focus();
		return false;
	 }
	 if(document.ThisForm.userPw.value=="")
	 {
	 	alert("请输入密码");
		document.ThisForm.userPw.focus();
		return false;
	 }

 }

 function callback(data)
 {
    document.getElementById("indicator").style.display="none";
    if(data=="no")
    {
        alert("用户名或密码错误");
    }
    if(data=="yes")
    {
        alert("通过验证,系统登录成功");
        window.location.href="admin/loginSuccess.jsp";
		}
	}
</script>
</head>
<body>
<body>
	<br>
	<br>
	<br>
	<br>
	<table width="559" height="423" border="0" align="center"
		cellpadding="0" cellspacing="0" background="dfff.jpg">
		<tr>
			<td>
				<div align="center"style="FONT-SIZE: 40pt;COLOR:BLACK">电子教育资源管理</div>
			</td>
		</tr>
		<tr>
			<td width="559">
				<form name="ThisForm" method="POST" action="<%= request.getContextPath()%>/ALoginServlet">
					<table width="350" height="200" border="0" align="right"
						cellpadding="0" cellspacing="0">
						<tr>
							<td height="10" colspan="2"></td>
						</tr>
						<tr>
<%
	 					if(session.getAttribute("admininfo")!=null){
	 						String info=(String)session.getAttribute("admininfo");
%>						
						<h2><%=info %></h2>
<%
	 					}
%>
							
						</tr>
						<tr>
							<td width="54" height="22" valign="bottom"><span
								class="STYLE15" style="FONT-SIZE: 10pt;COLOR:BLACK">账号：</span></td>
							<td width="356" valign="bottom"><input name="username"
								type="text" class="input2"
								onMouseOver="this.style.background='#F0DAF3';"
								onMouseOut="this.style.background='#FFFFFF'"></td>
						</tr>
						<tr>
							<td height="10" colspan="2" valign="bottom"></td>
						</tr>
						<tr>
							<td height="31" colspan="2" valign="top" class="STYLE15" style="FONT-SIZE: 10pt;COLOR:BLACK">
								密码： <input name="usrpassword" type="password" size="21"
								class="input2" align="bottom"
								onMouseOver="this.style.background='#F0DAF3';"
								onMouseOut="this.style.background='#FFFFFF'">
							</td>
						</tr>
						<tr>
							<td height="10" colspan="2" valign="bottom"></td>
						</tr>
						<tr>
							<td height="31" colspan="2" valign="top" class="STYLE15" style="FONT-SIZE: 10pt;COLOR:BLACK">
								单位： <select name="num" class="input2" align="bottom">
										<option value="#">--请选择管理员教学楼--</option>
										<option value="一教">一教</option>
										<option value="二教">二教</option>
										<option value="三教">三教</option>
										<option value="四教">四教</option>
									</select>
							</td>
						</tr>
						<tr>
							<td height="10" colspan="2" valign="bottom"></td>
						</tr>
						<tr>
							<td colspan="2" valign="top">&nbsp; &nbsp; &nbsp; &nbsp; <input
								name="button" type="submit" class="submit1" value="登录"
								onClick="check1()"> &nbsp; <input name="Submit2"
								type="reset" class="submit1" value="重置"> <img
								id="indicator" src="loading.gif"
								style="display:none" />
								<td>
									<a href="signin.jsp">注册</a>
								</td>
							</td>
						</tr>
						
					</table>
				</form>
			</td>
		</tr>
	</table>

	<a href="loginSuccess.jsp">123</a>

</body>
