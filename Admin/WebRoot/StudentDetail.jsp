<%@ page language="java" import="java.util.*,java.sql.*" contentType="text/html; charset=utf-8"%>
<%@ page import="DAO.*" %>
<%@ page import="DBHelp.DBConnection" %>
<%@ page import="Model.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
		#div3{
			margin-top:50px;
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
		<li><a href="/Admin/Servlet/ListServlet">查看学生列表</a></li>
		<li><a href="javascript:location.reload();">学生详情</a></li>
	</ul>
	<br><br><br>
	<div class="container">
				<table class="table table-hover table-responsive table-striped table-bordered" align="center" border = "1px" bordercolor="#0000FF" width="900px" cellpadding="0" cellspacing="0">
               <thead>
					<caption><font size="+2">学生详细信息</font></caption>
						<tr>
							<td width="120px">用户账号</td>
							<td width="80px">用户名称</td>
							<td width="70px">信誉分</td>
							<td width="200px">邮箱</td>
							<td width="100px">学校</td>
							<td width="300px">个人简介</td>					
							<td width="150px">专长</td>
						</tr>
						</thead>
						<tbody>
 <% 
     			   request.setCharacterEncoding("utf-8");    		
				   ArrayList<View_Student> list = new ArrayList<View_Student>(); 					   			   
				   View_StudentDAO a=new View_StudentDAO();
				   a.getView_Students(request.getParameter("sid"), list);
	               if(list!=null&&list.size()>0)
	               {
		               for(int i=0;i<list.size();i++)
		               {
		            	   View_Student view = list.get(i);
	 %>								
								<tr>
									<td><%=view.getuid() %></td>
	                             	<td><%=view.getname()%></td>
	                                <td><%=view.getpoint()%></td>
	                                <td><%=view.getemail()%></td>
	                                <td><%=view.getschool() %></td>
	                                <%if(view.getintrod()!=""){ %>
				 					<td><%=view.getintrod() %></td>
				 					<%} else{ %>
				 					<td>未填写</td>
				 					<%} %>
	                              
	                                <%if(view.getadv()!=""){ %>
					 					<td><%=view.getadv() %></td>
					 					<%} else{ %>
					 					<td>未填写</td>
					 					<%} %>
	                               
								</tr>	
<%
                   }
              } 
%>							</tbody>	
					</table>	

	</div>
		<br><br><br><br>
	<div class="container">
	
						<table class="table table-hover table-responsive table-striped table-bordered">
               <thead>
					<caption><font size="+2">项目信息</font></caption>
						<tr>
							<td width="200px">项目名称</td>
							<td width="100px">职务</td>
							<td width="220px">老师评语</td>
							<td width="220px">自我评语</td>
							<td width="80px">综合排名（名次）</td>
					    	<td width="80px">综合排名（总人数）</td>
						</tr>
						</thead>
						<tbody>
 <% 
     			   request.setCharacterEncoding("utf-8");    		
				   ArrayList<View_StudentProject> list2 = new ArrayList<View_StudentProject>(); 					   			   
				   View_StudentProjectDAO a1=new View_StudentProjectDAO();
				  a1.getView_StudentPtojects(request.getParameter("sid"), list2);
	               if(list2!=null&&list2.size()>0)
	               {
		               for(int i=0;i<list2.size();i++)
		               {
		            	   View_StudentProject view = list2.get(i);
	 %>								
								<tr>
									<td><%=view.getPname() %></td>
									<%if(view.getsrjob()!=null){ %>
	                             	<td><%=view.getsrjob()%></td>
	                             	 <%}
	                             	 else
	                             	 {
	                             	  %><td>无</td>
	                             	  <%} 
	                             	  %>
	                             	  <%if(view.getsccomment()!=null){ %>
	                             	<td><%=view.getsccomment()%></td>
	                             	 <%}
	                             	 else
	                             	 {
	                             	  %><td>无</td>
	                             	  <%} 
	                             	  %>
	                                <%if(view.getsrreview()!=null){ %>
	                             	<td><%=view.getsrreview()%></td>
	                             	 <%}
	                             	 else
	                             	 {
	                             	  %><td>无</td>
	                             	  <%} 
	                             	  %>
	                                <td><%=view.getpaiming()%></td>
	                                <td><%=view.getsum()%></td>
								</tr>	
<%
                   }
              } 
 else
              {
              %>
									<tr>
							     	<td colspan="6">暂无项目信息</td>
	                    
								
								</tr>	
<%         
   }
%>						</tbody>
					</table>	

	</div>	
		
  </body>
</html>
