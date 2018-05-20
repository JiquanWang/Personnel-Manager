<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.demo.po.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>企业人事管理平台</title>
		<meta charset="UTF-8" />
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
                    <a href="empinfo.action">
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
                <li>
                    <a href="initDepartment.action">
                        <i class="icon icon-flag"></i> 
                        <span>部门信息管理</span> 
                    </a>
                </li>
                <li class="active">
                    <a href="selectAllHeadship.action">
                        <i class="icon icon-briefcase"></i> 
                        <span>职位信息管理</span> 
                    </a>
                </li>
            </ul>
        </div>
        
		<div id="content">
			<div id="content-header">
				<h1>职位信息管理</h1>
			</div>
			<div id="breadcrumb">
				<a href="main.jsp" class="tip-bottom">
                	<i class="icon-home"></i>
                                                    首页
                </a>
				<a href="#" class="current">职位信息管理</a>
			</div>
			<form action="findHeadship.action" method="post" name="searchForm">
			<input type="hidden" name="pagenum" id="pagenum"/>
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="control-group">
						<span class="span3">
							名称：<input id="ename" name="headshipName" type="text" style="width:65%"/>
						</span>
						<span class="span3">
							状态：<select id="eflag" name="headshipMark" style="width:70%">
									<option value="-1">=请选择=</option>
									<option value="1">活动</option>
                                    <option value="2">撤销</option>
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
					<button class="btn btn-info" onclick="addJob();">
						<i class="icon-white icon-plus"></i>
						新增
					</button>
					<script type="text/javascript">
						function addJob(){
							location.href="addJob.jsp";
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
										<th>职位名称</th>
										<th>职位级别</th>
										<th>状态</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="ed" items="${list}">
                                    <tr>
                                        <td>${ed.headshipID}</td>
                                        <td>${ed.headshipName}</td>
                                        <td>${ed.headshipLevel}</td>
                                        <td>${ed.headshipMark}</td>
                                        <td>
                                            <button class="btn btn-info" onclick="see(${ed.headshipID})">
                                                <i class="icon-white icon-eye-open"></i>
                                                查看
                                            </button>
                    <script type="text/javascript">
						function see(id){
							location.href="chakan.action?id="+id;
						}
					</script>
                                            <button class="btn btn-warning" onclick="gotomodify(${ed.headshipID})">
                                                <i class="icon-white icon-refresh"></i>
                                                修改
                                            </button>
                    <script type="text/javascript">
						function gotomodify(id){
							location.href="xiugai.action?id="+id;
						}
					</script>  
					<c:choose>
					<c:when test="${ed.headshipMark=='活动'}">                                          
                                            <button class="btn btn-danger" onclick="huifu(${ed.headshipID})">
                                                <i class="icon-white icon-minus"></i>
                                                撤销
                                            </button>
					</c:when>
					<c:otherwise>
                                            <button class="btn btn-yeah" onclick="huifu(${ed.headshipID})">
                                                <i class="icon-white icon-plus"></i>
                                                恢复
                                            </button>
					</c:otherwise>
					</c:choose>
                    <script type="text/javascript">
						function huifu(id){
							location.href="huifu.action?id="+id;
						}
					</script>                                           
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