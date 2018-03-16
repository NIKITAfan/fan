<%@ page language="java" import="java.util.*,java.sql.*" contentType="text/html; charset=utf-8"%>
<%@ page import="DAO.View_ProjectDAO" %>
<%@ page import="Model.View_Project"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>项目详情</title>
    
    <script>
    	function check(){
    		if(!confirm("是否确定")){
    			window.event.preventDefault();
    		}
    	}
    </script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
		table {
			text-align: center;
			border-color: #000;
			table-layout:fixed;
			word-break:break-all; word-wrap:break-all;
		}
		
		#div1 {
			width: 100%;
			text-align:center;
			margin-top:30px
		}
		
		#h{
			text-align:center;
			line-height:100px;
			background:#039;
			font-size:24px;
			color:white;
			font-family:"Microsoft YaHei UI Light";
			height:100px;
			width:100%;
		}
		#div2{
			text-align:center;
		}
		
		</style>
  	<style type="text/css">  
		.breadcrumbs li:first-child a:before {  
		    display: none;  
		}
        .breadcrumbs li {  
            float: left;  
            position: relative;  
            list-style-type: none;  
        }  
        .breadcrumbs a {  
            position: relative;  
            display: block;  
            height: 40px;  
            line-height: 40px;  
            text-decoration: none;  
            text-align: center;  
            padding: 0 20px 0 30px;  
            background-color: #3498db;  
            margin-right: 10px;  
        }  
        .breadcrumbs a:after {  
            content: "";  
            position: absolute;  
            border-top: 20px solid transparent;  
            border-bottom: 20px solid transparent;  
            border-left: 20px solid #3498db;  
            right: -20px;  
            top: 0;  
            z-index: 1;  
        }  
        .breadcrumbs a:before {  
            content: "";  
            position: absolute;  
            border-top: 20px solid transparent;  
            border-bottom: 20px solid transparent;  
            border-left: 20px solid #FFF;  
            left: 0;  
            top: 0;  
        }  
    </style>
  </head>
  
  <body>
	<div id="h">项目帮管理员系统</div>
	<div id="div2">
		<br> 
		<table align="center">
			<tr>
				<td>
					<form action="http://112.74.176.171:8080/Admin/Servlet/ButtonServlet" method="post">	    
					  <a href=""> <input id="action" name="mbutton" type="submit" value="查看被举报项目" style="height:60px;width:180px"></a> 
					</form>				
				</td>
		
				<td>
			        <form action="http://112.74.176.171:8080/Admin/Servlet/ButtonServlet" method="post">
				   	  <a href=""><input id="action" name="mbutton" type="submit" value="查看被举报用户" style="height:60px;width:180px"></a> 
					</form>								
				</td>
				
				<td>
					<form action="http://112.74.176.171:8080/Admin/Servlet/ListServlet" method="post">	
					  <a href=""><input id="action"  name="mbutton" type="submit" value="查看全部学生" style="height:60px;width:180px"></a> 
					</form>
				</td>
				
				<td>
					<form action="http://112.74.176.171:8080/Admin/Servlet/ButtonServlet" method="post">	
					  <a href=""><input id="action"  name="mbutton" type="submit" value="查看数据统计信息" style="height:60px;width:180px"></a>
					</form>				
				</td>
			</tr>
		</table>
	</div>
	<br>
	<ul class="breadcrumbs">
		<li><a href="Main.jsp">查看被举报项目</a></li>
		<li><a href="javascript:location.reload();">被举报项目详情</a></li>
	</ul>
	<br><br><br>
	<div align="center">
				<% 
					request.setCharacterEncoding("utf-8");  
					View_ProjectDAO view_fp = new View_ProjectDAO(request.getParameter("pid")); 
					ArrayList<View_Project> list=null;
					list = view_fp.getView_Projects();				   			   
		            View_Project view = list.get(0);
	 			%>					
	 			<table aligen="centre" border = "1px" bordercolor="#0000FF" width="400px" height="500" cellpadding="3px" cellspacing="0">
					<caption><font size="+2">被举报项目详细信息</font></caption>	 			
	 				<tr>
	 					<td  width="100">项目编号 </td>
	 					<td><%=view.getPid() %></td>
	 				</tr>
	 				<tr>
	 					<td>项目名称 </td>
	 					<td><%=view.getPname()%></td>
	 				</tr>	 	
	 				<tr>
	 					<td>发布人员 </td>
	 					<td><%=view.getPtname()%></td>
	 				</tr>		 				
	 				
	 				<tr>
	 					<td>招收数量 </td>
	 					<td><%=view.getPnum() %></td>
	 				</tr>	
	 				<tr>
	 					<td>技术要求 </td>
	 					<%if (view.getPrequire()!="") {%>
	 					<td><%=view.getPrequire() %></td>
	 					<%} else { %>
	 					<td>无</td>
	 					<%} %>
	 				</tr>	
	 				<tr>
	 					<td>项目简介 </td>
	 					<td><%=view.getPintroduction() %></td>
	 				</tr>		
	 				<tr>
	 					<td>其它要求 </td>
	 					<%if (view.getPelse()!="") {%>
	 					<td><%=view.getPelse() %></td>
	 					<%} else { %>
	 					<td>无</td>
	 					<%} %>
	 					
	 				</tr>	 		
	 				<tr>
	 					<td>项目状态 </td>
	 					<td><%=view.getPcondition() %></td>
	 				</tr>						 				 				 				 						 							
	 			</table>
	</div>	
	<br>
	<div align="center">
				<table align="centre"  width="400px" height="50" cellpadding="0" cellspacing="0">
					<tr>
						<td>	
							<form action="http://112.74.176.171:8080/Admin/Servlet/FalseProjectServlet?pid=<%=list.get(0).getPid() %>" method="post">	
								<a href="" onClick="check();"><input id="action"  name="del" type="submit" value="查封项目" style="width:100px;height:50px;"></a> 
							</form>											
						</td>
						<td>	
							<form action="http://112.74.176.171:8080/Admin/Servlet/FalseProjectServlet?pid=<%=list.get(0).getPid() %>" method="post">	
								<a href="" onClick="check();"><input id="action"  name="del" type="submit" value="忽略举报" style="width:100px;height:50px;"></a> 
							</form>	
						</td>
					</tr>									
				</table>
	</div>
  </body>
</html>
