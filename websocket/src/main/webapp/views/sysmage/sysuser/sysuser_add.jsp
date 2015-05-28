<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
	<jsp:include page="../../layout/header.jsp" />
	<!-- BEGIN PAGE LEVEL STYLES --> 
	<!-- END PAGE LEVEL STYLES -->
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed">
	<!-- header -->
	<jsp:include page="../../layout/layout_header.jsp" />
	<!-- BEGIN CONTAINER -->
	<div class="page-container">
		<jsp:include page="../../layout/layout_menu.jsp" />
		<!-- BEGIN PAGE -->
		<div class="page-content">
			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<!-- BEGIN PAGE CONTAINER-->
			<div class="container-fluid">
				<!-- BEGIN PAGE HEADER-->
				<div class="row-fluid">
					<div class="span12">
						<!-- BEGIN STYLE CUSTOMIZER -->
						<jsp:include page="../../layout/theme.jsp" /> 
						<!-- END BEGIN STYLE CUSTOMIZER -->   
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->
						<h3 class="page-title">
							用户管理 
							<small> <i class="icon-double-angle-right"></i>
							    <c:choose>
									<c:when test="${user.id == null}">
									用户添加
								    </c:when>
									<c:otherwise>
									用户更新
								    </c:otherwise>
								</c:choose>
							</small>
						</h3>
						<ul class="breadcrumb">
							<li>
								<i class="icon-home"></i>
								<a href="<%=path%>/main">Home</a> 
								<i class="icon-angle-right"></i>
							</li>
							<li>
								<a href="<%=path%>/sysuser/list">用户管理</a> 
								<i class="icon-angle-right"></i>
							</li>
							<li><a href="#">添加新用户</a></li>
						</ul>
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->
				<!-- BEGIN PAGE CONTENT-->
				<div class="row-fluid">
					<div class="span12">
						<c:if test="${not empty edit_success}">
							<div class="alert alert-block alert-success">
								<button type="button" class="close" data-dismiss="alert">
									<i class="icon-remove"></i>
								</button>
								<i class="icon-ok green"></i> <strong class="green"> 成功 </strong>
								<small>${edit_success}</small>
							</div>
						</c:if>
						<c:if test="${not empty edit_failed}">
							<div class="alert alert-block alert-danger">
								<button type="button" class="close" data-dismiss="alert">
									<i class="icon-remove"></i>
								</button>
								<i class="icon-remove red"></i> <strong class="red"> 失败 </strong>
								<small>${edit_failed}</small>
							</div>
						</c:if> 
						<!-- BEGIN SAMPLE FORM PORTLET--> 
						<div class="portlet box blue tabbable">
							<div class="portlet-title">
								<div class="caption">
									<i class="icon-reorder"></i>
									<span class="hidden-480">General Layouts</span>
								</div>
							</div>
							<div class="portlet-body form">
								<div class="tabbable portlet-tabs">
									<ul class="nav nav-tabs">
										<li><a href="#portlet_tab3" data-toggle="tab">Inline</a></li>
										<li><a href="#portlet_tab2" data-toggle="tab">Grid</a></li>
										<li class="active"><a href="#portlet_tab1" data-toggle="tab">Default</a></li>
									</ul>
									<div class="tab-content">
										<div class="tab-pane active" id="portlet_tab1">
											<h4>Login Form</h4>
											<script type="text/javascript">
												function validateAndSubmit(){
													var span = document.getElementById("userExists");
													$.get("<%=path%>/sysuser/check", {username : $("#username").val()}, function(data) {
														if (data.exist) {
															span.innerHTML = "用户名已存在";
															$("#username").focus();
															return;
														} 
													});
													$("#user_form").submit();
												}
											</script>
											<form id="user_form" action="<%=path%>/sysuser/add" method="post"
														onkeydown="if(event.keyCode==13){return false;}">
												<script type="text/javascript">
													function validate(field) {  
														var span = document.getElementById("userExists");
														span.innerHTML = ""; 
														$.get("<%=path%>/sysuser/check", { username : field.value},
																  function(data){
																	if(data.exist)
																		span.innerHTML = "用户名已存在"; 
																	else 
																		span.innerHTML = ""; 
																  });
													}  
												</script>
												<span id="userExists" style="color: #e02222;"></span>
												<div class="input-icon left">
													<i class="icon-user"></i>
													<input type="text" id="username" name="username" value="${user.username}" 
														onblur="validate(this)" class="m-wrap" placeholder="Username">
												</div>
												<div class="input-icon left">                                          
													<i class="icon-lock"></i>
													<input type="password" name="password" class="m-wrap" placeholder="Password">
												</div>
												<div class="input-icon left">
													<i class="icon-ok"></i>
													<input type="password"  class="m-wrap" placeholder="Re-type Your Password">
												</div>
												<div class="input-icon left">
													<i class="icon-envelope"></i>
													<input type="text" name="email" value="${user.email}" class="m-wrap" placeholder="Email">
												</div>
												<div class="input-icon left">
													<i class='icon-male'></i>
													<input type="text" name="name" value="${user.name}" class="m-wrap" placeholder="Name">
												</div>
												<div class="controls">
													<label class="radio">
													<input name="sexMale" class="ace"
														${!user.sexMale ? 'checked' : ''} type="radio" value="false">
														<span class="lbl">&nbsp;<i class='icon-female'>
														</i>&nbsp;女</span>
													</label>
													<label class="radio">
													<input name="sexMale" class="ace"
														${user.sexMale ? 'checked' : ''} type="radio" value="true">
														<span class="lbl">&nbsp;<i class='icon-male'></i>&nbsp;男</span>
													</label>  
												</div>
												<div class="form-actions">
													<button type="submit" class="btn blue" onclick="validateAndSubmit()"><i class="icon-ok"></i> 保存</button>
													<button type="reset" class="btn"><i class="icon-undo"></i> 重置</button>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- END SAMPLE FORM PORTLET-->
					</div>
				</div>
				<!-- END PAGE CONTENT-->
			</div>
			<!-- END PAGE CONTAINER-->
		</div>
		<!-- END PAGE -->
	</div>
	<!-- END CONTAINER -->
	<!-- BEGIN COPYRIGHT -->
	<jsp:include page="../../layout/footer.jsp" />
	<!-- END COPYRIGHT -->
	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
	<!-- BEGIN CORE PLUGINS -->
	<jsp:include page="../../layout/bottom.jsp" />
	<!-- END CORE PLUGINS -->
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="<%=path%>/media/js/app.js" type="text/javascript"></script>
	<!-- END PAGE LEVEL SCRIPTS -->  
	<script>
		jQuery(document).ready(function() {    
		   App.init(); // initlayout and core plugins
		});
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>