<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>
<html>
<head>
	<title>login</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css"
		  href="${pageContext.request.contextPath}/css/style.css" />
</head>

<body>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>
<div id="wrap">
	<div id="top_content">
		<div id="header">
			<div id="rightheader">
				<p>
					<%= sdf.format(new Date()) %>
					<br />
				</p>
			</div>
			<div id="topheader">
				<h1 id="title">
					<a href="#">main</a>
				</h1>
			</div>
			<div id="navigation">
			</div>
		</div>
		<div id="content">
			<p id="whereami">
			</p>
			<h1>
				登陆
			</h1>
			<form action="${pageContext.request.contextPath}/admin/login.do" method="post">
				<table cellpadding="0" cellspacing="0" border="0"
					   class="form_table">
					<tr>
						<td valign="middle" align="right">
							用户名:
						</td>
						<td valign="middle" align="left">
							<input type="text" class="inputgri" name="username" />
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">
							密码:
						</td>
						<td valign="middle" align="left">
							<input type="password" class="inputgri" name="password" />
						</td>
					</tr>
				</table>
				<p>
					<input type="submit" class="button" value="登陆" />
					<input type="button" class="button" onclick="location.href='${pageContext.request.contextPath}/regist.jsp'" value="注册" />
				</p>
			</form>
		</div>
	</div>
	<div id="footer">
		<div id="footer_bg">
			ABC@126.com
		</div>
	</div>
</div>
</body>
</html>
