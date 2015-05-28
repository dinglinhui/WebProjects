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

					<div class="span12 news-page blog-page">

						<div class="row-fluid">

							<div class="span8 blog-tag-data">

								<h3 id="newstitle">${news.title}</h3>

								<%-- <img src="<%=path%>/media/image/item_img1.jpg" alt=""> --%>

								<div class="row-fluid">

									<div class="span6">

										<ul class="unstyled inline blog-tags">

											<li>

												<i class="icon-tags"></i> 

												<a href="#">Technology</a> 

												<a href="#">Education</a>

												<a href="#">Internet</a>

											</li>

										</ul>

									</div>

									<div class="span6 blog-tag-data-inner">

										<ul class="unstyled inline">

											<li><i class="icon-calendar"></i> <a href="#">${news.created}</a></li>

											<li><i class="icon-comments"></i> <a href="#">38 Comments</a></li>

										</ul>

									</div>

								</div>

								<div class="news-item-page">
								
									<div id="newscontent">${news.content}</div>
									
								</div>
								
								<br>
								
								<ul class="unstyled inline sidebar-tags">
		
									<li><a href="#"><i class="icon-tags"></i> 感动</a></li>

									<li><a href="#"><i class="icon-tags"></i> 愤怒</a></li>

									<li><a href="#"><i class="icon-tags"></i> 炒作</a></li>

									<li><a href="#"><i class="icon-tags"></i> 小编坑爹</a></li>

									<li><a href="#"><i class="icon-tags"></i> 值得收藏</a></li>

									<li><a href="#"><i class="icon-tags"></i> 正能量</a></li>

									<li><a href="#"><i class="icon-tags"></i> 负能量</a></li>

									<li><a href="#"><i class="icon-tags"></i> 元芳你怎么看</a></li>

									<li><a href="#"><i class="icon-tags"></i> 标题党</a></li>

									<li><a href="#"><i class="icon-tags"></i> 科技</a></li>

									<li><a href="#"><i class="icon-tags"></i> 娱乐</a></li>

									<li><a href="#"><i class="icon-tags"></i> 体育</a></li>

									<li><a href="#"><i class="icon-tags"></i> 财经</a></li>

									<li><a href="#"><i class="icon-tags"></i> 军事</a></li>

								</ul>

								<h3>评论</h3>
								<hr>

								<div class="media">

									<div class="media-body">

										<c:forEach items="${comment}" var="m">
										
											<h4 class="media-heading">张三 <span>${m.created} / <a href="#">支持（${m.support}）</a><a href="#">反对（${m.against}）</a></span></h4>

											<p> ${m.comment} </p>
											
											<hr>

										</c:forEach>

										<!--end media-->

									</div>

								</div>

								<div class="post-comment">

									<h3>元芳你怎么看？</h3>

									<form action="<%=path%>/sysnews/news" class="form-horizontal" id="newsadd_form" method="post"
														onkeydown="if(event.keyCode==13){return false;}">

										<input class="m-wrap medium" name="parentId" type="text" value="${news.id}" style="display:none;" readonly />
										
										<textarea name="comment" class="span10 m-wrap" rows="8"></textarea>

										<p><button class="btn blue" type="submit">评论</button></p>

									</form>

								</div>

							</div>

							<div class="span4">

								<h2>新闻类别</h2>

								<div class="top-news">

									<a href="#" class="btn green">

									<span>每周要闻</span>

									<em>Posted on: April 15, 2013</em>

									<em>

									<i class="icon-tags"></i>

									Internet, Music, People

									</em>

									<i class="icon-music top-news-icon"></i>                             

									</a>

									<a href="#" class="btn yellow">

									<span>科技</span>

									<em>Posted on: April 13, 2013</em>

									<em>

									<i class="icon-tags"></i>

									Education, Students, Canada

									</em>

									<i class="icon-book top-news-icon"></i>                              

									</a>

									<a href="#" class="btn red">

									<span>今日头条</span>

									<em>Posted on: April 16, 2013</em>

									<em>

									<i class="icon-tags"></i>

									Money, Business, Google

									</em>

									<i class="icon-briefcase top-news-icon"></i>

									</a>

									<a href="#" class="btn blue">

									<span>娱乐</span>

									<em>Posted on: April 14, 2013</em>

									<em>

									<i class="icon-tags"></i>

									USA, Business, Apple

									</em>

									<i class="icon-globe top-news-icon"></i>                             

									</a>

								</div>

								<div class="space20"></div>

								<div class="space20"></div>

								<h2></h2>

								<div class="tabbable tabbable-custom">

									<ul class="nav nav-tabs">

										<li class="active"><a data-toggle="tab" href="#tab_1_1">Section 1</a></li>

										<li class=""><a data-toggle="tab" href="#tab_1_2">Section 2</a></li>

										<li class=""><a data-toggle="tab" href="#tab_1_3">Section 3</a></li>

									</ul>

									<div class="tab-content">

										<div id="tab_1_1" class="tab-pane active">

											<p>I'm in Section 1.</p>

											<p>

												Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat.

											</p>

										</div>

										<div id="tab_1_2" class="tab-pane">

											<p>Howdy, I'm in Section 2.</p>

											<p>

												Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat. Ut wisi enim ad minim veniam, quis nostrud exerci tation.

											</p>

										</div>

										<div id="tab_1_3" class="tab-pane">

											<p>Howdy, I'm in Section 3.</p>

											<p>

												Duis autem vel eum iriure dolor in hendrerit in vulputate.

												Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat

											</p>

										</div>

									</div>

								</div>

								<div class="space20"></div>

								<h2>来自新浪</h2>

								<div class="blog-twitter">

									<div class="blog-twitter-block">

										<a href="">@keenthemes</a> 

										<p>At vero eos et accusamus et iusto odio.</p>

										<a href="#"><em>http://t.co/sBav7dm</em></a> 

										<span>5 hours ago</span>

										<i class="icon-twitter blog-twiiter-icon"></i>

									</div>

									<div class="blog-twitter-block">

										<a href="">@keenthemes</a> 

										<p>At vero eos et accusamus et iusto odio.</p>

										<a href="#"><em>http://t.co/sBav7dm</em></a> 

										<span>8 hours ago</span>

										<i class="icon-twitter blog-twiiter-icon"></i>

									</div>

									<div class="blog-twitter-block">

										<a href="">@keenthemes</a> 

										<p>At vero eos et accusamus et iusto odio.</p>

										<a href="#"><em>http://t.co/sBav7dm</em></a> 

										<span>12 hours ago</span>

										<i class="icon-twitter blog-twiiter-icon"></i>

									</div>

								</div>

								<div class="space20"></div>

								<h2>浏览者</h2>

								<ul class="unstyled blog-images">

									<li>

										<a class="fancybox-button" data-rel="fancybox-button" title="390 x 220 - keenthemes.com" href="<%=path%>/media/image/1.jpg">

										<img alt="" src="<%=path%>/media/image/1.jpg">

										</a>

									</li>

									<li><a href="#"><img alt="" src="<%=path%>/media/image/2.jpg"></a></li>

									<li><a href="#"><img alt="" src="<%=path%>/media/image/3.jpg"></a></li>

									<li><a href="#"><img alt="" src="<%=path%>/media/image/4.jpg"></a></li>

									<li><a href="#"><img alt="" src="<%=path%>/media/image/5.jpg"></a></li>

									<li><a href="#"><img alt="" src="<%=path%>/media/image/6.jpg"></a></li>

									<li><a href="#"><img alt="" src="<%=path%>/media/image/8.jpg"></a></li>

									<li><a href="#"><img alt="" src="<%=path%>/media/image/10.jpg"></a></li>

									<li><a href="#"><img alt="" src="<%=path%>/media/image/11.jpg"></a></li>

									<li><a href="#"><img alt="" src="<%=path%>/media/image/1.jpg"></a></li>

									<li><a href="#"><img alt="" src="<%=path%>/media/image/2.jpg"></a></li>

									<li><a href="#"><img alt="" src="<%=path%>/media/image/7.jpg"></a></li>

								</ul>

							</div>

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
	<script src="<%=path%>/media/js/login-soft.js" type="text/javascript"></script>
	<!-- END PAGE LEVEL SCRIPTS --> 
	<%-- <script type="text/javascript">
		/*var news = function () {
			
			var title = document.getElementById("newstitle");
			var content= document.getElementById("newscontent");
            
            var url = "<%=path%>/sysnews/news";

			//$.post(url, {}, function (res) {
			$.post(url, { newsid: "2" },

					function (data){
				
						var parsedJson = jQuery.parseJSON(data);
						
						title.innerHTML = parsedJson.title;
						content.innerHTML= parsedJson.content;
						
					}, "json");
		}*/
		/* $.getJSON("http://www.tuling123.com/openapi/api",{key:"e8210d16734c1b50768cbe6460607223",info:text}, function(json){
	
	    	var time_new = time.toString('MMM dd, yyyy hh:mm');
	    	if(json.text==null){
	    		return;
	    	}else{
	        	  var tpll='';
	        	  tpll += '<li class="in">';
	              tpll += '<img class="avatar" alt="" src="../media/image/avatar2.jpg"/>';
	              tpll += '<div class="message">';
	              tpll += '<span class="arrow"></span>';
	              tpll += '<a href="#" class="name">Bob Nilson</a>&nbsp;';
	              tpll += '<span class="datetime">at ' + time_new + '</span>';
	              tpll += '<span class="body">';
	              tpll += json.text;
	              tpll += '</span>';
	              tpll += '</div>';
	              tpll += '</li>';
	    	}
	    	var msgg = list.append(tpll);
	        input.val("");
	        $('.scroller', cont).slimScroll({
	            scrollTo: list.height()
	        });
	
	    }); */
	</script>  --%>
	<script>
		jQuery(document).ready(function() {     
		  App.init();
		  news();
		});
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>