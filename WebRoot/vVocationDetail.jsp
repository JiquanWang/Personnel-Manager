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
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
                        <li><a href="initHolidayList.action">查看休假记录</a></li>
                    <c:choose>    
                    	<c:when test="${user.power==2}">
                        <li class="active"><a href="vWaitingAppList.action">审批休假</a></li>
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
				<h1>休假详细信息</h1>
			</div>
			<div id="breadcrumb">
				<a href="main.html" class="tip-bottom">
                	<i class="icon-home"></i>首页
                </a>
				<a href="vWaitingAppList.html">审批休假</a>
				<a href="#" class="current">休假详细信息</a>
			</div>
        	<div class="container-fluid">
				<div class="row-fluid">
					<div class="span12">
						<div class="widget-box">
							<div class="widget-title">
								<span class="icon">
									<i class="icon-align-justify"></i>									
								</span>
								<h5>休假信息</h5>
							</div>
                            <table width="100%">
                           	
                            	<tr>
                                	<td width="15%" align="right">申请人:</td>
                                    <td width="60%" align="left">
                                    	&nbsp;&nbsp;
                                    	${employee.employeeName}(员工编号${employee.employeeID})
                                    </td>
                                    <td></td>
                                </tr>
                                <tr>
                                	<td align="right">休假类型:</td>
                                    <td align="left">
                                    	&nbsp;&nbsp;
                                    	${employee.holidayTypeName}
                                    </td>
                                    <td></td>
                                </tr>
                                <tr>
                                	<td align="right">休假天数:</td>
                                    <td align="left">
                                    	&nbsp;&nbsp;
                                    	${employee.takeOffDays}
                                    </td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td align="right">休假时间:</td>
                                    <td align="left">
                                        &nbsp;&nbsp;
                                         <fmt:formatDate value="${employee.startDay}" pattern="yyyy年MM月dd日"/> - <fmt:formatDate value="${employee.endDay}" pattern="yyyy年MM月dd日"/>
                                       
                                    </td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td align="right">申请时间:</td>
                                    <td align="left">
                                        &nbsp;&nbsp;
                                        <fmt:formatDate value="${employee.applyDay}" type="both" pattern="yyyy年MM月dd日  HH时mm分ss秒" />
                                        
                                    </td>
                                    <td></td>
                                </tr>
                                
                            </table>
						</div>			
					</div>
				</div>	
			</div>
            <div class="container-fluid">
                <div class="row-fluid">
                    <div class="span12">
                        <div class="widget-box">
                            <div class="widget-title">
                                <span class="icon">
                                    <i class="icon-align-justify"></i>                                  
                                </span>
                                <h5>审批信息</h5>
                            </div>
                            <table class="table table-bordered table-striped">
                                <thead>
                                    <tr>
                                        <th>审批级别</th>
                                        <th>审批人</th>
                                        <th>审批意见</th>
                                        <th>审批时间</th>
                                        <th>审批结果</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="ed1" items="${employee1}">
                                    <tr>
                                        <td>${ed1.examineLevel}</td>
                                        <td>${ed1.employeeName}</td>
                                        <td>${ed1.examineOpinion}</td>
                                        <td>
                                         <fmt:formatDate value="${ed1.examineDate}" type="both" pattern="yyyy年MM月dd日  HH时mm分ss秒" />
                                     	</td>
                                        <td>${ed1.examineResult}</td>
                                    </tr>
                                    </c:forEach>
                                </tbody>
                            </table>    
                        </div>          
                    </div>
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