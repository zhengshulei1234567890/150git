<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8" import="java.util.*" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
	<title>emplist</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
<div id="wrap">
	<div id="top_content">
		<div id="header">
			<div id="rightheader">
				<p>
					<%--2009/11/20--%>
					<fmt:formatDate value="<%=new Date()%>" timeStyle="yyyy-MM-dd"/>
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
				Welcome!
			</h1>
			<table class="table">
				<tr class="table_header">
					<td>
						ID
					</td>
					<td>
						头像
					</td>
					<td>
						Name
					</td>
					<td>
						Salary
					</td>
					<td>
						Age
					</td>
					<td>
						Operation
					</td>
				</tr>
				<c:forEach items="${users}" var="users" varStatus="stu" >
					<tr class="row1">
							<td>${stu.index+1}</td>

							<td>
								<img width="40px" height="40px" src="${pageContext.request.contextPath}/img/${users.head}"  />
							</td>
							<td>
								${users .name}
							</td>
							<td>
								${users.salary}
							</td>
							<td>
								${users.age}
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/admina/deleteShowAll?id=${users.id}">delete emp</a>&nbsp;<a href="${pageContext.request.contextPath}/admina/selectById?id=${users.id}">update emp</a>
							</td>
					</tr>
				</c:forEach>
			</table>
			<p>
				<input type="button" class="button" value="Add Employee" onclick="location='/SpringSm/addEmp.jsp'"/>
			</p>
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
