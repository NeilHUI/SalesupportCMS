<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html lang="ch">

<head>
    <meta charset="UTF-8">
    <!--IE Compatibility modes-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!--Mobile first-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Login Page</title>
    
    
    <meta name="author" content="">
    
    <meta name="msapplication-TileColor" content="#5bc0de" />
    <meta name="msapplication-TileImage" content="assets/img/metis-tile.png" />
    
    <!-- Bootstrap -->
    <link rel="stylesheet" href="assets/lib/bootstrap/css/bootstrap.css">
 
    <!-- Metis core stylesheet -->
    <link rel="stylesheet" href="assets/css/main.css">
    

    



    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body class="login">

      <div class="form-signin">
    <div class="text-center">
        <img src="assets/img/logo.png" alt="TechDream Logo">
    </div>
    <hr>
    <div class="tab-content">
        <div id="login" class="tab-pane active">
            <form action="admin!checkPass.action" method="post">
                <p class="text-muted text-center">
                                            请输入您的管理员账号和密码
                </p>
                <input type="text" name="ad.Admin_Name" placeholder="请输入管理员账号" class="form-control top">
                <input type="password" name="ad.Admin_Pass" placeholder="请输入密码" class="form-control bottom">
                <div class="checkbox">
		  <label>
		    <input type="checkbox"> 记住密码
		  </label>
		</div>
                <button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>
            </form>
        </div>
        
        
    </div>
    <hr>
    <div class="text-center">
        <ul class="list-inline">
            <li><a class="text-muted" href="#login" data-toggle="tab">如需帮助,请联系刘路辉-15036127325</a></li>           
        </ul>
    </div>
  </div>
    <!--jQuery -->
    <script src="assets/lib/jquery/jquery.js"></script>

    <!--Bootstrap -->
    <script src="assets/lib/bootstrap/js/bootstrap.js"></script>

</body>

</html>
