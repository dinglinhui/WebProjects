<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd"> 
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" > 
	<head>
		<base href="<%=basePath%>">
		<title>Login Interface</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		
		 <!-- Jquery directly from google servers--> 
		<script type="text/javascript" src="<%=basePath%>resources/js/jquery.min.js" ></script>
		
		<!-- Login javscript--> 
		<script type="text/javascript" src="<%=basePath%>resources/js/loginui.js"></script> 
		
		<link rel="stylesheet" type="text/css" media="all" href="<%=basePath%>resources/css/reset.css" />
		<link rel="stylesheet" type="text/css" media="all" href="<%=basePath%>resources/css/login.css" />
		<link rel="stylesheet" type="text/css" media="all" href="<%=basePath%>resources/css/blue.css" />

		<!-- comment extra.css for css validation -->
		<link rel="stylesheet" type="text/css" media="all" href="<%=basePath%>resources/css/extra.css" />
		
		<script type="text/javascript" src="<%=basePath%>resources/js/md5.js" ></script>  
		<%-- <script type="text/javascript">
			function login() {
				document.getElementById('password').value = hex_md5(document.getElementById('password').value);
				with (document.getElementById("loginForm")) {
					method = "post";
					action = "<%=basePath%>login";
					submit();
				}
			}
		</script> --%>
	</head>
		
	<body>
		
		<div class="boxLogin clearfix">
			 <!-- Tooltip styles  --> 
			<%-- <div class="toolTip tpRed clearfix" >
				<p>
					<img src="<%=basePath%>resources/images/icons/exclamation-red.png" alt="Tip!" />
					The username or password is incorrect.
				</p>
				
				<a class="close" title="Close"></a>
			</div> --%>
			
			<form action = "<%=basePath%>login" method="post" id="loginForm" name="loginForm">
			<div class="fields">
				<p class="sep">
					<label class="small" for="user01">帐&nbsp;&nbsp;号：</label>
					<input type="text" value="" class="sText" id="account" name="account"/>
				</p>
				
				<p class="sep">
					<label class="small" for="pass01">密&nbsp;&nbsp;码：</label>
					<input type="password" value="" class="sText" id="password" name="password"/>
				</p>
					
				<p class="rem"> 
				<input class="sCheck" type="checkbox" name="ts_1" value="ts_1" id="check08"/><label for="check08">记住我</label> </p>
				
				<div class="action">
					<input type="button" class="butDef" value="注&nbsp;&nbsp;册" />
					<input type="submit" class="butDef" value="登&nbsp;&nbsp;录" onclick="document.getElementById('password').value = hex_md5(document.getElementById('password').value);"/>
				</div>
			</div>
			</form>
		</div>
		
		<!-- Google Analytics --> 
		<script type="text/javascript">
		var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
		document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
		</script>
		<script type="text/javascript">
		try {
		var pageTracker = _gat._getTracker("UA-11944791-1");
		pageTracker._setDomainName(".logntimber.com");
		pageTracker._trackPageview();
		} catch(err) {}</script>
	</body>

</html>
