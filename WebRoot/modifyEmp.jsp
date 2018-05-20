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
		<link rel="stylesheet" href="css/datepicker.css" />	
		<link rel="stylesheet" href="css/unicorn.main.css" />
		<link rel="stylesheet" href="css/unicorn.grey.css" class="skin-color" />			
		<script src="js/jquery.min.js"></script>
        <script src="js/jquery.ui.custom.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.uniform.js"></script>
        <script src="js/bootstrap-datepicker.js"></script>
        <script src="js/jquery.validate.js"></script>
        <script src="js/unicorn.js"></script>
        <script src="js/modifyemp.js"></script>	          
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
                <li >
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
				<h1>修改员工</h1>
			</div>
			<div id="breadcrumb">
				<a href="main.jsp" class="tip-bottom">
                	<i class="icon-home"></i>
                                                    首页
                </a>
				<a href="/NeuFinal/getAllEmpInfo.action">员工列表</a>
				<a href="#" class="current">修改员工</a>
			</div>
			<div class="container-fluid">
				<div class="row-fluid">
						<div class="span12">
							<div class="widget-box">
								<div class="widget-title">
									<span class="icon">
										<i class="icon-align-justify"></i>									
									</span>
									<h5>员工信息</h5>
								</div>
								<div class="widget-content nopadding">
									<form id="eform" action="updateEmp.action" class="form-horizontal" method="post" >
	                                    <div id="info1" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	员工姓名:
	                                        </label>
	                                        <div class="controls">
	                                            <input type="text" name="employeeName" id="ename" value="${empInfo.employeeName }" />
	                                        </div>
	                                    </div>
	                                    <div id="info2" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	登录名:
	                                        </label>
	                                        <div class="controls">
	                                            <input type="text" name="username" id="lname" value="${empInfo.username }" />
	                                        </div>
	                                    </div>
	                                    <div id="info4" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	性别:
	                                        </label>
	                                        <div class="controls">
	                                            <select id="sex" name="sex">
	                                            	<option value="-1">=请选择=</option>
	                                            	<c:choose>
	                                            		<c:when test="${empInfo.sex == '男'}">
	                                            			<option value="1" selected>男</option>
	                                            			<option value="2">女</option>
	                                            		</c:when>
	                                            		<c:when test="${empInfo.sex == '女'}">
	                                            			<option value="1">男</option>
	                                            			<option value="2" selected>女</option>
	                                            		</c:when>
	                                            	</c:choose>
	                                            </select>
	                                        </div>
	                                    </div>
	                                    <div id="info5" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	生日:
	                                        </label>
	                                        <div class="controls">
	                                            <input type="date" name="birthday" id="birthday" data-date-format="yyyy-mm-dd" readonly class="datepicker" value="${empInfo.birthday}"/>
	                                        </div>
	                                    </div>
	                                    <div id="info6" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	入职日期:
	                                        </label>
	                                        <div class="controls">
	                                            <input type="date" name="hiredate" id="hiredate" data-date-format="yyyy-mm-dd" readonly class="datepicker" value="${empInfo.hiredate }"/>
	                                        </div>
	                                    </div>
	                                    <div id="info7" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	月薪:
	                                        </label>
	                                        <div class="controls">
	                                            <input type="text" name="salary" id="salary" value="${empInfo.salary }"/>
	                                        </div>
	                                    </div>
	                                    <div id="info8" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	权限:
	                                        </label>
	                                        <div class="controls">
	                                            <select id="power" name="power">
	                                            	<option value="-1">=请选择=</option>
	                                            	<c:choose>
	                                            		<c:when test="${empInfo.power == 1 }">
	                                            			<option value="1" selected>普通员工</option>
	                                            			<option value="2">管理员</option>
	                                            		</c:when>
	                                            		<c:when test="${empInfo.power == 2 }">
	                                            			<option value="1">普通员工</option>
	                                            			<option value="2" selected>管理员</option>
	                                            		</c:when>
	                                            	</c:choose>
	                                            </select>
	                                        </div>
	                                    </div>
	                                    <div class="form-actions">
	                                    	<input type="hidden" name="employeeID" id="dID" value="${empInfo.employeeID }"/>
	                                        <input type="submit" value="提交" class="btn btn-primary" />
	                                        <input type="reset" value="重置" class="btn btn-primary" />
	                                    </div>
	                                </form>
								</div>
							</div>			
						</div>
				</div>	
			</div>	

            <div class="alert alert-error">
                保存失败
            </div>

            <div class="alert alert-success">
                保存成功
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