<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8" import="java.util.*" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
	<head>
		<title>update Emp</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/style.css" />

		<script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
		<script type="application/javascript">
            $(function () {
               /* var option=$("<span>haha</span>");
                //  var option = $("<option value=" + departments.get([i]).id + ">" + departments.get([i]).department + "</option>");
                //把option放入select标签里
                $("#td").append(option);*/
                $.ajax({
                    url: "${pageContext.request.contextPath}/dep/ShowAll",
                    type: "POST",
                    dataType: "Json",
                    success: function (departments) {
                        for (var i = 0; i < departments.length; i++) {
                          var option = $("<option value=" + departments[i].id + ">" + departments[i].department + "</option>");
                            //把option放入select标签里
                            $("#departments").append(option);
                        }
                    }
                })
			});
                </script>
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
								<a href="#">Main</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						update Emp info:
					</h1>
					<form action="${pageContext.request.contextPath}/emp/updateShowAll" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">				
							<tr>
								<td valign="middle" align="right">
									id:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="employees.id" value="${employees.id}"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									头像:
								</td>
								<td valign="middle" align="left">
								<img width="40px" height="40px" src="img/1.jpg" />
									<input type="file" name="upload" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="employees.name" value="${employees.name}"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									工资:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="employees.salary" value="${employees.salary}"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									年龄:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="employees.age" value="${employees.age}"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right" id="td">
									部门:
								</td>
								<td valign="middle" align="left">
									<select id="departments"  name="employees.d_id">
									</select>

								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="修改" />
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
