<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" 
           uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ page import="DAO.*" %>
<%@ page import="Model.*"%>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>管理员界面</title>
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<style>
		table {
			text-align: center;
			border-color: #000;
		table-layout:fixed;word-break:break-all; word-wrap:break-all;
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
		.autocut {  			
		    overflow:hidden;  		
		    white-space:nowrap;  		
		    text-overflow:ellipsis;  		
		    -o-text-overflow:ellipsis;  		
		    -icab-text-overflow: ellipsis;  		
		    -khtml-text-overflow: ellipsis;  		
		    -moz-text-overflow: ellipsis;  	
		    -webkit-text-overflow: ellipsis;  
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
			<li><a href="javascript:location.reload();">查看全部学生</a></li>
	</ul>
	<br><br><br>
	<div class="container">
    <c:set var="totalUsers" value="${requestScope.totalUsers}"/>
    <c:set var="usersPerPage" value="${requestScope.usersPerPage}"/>
    <c:set var="totalPages" value="${requestScope.totalPages}"/>
    <c:set var="beginIndex" value="${requestScope.beginIndex}"/>
    <c:set var="endIndex" value="${requestScope.endIndex}"/>
    <c:set var="page" value="${requestScope.page}"/>
    <c:set var="currentPageUsers" value="${requestScope.users.subList(beginIndex,endIndex)}"/>		
	
    <table class="table table-hover table-responsive table-striped table-bordered">
        <thead>
        <caption><font size="+2">学生列表</font></caption>
						<tr>
							<td width="110px">用户账号</td>
							<td width="120px">学生姓名</td>
							<td width="80px">所属学校</td>
							<td width="200px">个人简介</td>		
							<td width="130px">专业特长</td>
							<td width="60px">项目数量</td>
							<td width="65px">查看详情</td>
						</tr>

        </thead>
        <tbody>
        <c:forEach var="user" items="${currentPageUsers}">
            <tr>
                <td>${user.sid}</td>
                <td>${user.sname}</td>
                <td>${user.school}</td>
                <td><div class="autocut">${user.adv1}</div></td>
                <td><div class="autocut">${user.adv}</div></td>
                <td>${user.pcount}</td>
                <td>
                	<a href="http://112.74.176.171:8080/Admin/StudentDetail.jsp?sid=${user.sid}">
                	<input type="button" value="查看"></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <hr>

    <div class="text-center">
        <nav>
            <ul class="pagination">
                <li><a href="<c:url value="/Servlet/ListServlet?page=1"/>">首页</a></li>
                <li><a href="<c:url value="/Servlet/ListServlet?page=${page-1>=1?page-1:1}"/>">&laquo;</a></li>

                <c:forEach begin="1" end="${totalPages}" varStatus="loop">
                    <c:set var="active" value="${loop.index==page?'active':''}"/>
                    <li class="${active}"><a
                            href="<c:url value="/Servlet/ListServlet?page=${loop.index}"/>">${loop.index}</a>
                    </li>
                </c:forEach>
                <li>
                    <a href="<c:url value="/Servlet/ListServlet?page=${page+1<=totalPages?page+1:totalPages}"/>">&raquo;</a>
                </li>
                <li><a href="<c:url value="/Servlet/ListServlet?page=${totalPages}"/>">尾页</a></li>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>