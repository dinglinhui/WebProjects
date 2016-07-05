<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String cxtPath = request.getContextPath();
	String serverPath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort();
	String appBasePath = serverPath + cxtPath + "/";
	pageContext.setAttribute("appBasePath", appBasePath);
%>
<!DOCTYPE HTML>
<html>
<head>
<title>DINGLINHUI.COM</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />

<link rel="stylesheet" type="text/css" href="<%=appBasePath%>css/skel.css" />
<link rel="stylesheet" type="text/css" href="<%=appBasePath%>css/style.css" />
<link rel="stylesheet" type="text/css" href="<%=appBasePath%>css/style-wide.css" />
<link rel="stylesheet" type="text/css" href="<%=appBasePath%>css/style-normal.css" />

<script src="<%=appBasePath%>js/jquery.min.js"></script>
<script src="<%=appBasePath%>js/jquery.poptrox.min.js"></script>
<script src="<%=appBasePath%>js/jquery.scrolly.min.js"></script>
<script src="<%=appBasePath%>js/jquery.scrollgress.min.js"></script>
<script src="<%=appBasePath%>js/skel.min.js"></script>
<script src="<%=appBasePath%>js/init.js"></script>
</head>
<body>

	<!-- Header -->
	<header id="header">

		<!-- Logo -->
		<h1 id="logo">
			<a href="">DINGLINHUI.COM</a>
		</h1>

		<!-- Nav -->
		<nav id="nav">
			<ul>
				<li><a href="#intro">Intro</a></li>
				<li><a href="#one">What I Do</a></li>
				<li><a href="#two">Who I Am</a></li>
				<li><a href="#work">My Work</a></li>
				<li><a href="#contact">Contact</a></li>
			</ul>
		</nav>

	</header>

	<!-- Intro -->
	<section id="intro" class="main style1 dark fullscreen">
		<div class="content container small">
			<header>
				<h2>Hey.</h2>
			</header>
			<p>
				Welcome to <strong>dinglinhui.com</strong>
				<!-- a responsive site template
				designed by <a href="http://html5up.net">HTML5 UP</a>, built on <strong>skel</strong>,
				and released for free under the <a href="http://html5up.net/license">Creative
					Commons Attribution 3.0 license</a>. -->
			</p>
			<footer>
				<a href="#one" class="button style2 down">More</a>
			</footer>
		</div>
	</section>

	<!-- One -->
	<section id="one" class="main style2 right dark fullscreen">
		<div class="content box style2">
			<header>
				<h2>What I Do</h2>
			</header>
			<p>Lorem ipsum dolor sit amet et sapien sed elementum egestas
				dolore condimentum. Fusce blandit ultrices sapien, in accumsan orci
				rhoncus eu. Sed sodales venenatis arcu, id varius justo euismod in.
				Curabitur egestas consectetur magna.</p>
		</div>
		<a href="#two" class="button style2 down anchored">Next</a>
	</section>

	<!-- Two -->
	<section id="two" class="main style2 left dark fullscreen">
		<div class="content box style2">
			<header>
				<h2>Who I Am</h2>
			</header>
			<p>Lorem ipsum dolor sit amet et sapien sed elementum egestas
				dolore condimentum. Fusce blandit ultrices sapien, in accumsan orci
				rhoncus eu. Sed sodales venenatis arcu, id varius justo euismod in.
				Curabitur egestas consectetur magna.</p>
		</div>
		<a href="#work" class="button style2 down anchored">Next</a>
	</section>

	<!-- Work -->
	<section id="work" class="main style3 primary">
		<div class="content container">
			<header>
				<h2>My Work</h2>
				<p>Lorem ipsum dolor sit amet et sapien sed elementum egestas
					dolore condimentum. Fusce blandit ultrices sapien, in accumsan orci
					rhoncus eu. Sed sodales venenatis arcu, id varius justo euismod in.
					Curabitur egestas consectetur magna vitae.</p>
			</header>

			<!-- Lightbox Gallery  -->
			<div class="container small gallery">
				<div class="row flush images">
					<div class="6u">
						<a href="<%=appBasePath%>images/fulls/01.jpg"
							class="image fit from-left"><img
							src="<%=appBasePath%>images/thumbs/01.jpg"
							title="The Anonymous Red" alt="" /></a>
					</div>
					<div class="6u">
						<a href="<%=appBasePath%>images/fulls/02.jpg"
							class="image fit from-right"><img
							src="<%=appBasePath%>images/thumbs/02.jpg"
							title="Airchitecture II" alt="" /></a>
					</div>
				</div>
				<div class="row flush images">
					<div class="6u">
						<a href="<%=appBasePath%>images/fulls/03.jpg"
							class="image fit from-left"><img
							src="<%=appBasePath%>images/thumbs/03.jpg" title="Air Lounge"
							alt="" /></a>
					</div>
					<div class="6u">
						<a href="<%=appBasePath%>images/fulls/04.jpg"
							class="image fit from-right"><img
							src="<%=appBasePath%>images/thumbs/04.jpg" title="Carry on"
							alt="" /></a>
					</div>
				</div>
				<div class="row flush images">
					<div class="6u">
						<a href="<%=appBasePath%>images/fulls/05.jpg"
							class="image fit from-left"><img
							src="<%=appBasePath%>images/thumbs/05.jpg"
							title="The sparkling shell" alt="" /></a>
					</div>
					<div class="6u">
						<a href="<%=appBasePath%>images/fulls/06.jpg"
							class="image fit from-right"><img
							src="<%=appBasePath%>images/thumbs/06.jpg" title="Bent IX" alt="" /></a>
					</div>
				</div>
			</div>

		</div>
	</section>

	<!-- Contact -->
	<section id="contact" class="main style3 secondary">
		<div class="content container">
			<header>
				<h2>Say Hello.</h2>
				<p>Lorem ipsum dolor sit amet et sapien sed elementum egestas
					dolore condimentum.</p>
			</header>
			<div class="box container small">

				<!-- Contact Form -->
				<form method="post" action="#">
					<div class="row half">
						<div class="6u">
							<input type="text" name="name" placeholder="Name" />
						</div>
						<div class="6u">
							<input type="email" name="email" placeholder="Email" />
						</div>
					</div>
					<div class="row half">
						<div class="12u">
							<textarea name="message" placeholder="Message" rows="6"></textarea>
						</div>
					</div>
					<div class="row">
						<div class="12u">
							<ul class="actions">
								<li><input type="submit" value="Send Message" /></li>
							</ul>
						</div>
					</div>
				</form>

			</div>
		</div>
	</section>

	<!-- Footer -->
	<footer id="footer">

		<!-- Icons -->
		<ul class="actions">
			<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
			<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
			<li><a href="#" class="icon fa-google-plus"><span
					class="label">Google+</span></a></li>
			<li><a href="#" class="icon fa-dribbble"><span class="label">Dribbble</span></a></li>
			<li><a href="#" class="icon fa-pinterest"><span
					class="label">Pinterest</span></a></li>
			<li><a href="#" class="icon fa-instagram"><span
					class="label">Instagram</span></a></li>
		</ul>

		<!-- Menu -->
		<ul class="menu">
			<li>&copy; dinglinhui.com</li>
			<li>Author: Kevin Ding</li>
		</ul>

	</footer>

</body>
</html>