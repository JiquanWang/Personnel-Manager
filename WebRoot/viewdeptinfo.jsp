<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<title>企业人事管理平台</title>
		<meta charset="UTF-8" />
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
                    <a href="login.jsp">
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
                <li>
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
                        <li><a href="vWaitingAppList.action">审批休假</a></li>
                        <li><a href="initHolidayList.action">查看休假记录</a></li>
                        <li><a href="ApprovalRecord.action">查看审批记录</a></li>
                        <li><a href="/NeuFinal/before.action">假期类型管理</a></li>
                    </ul>
                </li>
                <li>
                    <a href="/NeuFinal/getAllEmpInfo.action">
                        <i class="icon icon-user"></i> 
                        <span>员工信息管理</span> 
                    </a>
                </li>
                <li class="active">
                    <a href="initDepartment.action" >
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
            </ul>
        </div>
        
        
        <div id="content">
			<div id="content-header">
				<h1>查看部门信息</h1>
			</div>
			<div id="breadcrumb">
				<a href="main.html" class="tip-bottom">
                	<i class="icon-home"></i>首页
                </a>
				<a href="deptlist.html">部门列表</a>
				<a href="#" class="current">查看部门</a>
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
                                	<td width="15%" align="right">部门编号:</td>
                                    <td width="60%" align="left">
                                    	&nbsp;&nbsp;
                                    	${ddv.departmentID}
                                    </td>
                                    <td></td>
                                </tr>
                                <tr>
                                	<td align="right">部门名称:</td>
                                    <td align="left">
                                    	&nbsp;&nbsp;
                                    	${ddv.departmentName}
                                    </td>
                                    <td></td>
                                </tr>
                                <tr>
                                	<td align="right">部门负责人:</td>
                                    <td align="left">
                                    	&nbsp;&nbsp;
                                    	${ddv.employeeName}(员工编号：${ddv.employeeID})
                                    </td>
                                    <td></td>
                                </tr>
                                <tr>
                                	<td align="right">员工人数/部门编制:</td>
                                    <td align="left">
                                    	&nbsp;&nbsp;
                                    	${ddv.numberOfEmployee}/${ddv.maxPeople}
                                    </td>
                                    <td></td>
                                </tr>
                                <tr>
                                	<td align="right">创建时间:</td>
                                    <td align="left">
                                    	&nbsp;&nbsp;
                                    	${ddv.newdate}
                                    </td>
                                    <td></td>
                                </tr>
                                <tr>
                                	<td align="right">上级部门:</td>
                                    <td align="left">
                                    	&nbsp;&nbsp;
                                    	${ddv.fatherDepartmentName}(部门编号:${ddv.fatherDepartmentID})
                                    </td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td align="right">状态:</td>
                                    <td align="left">
                                        &nbsp;&nbsp;
                                        ${ddv.departmentMark}
                                    </td>
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
					<h5>部门下属员工信息</h5>
				</div>
				<div class="widget-content nopadding">
					<table class="table table-bordered table-striped">
						<thead>
							<tr>
                                <th>员工编号</th>
								<th>姓名</th>
								<th>职位/职级</th>
                                <th>性别</th>
                                <th>年龄</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="u" items="${ldev}">
								<tr>
									<td>${u.employeeID}</td>
									<td>${u.employeeName}</td>
									<td>${u.headshipName}/${u.headshipLevel}级</td>
									<td>${u.sex}</td>
	                                <td>${u.age}</td>
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