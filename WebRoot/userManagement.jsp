<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-cn">
  <head>
    <base href="<%=basePath%>">
    
    
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>SaleSupport</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]-->
    <style >
      body{
        /*padding-top: 50px;*/
        padding-bottom: 50px;
      }
      #navbar-d{
        margin-bottom: 50px;

        
      }
      .navbar-brand {
        font-size: 30px;

      }
      /* 背景 */
      .carousel{
        height: 500px;
        background-color: #000;
        margin-bottom: 60px;/*底部间距*/
        margin-top: 0px;
      }
      /* 内部主题 */
      .carousel .item{
        height: 500px;
        background-color: #000;
      }
      /* 图片 */
      .carousel img{
        width: 100%;
      }
      /* 导航内文字 */
      .carousel-caption p{
        margin-bottom: 20px;
        font-size: 20px;
        line-height: 1.8;
      }
      #summary-container .col-sm-3 .col-md-4{
        text-align: center;
      }

       .div_font{
        margin-left: 40px;
        margin-right: 40px;
        margin-bottom: 0px;

        color:#2a6496;
        
      }

      hr.divider_1{
        margin: 0px;
        margin-left: 40px;
        margin-right: 40px;
      }
      hr.divider{
        margin: 40px;
      }
      .feature{
        padding: 30px 0;
      }
      .feature-heading{
        font-size: 50px;
        color:#2a6496;
        margin-top: 120px: 
      }
      .feature-heading .text-muted{
        font-size: 28px;
        color: #999;
      }
      #ratio_pos{
        margin-left: 40px;
        margin-right: 40px;
      }
      .input_text{
        width: 450px;
      }
      .span_1{
        width: 120px;
      }
      .submit_user{
        width: 450px;
      }
   #code  
          {  
             background:#ffffff;
             font-family:Arial;
             font-style:italic;
             font-size:10px;
             border:0;
             color:#2a6496;
             padding:2px 3px;
             letter-spacing:3px;
             font-weight:bolder;
             float:left;
             cursor:pointer;
             width:60px;
             height:30px;
             line-height:30px;
             text-align:center;
             vertical-align:middle;
          }  
    </style>
<script type="text/javascript">  
       var code ; //在全局定义验证码   
      //产生验证码  
       window.onload = function createCode(){  
           code = "";   
           var codeLength = 4;//验证码的长度  
           var checkCode = document.getElementById("code");   
           var random = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R',  
           'S','T','U','V','W','X','Y','Z');//随机数  
           for(var i = 0; i < codeLength; i++) {//循环操作  
              var index = Math.floor(Math.random()*36);//取得随机数的索引（0~35）  
              code += random[index];//根据索引取得随机数加到code上  
          }  

          checkCode.value = code;//把code值赋给验证码 

       }  
//校验验证码  
        function validate(){  

            var inputCode = document.getElementById("val_inp").value.toUpperCase(); //取得输入的验证码并转化为大写        
            if(inputCode.length <= 0) { //若输入的验证码长度为0  
                alert("请输入验证码！"); //则弹出请输入验证码  
                return false;
            }         
            else if(inputCode != code ) { //若输入的验证码与产生的验证码不一致时  
                alert("验证码输入错误！@_@"); //则弹出验证码输入错误  
                document.getElementById("val_inp").value = "";//清空文本框
                return false;
            }         
            else { //输入正确时  
                return true;
            }             
        }  

</script>  
  </head>
  
  <body>
<!--     <a  href="student!queryAll.action">查询学生</a> -->
    <!-- 导航 -->
  <nav class="navbar navbar-default navbar-static-top  " role="navigation" id="navbar-d"><!-- 加上navbar-fixed-top置顶 navbar-inverse黑白反转 -->
  <div class="container"><!-- container-fluid靠左 -->
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#demo-navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#"><p style="color: #4a6a93;"> <b>S</b>aleSupport</p></a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="demo-navbar">
      <ul class="nav navbar-nav">
        <li ><a href="#" data-toggle="modal" data-target="#about" >企业介绍</a></li>
        <li ><a href="training.jsp">培训课堂</a></li>
        <li class="active"><a href="userManagement.jsp">维修管理</a></li>
        <li><a href="http://www.jingdong.com">官方店铺</a></li>
        <!-- 预留dropdown -->
       <%--  <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
              <li><a href="#tab-chrome">Chrome</a></li>
              <li><a href="#tab-firefox">Firefox</a></li>
              <li><a href="#tab-safari">Safari</a></li>
              <li><a href="#tab-opera">Opera</a></li>
              <li><a href="#tab-ie">IE</a></li>
            <li class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li> --%>
      </ul>
  <!--     预留搜索 -->
     <!--  <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form> -->
      <ul class="nav navbar-nav navbar-right">
         <li><p class="navbar-text"><s:if test="null==#session.sess_user"><a href="#" data-toggle="modal" data-target="#login">登录</a>&nbsp;|&nbsp;<a href="register.jsp" class="navbar-link">免费注册</a></s:if><s:else>欢迎：<a href="admin!list_user.action" class="navbar-link"><s:property value="#session.sess_user"/></a>&nbsp;|&nbsp;<a href="admin!logout.action" class="navbar-link">退出</a></s:else></p></li>

        
       
        <!-- <li><a href="#" data-toggle="modal" data-target="#about">关于</a></li> -->
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>



<!-- 栅格 -->
<div class="container" id="summary-container">

  
<div class="div_font"><span style="font-size: 30px">个人中心</span> Personal Center</div> 
<hr class="divider_1">

<!-- 通用位置 -->
<div  id="ratio_pos" style="text-align: center; margin-bottom: 260px; margin-top: 60px;">
  

 <div class="row" >
        <div class="col-xs-6 col-sm-3">
            <a href="repair_tj.jsp">
               <img class="img-circle" src="images/shouhoufuwu.png" alt="chrome">

               <h5>申请售后服务</h5>

             </a>
           
        </div>
         <div class="col-xs-6 col-sm-3">
            <a href="repair_table.jsp">
               <img class="img-circle" src="images/dingdan.png" alt="chrome">

               <h5>维修单查询</h5>

             </a>
           
        </div>
        <div class="col-xs-6 col-sm-3">
           <a href="account.jsp">
               <img class="img-circle" src="images/account.png" alt="chrome">

               <h5>账户资料</h5>

             </a>
        </div>
        <div class="col-xs-6 col-sm-3">
            <a href="chaxun.jsp">
               <img class="img-circle" src="images/chaxun.png" alt="chrome">

               <h5>查询真伪</h5>

             </a>
        </div>
    </div>

</div>




<hr class="divider">
<footer>
  <p class="pull-right"><a href="#top">回到顶部</a></p>
  <p>Copyright © 2016：SaleSupport</p>
</footer> 


<!-- login -->


<form action="admin!login.action" method="post" onSubmit="return validate();" >
<div class="modal fade" id="login">
  <div class="modal-dialog">
    <div class="modal-content">

      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title">登录</h4>
      </div>
      <div class="modal-body">
 

        <div class="input-group input-group-lg">
          <span class="input-group-addon" style="width: 60px;"><span class="glyphicon glyphicon-user"></span> 用户名</span>
          <input type="text" class="form-control" name="a.admin_name" placeholder="Username">
        </div>
        <br/>
        <div class="input-group input-group-lg">
          <span class="input-group-addon" style="width: 60px;"><span class="glyphicon glyphicon-lock"></span> 密&nbsp;&nbsp;&nbsp;&nbsp;码</span>
          <input type="password" class="form-control" name="a.admin_pass" placeholder="Password">
        </div>


<br/>

<div class="row">
  <div class="col-lg-6">
    <div class="input-group">
     <input type="text" class="form-control" style="width: 280px;" id="val_inp" placeholder="验证码">
    </div><!-- /input-group -->
  </div><!-- /.col-lg-6 -->
  <div class="col-lg-6">
    <div class="input-group">
      <input type = "button" style="width: 60px; height: 30px;" id="code" />
    </div><!-- /input-group -->
  </div><!-- /.col-lg-6 -->
</div><!-- /.row -->


     
 <!-- <div>  
            <input type = "text" id = "input"/>  
            <input type = "button" id="code" onclick="createCode()"/>  
            <input type = "button" value = "验证" onclick = "validate()"/>  
        </div>   -->


      </div>
      <div class="modal-footer">
        <button type="resert" class="btn btn-default">重置</button>
        <button type="submit" class="btn btn-primary" >登录</button>
        
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</form>
<!-- 弹出框 -->
<div class="modal fade" id="about">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title">关于</h4>
      </div>
      <div class="modal-body">
        <p>公司主要生产商用厨房制冷设备及超市制冷设备。产品系列有厨房冰箱、卧式冷柜、陈列柜、展示柜、海鲜柜、豆制品保鲜柜、蛋糕柜、点菜柜、风幕柜、岛柜及小酒柜等；目前所生产的产品500L以下通过"3C"认证，500L以上通过全国工业生产许可认证。并且提供完善的售后服务。&hellip;



        </p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">了解了</button>
  
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</div>

<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script >
$(document).ready(function(){
    $("#demo-navbar .dropdown-menu a").click(function(){
        var href = $(this).attr("href");
        $("#tab-list a[href='"+href+"']").tab("show");

    });
  });
</script>
  </body>
</html>
