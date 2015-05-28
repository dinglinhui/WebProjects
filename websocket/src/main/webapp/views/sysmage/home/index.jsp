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
	<link href="<%=path%>/media/css/jquery.gritter.css" rel="stylesheet" type="text/css"/>
	<link href="<%=path%>/media/css/daterangepicker.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/media/css/fullcalendar.css" rel="stylesheet" type="text/css"/>
	<link href="<%=path%>/media/css/jqvmap.css" rel="stylesheet" type="text/css" media="screen"/>
	<link href="<%=path%>/media/css/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/> 
	<link href="<%=path%>/media/css/login-soft.css" rel="stylesheet" type="text/css"/>
	<!-- END PAGE LEVEL STYLES -->
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed">
	<!-- header -->
	<jsp:include page="../../layout/layout_header.jsp" />
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
						<jsp:include page="../../layout/theme.jsp" /> 
						<!-- END BEGIN STYLE CUSTOMIZER -->   
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->
						<h3 class="page-title">
							BBC NEWS <small>Hello World！</small>
						</h3>
						<%-- <ul class="breadcrumb">
							<li>
								<i class="icon-home"></i>
								<a href="<%=path%>/main">Home</a> 
								<i class="icon-angle-right"></i>
							</li>
							<li><a href="#">Dashboard</a></li>
						</ul> --%>
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->
				<!-- BEGIN PAGE CONTENT-->
				<div class="row-fluid">

					<div class="span12 news-page">
						<h2>新闻分类</h2>
						<div class="row-fluid top-news">

							<div class="span3">

								<a href="#" class="btn red">

								<span style="font-weight:bold;">今日头条</span>

								<em>更新时间： April 16, 2013</em>

								<em>

								<i class="icon-tags"></i>

								Money, Business, Google

								</em>

								<i class="icon-briefcase top-news-icon"></i>

								</a>

							</div>

							<div class="span3">

								<a href="#" class="btn green">

								<span>每周要闻</span>

								<em>更新时间： April 15, 2013</em>

								<em>

								<i class="icon-tags"></i>

								Internet, Music, People

								</em>

								<i class="icon-music top-news-icon"></i>                             

								</a>

							</div>

							<div class="span3">

								<a href="#" class="btn blue">

								<span>国内新闻</span>

								<em>更新时间： April 14, 2013</em>

								<em>

								<i class="icon-tags"></i>

								USA, Business, Apple

								</em>

								<i class="icon-globe top-news-icon"></i>                             

								</a>

							</div>

							<div class="span3">

								<a href="#" class="btn yellow">

								<span>国际新闻</span>

								<em>更新时间： April 13, 2013</em>

								<em>

								<i class="icon-tags"></i>

								Education, Students, Canada

								</em>

								<i class="icon-globe top-news-icon"></i>                              

								</a>

							</div>

						</div>
						
						<div class="row-fluid top-news">

							<div class="span3">

								<a href="#" class="btn green">

								<span>娱乐</span>

								<em>更新时间： April 15, 2013</em>

								<em>

								<i class="icon-tags"></i>

								Internet, Music, People

								</em>

								<i class="icon-music top-news-icon"></i>                             

								</a>

							</div>

							<div class="span3">

								<a href="#" class="btn purple">

								<span>科技</span>

								<em>更新时间： April 13, 2013</em>

								<em>

								<i class="icon-tags"></i>

								Education, Students, Canada

								</em>

								<i class="icon-book top-news-icon"></i>                              

								</a>

							</div>

							<div class="span3">

								<a href="#" class="btn red">

								<span>财经</span>

								<em>更新时间： April 16, 2013</em>

								<em>

								<i class="icon-tags"></i>

								Money, Business, Google

								</em>

								<i class="icon-briefcase top-news-icon"></i>

								</a>

							</div>

							<div class="span3">
								<div class="dropdown" id="header_inbox_bar">
									<a href="#" class="dropdown-toggle btn blue" data-toggle="dropdown">
										<span>更多分类</span>
	
										<em>更新时间： April 14, 2013</em>
		
										<em>
		
										<i class="icon-tags"></i>
		
										USA, Business, Apple
		
										</em>
		
										<i class="icon-globe top-news-icon"></i>                             
									
									</a>
										
										<ul class="dropdown-menu extended notification">
		
					
											<li class="external">
					
												<a href="#">体育<i class="m-icon-swapright"></i></a>
					
											</li>
											<li class="external">
					
												<a href="#">房产<i class="m-icon-swapright"></i></a>
					
											</li>
											<li class="external">
					
												<a href="#">社会 <i class="m-icon-swapright"></i></a>
					
											</li>
											<li class="external">
					
												<a href="#">游戏 <i class="m-icon-swapright"></i></a>
					
											</li>
											<li class="external">
					
												<a href="#">汽车 <i class="m-icon-swapright"></i></a>
					
											</li>
					
										</ul>
								</div>

							</div>

						</div>

						<!-- <h1>Recent News</h1> -->
						
						<HR style="border:1 dashed #987cb9" width="100%" color=#987cb9 SIZE=1>
						
						<div class="row-fluid">
						
							<div class="span4" style="margin-left: 9px; margin-right: 9px;">

								<div id="myCarousel" class="carousel slide">

									<!-- Carousel indicators

										<ol class="carousel-indicators">

										 <li data-target="#myCarousel" data-slide-to="0" class="active"></li>

										 <li data-target="#myCarousel" data-slide-to="1"></li>

										 <li data-target="#myCarousel" data-slide-to="2"></li>

										</ol>

										-->

									<!-- Carousel items -->

									<div class="carousel-inner">

										<div class="active item">

											<img src="<%=path%>/media/image/image5.jpg" alt="">

											<div class="carousel-caption" style="padding-top: 7px; padding-bottom: 3px;">

												<h4><a href="page_news_item.html">哈姆雷特宫</a></h4>

											</div>

										</div>

										<div class="item">

											<img src="<%=path%>/media/image/image2.jpg" alt="">

											<div class="carousel-caption" style="padding-top: 7px; padding-bottom: 3px;">

												<h4><a href="page_news_item.html">落叶归根</a></h4>

											</div>

										</div>

										<div class="item">

											<img src="<%=path%>/media/image/image1.jpg" alt="">

											<div class="carousel-caption" style="padding-top: 7px; padding-bottom: 3px;">

												<h4><a href="page_news_item.html">风生水起</a></h4>

											</div>

										</div>

									</div>

									<!-- Carousel nav -->

									<a class="carousel-control left" href="#myCarousel" data-slide="prev">

									<i class="m-icon-big-swapleft m-icon-white"></i>

									</a>

									<a class="carousel-control right" href="#myCarousel" data-slide="next">

									<i class="m-icon-big-swapright m-icon-white"></i>

									</a>

								</div>

							</div>

							<!--end span5-->
							
							<c:forEach items="${newstype}" var="t">
								<div class="span4" style="margin-left: 9px; margin-right: 9px;">
									<div>
										<div class="portlet box ${t.misc1}">
											<div class="portlet-title">
												<div class="caption">${t.misc2}${t.name}</div>
												<div class="tools">
													<a href="javascript:;" class="collapse"></a>
													<a href="#portlet-config" data-toggle="modal" class="config"></a>
													<a href="javascript:;" class="reload"></a>
													<a href="javascript:;" class="remove"></a>
												</div>
											</div>
											<div class="portlet-body">
												<ul class="longList">
													<c:forEach items="${news}" var="m">
													
														<c:if test="${m.type.id==t.id}">
														
															<c:if test="${m.duang}">
																<li>
																	<a href="<%=path%>/sysnews/news?id=${m.id}" target="_blank">
																		<b>${m.title}</b>
																	</a>
																</li>
															</c:if>
															<c:if test="${!m.duang}">
																<li>
																	<a href="<%=path%>/sysnews/news?id=${m.id}" target="_blank">
																		${m.title}
																	</a>
																</li>
															</c:if>
															
															</c:if>
														
													</c:forEach>
												</ul>
												<div class="clearfix">
												</div>
											</div>
										</div>
									</div>
							        
								</div>
							</c:forEach>

							<!--end span4-->

						</div>
						
						<HR style="border:1 dashed #987cb9" width="100%" color=#987cb9 SIZE=1>

						<div class="space20"></div>

						<span id="message">${message}</span>
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
	<script src="<%=path%>/media/js/login.js" type="text/javascript"></script>
	<!-- END PAGE LEVEL SCRIPTS -->
	<script>
		jQuery(document).ready(function() {    
		   App.init(); // initlayout and core plugins
		   //Login.init();
		   //news();
		   
		});
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>