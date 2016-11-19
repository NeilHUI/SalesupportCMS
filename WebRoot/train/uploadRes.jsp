<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'uploadRes.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <s:form action="train_resource!upload.action" method="post" enctype="multipart/form-data" theme="simple">
    	<table>
    		<tr>
    			<td>资源描述</td>
    			<td>
    				<textArea cols="50" rows="20" name="desc"></textArea>
    			</td>
    		</tr>
    		<tr>
    			<td>资源路径</td>
    			<td>
    				<input type="file" name="up"/>
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2"><s:submit value="确定"></s:submit></td>
    		</tr>	
    	</table>
    </s:form>  
  </body>
</html>
