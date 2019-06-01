<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>
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
						编号
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
				<c:forEach var="employee" items="${department.list}" varStatus="stu">
					<tr class="row1">
						<td>
								${stu.index+1}
						</td>
						<td>
							<img width="40px" height="40px" src="${pageContext.request.contextPath}/img/${employee.head}" />
						</td>

						<td>
								${employee.name}
						</td>
						<td>
								${employee.salary}
						</td>
						<td>
								${employee.age}
						</td>
						<td>
								${department.deptname}
						</td>
						<td>
							<a href="${pageContext.request.contextPath}/employee/delete.do?id=${employee.id}&depId=${department.id}">delete emp</a>&nbsp;<a href="${pageContext.request.contextPath}/employee/selectByID.do?id=${employee.id}">update emp</a>
						</td>
					</tr>
				</c:forEach>
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
                        <a href="emplist.html">delete emp</a>&nbsp;<a href="updateEmp.html">update emp</a>
                    </td>
                </tr>--%>
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
