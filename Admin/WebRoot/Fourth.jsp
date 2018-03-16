<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ page import="DAO.*" %>
<%@ page import="Model.*"%>

<html>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>管理员界面</title>
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
			margin:0 auto;
		}
		#div3{
		text-align:center;
		   height:500px;
		  width: 100%;
		}
		
		#div4{
		   margin:0 auto;
		   height:500px;
		   width:400px;
		  
		}
		#div5{
   	margin:0 auto;
	  float: left;
	  height:500px;
		width:400px;
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
	<div id="div2" style="height: 40px;">
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
	<br><br><br>
	<ul class="breadcrumbs">
		<li><a href="javascript:location.reload();">查看数据统计信息</a></li>
	</ul>
	<br>
		<br><br>
	<%--用户数量 --%>
		<div style="height:600px;width:450px;margin:0 auto">
			<script src="/Admin/Chart.js"></script>
   			<table class="table table-hover table-responsive table-striped table-bordered">
               <thead>
				<caption><font size="+2">用户数量</font></caption>
					<tr>
						<td>总人数/人</td>
						<td>学生人数/人</td>
						<td>老师人数/人</td>
					</tr>
			    </thead>
			    
			    <tbody>
 			<% 
	               View_AllUserDAO view_fp = new View_AllUserDAO(); 
	               ArrayList<View_AllUser> list=null;
	               list = view_fp.getView_Users();
	               if(list!=null&&list.size()>0)
	               {
		               for(int i=0;i<list.size();i++)
		               {
		            	   View_AllUser view = list.get(i);
			 %>								
								<tr>
									<td><%=view.getunum() %></td>
	                             	<td><%=view.getsnum()%></td>
	                                <td><%=view.gettnum()%></td>                         
								</tr>	
			<%
                   		}
              		} 
			%>
			</tbody>
			</table>
			<canvas id="myChart" width="100px" height="100px" class="chartjs-render-monitor" style="display;block;width:400px;height:400px"></canvas>					
			 <script>
				 var s =<%=list.get(0).getsnum()%>;
				 var t =<%=list.get(0).gettnum()%>;
				 var popCanvas = document.getElementById("myChart").getContext("2d");
				 var barChart = new Chart(popCanvas, {
				     type: 'pie',
				     data: {
						labels: ["学生总数", "老师总数"],
						datasets: [{
						data: [s, t],
						backgroundColor: [
				        'rgba(255, 99, 132, 0.6)',
				        'rgba(54, 162, 235, 0.6)',       
						      ]
						    }]
					}
				 });
			</script>
		</div>

	<%--项目数量 --%>
		<div style="height:600px;width:450px;margin:0 auto">
			<script src="../Chart.js"></script>
   			<table class="table table-hover table-responsive table-striped table-bordered">
               <thead>
					<caption><font size="+2">项目数量</font></caption>
						<tr>
							<td>总项目数/个</td>
							
						</tr>
						</thead>
						<tbody>
 				<% 
	               View_AllProjectDAO view_fp1 = new View_AllProjectDAO(); 
	               ArrayList<View_AllProject> list1=null;
	               list1 = view_fp1.getView_Projects();
	               if(list1!=null&&list1.size()>0)
	               {
		               for(int i=0;i<list1.size();i++)
		               {
		            	   View_AllProject view = list1.get(i);
				 %>								
								<tr>
	                                <td><%=view.getpnum()%></td>                         						
								</tr>	
				<%
                   		}
              		} 
				%>
				</tbody>
			</table>
			<canvas id="myChart1" width="100px" height="100px"></canvas>					
				<script>
					var t =<%=list1.get(0).getpnum()%>;
					var popCanvas = document.getElementById("myChart1").getContext("2d");
					var barChart = new Chart(popCanvas, {
					type: 'bar',
					data: {
					labels: ["项目数量",""],
					datasets: [{	
					 label :"项目数量",	     
						 data: [t,0],
						 backgroundColor: [
						 	'rgba(153, 102, 255, 0.6)',
						 	
		      		]
		    		}]
		  			}
				});</script>
		</div>	
<%--日活跃度 --%>	
		<div style="height:600px;width:450px;margin:0 auto">
		<table class="table table-hover table-responsive table-striped table-bordered">
               <thead>
					<caption><font size="+2">过去一周活跃度统计/次</font></caption>
						<tr>
							<td width="80">今天登陆</td>
							<td width="80">距今一天登陆</td>		
							<td width="80">距今两天登陆</td>		
							<td width="80">距今三天登陆</td>		
							<td width="80">距今四天登陆</td>		
							<td width="80">距今五天登陆</td>		
							<td width="80">距今六天登陆</td>		
						</tr>
		   	</thead>
		   	<tbody>
<tr>
 <% 
	               View_DateDAO view_fp5 = new View_DateDAO(); 
	               ArrayList<Integer> list5=null;
	                String s1=new String();
	               list5 = view_fp5.getView_Dates();
	               if(list5!=null&&list5.size()>0)
	               {
	                  for(int i=0;i<list5.size();i++)
	                  {
	 %>								
									<td><%=list5.get(i) %></td>						
<%
                   }
                    for(int j=list5.size();j<7;j++)
                    {
%>
                       	   <td><%=0 %></td>
<%                        						
                    }
                   for(int i=0;i<list5.size();i++)
                   {
                   if(list5.size()==7)
                   {
                   if(i!=list5.size()-1)
                      {s1+=list5.get(i)+",";}
                      else
                      {
                       s1+=list5.get(i);
                      }
                   }   
                   else
                   {s1+=list5.get(i)+",";
                   }
                   }
                   if(list5.size()<7)
                   {
                      for(int j=list5.size();j<7;j++)
                      {
	                       if(j!=6)
	                       {s1+="0,";}
	                      else
	                      {
	                       s1+="0";
	                      }
                      }
                   }
                   
                   }
                   else
                  {
                  s1="0,0,0,0,0,0,0";
                  }
                   
%>
         
</tr>	</tbody>
						</table>

<canvas id="myChart5" width="100px" height="100px"></canvas>					
	 <script>
	
var popCanvas = document.getElementById("myChart5").getContext("2d");
	var barChart = new Chart(popCanvas, {
  type: 'bar',
  data: {
    labels:["今天登陆","距今一天","距今两天","距今三天","距今四天","距今五天","距今六天",""],
    datasets: [{
      label :"日活跃度统计",
      data: [<%=s1%>,0],
      backgroundColor: [
       'rgba(255, 99, 132, 0.6)',
        'rgba(54, 162, 235, 0.6)',
        'rgba(255, 206, 86, 0.6)',
        'rgba(75, 192, 192, 0.6)',
        'rgba(153, 102, 255, 0.6)',
        'rgba(255, 159, 64, 0.6)',
        'rgba(255, 99, 132, 0.6)',
        'rgba(54, 162, 235, 0.6)',
        'rgba(255, 206, 86, 0.6)',
        'rgba(75, 192, 192, 0.6)',
        'rgba(153, 102, 255, 0.6)'
      ]
    }]
  }
});</script>	
		
		</div>
	<%--老师学校 --%>
		<div style="width:1000px ;height:600px;margin:0 auto" >
			<table class="table table-hover table-responsive table-striped table-bordered">
               <thead>
					<caption><font size="+2">老师学校统计</font></caption>
						<tr>
							<td width="80">学校名称</td>
							<td width="80">学校数量/所</td>		
						</tr>
			   </thead>
			   <tbody>
 				<% 
					View_TSchoolDAO view_fp3 = new View_TSchoolDAO(); 
	                ArrayList<View_School> list3=null;
	                list3 = view_fp3.getView_Schools();
	                ArrayList<String> list23=new ArrayList<String>();
	                ArrayList<Integer> list24=new ArrayList<Integer>();
	                if(list3!=null&&list3.size()>0)
	                {
		               for(int i=0;i<list3.size();i++)
		               {
		            	   View_School view = list3.get(i);
				 %>								
								<tr>
									<td><%=view.getschool() %></td>
	                             	<td><%=view.getnum()%></td>							
								</tr>	
				<%
                   	   }
              		}             
                 	if(list3!=null&&list3.size()>0)
	                {
		               for(int i=0;i<list3.size();i++)
		               {
		                 String view=list3.get(i).getschool();
		                   list23.add(view);
		                   int num = list3.get(i).getnum();
		                   list24.add( num);
		               }
                    }
                   String v11=new String();
                   String v12=new String();
	                for(int i=0;i<list23.size();i++)
	                {
	                if(i!=list23.size()-1)
	                   v11+='"'+list23.get(i)+'"'+',';
	                   else
	                   v11+='"'+list23.get(i)+'"';
	                }
	                
	                 for(int i=0;i<list24.size();i++)
	                {
	                if(i!=list24.size()-1)
	                   v12+=String.valueOf(list24.get(i))+',';
	                   else
	                   v12+=String.valueOf(list24.get(i));
	                }
				%>
				</tbody>
			</table>
			
			<div style="height:400px;width:400px;float:left;margin:10px">
		<canvas id="myChart3" width="100px" height="100px"></canvas>					
			 <script>
				var popCanvas = document.getElementById("myChart3").getContext("2d");
				var barChart = new Chart(popCanvas, {
		  		type: 'pie',
		  		data: {
		   			 labels:[<%=v11%>],
		   			 datasets: [{
		   			 data: [<%=v12%>],
		   			 backgroundColor: [
		   			 '#9bca3c','#eef66a','#f2a03d','#cf3334','#9bca3c','#eef66a',
		       		 '#f2a03d','#cf3334','#9bca3c','#eef66a','#f2a03d','#cf3334',
		      		 '#9bca3c','#eef66a','#f2a03d','#cf3334','#9bca3c','#eef66a',
		      		 '#f2a03d','#cf3334','#9bca3c','#eef66a','#f2a03d','#cf3334',
		       		 '#9bca3c','#eef66a','#f2a03d','#cf3334','#9bca3c','#eef66a',
		       		 '#f2a03d','#cf3334',
		      		]
			    	}]
			  	}
				});
				</script>		
			</div>		
		<div style="height:400px;width:400px;float:right;margin:10px">					
		<canvas id="myChart13" width="100px" height="100px"></canvas>					
			 <script>
				var popCanvas = document.getElementById("myChart13").getContext("2d");
					var barChart = new Chart(popCanvas, {
				  type: 'bar',
				  data: {
				    labels:[<%=v11%>,""],
				    datasets: [{
				      label :"老师学校统计",
				      data: [<%=v12%>,0],
				      backgroundColor: [
				      '#3d6272',
			       '#3c899b',
			       '#45a298',
			       '#d8f8b7',
			       '#3d6272',
			       '#3c899b',
			       '#45a298',
			       '#d8f8b7'
				      ]
				    }]
				  }
				});
				</script>	
			</div>							
		</div>
	
	<%--学生学校 --%>
		<div style="width:1000px;height:600px; margin:0 auto">
			<table class="table table-hover table-responsive table-striped table-bordered">
               <thead>
					<caption><font size="+2">学生学校统计</font></caption>
						<tr>
							<td>学校名称</td>
							<td>学校数量/所</td>		
						</tr>
			   </thead>
			   <tbody>
 		<% 
	               View_SSchoolDAO view_fp2 = new View_SSchoolDAO(); 
	               ArrayList<View_School> list2=null;
	               ArrayList<String> list13=new ArrayList<String>();
	                ArrayList<Integer> list14=new ArrayList<Integer>();
	               list2 = view_fp2.getView_Schools();
	             
	               if(list2!=null&&list2.size()>0)
	               {
		               for(int i=0;i<list2.size();i++)
		               {
		            	   View_School view = list2.get(i);
	 	%>								
								<tr>
									<td><%=view.getschool() %></td>
	                             	<td><%=view.getnum()%></td>							
			
								</tr>	
		<%
                   }
              }             
               if(list2!=null&&list2.size()>0)
	               {
		               for(int i=0;i<list2.size();i++)
		               {
		                 String view=list2.get(i).getschool();
		                   list13.add(view);
		                   int num = list2.get(i).getnum();
		                   list14.add( num);
		               }
                   }
                   String v1=new String();
                   String v2=new String();
                for(int i=0;i<list13.size();i++)
                {
                if(i!=list13.size()-1)
                   v1+='"'+list13.get(i)+'"'+',';
                   else
                   v1+='"'+list13.get(i)+'"';
                }
                
                 for(int i=0;i<list14.size();i++)
                {
                if(i!=list14.size()-1)
                   v2+=String.valueOf(list14.get(i))+',';
                   else
                   v2+=String.valueOf(list14.get(i));
                }
                
		%>
		</tbody>
		</table>
			
			<div style="height:400px;width:400px;float:left;margin:10px">
				<canvas id="myChart12" width="100px" height="100px"></canvas>					
				 	<script>
					var popCanvas = document.getElementById("myChart12").getContext("2d");
						var barChart = new Chart(popCanvas, {
					  type: 'pie',
					  data: {
					    labels:[<%=v1%>],
					    datasets: [{
					      
					      data: [<%=v2%>],
					      backgroundColor: [
					       '#73f8dd',
					       '#2bc4ca',
					       '#1872a4',
					       '#2e3988',
					        '#73f8dd',
					       '#2bc4ca',
					       '#1872a4',
					       '#2e3988',
					        '#73f8dd',
					       '#2bc4ca',
					       '#1872a4',
					       '#2e3988',
					      
					      ]
					    }]
					  }
					});
					</script>			
			</div>
				<div style="height:400px;width:400px;float:right;margin:10px">	
					<canvas id="myChart2" width="100px" height="100px"></canvas>					
			 <script>
				var popCanvas = document.getElementById("myChart2").getContext("2d");
					var barChart = new Chart(popCanvas, {
				  type: 'bar',
				  
				  data: {
				    labels:[<%=v1%>,""],
				   
				    datasets: [{
				     label: '学校统计',
				      data: [<%=v2%>,0],
				      backgroundColor: [
				       '#9bca3c',
				       '#eef66a',
				       '#f2a03d',
				       '#cf3334',
				      '#9bca3c',
				       '#eef66a',
				       '#f2a03d',
				       '#cf3334',
				      ]
				    }]
				  },
				    options: {	   
				    }	  
				});
				</script>
			</div>
		</div>
		
		
		</div>
	<%--学生专长 --%>	
		<div style="height:600px;width:450px;margin:0 auto">
			<table class="table table-hover table-responsive table-striped table-bordered">
               <thead>
					<caption><font size="+2">学生专长统计</font></caption>
						<tr>
							<td width="280">专长名称</td>
							<td width="120">学生数量/人</td>		
						</tr>
                </thead>
                <tbody>
 <% 
	               View_AdvDAO view_fp4 = new View_AdvDAO(); 
 					View_guolvDAO view_fp555 = new View_guolvDAO();  	               
	               ArrayList<View_School> list4=null;
	               list4 = view_fp4.getView_Advs(); //获取的专长列表，以逗号为分割结束，getschool专长  getnum数量
	               if(list4.size()>10){ list4=view_fp555.getADV(list4);}
	             ArrayList<String> list33=new ArrayList<String>();
	                ArrayList<Integer> list34=new ArrayList<Integer>();
	               if(list4!=null&&list4.size()>0)
	               {
		               for(int i=0;i<list4.size();i++)
		               {
		            	   View_School view = list4.get(i);
	 %>								
								<tr>
									<td><%=view.getschool() %></td>
	                             	<td><%=view.getnum()%></td>							
			
								</tr>	
<%
                   }
              }             
                if(list4!=null&&list4.size()>0)
	               {
		               for(int i=0;i<list4.size();i++)
		               {
		                 String view=list4.get(i).getschool();
		                   list33.add(view);
		                   int num = list4.get(i).getnum();
		                   list34.add( num);
		               }
                   }
                   String v111=new String();
                   String v112=new String();
                for(int i=0;i<list33.size();i++)
                {
                if(i!=list33.size()-1)
                   v111+='"'+list33.get(i)+'"'+',';
                   else
                   v111+='"'+list33.get(i)+'"';
                }
                
                 for(int i=0;i<list34.size();i++)
                {
                if(i!=list34.size()-1)
                   v112+=String.valueOf(list34.get(i))+',';
                   else
                   v112+=String.valueOf(list34.get(i));
                }
%></tbody>
		</table>
		<canvas id="myChart4" width="100px" height="100px"></canvas>					
	 		<script>	
			var popCanvas = document.getElementById("myChart4").getContext("2d");
				var barChart = new Chart(popCanvas, {
			  type: 'pie',
			  data: {
			    labels:[<%=v111%>],
			    datasets: [{
			     
			      data: [<%=v112%>],
			      backgroundColor: [
			       '#3d6272',
			       '#3c899b',
			       '#45a298',
			       '#d8f8b7',
			                '#73f8dd',
					       '#2bc4ca',
					       '#1872a4',
					       '#2e3988',
			        '#3d6272',
			       '#3c899b',
			       '#45a298',
			       '#d8f8b7',
			                '#73f8dd',
					       '#2bc4ca',
					       '#1872a4',
					       '#2e3988',	
					       '#3d6272',
			       '#3c899b',
			       '#45a298',
			       '#d8f8b7',
			                '#73f8dd',
					       '#2bc4ca',
					       '#1872a4',
					       '#2e3988',
			        '#3d6272',
			       '#3c899b',
			       '#45a298',
			       '#d8f8b7',
			                '#73f8dd',
					       '#2bc4ca',
					       '#1872a4',
					       '#2e3988',	
					       '#3d6272',
			       '#3c899b',
			       '#45a298',
			       '#d8f8b7',
			                '#73f8dd',
					       '#2bc4ca',
					       '#1872a4',
					       '#2e3988',
			        '#3d6272',
			       '#3c899b',
			       '#45a298',
			       '#d8f8b7',
			                '#73f8dd',
					       '#2bc4ca',
					       '#1872a4',
					       '#2e3988',	  
			      ]
			    }]
			  }
			});</script>		
		</div>
		
	
	</div>
	
	
	
	
	
	
</body>
</html>