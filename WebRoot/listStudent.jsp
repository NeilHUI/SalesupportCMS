<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'listStudent.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function del(id) {
			if(confirm("确定要删除吗？")) {
				location.href = "student!delete.action?s.id=" + id;
			}
		}
	</script>
</head>

<body>
	<h1>学生信息</h1>
	<table align="center" border="1" width="60%">
		<tr>
			<td>姓名</td>
			<td>年龄</td>
			<td>性别</td>
			<td>爱好</td>
			<td>年级</td>
			<td>备注</td>
			<td>操作</td>
		</tr>
		<s:iterator value="list">
			<tr>
				<td><s:property value="name" /></td>
				<td><s:property value="age" /></td>
				<td><s:property value="sex" /></td>
				<td><s:property value="hobby" /></td>
				<td><s:property value="grade" /></td>
				<td><s:property value="descr" /></td>
				<td>
					<a href="javascript:del('<s:property value="id"/>')">删除</a>| 
					<a href="student!preUpdate.action?s.id=<s:property value='id'/>">修改</a>
				</td>
			</tr>
		</s:iterator>
		<tr>
			<td colspan="7"><a href="addStu.jsp">增加</a></td>
		</tr>
	</table>
</body>
</html>
