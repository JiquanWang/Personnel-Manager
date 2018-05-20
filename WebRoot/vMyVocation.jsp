<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.demo.po.*" %>
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
                <li class="submenu open">
                    <a href="#">
                        <i class="icon icon-time"></i> 
                        <span>休假管理</span> 
                        <!--
                        <span class="label">2</span>
                        -->
                    </a>
                    <ul>
                        <li><a href="beforeHolidayReq.action">申请休假</a></li>
                        <li class="active"><a href="initHolidayList.action">查看休假记录</a></li>
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
				<h1>查看休假记录</h1>
			</div>
			<div id="breadcrumb">
				<a href="main.html" class="tip-bottom">
                	<i class="icon-home"></i>
                                                    首页
                </a>
				<a href="#" class="current">查看休假记录</a>
			</div>
			<form action="selectHolidayList.action" method="post" name="searchForm">
			<input type="hidden" name="pagenum" id="pagenum"/>
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="control-group">
						<span class="span6">
							休假时间：
                            <input readonly id="sdate" name="startDay" type="date" style="width:35%" data-date-format="yyyy-mm-dd" class="datepicker"/>
                            -
                            <input readonly id="edate" name="endDay" type="date" style="width:35%" data-date-format="yyyy-mm-dd" class="datepicker"/>
						</span>
                        <span class="span3">
							<button class="btn btn-info" onclick="submitForm(1);">
								<i class="icon-white icon-search"></i>
								查询
							</button>
							<input type="reset" value="重置" class="btn btn-info" onclick="resetForm();"/>
						</span>
					</div>
				</div>
			</div>
			</form>
			<hr/>
			<div class="row-fluid">  
				<div class="span12">
					<div class="widget-box">
						<div class="widget-content nopadding">
							<table class="table table-bordered table-striped">
								<thead>
									<tr>
										<th>申请人</th>
										<th>休假类型</th>
										<th>休假天数</th>
										<th>休假时间</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="u" items="${hlist}">
	                                    <tr>
	                                        <td>${u.employeeName}</td>
	                                        <td>${u.holidayTypeName}</td>
	                                        <td>${u.takeOffDays}</td>
	                                        <td>
	                           <fmt:formatDate value="${u.startDay}" pattern="yyyy年MM月dd日"/> - <fmt:formatDate value="${u.endDay}" pattern="yyyy年MM月dd日"/>
	                                        </td>
	                                        <td>
	                                            <button class="btn btn-info" onclick="allmessage(${u.takeOffID})">
	                                                <i class="icon-white icon-eye-open"></i>
	                                                详细
	                                            </button>
	                                            <script type="text/javascript">
												  function allmessage(tid){
	                                                   location.href="takeOffDetails.action?takeOffID=" + tid;
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

