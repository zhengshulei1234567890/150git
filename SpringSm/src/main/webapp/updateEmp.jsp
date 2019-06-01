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
	</head>

	<body>
		<div id="wrap">
			<div id="top_content">
					<div id="header">
						<div id="rightheader">
							<p>
								<%--2009/11/20--%>
								<fmt:formatDate value="<%=new Date()%>" timeStyle="yyyy-DD-mm"/>
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

					<form action="${pageContext.request.contextPath}/admina/updateShowAll" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									头像:
								</td>
								<td valign="middle" align="left">
									<label>
								<img id="upload"  width="40px" height="40px" src="${pageContext.request.contextPath}/img/${users.head}"/>
										</label>
										<input type="hidden" name="user.head" value="${user.head}"/>
									<input type="file" name="head" id="upload1" onchange="upload_review()">
								</td>
								<%--<script>
                                    function upload_review() {
                                        var img = document.getElementById("upload");
                                        var input = document.getElementById("upload1");
                                        var tip = document.getElementById("uploadtip");
                                        var file = input.files.item(0);
                                        var freader = new FileReader();
                                        freader.readAsDataURL(file);
                                        freader.onload = function(e) {
                                            img.src = e.target.result;
                                            tip.style.display = "none";
                                        };
                                    }
								</script>
--%>
							<tr>
								<td valign="middle" align="right">
									id:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="users.id" value="${users.id}"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									name:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="users.name" value="${users.name}"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									salary:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="users.salary" value="${users.salary}"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									age:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="users.age" value="${users.age}"/>
								</td>
							</tr>

						</table>
						<p>
							<input type="submit" class="button" value="Confirm" />
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
