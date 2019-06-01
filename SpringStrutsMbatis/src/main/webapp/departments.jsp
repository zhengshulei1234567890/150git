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
						<c:forEach items="${departments}" var="departments" varStatus="stu">
						<tr class="row1">						   
							<td>
								<%--1--%>
								${stu.count}
							</td>
		
							<td>
								<%--0101010101--%>
								${departments.number}
							</td>
							<td>
								<%--研发部--%>
								${departments.department}
							</td>				
							<td>
								<a href="${pageContext.request.contextPath}/dep/selectById?id=${departments.id}">更新</a>&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/emp/selectAllEmp">员工列表</a>
							</td>
						</tr>
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
								<a href="updateDepartment.jsp">更新</a>&nbsp;&nbsp;&nbsp;<a href="updateEmp.jsp">员工列表</a>
							</td>
						</tr>--%>
						</c:forEach>
					</table>
					<p>
						<input type="button" class="button" value="添加员工" onclick="location='/SpringStrutsMbatis/addEmp.jsp'"/> <input type="button" class="button" value="添加部门" onclick="location='/SpringStrutsMbatis/addDepartment.jsp'"/>
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
