<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'listRes.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/train/css/train_search.css">
	
	<script type="text/javascript">
		function forward1(param)
		{
			var totalRecord=document.getElementById("totalRecord").value;
			if(param.value!="" &&! isNaN(param.value)&&param.value>0&&parseInt(param.value)<parseInt(totalRecord))
			{
				location.href="resPage!listRes?resPage.onePageNum="+param.value+"";
			}
			else
			{
				alert("请填写正确的数值!");
			}
			
			 
		}
		 function forward2(param) 
		{
			 var pageCount = document.getElementById("totalPage").value;
			 var pagesize = document.getElementById("pagesize").value;
			 if(param.value!="" && !isNaN(param.value) && param.value>0 && parseInt(param.value)<=parseInt(pageCount)) 
			 {
				 location.href = "resPage!listRes?resPage.currentPage=" + param.value + "&resPage.onePageNum=" + pagesize+"&resource_type=2";
			 }
		}
		function search()
		{
			 var searchContent=document.getElementById("search").value;
			 var pagesize = document.getElementById("pagesize").value;
			 location.href = "resPage!listRes?&resPage.onePageNum=" + pagesize+"&resource_type=2"+"&searchContent="+searchContent;
			// alert(searchContent);
		}
	</script>
  </head>
  
  <body>
  	<center style="margin-top:100px;">搜索:<input type="text" id="search"/><input id="search_text" type="button" value="go" onclick="search();"/></center>
  	<input type="hidden" id="totalRecord" value="${resPage.totalRecord }"/>
  	<input type="hidden" id="totalPage" value="${resPage.totalPage }"/>
   <table class="table">
    	<tr align="center">
    		<th>资源名</th>
    		<th>描述</th>
    		<th>上传时间</th>
    		<th>预览</th>
    		<th>下载</th>
    	</tr>
    	<c:forEach items="${list }" var="p">
    	<tr align="center">
    		<td>${p.resource_name }</td>
    		<td>${p.resource_desc}</td>
    		<td>${p.resource_time }</td>
    		<td><a href="">预览</a></td>
    		<td><a href="train_resource!download.action?downName=${p.resource_name }">下载</a></td>
    	</tr>
    	</c:forEach>
    	<tr>
   			 <td colspan="5" align="center">
    			总共${resPage.totalRecord}条记录，
    			每页显示<input type="text" id="pagesize" size="1" value="${resPage.onePageNum}" onblur="forward1(this)"/>条记录，
    			共${resPage.totalPage } 页
    			
    			<!-- <a href="resPage!listRes?resPage.currentPage=${resPage.currentPage-1 }&resPage.onePageNum=${resPage.onePageNum}">上一页</a> -->
    			<!-- <a href="resPage!listRes?resPage.currentPage=${resPage.currentPage+1 }&resPage.onePageNum=${resPage.onePageNum}">下一页</a> -->
    			<c:choose>
    				<c:when test="${resPage.currentPage==1}">
    					首页
    					上一页
    				</c:when>
    				<c:otherwise>
    					<a href="resPage!listRes?resPage.currentPage=1&resPage.onePageNum=${resPage.onePageNum}&resource_type=2">首页</a>
    					<a href="resPage!listRes?resPage.currentPage=${resPage.currentPage-1 }&resPage.onePageNum=${resPage.onePageNum}&resource_type=2">上一页</a>
    				</c:otherwise>
    			</c:choose>
    			<c:choose>
    				<c:when test="${resPage.currentPage==resPage.totalPage}">
    					下一页
    					尾页
    				</c:when>
    				<c:otherwise>
    					<a href="resPage!listRes?resPage.currentPage=${resPage.currentPage+1 }&resPage.onePageNum=${resPage.onePageNum}&resource_type=2">下一页</a>
    					<a href="resPage!listRes?resPage.currentPage=${resPage.totalPage }&resPage.onePageNum=${resPage.onePageNum}&resource_type=2">尾页</a>
    				</c:otherwise>
    			</c:choose>
    			当前页数 <input type="text" size="1" value="${resPage.currentPage }" onKeyUP="forward2(this)"/>
    			
   			 </td>
   		 </tr>
    </table>
  </body>
</html>
