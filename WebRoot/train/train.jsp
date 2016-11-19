<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'train.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/train/js/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="css/train/bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/train/css/muke.css">
<link rel="stylesheet" type="text/css" href="css/train/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" type="text/css" href="css/train/css/style.css">
<script type="text/javascript" src="js/train/js/jquery.SuperSlide.2.1.1.js"></script>
  </head>
  
  <body class="backg_huibai">
  <!-- 顶部 -->
<div class="width100 float_l height490 img_backg1">
	<div class="width100 float_l height80 line_hei80">
        <!-- 顶部左边 -->
        <div class="float_l">
            
            <div class="float_l" style="margin-left:100px;">
                <ul class="ul_li fon_siz16">
                    <li><a href="index.jsp">主页</a></li>
                    <li><a href="resPage!listRes?resource_type=1&searchContent= ">视频</a></li>
                    <li><a href="resPage!listRes?resource_type=2&searchContent= ">文档</a></li>
                    <li><a>笔记</a></li>
                    <li><a>提问</a></li>
                    <li><a>考核</a></li>
                </ul>
            </div>
        </div>
        
        <!-- 顶部右边 -->
        <div class="float_r">
        </div>
	</div>
</div>

<!-- 轮播图 -->
<div class="width100 float_l margin_t-405 margin_b40" >
	<div class="width_1200 margin_auto">
    	<div class="width100 float_l height460 posi_relative"  >
    	
        	<div class="width80 float_l" style="margin-left:250px;" >
               <div class="focusBox" ">
                   <!--  <ul class="pic">
                        <li><a><img src="images/train/img/uiz21.jpg" /></a></li>
                        <li><a><img src="images/train/img/uiz20.jpg" /></a></li>
                    </ul> 
                  
                    <a class="prev" href="javascript:void(0)"></a>
                    <a class="next" href="javascript:void(0)"></a>
                    <ul class="hd">
                        <li></li>
                        <li></li>
                    </ul> -->
                     <!-- <embed src="C:/Users/wto/Desktop/zhi/video/a.mp4" style="height:450px;width:100%;" loop="true" autostart="true"> -->
                     <video id="v1"   controls width="100%" height="100%">
                <source src="train/a.mp4"/>
            </video>
                </div>
                
               
            </div>
            
            <div class="width_224 float_l height460 posi_absolute backg_jqian padding_t5 bianshou">
            	<div class="width100 float_l tab_qiehuan ">
                	<div class="width100 float_l text_c height64 line_hei64 color_white bianhuabeijing backg_jqian padding_lr20">
                        <div class="width100 float_l text_l height64 line_hei64 color_white border_b_baise fon_siz16">
                            <span>维修技能</span>
                            <span class="float_r">></span>
                        </div>
                    </div>
                    <div class="width_700 float_l lunbofenlei dis_none img_backg15">
                    	<div class="width100 float_l padding40">
                        	<div class="width100 float_l margin_b40">
                            	<span class="width100 color_shenred fon_siz16 float_l margin_b20">分类目录</span>
                                <ul class="width100 ul_lis float_l">
                                	<li><a>烹调设备</a></li>
                                    <li>/</li>
                                    <li><a>食品加工机械</a></li>
                                    <li>/</li>
                                    <li><a>水处理设备</a></li>
                                    <li>/</li>
                                    <li><a>用具</a></li>
                                </ul>
                            </div>
                            
                            <div class="width100 float_l margin_b40">
                            	<span class="width100 color_shenred fon_siz16 float_l margin_b20">推荐</span>
                                <ul class="width100 ul_lis float_l">
                                	<li class="width100 float_l margin_b15"><a>课程 | 烹调设备维修入门基础</a></li>
									<li class="width100 float_l margin_b15"><a>课程 | 餐具清洁与保养</a></li>
									
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="width100 float_l tab_qiehuan">
                	<div class="width100 float_l text_c height64 line_hei64 color_white bianhuabeijing backg_jqian padding_lr20">
                        <div class="width100 float_l text_l height64 line_hei64 color_white border_b_baise fon_siz16">
                            <span>产品基础</span>
                            <span class="float_r">></span>
                        </div>
                    </div>
                    <div class="width_700 float_l lunbofenlei dis_none img_backg16">
                    	<div class="width100 float_l padding40">
                        	<div class="width100 float_l margin_b40">
                            	<span class="width100 color_shenred fon_siz16 float_l margin_b20">分类目录</span>
                                <ul class="width100 ul_lis float_l">
                                	<li><a>基础设施</a></li>
                                    <li>/</li>
                                    <li><a>定制服务</a></li>
                                    <li>/</li>
                                    <li><a>解决方案</a></li>
                                   
                                </ul>
                            </div>
                            
                            <div class="width100 float_l margin_b40">
                            	<span class="width100 color_shenred fon_siz16 float_l margin_b20">推荐</span>
                                <ul class="width100 ul_lis float_l">
                                	<li class="width100 float_l margin_b15"><a>课程 | 解决方案设计入门</a></li>
									
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="width100 float_l tab_qiehuan">
                	<div class="width100 float_l text_c height64 line_hei64 color_white bianhuabeijing backg_jqian padding_lr20">
                        <div class="width100 float_l text_l height64 line_hei64 color_white border_b_baise fon_siz16">
                            <span>制度规定</span>
                            <span class="float_r">></span>
                        </div>
                    </div>
                    <div class="width_700 float_l lunbofenlei dis_none img_backg17">
                    	<div class="width100 float_l padding40">
                        	<div class="width100 float_l margin_b40">
                            	<span class="width100 color_shenred fon_siz16 float_l margin_b20">分类目录</span>
                                <ul class="width100 ul_lis float_l">
                                	<li><a> 规章</a></li>
                                    <li>/</li>
                                    <li><a>条例</a></li>
                                    <li>/</li>
                                    <li><a>守则</a></li>
                                    <li>/</li>
                                    <li><a>规程</a></li>
                                    <li>/</li>
                                    <li><a>程序</a></li>
                                    <li>/</li>
                                    <li><a>标准</a></li>
                                </ul>
                            </div>
                            
                            <div class="width100 float_l margin_b40">
                            	<span class="width100 color_shenred fon_siz16 float_l margin_b20">推荐</span>
                                <ul class="width100 ul_lis float_l">
                                	<li class="width100 float_l margin_b15"><a>文档 | 上门服务条例</a></li>
									<li class="width100 float_l margin_b15"><a>文档 | 公司制度</a></li>
									<li class="width100 float_l margin_b15"><a>文档 | 客户关系</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="width100 float_l tab_qiehuan">
                	<div class="width100 float_l text_c height64 line_hei64 color_white bianhuabeijing backg_jqian padding_lr20">
                        <div class="width100 float_l text_l height64 line_hei64 color_white border_b_baise fon_siz16">
                            <span>物品申请</span>
                            <span class="float_r">></span>
                        </div>
                    </div>
                    <div class="width_700 float_l lunbofenlei dis_none img_backg18">
                    	<div class="width100 float_l padding40">
                        	<div class="width100 float_l margin_b40">
                            	<span class="width100 color_shenred fon_siz16 float_l margin_b20">分类目录</span>
                                <ul class="width100 ul_lis float_l">
                                	<li><a>物品申请</a></li>
                                    
                                </ul>
                            </div>
                            
                            <div class="width100 float_l margin_b40">
                            	<span class="width100 color_shenred fon_siz16 float_l margin_b20">推荐</span>
                                <ul class="width100 ul_lis float_l">
                                	<li class="width100 float_l margin_b15"><a>文档 | 物品申请流程</a></li>
									<li class="width100 float_l margin_b15"><a>文档 | 换下的物品处理方案</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="width100 float_l tab_qiehuan">
                	<div class="width100 float_l text_c height64 line_hei64 color_white bianhuabeijing backg_jqian padding_lr20">
                        <div class="width100 float_l text_l height64 line_hei64 color_white border_b_baise fon_siz16">
                            <span>考核&评级</span>
                            <span class=" float_r">></span>
                        </div>
                    </div>
                    <div class="width_700 float_l lunbofenlei dis_none img_backg16">
                    	<div class="width100 float_l padding40">
                        	<div class="width100 float_l margin_b40">
                            	<span class="width100 color_shenred fon_siz16 float_l margin_b20">分类目录</span>
                                <ul class="width100 ul_lis float_l">
                                	<li><a>考核</a></li>
                                    <li>/</li>
                                    <li><a>评级</a></li>
                         
                                </ul>
                            </div>
                            
                            <div class="width100 float_l margin_b40">
                            	<span class="width100 color_shenred fon_siz16 float_l margin_b20">推荐</span>
                                <ul class="width100 ul_lis float_l">
                                	<li class="width100 float_l margin_b15"><a>文档 | 考核制度</a></li>
									<li class="width100 float_l margin_b15"><a>文档 | 评级制度</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="width100 float_l tab_qiehuan">
                	<div class="width100 float_l text_c height64 line_hei64 color_white bianhuabeijing backg_jqian padding_lr20">
                        <div class="width100 float_l text_l height64 line_hei64 color_white border_b_baise fon_siz16">
                            <span>学习积分</span>
                            <span class="float_r">></span>
                        </div>
                    </div>
                    <div class="width_700 float_l lunbofenlei dis_none img_backg15">
                    	<div class="width100 float_l padding40">
                        	<div class="width100 float_l margin_b40">
                            	<span class="width100 color_shenred fon_siz16 float_l margin_b20">分类目录</span>
                                <ul class="width100 ul_lis float_l">
                                	<li><a>学习积分</a></li>
                                </ul>
                            </div>
                            
                            <div class="width100 float_l margin_b40">
                            	<span class="width100 color_shenred fon_siz16 float_l margin_b20">推荐</span>
                                <ul class="width100 ul_lis float_l">
                                	<li class="width100 float_l margin_b15"><a>文档 | 积分制度</a></li>
									
									
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="width100 float_l tab_qiehuan ">
                	<div class="width100 float_l text_c height64 line_hei64 color_white bianhuabeijing backg_jqian padding_lr20">
                        <div class="width100 float_l text_l height64 line_hei64 color_white border_b_baise fon_siz16">
                            <span>导师信息</span>
                            <span class="float_r">></span>
                        </div>
                    </div>
                    <div class="width_700 float_l lunbofenlei dis_none img_backg17">
                    	<div class="width100 float_l padding40">
                        	<div class="width100 float_l margin_b40">
                            	<span class="width100 color_shenred fon_siz16 float_l margin_b20">分类目录</span>
                                <ul class="width100 ul_lis float_l">
                                	<li><a>导师信息</a></li>
                                    
                                </ul>
                            </div>
                            
                            <div class="width100 float_l margin_b40">
                            	<span class="width100 color_shenred fon_siz16 float_l margin_b20">推荐</span>
                                <ul class="width100 ul_lis float_l">
                                	<li class="width100 float_l margin_b15"><a>文档 | 导师简介</a></li>
									<li class="width100 float_l margin_b15"><a>文档 | 导师评价</a></li>
									<li class="width100 float_l margin_b15"><a>文档 | 导师交流</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>   
            </div>
            
        </div>
    </div>
</div>
<script>
	$('.tab_qiehuan').hover(function(){
         $(this).children(".bianhuabeijing").css("background-color","#8a8f93").next().css("display","block")
	},function(){
    	 $(this).children(".bianhuabeijing").css("background-color","#a9aaae").next().css("display","none")
	});
</script>

<script type="text/javascript">
	jQuery(".focusBox").slide({ mainCell:".pic",effect:"left", autoPlay:true, delayTime:500});
</script>

<!-- 实战推荐 -->


  </body>
</html>
