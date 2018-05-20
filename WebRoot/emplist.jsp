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
        <link rel="stylesheet" href="css/colorpicker.css" />
        <link rel="stylesheet" href="css/datepicker.css" />
		<link rel="stylesheet" href="css/uniform.css" />	
		<link rel="stylesheet" href="css/unicorn.main.css" />
		<link rel="stylesheet" href="css/unicorn.grey.css" class="skin-color" />	          
		<script src="js/jquery.min.js"></script>
       	<script src="js/jquery.ui.custom.js"></script>
       	<script src="js/bootstrap.min.js"></script>
       	<script src="js/bootstrap-colorpicker.js"></script>
       	<script src="js/bootstrap-datepicker.js"></script>
       	<script src="js/jquery.uniform.js"></script>
       	<script src="js/unicorn.js"></script>
		<script type="text/javascript" language="javascript">
			$(document).ready(function(){
				$('input[type=checkbox],input[type=radio],input[type=file]').uniform();
				$('.datepicker').datepicker();
				
			});
		</script>  
		<script type="text/javascript">
			function allmessage(){
           		location.href="viewempinfo.html";
            }
            function gotomodify(eid){
            	location.href="modifyEmp.action?id="+eid;
            }
			function gotoChange(){
            	location.href = "changeEmp.html";
            }
            function detail(eid){
            	location.href ="empDetail.action?id="+eid;
            }
            function addemp1(){
            	location.href="beforeAdd.action";
            }
            function reset(id){
				location.href="resetEmpMark.action?employeeID="+id;
			}
			function change(eid){
				location.href="beforeChange.action?id="+eid;
			}
       </script>
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
                        <li><a href="before.action">假期类型管理</a></li>
                    </ul>
                </li>
                <li class="active">
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
            </ul>
        </div>
        
		<div id="content">
			<div id="content-header">
				<h1>员工信息管理</h1>
			</div>
			<div id="breadcrumb">
				<a href="main.jsp" class="tip-bottom">
                	<i class="icon-home"></i>
                                                    首页
                </a>
				<a href="#" class="current">员工信息管理</a>
			</div>
			
			<!-- 页面业务逻辑开始 -->
			
			<form action="selectEmp.action" method="post" name="searchForm">
			<!-- <input type="hidden" name="pagenum" id="pagenum"/> -->
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="control-group">
						<span class="span3">
							姓名：<input id="ename" name="employeeName" type="text" style="width:65%"/>
						</span>
						<span class="span3">
							性别：<select id="sex" name="sex" style="width:70%">
									<option value="-1">=请选择=</option>
									<option value="1">男</option>
									<option value="2">女</option>
								</select>
						</span>
						<span class="span3">
							职位：<select id="job" name="headshipName" style="width:70%">
									<option value="-1">=请选择=</option>
									<c:forEach items="${headships}" var="headship">
					    				<option value="${headship.headshipID}">${headship.headshipName}</option>
					    			</c:forEach>
								</select>
						</span>
						<span class="span3">
							部门：<select id="dept" name="departmentName" style="width:70%">
									<option value="-1">=请选择=</option>
									<c:forEach items="${depts}" var="dept">
					    				<option value="${dept.departmentID}">${dept.departmentName}</option>
					    			</c:forEach>
								</select>
						</span>
					</div>
					<div class="control-group">
						<span class="span6">
							入职日期：
							<input readonly id="sdate" name="startDate" type="date" data-date-format="yyyy-mm-dd" class="datepicker"/> - 
							<input readonly id="edate" name="endDate" type="date" data-date-format="yyyy-mm-dd" class="datepicker"/>
                        </span>   
						<span class="span3">
							状态：<select id="eflag" name="employeeMark" style="width:70%">
									<option value="-1">=请选择=</option>
									<option value="1">在职</option>
                                    <option value="2">离职</option>
								</select>
						</span>
                        <span class="span3">
                        	<input type="submit" class="btn btn-info" value="查询" />
							<input type="reset" class="btn btn-info" value="重置" />
						</span>
					</div>
					
				</div>
			</div>
			</form>
			<hr/>
			<div class="row-fluid">
				<div class="span12" style="padding-left:30px;">
					<button class="btn btn-info" onclick="addemp1();">
						<i class="icon-white icon-plus"></i>
						新增
					</button>
					<script type="text/javascript">
						function addemp(){
							location.href="addEmp.html";
						}
					</script>
				</div>
				<div class="span12">
					<div class="widget-box">
						<div class="widget-content nopadding">
							<table class="table table-bordered table-striped">
								<thead>
									<tr>
										<th>编号</th>
										<th>姓名</th>
										<th>性别</th>
										<th>职位</th>
										<th>部门</th>
										<th>状态</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody id="tb">
								<c:forEach var = "emp" items="${empInfoList}">
                                    <tr>
                                        <td>${emp.employeeID }</td>
                                        <td>${emp.employeeName }</td>
                                        <td>${emp.sex}</td>
                                        <td>${emp.headshipName }</td>
                                        <td>${emp.departmentName }</td>
                                        <td>${emp.employeeMark }</td>
                                        <td>
                                        <button class="btn btn-chakan" onclick="detail(${emp.employeeID })">
                                        <i class="icon-white icon-eye-open"></i>
                                        	查看
                                        </button>
                                        <button class="btn btn-warning" onclick="gotomodify(${emp.employeeID })">
                                        <i class="icon-white icon-refresh"></i>
                                        	修改
                                        </button>
                                        <c:choose>
                                        	<c:when test="${emp.employeeMark eq '在职'}">
                                        		 <button class="btn btn-danger" onclick="reset(${emp.employeeID})">
                                        			<i class="icon-white icon-minus"></i>
                                        			离职
                                       			 </button>
                                        	</c:when>
                                        	<c:when test="${emp.employeeMark eq '离职'}">
                                        		<button class="btn btn-yeah" onclick="reset(${emp.employeeID})">
                                                	<i class="icon-white icon-plus"></i>
                                                	 入职
                                            	</button>
                                        	</c:when>
                                        </c:choose>
                                         <button class="btn btn-success" onclick="change(${emp.employeeID})">
                                         <i class="icon-white icon-share"></i>
                                         	调转
                                         </button>
                                        </td>
                                    </tr>
                                    </c:forEach>     
								</tbody>
							</table>							
						</div>
					</div>
				</div>
			</div>
			<div class="fg-toolbar ui-toolbar ui-widget-header ui-corner-bl ui-corner-br ui-helper-clearfix">
				<div class="dataTables_paginate fg-buttonset ui-buttonset fg-buttonset-multi ui-buttonset-multi paging_full_numbers">
			<a tabindex="0" href="javascript:"+method+"(1)" class="first ui-corner-tl ui-corner-bl fg-button ui-button ui-state-default">首页</a>
			<a tabindex="0" href="#" class="previous fg-button ui-button ui-state-default">上一页</a>
            <a tabindex="0" href="#" class="fg-button ui-button ui-state-default">1</a>
            <a tabindex="0" class="fg-button ui-button ui-state-default ui-state-disabled">2
            </a>
            <a tabindex="0" href="#" class="fg-button ui-button ui-state-default">3</a>
            <a tabindex="0" href="#" class="previous fg-button ui-button ui-state-default">下一页</a>
			<a tabindex="0" href="#" class="last ui-corner-tr ui-corner-br fg-button ui-button ui-state-default">尾页</a>
			
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
