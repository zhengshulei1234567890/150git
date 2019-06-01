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
								姓名
							</td>
							<td>
								工资
							</td>
							<td>
								年龄
							</td>
							<td>
								部门名称
							</td>
							<td>
								操作
							</td>
						</tr>
						<c:forEach items="${employees}" var="employees" varStatus="stu">
						<tr class="row1">						   
							<td>
								<%--1--%>
								${stu.count}
							</td>
							 <td>
							  <img width="40px" height="40px" src="img/1.jpg" />
							</td>
							
							<td>
								<%--zhangshan--%>
								${employees.name}
							</td>
							<td>
								<%--20000--%>
								${employees.salary}
							</td>
							<td>
								<%--20--%>
								${employees.age}
							</td>
							<td>
								<%--研发部--%>
								${employees.department}
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/emp/deleteAllEmp?id=${employees.id}">delete emp</a>&nbsp;<a href="${pageContext.request.contextPath}/emp/selectById?id=${employees.id}">update emp</a>
							</td>
						</tr>
						<%--<tr class="row2">
						    
							<td>
								2
							</td>
							<td>
							  <img width="40px" height="40px" src="img/2.jpg" />
							</td>
							<td>
								lishi
							</td>
							<td>
								20000
							</td>
							<td>
								20
							</td>
							<td>
								研发部
							</td>
							<td>
								<a href="emplist.jsp">delete emp</a>&nbsp;<a href="updateEmp.jsp">update emp</a>
							</td>
						</tr>--%>
						</c:forEach>
					</table>
					
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
