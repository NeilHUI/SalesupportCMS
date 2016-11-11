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
    
    <title>My JSP 'addStu.jsp' starting page</title>
    
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
    <s:form action="student!add.action" method="post" theme="simple">
    	<table>
    		<tr>
    			<td>姓名：</td>
    			<td>
    				<s:textfield name="s.name"></s:textfield>
    			</td>
    		</tr>
    		<tr>
    			<td>年龄：</td>
    			<td>
    				<s:textfield name="s.age"></s:textfield>
    			</td>
    		</tr>
    		<tr>
    			<td>性别：</td>
    			<td>
    				<s:radio list="{'男','女'}" name="s.sex"></s:radio>
    			</td>
    		</tr>
    		<tr>
    			<td>爱好：</td>
    			<td>
    				<s:checkboxlist list="{'相声','京剧','歌剧','古典音乐'}" name="s.hobbyArr"></s:checkboxlist>
    			</td>
    		</tr>
    		<tr>
    			<td>年级：</td>
    			<td>
    				<s:select list="{'2014','2015','2016'}" name="s.grade"></s:select>
    			</td>
    		</tr>
    		<tr>
    			<td>备注：</td>
    			<td>
    				<s:textarea cols="25" rows="8" name="s.descr"></s:textarea>
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2">
    				<s:submit value="确定"></s:submit>
    			</td>
    		</tr>
    	</table>
    </s:form>
  </body>
</html>
