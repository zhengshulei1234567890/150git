<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page pageEncoding="UTF-8" contentType="text/html;UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
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
						Welcome!&nbsp;&nbsp;${sessionScope.admin.username}
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								部门ID
							</td>
							<td>
								部门编号
							</td>
							<td>
								部门名称
							</td>
							<td>
								操作
							</td>
						</tr>
						<c:forEach var="department" items="${requestScope.departments}" >
						<tr class="row1">						   
							<td>
								${department.id}
							</td>
		
							<td>
								${department.deptnumber}
							</td>
							<td>
								${department.deptname}
							</td>				
							<td>
								<a href="${pageContext.request.contextPath}/department/selectByID.do?id=${department.id}">更新</a>&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/department/queryAllEmployee.do?id=${department.id}">员工列表</a>
							</td>
						</tr>
						</c:forEach>
						<%--<tr class="row2">
							<td>
								2
							</td>
							<td>
								0202020202
							</td>
							<td>
								教学部
							</td>
							<td>
								<a href="updateDepartment.html">更新</a>&nbsp;&nbsp;&nbsp;<a href="updateEmp.html">员工列表</a>
							</td>
						</tr>--%>
					</table>
					<p>
						<input type="button" class="button" value="添加员工" onclick="location='${pageContext.request.contextPath}/addEmp.jsp'"/> <input type="button" class="button" value="添加部门" onclick="location='${pageContext.request.contextPath}/addDepartment.jsp'"/>
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
