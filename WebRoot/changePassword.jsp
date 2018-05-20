<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		<script type="text/javascript">
			$(document).ready(function (){
				$("#saveFail").css("opacity","0");
				$("#saveSuccess").css("opacity","0");
				$("#pass1").blur(function (){
					validatePass1b();
				});
				$("#pass1").focus(function (){
					validatePass1f();
				});
				$("#pass2").blur(function (){
					validatePass2b();
				});
				$("#pass2").focus(function (){
					validatePass2f();
				});
				$("#pass3").blur(function (){
					validatePass3b();
				});
				$("#pass3").focus(function (){
					validatePass3f();
				});
				$("#pform").submit(function (){
					var flag = true;
					var v = $("#pass1").val();
					if(v != ${user.password})
					{
						alert("原密码不正确！");
						flag = false;
					} 
					flag = validatePass1b() && flag;
					flag = validatePass2b() && flag;
					flag = validatePass3b() && flag;
					if(flag == true)
					{
						$("#saveFail").css("opacity","0");
						$("#saveSuccess").css("opacity","0.7");
					}
					else{
						$("#saveSuccess").css("opacity","0");
						$("#saveFail").css("opacity","0.7");
						$("#pform")[0].reset();
					}
					return flag;
				});
				
			});
			function validatePass1f(){
				var v = $("#pass1").val();
				$("#con1").html("");
				if(v == ""){
					$("#info1").removeClass("success");
					$("#info1").addClass("error");
					return false;
				}else{
					$("#info1").removeClass("error");
					$("#info1").addClass("success");
					return true;
				}
			}
			
			function validatePass1b(){
				var v = $("#pass1").val();
				if(v == ""){
					$("#info1").removeClass("success");
					$("#info1").addClass("error");
					$("#con1").html("不能为空");
					return false;
				}else{
					$("#info1").removeClass("error");
					$("#info1").addClass("success");
					$("con1").html("");
					return true;
				}
			}
			
		
			function validatePass2f(){
				var v = $("#pass2").val();
				$("#con2").html("");
				if(v == ""){
					$("#info2").removeClass("success");
					$("#info2").addClass("error");
					return false;
				}else{
					$("#info2").removeClass("error");
					$("#info2").addClass("success");
					
					return true;
				}
			}
			
			
			function validatePass2b(){
				var v = $("#pass2").val();
				if(v == ""){
					$("#info2").removeClass("success");
					$("#info2").addClass("error");
					$("#con2").html("不能为空");
					return false;
				}else{
					$("#info2").removeClass("error");
					$("#info2").addClass("success");
					$("#con2").html("");
					return true;
				}
			}
			function validatePass3f(){
				var v1 = $("#pass3").val();
				var v2 = $("#pass2").val();
				$("#con3").html("");
				if(v1 != v2){
					$("#info3").removeClass("success");
					$("#info3").addClass("error");
					
					return false;
				}else{
					$("#info3").removeClass("error");
					$("#info3").addClass("success");
					return true;
				}
			}
			
			function validatePass3b(){
				var v1 = $("#pass3").val();
				var v2 = $("#pass2").val();
				if(v1 != v2){
					$("#info3").removeClass("success");
					$("#info3").addClass("error");
					$("#con3").html("密码不一致！");
					return false;
				}else{
					$("#info3").removeClass("error");
					$("#info3").addClass("success");
					$("#con3").html("");
					return true;
				}
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
                <li class="active">
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
                        <li><a href="before.action">假期类型管理</a></li>
                       	</c:when>
                    </c:choose>
                    </ul>
                </li>
              	<c:choose>
                	<c:when test="${user.power==2}">
	                <li>
	                    <a href="getAllEmpInfo.action">
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
				<h1>修改登录密码</h1>
			</div>
			<div id="breadcrumb">
				<a href="main.jsp" class="tip-bottom">
                	<i class="icon-home"></i>首页
                </a>
				<a href="#" class="current">修改登录密码</a>
			</div>
			<div class="container-fluid">
				<div class="row-fluid">
						<div class="span12">
							<div class="widget-box">
								<div class="widget-title">
									<span class="icon">
										<i class="icon-align-justify"></i>									
									</span>
									<h5>修改登录密码</h5>
								</div>
								<div class="widget-content nopadding">
									<form id="pform" action="/NeuFinal/changePassword.action" method="post" class="form-horizontal">
	                                    <div id="info1" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	原密码:
	                                        </label>
	                                        <div class="controls">
	                                            <input type="password" name="o_pass" id="pass1" />
	                                        </div><br/>
	                                    	<span id="con1" style="color: red"></span>
	                                    </div>
	                                    <div id="info2" class="control-group">
	                                       <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	新密码:
	                                        </label>
	                                        <div class="controls">
	                                            <input type="password" name="n_pass1" id="pass2" />
	                                        </div><br/>
	                                    	<span id="con2" style="color: red"></span>
	                                    </div>
	                                    <div id="info3" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	确认新密码:
	                                        </label>
	                                        <div class="controls">
	                                            <input type="password" name="n_pass2" id="pass3" />
	                                        </div><br/>
	                                    	<span id="con3" style="color: red"></span>
	                                    </div>
	                                   
	                                    <div class="form-actions">
	                                        <input type="submit" value="提交" class="btn btn-primary" />
	                                        <input type="reset" value="重置" class="btn btn-primary" />
	                                    </div>
	                                </form>
								</div>
							</div>			
						</div>
				</div>	
			</div>	
            <div class="alert alert-error" id="saveFail" >
                保存失败
            </div>
            <div class="alert alert-success" id="saveSuccess" >
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

