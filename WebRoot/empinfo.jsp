<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.demo.po.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<title>企业人事管理平台</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
		<link rel="stylesheet" href="css/uniform.css" />	
		<link rel="stylesheet" href="css/unicorn.main.css" />
		<link rel="stylesheet" href="css/unicorn.grey.css" class="skin-color" />	        <style>
			tr{
				height:40px;
			}
		</style>
		<script src="js/jquery.min.js"></script>
       	<script src="js/jquery.ui.custom.js"></script>
       	<script src="js/bootstrap.min.js"></script>
       	<script src="js/bootstrap-colorpicker.js"></script>
       	<script src="js/bootstrap-datepicker.js"></script>
       	<script src="js/jquery.uniform.js"></script>
       	<script src="js/unicorn.js"></script>
	</head>	
	<body>
		<div id="header"><h1></h1></div>
		<div id="user-nav" class="navbar navbar-inverse">
            <ul class="nav btn-group">
                <li class="btn btn-inverse">
                    <a href="#">
                        <i class="icon icon-user"></i>
                        <span class="text">
                            ${user.employeeName}
                        </span>
                    </a>
                </li>
                <li class="btn btn-inverse">
                    <a href="login.html">
                        <i class="icon icon-share-alt"></i>
                        <span class="text">注销</span>
                    </a>
                </li>
            </ul>
        </div>
        <div id="sidebar">
            <ul>
                <li>
                    <a href="main.jsp">
                        <i class="icon icon-home"></i> 
                        <span>首页</span>
                    </a>
                </li>
                <li class="active">
                    <a href="/NeuFinal/empinfo.action">
                        <i class="icon icon-tag"></i> 
                        <span>查看个人信息</span>
                    </a>
                </li>
                <li>
                    <a href="changePassword.jsp">
                        <i class="icon icon-ok-circle"></i> 
                        <span>修改登录密码</span>
                    </a>
                </li>
                <li class="submenu">
                    <a href="#">
                        <i class="icon icon-time"></i> 
                        <span>休假管理</span> 
                        <!--
                        <span class="label">2</span>
                        -->
                    </a>
                    <ul>
                        <li><a href="beforeHolidayReq.action">申请休假</a></li>
                        <li><a href="initHolidayList.action">查看休假记录</a></li>
                    <c:choose>    
                    	<c:when test="${user.power==2}">
                        <li><a href="vWaitingAppList.action">审批休假</a></li>
                        <li><a href="ApprovalRecord.action">查看审批记录</a></li>
                        <li><a href="/NeuFinal/before.action">假期类型管理</a></li>
                        </c:when>
                    </c:choose>
                    </ul>
                </li>
                <c:choose>
                	<c:when test="${user.power==2}">
	                <li>
	                    <a href="/NeuFinal/getAllEmpInfo.action">
	                        <i class="icon icon-user"></i> 
	                        <span>员工信息管理</span> 
	                    </a>
	                </li>
	                <li>
	                    <a href="initDepartment.action">
	                        <i class="icon icon-flag"></i> 
	                        <span>部门信息管理</span> 
	                    </a>
	                </li>
	                <li>
	                    <a href="selectAllHeadship.action">
	                        <i class="icon icon-briefcase"></i> 
	                        <span>职位信息管理</span> 
	                    </a>
	                </li>
	                </c:when>
                </c:choose>
            </ul>
        </div>
        
        
        
        <div id="content">
			<div id="content-header">
				<h1>查看个人信息</h1>
			</div>
			<div id="breadcrumb">
				<a href="main.jsp" class="tip-bottom">
                	<i class="icon-home"></i>
                    首页
                </a>
				<a href="#" class="current">查看个人信息</a>
			</div>
        	<div class="container-fluid">
				<div class="row-fluid">
					<div class="span12">
						<div class="widget-box">
							<div class="widget-title">
								<span class="icon">
									<i class="icon-align-justify"></i>									
								</span>
								<h5>基础信息</h5>
							</div>
                            <table width="100%">
                            	<tr>
                                	<td width="15%" align="right">员工姓名:</td>
                                    <td width="60%" align="left">
                                    	&nbsp;&nbsp;
                                    	${userInfo.employeeName}
                                    </td>
                                    <td width="200px" rowspan="5">
                                    	<img src="img/head.jpg" width="200" height="160"></img>
                                    </td>
                                    <td></td>
                                </tr>
                                <tr>
                                	<td align="right">所属部门:</td>
                                    <td align="left">
                                    	&nbsp;&nbsp;
                                    	${userInfo.departmentName}
                                    </td>
                                    <td></td>
                                </tr>
                                <tr>
                                	<td align="right">职位:</td>
                                    <td align="left">
                                    	&nbsp;&nbsp;
                                    	${userInfo.headshipName}(${userInfo.headshipLevel})
                                    </td>
                                    <td></td>
                                </tr>
                                <tr>
                                	<td align="right">性别:</td>
                                    <td align="left">
                                    	&nbsp;&nbsp;
                                    	${userInfo.sex}
                                    </td>
                                    <td></td>
                                </tr>
                                <tr>
                                	<td align="right">入职日期:</td>
                                    <td align="left">
                                    	&nbsp;&nbsp;
                                    	<fmt:formatDate value="${userInfo.hireDate}" pattern="yyyy年MM月dd日"/>
                                    </td>
                                    <td></td>
                                </tr>
                                <tr>
                                	<td align="right">生日:</td>
                                    <td align="left">
                                    	&nbsp;&nbsp;
                                    	<fmt:formatDate value="${userInfo.birthday}" pattern="yyyy年MM月dd日"/>
                                    </td>
                                    <td></td>
                                    <td></td>
                                </tr>
                            </table>
						</div>			
					</div>
				</div>	
			</div>
        	<hr/>
			<div class="widget-box">
				<div class="widget-title">
					<span class="icon">
						<i class="icon-th"></i>
					</span>
					<h5>部门履历信息</h5>
				</div>
				<div class="widget-content nopadding">
					<table class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>员工姓名</th>
								<th>部门名称</th>
								<th>开始日期</th>
								<th>结束日期</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="ed" items="${edlist}">
							<tr>
								<td>${ed.employeeName}</td>
								<td>${ed.departmentName}</td>
								<td>
									<fmt:formatDate value="${ed.startDate}" pattern="yyyy年MM月dd日"/>
								</td>
								<td>
									<fmt:formatDate value="${ed.endDate}" pattern="yyyy年MM月dd日"/>
								</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>							
				</div>
			</div>
        	<hr/>
			<div class="widget-box">
				<div class="widget-title">
					<span class="icon">
						<i class="icon-th"></i>
					</span>
					<h5>职位履历信息</h5>
				</div>
				<div class="widget-content nopadding">
					<table class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>员工姓名</th>
								<th>职位名称</th>
								<th>开始日期</th>
								<th>结束日期</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="eh" items="${ehlist}">
							<tr>
								<td>${eh.employeeName }</td>
								<td>${eh.headshipName }</td>
								<td>
									<fmt:formatDate value="${eh.startDate}" pattern="yyyy年MM月dd日"/>
								</td>
								<td>
									<fmt:formatDate value="${eh.endDate}" pattern="yyyy年MM月dd日"/>
								</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>							
				</div>
			</div>
		</div>
       <div class="row-fluid">&nbsp;</div>
       <div class="row-fluid">
           <div id="footer" class="span12">
               2016 &copy; 企业人事管理平台
           </div>
       </div>
	</body>
</html>
