<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ page import="DAO.View_FalseUserDAO" %>
<%@ page import="Model.View_FalseUser"%>
<%@ page import="DAO.DoneView_FalseUserDAO" %>
<html>
<head>
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>管理员界面</title>
		<style>
			table {
			text-align: center;
			border-color: #000;
			table-layout:fixed;
			word-break:break-all; word-wrap:break-all;
		}
		#div1 {
			width: 100%;
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
			<li><a href="javascript:location.reload();">查看被举报用户</a></li>
	</ul>
	<br><br><br>
	
	<div class="container">
	
				<table class="table table-hover table-responsive table-striped table-bordered">
               <thead>
					<caption><font size="+2">未处理的被举报用户列表</font></caption>
						<tr>
						
						    <td width="200px">用户账号</td>
							<td width="200px">用户名称</td>
							<td width="80px">用户身份</td>
							<td width="80px">举报人数</td>
							<td width="80px">当前状态</td>
							<td width="65px">查看详情</td>
							
						</tr>
                 </thead>
                 <tbody>
 <% 
	               View_FalseUserDAO view_fp = new View_FalseUserDAO(); 
	               ArrayList<View_FalseUser> list=null;
	               list = view_fp.getView_FalseUsers();
	               if(list!=null&&list.size()>0)
	               {
		               for(int i=0;i<list.size();i++)
		               {
		            	   View_FalseUser view = list.get(i);
	 %>								
								<tr>
							     	<td ><%=view.getFuid()%></td>
	                             	<td><%=view.getName()%></td>
	                                <td><%=view.getUidentity()%></td>
	                                <td><%=view.getFunum()%></td>
	                                <td><%=view.getFusituation()%></td>
							    	<td><a href="http://112.74.176.171:8080/Admin/UserDetail.jsp?fuid=<%=list.get(i).getFuid() %>"><input type="button" value="查看"></a></td>
								</tr>
									
<%
                   }
              } 
                else
              {
              %>
									<tr>
							     	<td colspan="6">暂无未处理的被举报用户</td>
	                    
								
								</tr>	
<%         
   }
%>
</tbody>
						</table>
	</div>
	
	<div class="container">
		<br><br><br><br>
				<table class="table table-hover table-responsive table-striped table-bordered">
               <thead>
					<caption><font size="+2">已处理的被举报用户列表</font></caption>
						<tr>
						
						    <td width="200px">用户账号</td>
							<td width="200px">用户名称</td>
							<td width="80px">用户身份</td>
							<td width="80px">举报人数</td>
							<td width="80px">当前状态</td>
							<td width="65px">查看详情</td>
							
						</tr>
                 </thead>
<tbody>
 <% 
	               DoneView_FalseUserDAO view_fp2 = new DoneView_FalseUserDAO(); 
	               ArrayList<View_FalseUser> list2=null;
	               list2 = view_fp2.getView_FalseUsers();
	               if(list2!=null&&list2.size()>0)
	               {
		               for(int i=0;i<list2.size();i++)
		               {
		            	   View_FalseUser view = list2.get(i);
	 %>								
								<tr>
							     	<td><%=view.getFuid()%></td>
	                             	<td><%=view.getName()%></td>
	                                <td><%=view.getUidentity()%></td>
	                                <td><%=view.getFunum()%></td>
	                                <td><%=view.getFusituation()%></td>
							    	<td><a href="http://112.74.176.171:8080/Admin/UserDetail.jsp?fuid=<%=list2.get(i).getFuid() %>"><input type="button" value="查看"></a></td>
								
								</tr>	
<%
                   }
              } 
  else
              {
              %>
								<tr>
							     	<td colspan="6">暂无已处理的被举报用户</td>
	                    
								
								</tr>	
<%         
   }
%>
</tbody>
						</table>
	</div>
	
	
</body>
</html>