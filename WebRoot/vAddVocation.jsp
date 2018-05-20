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
        <script type="text/javascript">
        	$(document).ready(function (){
        		$("form input").blur(function (){
        			validateInput(this);
        		});
        		$("form").submit(function (){
        			var f = true;
        			var a = $("form input"); 
        			var rd = $("#dno").val();
        			var td = $("#sno").val();
        			for(var i = 0; i < a.size(); i++){
        				var t = validateInput(a.get(i));
        				f = f && t;
        			}
        			if(rd != "无限制")
        			{
        				if(rd < td){
        					alert("没有那么多天可以请啦 好好上班吧");
        					f = false;
        				}
        				else if(td < 0)
        				{
        					alert("请假负数是想多上两天班吗？？？？");
        					f = false;
        				} 
        			}
        			else
        			{
        				if(td<0)
        				{
        				alert("请假负数是想多上两天班吗？？？？");
        					f = false;
        				}
        			}
         			return f;
        		});
        		$("#vtype").change(function (){
                    var v = $(this).val();
                    $.ajax({
                    	type:"POST",
                    	url: "/NeuFinal/getRemainDays.action",
                    	data:{"employeeID":${user.employeeID} , "holidayTypeID": $("#vtype").val()},
                    	dataType:"json",
                    	success:function(data){
                    		if(data == null)
                    		$("#dno").val("无限制");
                    		else
                    		$("#dno").val(data);
                    	}
                    });
                });
        	});

        	function validateInput(obj){
        		var v = $(obj).val();
    			if(v == ""){
    				$(obj).parent().parent().removeClass("success");
					$(obj).parent().parent().addClass("error");
					return false;
    			}else{
    				$(obj).parent().parent().removeClass("error");
					$(obj).parent().parent().addClass("success");
					return true;
    			}
        	}
        	
        	function setEndDate(){
        		
        		var strdate = $("#sdate").val();
        		var dayCount = $("#sno").val();
        		var isdate = new Date(strdate.replace(/-/g,"/"));
        		isdate = new Date((isdate/1000 + (86400*dayCount))*1000);
        		var year = isdate.getFullYear();
        		var month = isdate.getMonth() + 1;
        		if(month<10){
        			month = "0" + month;
        		}
        		var date = isdate.getDate();
        		if(date <10){
        			date = "0" + date;
        		}
        		$("#edate").val(year+"-"+month+"-"+date);
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
                <li class="submenu open">
                    <a href="#">
                        <i class="icon icon-time"></i> 
                        <span>休假管理</span> 
                        <!--
                        <span class="label">2</span>
                        -->
                    </a>
                    <ul>
                        <li class="active"><a href="beforeHolidayReq.action">申请休假</a></li>
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
				<h1>申请休假</h1>
			</div>
			<div id="breadcrumb">
				<a href="main.jsp" class="tip-bottom">
                	<i class="icon-home"></i>
                                                    首页
                </a>
				<a href="#" class="current">申请休假</a>
			</div>
			<div class="container-fluid">
				<div class="row-fluid">
						<div class="span12">
							<div class="widget-box">
								<div class="widget-title">
									<span class="icon">
										<i class="icon-align-justify"></i>									
									</span>
									<h5>申请信息</h5>
								</div>
								<div class="widget-content nopadding">
									<form id="eform" action="reqSubmit.action" class="form-horizontal" method="post" >
	                                    <div id="info0" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	员工编号:
	                                        </label>
	                                        <div class="controls">
	                                            <input type="text" name="employeeID" id="dname" value="${user.employeeID }"  readonly/>
	                                        </div>
	                                    </div>
	                                    
	                                    <div id="info1" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	员工姓名:
	                                        </label>
	                                        <div class="controls">
	                                            <input type="text" name="employeeName" id="dname" value="${user.employeeName}"  readonly/>
	                                        </div>
	                                    </div>
	                                    <div id="info2" class="control-group">
	                                        <label class="control-label">
                                                <span style="color: red">*</span>
                                               		 假期类型:
                                            </label>
                                            <div class="controls">
                                                <select id="vtype" name="holidayTypeID">
                                                    <option value="-1">=请选择=</option>
													<c:forEach items="${holist}" var="holiday">
					    								<option value="${holiday.holidayTypeID}">${holiday.holidayTypeName}</option>
					    							</c:forEach>
                                                </select>
                                            </div>
	                                    </div>
	                                    <div id="info3" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	剩余天数:
	                                        </label>
	                                        <div class="controls">
	                                            <input type="text" name="remain" id="dno" value="" readonly/>
	                                        </div>
	                                    </div>
	                                    <div id="info4" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	休假天数:
	                                        </label>
	                                        <div class="controls">
	                                             <input type="number" name="takeOffDays" id="sno" onchange="setEndDate()"/>
	                                        </div>
	                                    </div>
                                        <div id="info5" class="control-group">
                                            <label class="control-label">
                                                <span style="color: red">*</span>
                                               		 休假日期:
                                            </label>
                                            <div class="controls">
                                                 <input class="datepicker" type="date" name="startDay" class="datepicker" id="sdate" data-date-format="yyyy-mm-dd" onchange="setEndDate()"/> -
                                                 <input class="datepicker" type="date" name="endDay" class="datepicker" id="edate" data-date-format="yyyy-mm-dd" readonly/> 
                                            </div>
                                        </div>
	                                    <div class="form-actions">
	                                        <input type="submit"  value="提交" class="btn btn-primary" />
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

