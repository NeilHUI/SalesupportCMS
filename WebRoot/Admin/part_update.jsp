<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="h" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
    
    <title>My JSP 'update_part.jsp' starting page</title>
    
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
    <h:form action="Resource!update.action" method="post" theme="simple">
    	<table>
    		<tr>
    			<td> 编号：</td>
    			<td>
    				<h:textfield name="h.id"></h:textfield>
    			</td>
    		</tr>
    		<tr>
    			<td>名字：</td>
    			<td>
    				<h:textfield name="h.name"></h:textfield>
    			</td>
    		</tr>
    		<tr>
    			<td>数量：</td>
    			<td>
    				<h:textfield name="h.num"></h:textfield>
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2">
    				<h:submit value="确定"></h:submit>
    			</td>
    		</tr>
    	</table>
    </h:form>
  </body>
</html>
