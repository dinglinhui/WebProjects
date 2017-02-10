<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ATSpro</title>
<link href="<%=basePath%>view/css/reset.css" rel="stylesheet" type="text/css" media="screen" />
<link href="<%=basePath%>view/css/styles.css" rel="stylesheet" type="text/css" media="screen" />
<link href="<%=basePath%>view/css/print.css" rel="stylesheet" type="text/css" media="print" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>view/css/brower.css" media="all" />

<script type="text/javascript" src="<%=basePath%>resources/jquery/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=basePath%>view/js/brower.js"></script>
<script type="text/javascript" src="<%=basePath%>view/js/custom-menu.js"></script>

<link href="<%=basePath%>view/css/onebyone.css" rel="stylesheet" type="text/css" media="screen" />
<script src="<%=basePath%>view/js/jquery.cycle.all.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$('#slider').cycle({
			fx : 'scrollLeft',
			timeout : 4100,
			speed : 500,
			pager : '#cyclenav'
		});
	});
</script>
<link rel="stylesheet" href="<%=basePath%>view/css/coda-slider-2.0.css" type="text/css"
	media="screen" />
<script src="<%=basePath%>view/js/jquery.easing.1.3.js" type="text/javascript"></script>
<script src="<%=basePath%>view/js/jquery.coda-slider-2.0.js" type="text/javascript"></script>
<script type="text/javascript">
	$().ready(function() {
		$('#coda-slider-1').codaSlider();
	});
</script>
<script src="<%=basePath%>view/js/jquery.ui.core.js" type="text/javascript"></script>
<script src="<%=basePath%>view/js/jquery.ui.widget.js" type="text/javascript"></script>
<script src="<%=basePath%>view/js/jquery.ui.accordion.js" type="text/javascript"></script>
<script type="text/javascript">
	jQuery(function() {
		jQuery("#accordion").accordion({
			autoHeight : false,
			navigation : true
		});
	});
</script>
<link rel="stylesheet" href="<%=basePath%>view/css/prettyPhoto.css" type="text/css"
	media="screen" />
<script src="<%=basePath%>view/js/jquery.prettyPhoto.js" type="text/javascript"></script>
<script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
		$("a[rel^='prettyPhoto']").prettyPhoto();
	});
</script>
<script src="<%=basePath%>view/js/image-hover.js" type="text/javascript"></script>
<script src="<%=basePath%>view/js/mailmask.js" type="text/javascript"></script>

</head>
<body>
	<div id="wrapper">
		<!-- start header -->
		<div id="header">
			<div class="header-content">
				<a class="logo ir" rel="home" href="/">view</a>
				<ul class="topnav alignleft">
					<li class="first active"><a href="#" title="Home"><s:text name="view.header.topnav.home"></s:text></a></li>
					<li><a href="#" title="About"><s:text name="view.header.topnav.about"></s:text></a>
						<div class="subnav subnav3">
							<div class="clearfix" id="home">
								<dl class="alignleft">
									<dd>
										<a href="#" title="Cycle Slider with Easing function">Easing
											Function</a>
									</dd>
									<dd>
										<a href="#" title="Full Width Image Slider">Full Width
											Image</a>
									</dd>
								</dl>
							</div>
						</div></li>
					<li><a href="#" title="Work"><s:text name="view.header.topnav.work"></s:text></a>
						<div class="subnav subnav1">
							<div class="clearfix" id="services">
								<dl class="alignleft">
									<dt>Shortcodes</dt>
									<dd>
										<a href="#" title="Typography &amp; Elements">Typography
											&amp; Elements</a>
									</dd>
									<dd>
										<a href="#" title="Columns">Columns</a>
									</dd>
									<dd>
										<a href="#" title="Price Table">Price Table</a>
									</dd>
									<dt class="head">Navi Options</dt>
									<dd>
										<a href="#" title="On Click">OnClick</a>
									</dd>
								</dl>
							</div>
						</div></li>
					<li><a href="#" title="Blog"><s:text name="view.header.topnav.blog"></s:text></a>
						<div class="subnav subnav3">
							<div class="clearfix" id="blog">
								<dl class="alignleft">
									<dd>
										<a href="#" title="Overview">Overview</a>
									</dd>
									<dd>
										<a href="#" title="Single Blog Entry">Single Blog Entry</a>
									</dd>
								</dl>
							</div>
						</div></li>
					<li><a href="#" title="Contact"><s:text name="view.header.topnav.contact"></s:text></a>
						<div class="subnav subnav3">
							<div class="clearfix" id="company">
								<dl class="alignleft">
									<dd>
										<a href="#" title="About Us">About Us</a>
									</dd>
									<dd>
										<a href="#" title="Our Team">Our Team</a>
									</dd>
								</dl>
							</div>
						</div></li>
				</ul>
				<ul class="topnav2 alignright">
					<!-- 指定URL为英文的语言设置 -->
					<s:url id="english" action="system!initLocale">
						<!-- 参数request_locale设置英文 -->
						<s:param name="reqCode">en_US</s:param>
					</s:url>
					<!-- 英文语言设置的链接定义 -->
					<li><s:a href="%{english}" title="English">English</s:a></li>
					
					<!-- 指定URL为中文的语言设置 -->
					<s:url id="chinese" action="system!initLocale">
						<!-- 参数request_locale设置中文 -->
						<s:param name="reqCode">zh_CN</s:param>
					</s:url>
					<!-- 中文语言设置的链接定义 -->
					<li><s:a href="%{chinese}" title="Chinese">中文</s:a></li>
				</ul>
			</div>
			<!-- <div id="header-bottom" class="clear"></div> -->
		</div>
		<!-- end header -->

		<!-- start content -->
		<div id="container" class="clearfix">
			<div class="content">
				<!-- start Slidebox -->
				<div id="Slidebox">
					<!--flash begin-->
					
					<div id="flashBg">
						<div id="flashLine">
							<div id="flash">
								<%-- <c:forEach items="${pictureView.listPic}" var="picture">
									<%=basePath%>${picture.imageplace}${picture.imagename}
									<a name="#ffffff" id="${picture.usedid}" target="_blank" href="#" style="display:block;background: url('<%=basePath%>${picture.imageplace}${picture.imagename} }') no-repeat scroll 50% 0 transparent;"></a> 
								</c:forEach> --%>
								<a name="#ffffff" id="flash1" target="_blank" href="#" style="display:block;background: url('<%=basePath%>view/images/slides/rowboat.jpg') no-repeat scroll 50% 0 transparent;"></a> 
								<a name="#ffffff" id="flash2" target="_blank" href="#" style="display:block;background: url('<%=basePath%>view/images/slides/feature-08.jpg') no-repeat scroll 50% 0 transparent;"></a>
								<a name="#ffffff" id="flash3" target="_blank" href="#" style="display:block;background: url('<%=basePath%>view/images/slides/bg-initiatives-index.jpg') no-repeat scroll 50% 0 transparent;"></a> 
								<a name="#ffffff" id="flash4" target="_blank" href="#" style="display:block;background: url('<%=basePath%>view/images/slides/google-impact-award.jpg') no-repeat scroll 50% 0 transparent;"></a>
								<a name="#ffffff" id="flash5" target="_blank" href="#" style="display:block;background: url('<%=basePath%>view/images/slides/WWF-Case-Story-homepage-large-screen.jpg') no-repeat scroll 50% 0 transparent;"></a> 
								<a name="#ffffff" id="flash6" target="_blank" href="#" style="display:block;background: url('<%=basePath%>view/images/slides/GPN112363_elephants_(c)_Martin_Harvey_WWF_Canon.jpg') no-repeat scroll 50% 0 transparent;"></a>		
								
								<div class="flash_bar">
									<div class="dq" id="f1" onclick="changeflash(1)"></div>
									<div class="no" id="f2" onclick="changeflash(2)"></div>
									<div class="no" id="f3" onclick="changeflash(3)"></div>
									<div class="no" id="f4" onclick="changeflash(4)"></div>
									<div class="no" id="f5" onclick="changeflash(5)"></div>
									<div class="no" id="f6" onclick="changeflash(6)"></div>
								</div>
							</div>
						</div>
					</div>
					<!--flash end-->
				</div>
				<!--Slide & Banner  End-->
				
				<div class="content_new"> 
					<div id="quote" class="clear">
						<div class="coda-slider-wrapper">
							<div class="coda-slider preload" id="coda-slider-1">
								<div class="panel">
									<div class="panel-wrapper">
										<div class="logos alignleft">
											<img src="<%=basePath%>view/images/logos/audiojungle.jpg" alt="audiojungle" />
										</div>
										<div class="quote">
											<p>Over the last eighteen months our sales have increased
												by 200%, since the launch of our new website. We have to say,
												it has made us glad to have chosen Tilability! Lorem ipsum
												dolor sit amet, consetetur sadipscing elitr, sed diam nonumy
												eirmod tempor invidunt.â</p>
											<p class="quoter">John Doe</p>
										</div>
									</div>
								</div>
								<div class="panel">
									<div class="panel-wrapper">
										<div class="logos alignleft">
											<img src="<%=basePath%>view/images/logos/themeforest.jpg" alt="themeforest" />
										</div>
										<div class="quote">
											<p>Lorem ipsum dolor sit amet, consetetur sadipscing
												elitr, sed diam nonumy eirmod tempor invidunt. Stet clita
												kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor
												sit amet et justo duo dolor. Stet clita kasd gubergren, no
												sea takimata sanctus est Lorem ipsum dolor sit amet et justo
												duo dolor.â</p>
											<p class="quoter">Max Mustermann</p>
										</div>
									</div>
								</div>
								<div class="panel">
									<div class="panel-wrapper">
										<div class="logos alignleft">
											<img src="<%=basePath%>view/images/logos/photodune.jpg" alt="photodune" />
										</div>
										<div class="quote">
											<p>Duis autem vel eum iriure dolor in hendrerit in
												vulputate velit esse molestie consequat, vel illum dolore eu
												feugiat nulla facilisis at vero eros et accumsan et iusto
												odio dignissim qui blandit praesent luptatum zzril delenit
												augue duis dolore te feugait nulla facilisi. Stet clita kasd
												gubergren, no sea takimata sanctus est Lorem ipsum dolor sit
												amet et justo duo dolor. Lorem ipsum dolor sit amet,
												consetetur sadipscing elitr.â</p>
											<p class="quoter">Amy McDonald</p>
										</div>
									</div>
								</div>
								<!-- end panel -->
							</div>
						</div>
					</div>
					<!-- end quote -->
					<div class="col1-3">
					<h3>Our Services</h3>
					<div id="accordion">
						<h6>
							<a href="#section1">Tempor Invidunt</a>
						</h6>
						<div>
							<p>
								Phasellus egestas accumsan laoreet. Tincidunt ipsum sit amet
								urna egestas rhoncus. Lorem ipsum dolor sit amet, consetetur ut
								sadip elitr, sed diam. <a href="#" onclick="return false"
									title="Link">Read more</a>
							</p>
						</div>
						<h6>
							<a href="#section2">Lorem Ipsum</a>
						</h6>
						<div>
							<p>
								Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed
								diam nonumy eirmod tempor invidunt ut labore et dolore magna
								aliquyam erat, sed diam voluptua. <a href="#"
									onclick="return false" title="Link">Read more</a>
							</p>
						</div>
						<h6>
							<a href="#section3">Suspendisse Semper</a>
						</h6>
						<div>
							<p>
								At vero eos et accusam et justo duo dolores et ea rebum. <a
									href="#" onclick="return false" title="Link">Read more</a>
							</p>
						</div>
					</div>
				</div>
				<div class="col1-3">
					<h3>Why Choose Us?</h3>
					<div class="pics">
						<div class="proj-img">
							<a href="<%=basePath%>view/images/shutterstock_84787564.jpg" title="Image Title"
								rel="prettyPhoto"></a><img src="<%=basePath%>view/images/image1-s.jpg"
								alt="Shutterstock 84787564" /><i>hover background</i>
						</div>
					</div>
					<p>Ante ipsum primis in faucibus orci luctus et ultrices
						posuere cubilia. Nam quis cursus massa. Dapibus, turpis quis
						ultricies tincidunt , elit augue facilisis turpis, et suscipit
						nibh eros eget tortor.</p>
					<p>
						<a href="#" onclick="return false" title="Link">more about us</a>
					</p>
				</div>
				<div class="col1-3 last">
					<h3>From the Blog</h3>
					<div class="date alignleft">
						<p>
							28<br /> <span class="bold">FEB</span>
						</p>
					</div>
					<div class="next-to-date">
						<h4>Sed Sem Pharetra Luctus</h4>
						<p>
							Pellentesque id neque ut mauris bibendum tempor ut eu nibh turpis
							velit porttitor arcu. <a href="single-post.html"
								title="Single Blog Entry">Read more</a>
						</p>
					</div>
					<div class="date alignleft">
						<p>
							24<br /> <span class="bold">FEB</span>
						</p>
					</div>
					<div class="next-to-date">
						<h4>Vulputate Velit Esse Molestie</h4>
						<p>
							Duis autem vel eum iriure dolor in hendrerit in vulputate velit
							esse molestie consequat, vel illum dolore. <a
								href="single-post.html" title="Single Blog Entry">Read more</a>
						</p>
					</div>
					<div class="date alignleft">
						<p>
							03<br /> <span class="bold">FEB</span>
						</p>
					</div>
					<div class="next-to-date">
						<h4>Sed Sem Pharetra Luctus</h4>
						<p>
							Stet clita kasd gubergren, no sea takimata sanctus. <a href="#"
								title="Single Blog Entry">Read more</a>
						</p>
					</div>
				</div>
				</div>
				<!-- end slideshow navigation -->
				
				
			</div>
		</div>
		<!-- end content -->
	</div>
	<!-- start footer -->
	<div id="footer">
		<div class="footer-content clearfix">
			<div class="col1-4">
				<h3>Contact Us</h3>
				<p>
					ppandp Business Theme<br /> 22 Miron Drive<br /> New York City,
					12603 NY<br /> Email: <a href="#" class="escape" title="Contact">info<span><span>&part;</span>
					</span>domain.com</a><br /> Phone: (845) 123 4567
				</p>
			</div>
			<div class="col1-4">
				<h3>About Us</h3>
				<p>Nam liber tempor cum soluta nobis eleifend option congue
					nihil imperdiet doming id quod mazim placerat facer possim assum.
					Lorem ipsum dolor sit amet.</p>
			</div>
			<div class="col1-4">
				<h3>Footer Links</h3>
				<p>
					<a href="#" title="Home">Home</a><br /> <a href="#"
						title="Typography">Services</a><br /> <a href="#"
						title="Portfolio">Portfolio</a><br /> <a href="#" title="Blog">Blog</a><br />
					<a href="#" title="Company">Company</a><br />
				</p>
			</div>
			<div class="col1-4 last">
				<h3>We are Social</h3>
				<p>Connect with us through the following social media platforms!</p>
				<ul class="social">
					<li class="twitter first"><a href="#" title="twitter">Visit
							our twitter Account</a>
					</li>
					<li class="facebook"><a href="#" title="facebook">Visit
							our facebook Account</a>
					</li>
					<li class="dribble"><a href="#" title="dribble">Visit our
							dribble Account</a>
					</li>
					<li class="flickr"><a href="#" title="flickr">Visit our
							flickr Account</a>
					</li>
					<li class="vimeo"><a href="#" title="vimeo">Visit our
							vimeo Account</a>
					</li>
				</ul>
				<div class="clear"></div>
			</div>
			<div id="footer-bottom" class="clear">
				<p class="alignleft">Â© 2012 Tilability.com. All rights reserved.</p>
				<p class="alignright">
					<a href="#" onclick="return false" title="Link">Terms of Use</a> <span
						class="padding">|</span> <a href="#" onclick="return false"
						title="Link">Privacy Policy</a>
				</p>
			</div>
		</div>
	</div>
	<!-- end footer -->
	<div id="background"></div>
</body>
</html>
