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
	<link href="<%=path%>/media/css/jquery.gritter.css" rel="stylesheet" type="text/css"/>
	<link href="<%=path%>/media/css/daterangepicker.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/media/css/fullcalendar.css" rel="stylesheet" type="text/css"/>
	<link href="<%=path%>/media/css/jqvmap.css" rel="stylesheet" type="text/css" media="screen"/>
	<link href="<%=path%>/media/css/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>
	<!-- END PAGE LEVEL STYLES -->
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed" style="background-color:#fff;overflow-x : hidden;overflow-y : hidden;">
	<!-- header -->
	<!-- BEGIN CONTAINER -->
	<div class="page-container">
		<!-- BEGIN PAGE -->
		<!-- <div class="page-content"> -->
			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<!-- BEGIN PAGE CONTAINER-->
			<div class="container-fluid">
				<!-- BEGIN PAGE HEADER-->
				<!-- END PAGE HEADER-->
				<!-- BEGIN PAGE CONTENT-->
				<div class="clearfix"></div>
				<div class="row-fluid">
					<div class="span6">
						<!-- BEGIN PORTLET-->
						<div class="portlet">
							<div class="portlet-title line">
								<div class="caption"><i class="icon-comments"></i>Chats</div>
								<div class="tools">
									<a href="" class="collapse"></a>
									<a href="#portlet-config" data-toggle="modal" class="config"></a>
									<a href="" class="reload"></a>
									<a href="" class="remove"></a>
								</div>
							</div>
							<div class="portlet-body" id="chats">
								<div class="scroller" data-height="435px" data-always-visible="1" data-rail-visible1="1">
									<ul class="chats">
										<li class="in">
											<img class="avatar" alt="" src="<%=path%>/media/image/avatar3.jpg" />
											<div class="message">
												<span class="arrow"></span>
												<a href="#" class="name">Richard Doe</a>
												<span class="datetime">at Jul 25, 2012 11:09</span>
												<span class="body">
												Lorem ipsum dolor sit amet, consectetuer adipiscing elit, 
												sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.
												</span>
											</div>
										</li>
										<li class="out">
											<img class="avatar" alt="" src="<%=path%>/media/image/avatar1.jpg" />
											<div class="message">
												<span class="arrow"></span>
												<a href="#" class="name">Bob Nilson</a>
												<span class="datetime">at Jul 25, 2012 11:09</span>
												<span class="body">
												Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. sed diam nonummy nibh euismod tincidunt ut laoreet.
												</span>
											</div>
										</li>
									</ul>
								</div>
								<div class="chat-form">
									<div class="input-cont">   
										<input class="m-wrap" type="text" placeholder="Type a message here..." />
									</div>
									<div class="btn-cont"> 
										<span class="arrow"></span>
										<a href="" class="btn blue icn-only"><i class="icon-ok icon-white"></i></a>
									</div>
								</div>
							</div>
						</div>
						<!-- END PORTLET-->
					</div>
				<!-- </div> -->
				<!-- END PAGE CONTENT-->
			</div>
			<!-- END PAGE CONTAINER-->
		</div>
		<!-- END PAGE -->
	</div>
	<!-- END CONTAINER -->
	<!-- BEGIN COPYRIGHT -->
	<jsp:include page="../layout/footer.jsp" />
	<!-- END COPYRIGHT -->
	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
	<!-- BEGIN CORE PLUGINS -->
	<jsp:include page="../layout/bottom.jsp" />
	<!-- END CORE PLUGINS -->
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script src="<%=path%>/media/js/jquery.vmap.js" type="text/javascript"></script>   
	<script src="<%=path%>/media/js/jquery.vmap.russia.js" type="text/javascript"></script>
	<script src="<%=path%>/media/js/jquery.vmap.world.js" type="text/javascript"></script>
	<script src="<%=path%>/media/js/jquery.vmap.europe.js" type="text/javascript"></script>
	<script src="<%=path%>/media/js/jquery.vmap.germany.js" type="text/javascript"></script>
	<script src="<%=path%>/media/js/jquery.vmap.usa.js" type="text/javascript"></script>
	<script src="<%=path%>/media/js/jquery.vmap.sampledata.js" type="text/javascript"></script>  
	<script src="<%=path%>/media/js/jquery.flot.js" type="text/javascript"></script>
	<script src="<%=path%>/media/js/jquery.flot.resize.js" type="text/javascript"></script>
	<script src="<%=path%>/media/js/jquery.pulsate.min.js" type="text/javascript"></script>
	<script src="<%=path%>/media/js/date.js" type="text/javascript"></script>
	<script src="<%=path%>/media/js/daterangepicker.js" type="text/javascript"></script>     
	<script src="<%=path%>/media/js/jquery.gritter.js" type="text/javascript"></script>
	<script src="<%=path%>/media/js/fullcalendar.min.js" type="text/javascript"></script>
	<script src="<%=path%>/media/js/jquery.easy-pie-chart.js" type="text/javascript"></script>
	<script src="<%=path%>/media/js/jquery.sparkline.min.js" type="text/javascript"></script> 
	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="<%=path%>/media/js/app.js" type="text/javascript"></script>
	<script src="<%=path%>/media/js/index.js" type="text/javascript"></script>
	<!-- END PAGE LEVEL SCRIPTS -->  
	<script>
		jQuery(document).ready(function() {    
		    App.init(); // initlayout and core plugins
			Index.initChat();
		});
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>