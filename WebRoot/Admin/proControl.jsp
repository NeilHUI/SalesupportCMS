<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html lang="ch">

<head>
	<meta charset="utf-8"/>
	<title>过程监控</title>
	
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
			<h1 class="site_title"><a href="dashboard.jsp">设备维修后台管理</a></h1>
			<h2 class="section_title"></h2><div class="btn_view_site"><a href="login.jsp">退出</a></div>
		</hgroup>
	</header> <!-- end of header bar -->
	
	<section id="secondary_bar">
		<div class="user">
			<p><s:property value="#session.USER_NAME"/> </p>
			<!-- <a class="logout_user" href="#" title="Logout">Logout</a> -->
		</div>
		<div class="breadcrumbs_container">
			<article class="breadcrumbs"><a href="dashboard.jsp">系统管理</a> <div class="breadcrumb_divider"></div> <a class="current">过程监控</a></article>
		</div>
	</section><!-- end of secondary bar -->
	
	<aside id="sidebar" class="column">
		<form class="quick_search">
			<input type="text" value="Quick Search" onfocus="if(!this._haschanged){this.value=''};this._haschanged=true;">
		</form>
		<hr/>
		<h3>系统管理</h3>
		<ul class="toggle">
			<li class="icn_categories"><a href="admin!queryOrder.action">维修订单</a></li>
			<li class="icn_settings"><a href="system!querySystemPlan.action">系统调度</a></li>
			<li class="icn_tags"><a href="monitor!querys.action">过程监控</a></li>
		</ul>		
		
		<h3>维修人员管理</h3>
		<ul class="toggle">
			
			<li class="icn_view_users"><a href="personnel!queryAllPerson.action">查看维修人员</a></li>
			<li class="icn_add_user"><a href="addPerson.jsp">添加维修人员</a></li>
			<li class="icn_profile"><a href="#">维修人员历史贡献</a></li>
		</ul>

		<footer>
			<hr />
			<p><strong>Copyright &copy; 2016 后台管理 Admin</strong></p>
			<p>Theme by TechDream</p>
		</footer>
	</aside><!-- end of sidebar -->
	
	<section id="main" class="column">
		
		<h4 class="alert_warning">加快进度吧！</h4>
		
		<article class="module width_3_quarter">
		<header><h3 class="tabs_involved">维修订单列表</h3></header>

		<div class="tab_container">
			<div id="tab1" class="tab_content">
			<table class="tablesorter" cellspacing="0"> 
			<thead> 
				<tr>  
					<th></th> 					
    				<th>维修设备SN</th> 
    				<th>维修描述</th> 
    				<th>当前状态</th> 
    				<th>查看历史</th> 
				</tr> 
			</thead> 
			<tbody> 
				<s:iterator value="listrepair">
				<tr> 
   					<td></td> 
    				<td><s:property value="Repair_SN" /></td> 
    				<td><s:property value="Repair_Des" /></td> 
    				<td><s:property value="Repair_State" /></td> 
    				<td><a href="monitor!findhistory.action?myrepair.Repair_ID=<s:property value="Repair_ID" />"><input type="image" src="images/findd.png" title="查看"></a></td> 
				</tr> 
				</s:iterator>
			</tbody> 
			</table>
			</div><!-- end of #tab1 -->
		</div><!-- end of .tab_container -->
		
		</article><!-- end of content manager article -->
		<article class="module width_quarter">
			<header><h3>维修历史</h3></header>
			<div class="message_list">
				<div class="module_content">
				<s:iterator value="listRecord">
					<div class="message"><p> <s:property value="deviceSN" /> -- <s:property value="currentname" /> </p>
					<p><strong><s:property value="currenttime" /></strong></p></div>
				</s:iterator>
					<%-- <div class="message"><p>维修订单审核通过</p>
					<p><strong>2016-11-3</strong></p></div>
					<div class="message"><p>维修正在处理中······</p>
					<p><strong>2016-11-4</strong></p></div>
					<div class="message"><p>维修已完成</p>
					<p><strong>2016-11-5</strong></p></div>
					<div class="message"><p>用户已评论</p>
					<p><strong>2016-11-6</strong></p></div> --%>
				</div>
			</div>
			<footer>
				<form class="post_message">
					<input type="text" value="Message" onfocus="if(!this._haschanged){this.value=''};this._haschanged=true;">
					<input type="submit" class="btn_post_message" value=""/>
				</form>
			</footer>

		</article><!-- end of stats article -->
		
		<div class="clear"></div>
		<div class="spacer"></div>
	</section>


</body>

</html>