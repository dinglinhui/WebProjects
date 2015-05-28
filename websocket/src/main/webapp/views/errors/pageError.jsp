<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<jsp:include page="../layout/header.jsp" />
<!-- BEGIN PAGE LEVEL STYLES -->
<link href="<%=path%>/media/css/error.css" rel="stylesheet" type="text/css"> 
<!-- END PAGE LEVEL STYLES -->
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed">
	<!-- header -->
	<jsp:include page="../layout/layout_header.jsp" />
	<!-- BEGIN CONTAINER -->
	<div class="page-container">
		<!-- BEGIN PAGE -->
		<div class="page-content" style="margin-left:0px;">
			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<!-- BEGIN PAGE CONTAINER-->
			<div class="container-fluid">
				<!-- BEGIN PAGE HEADER-->
				<div class="row-fluid">
					<div class="span12">
						<!-- BEGIN STYLE CUSTOMIZER -->
						<jsp:include page="../layout/theme.jsp" /> 
						<!-- END BEGIN STYLE CUSTOMIZER -->   
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->
						<h3 class="page-title">
							error Page <small>error page</small>
						</h3>
						<ul class="breadcrumb">
							<li>
								<i class="icon-home"></i>
								<a href="<%=path%>/sysmage/home">Home</a> 
								<i class="icon-angle-right"></i>
							</li>
							<li><a href="#">error page</a></li>
						</ul>
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->
				<!-- BEGIN PAGE CONTENT-->
				<div class="error-container">
					<div class="well">
						<h1 class="grey lighter smaller">
							<span class="blue bigger-125"> <i class="icon-random"></i>
								异常
							</span> 系统运行错误
						</h1>

						<hr>
						<h3 class="lighter smaller">
							我们正在修复 <i
								class="icon-wrench icon-animated-wrench bigger-125"></i> 此问题!请您联系管理员
						</h3>

						<div class="space"></div>

						<div>
							<h4 class="lighter smaller">请尝试以下方法:</h4>

							<ul class="list-unstyled spaced inline bigger-110 margin-15">
								<li><i class="icon-hand-right blue"></i> 读取帮助文件/操作手册</li>

								<li><i class="icon-hand-right blue"></i> 告诉系统管理员相关的信息(是如何产生的这个问题呢?)</li>
							</ul>
						</div>

						<hr>
						<div class="space"></div>

						<div class="center">
							<a href="javascript:history.go(-1);" class="btn btn-grey"> <i class="icon-arrow-left"></i>
								返回
							</a> <a href="#" class="btn btn-primary"> <i
								class="icon-dashboard"></i> 首页
							</a>
						</div>
					</div>
				</div>
				<!-- END PAGE CONTENT-->
			</div>
			<!-- END PAGE CONTAINER-->
		</div>
		<!-- END PAGE -->
	</div>
	<!-- END CONTAINER -->
	<jsp:include page="../layout/footer.jsp" />
	<jsp:include page="../layout/bottom.jsp" />
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
</html>