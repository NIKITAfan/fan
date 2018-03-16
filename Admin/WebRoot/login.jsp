<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>项目帮管理员系统</title>
     <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
    <script src="js/modernizr.js"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		#h{
			text-align:center;
			line-height:100px; 
			font-size:24px;			
			font-family:"Microsoft YaHei UI Light";
			height:70px;
			width:100%;
		}
	</style>

  </head>
  
  <body>
  	<%
  		Object message=request.getAttribute("message");
  		if(message!=null&&!"".equals(message)){
  	 %>
  	 	<script type="text/javascript">
  	 		alert("<%=message%>");
  	 	</script>
  	 <%
  	 	}
  	  %>
	<div class="login">
		<p id="h">项目帮管理员系统</p>
		<div >
			<div class="input">
				<div class="log">
					<form action="http://112.74.176.171:8080/Admin/Servlet/LoginServlet" method="post">
					<div class="name">
						<input type="text" name="username" class="name" id="value_1" 
						maxlength="11"
						placeholder="用户名" tabindex="1">
					</div>	
					<div class="pwd">
						<input type="password" class="name" id="value_2" 
						placeholder="密码" name="password" tabindex="2" maxlength="15">
						<input type="submit" class="btn" tabindex="3" value="登录" >
						<div class="check"></div>
					</div>
					<div class="tip"></div>
					</form>
				</div>
			</div>
		</div>

	</div>
		<script type="text/javascript" src="js/jQuery.js"></script>
	<!--[if IE 6]>
	<script src="js/DD_belatedPNG.js" type="text/javascript"></script>
	<script>DD_belatedPNG.fix('.png')</script>
	<![endif]-->
  </body>
</html>
