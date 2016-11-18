<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%> 
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
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<title>Salesupport</title>
	
	<link rel="stylesheet" href="css/layout.css" type="text/css" media="screen" />
	<!--[if lt IE 9]>
	<link rel="stylesheet" href="css/ie.css" type="text/css" media="screen" />
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	<script src="js/jquery-1.5.2.min.js" type="text/javascript"></script>
	<script src="js/hideshow.js" type="text/javascript"></script>
	<script src="js/jquery.tablesorter.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/jquery.equalHeight.js"></script>
	<script type="text/javascript">
	$(document).ready(function() 
    	{ 
      	  $(".tablesorter").tablesorter(); 
   	 } 
	);
	$(document).ready(function() {

	//When page loads...
	$(".tab_content").hide(); //Hide all content
	$("ul.tabs li:first").addClass("active").show(); //Activate first tab
	$(".tab_content:first").show(); //Show first tab content

	//On Click Event
	$("ul.tabs li").click(function() {

		$("ul.tabs li").removeClass("active"); //Remove any "active" class
		$(this).addClass("active"); //Add "active" class to selected tab
		$(".tab_content").hide(); //Hide all tab content

		var activeTab = $(this).find("a").attr("href"); //Find the href attribute value to identify the active tab + content
		$(activeTab).fadeIn(); //Fade in the active ID content
		return false;
	});

});
    </script>
    <script type="text/javascript">
    $(function(){
        $('.column').equalHeight();
    });
	</script>
	
</head>


<body>

	<header id="header">
		<hgroup>
			<h1 class="site_title"><a href="index.html">设备维修后台管理</a></h1>
			<h2 class="section_title">Dashboard</h2><div class="btn_view_site"><a href="login.jsp">退出</a></div>
		</hgroup>
	</header> <!-- end of header bar -->
	
	<section id="secondary_bar">
		<div class="user">
			<p>刘路辉 </p>
			<!-- <a class="logout_user" href="#" title="Logout">Logout</a> -->
		</div>
		<div class="breadcrumbs_container">
			<article class="breadcrumbs"><a href="index.html">后台管理 Admin</a> <div class="breadcrumb_divider"></div> <a class="current">Dashboard</a></article>
		</div>
	</section><!-- end of secondary bar -->
	
	<aside id="sidebar" class="column">
		<form class="quick_search">
			<input type="text" value="Quick Search" onfocus="if(!this._haschanged){this.value=''};this._haschanged=true;">
		</form>
		<hr/>
		<h3>系统管理</h3>
		<ul class="toggle">
			<li class="icn_categories"><a href="#">维修订单管理</a></li>
			<li class="icn_settings"><a href="#">系统调度</a></li>
			<li class="icn_photo"><a href="#">订单状态查看</a></li>
			<li class="icn_tags"><a href="#">过程监控</a></li>
		</ul>		
		
		<h3>维修人员管理</h3>
		<ul class="toggle">
			<li class="icn_add_user"><a href="#">添加维修人员</a></li>
			<li class="icn_view_users"><a href="#">查看维修人员</a></li>
			<li class="icn_profile"><a href="#">维修人员历史贡献</a></li>
		</ul>

		<h3>物品</h3>
		<ul class="toggle">
			<li class="icn_add_user"><a href="Resource!queryAll.action">查询物品信息</a></li>
			<li class="icn_view_users"><a href="ShenQing_add.jsp">填写申请信息</a></li>
			<li class="icn_profile"><a href="ShenQing_query.jsp">查询申请信息</a></li>
		</ul>

		<footer>
			<hr />
			<p><strong>Copyright &copy; 2016 后台管理 Admin</strong></p>
			<p>Theme by TechDream</p>
		</footer>
	</aside><!-- end of sidebar -->
	
	<section id="main" class="column">
		
		<h4 class="alert_warning">加快进度吧！</h4>
		
		<article class="module width_full">
		<table align="center" border="0" width="60%">
		<tr>
			<td>编号</td>
			<td>时间</td>
			<td>维修员id</td>
			<td>用途</td>
		</tr>
		<s:iterator value="list">
			<tr>
				<td><s:property value="id" /></td>
				<td><s:property value="time" /></td>
				<td><s:property value="manId" /></td>
				<td><s:property value="addr" /></td>
			</tr>
		</s:iterator>
	</table>
	<br/>
	<a href="ShenQing_query.jsp">back</a>
		</article><!-- end of stats article -->

		
		<div class="clear"></div>
		
		
		<div class="spacer"></div>
	</section>


</body>
</html>