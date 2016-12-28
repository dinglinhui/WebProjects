<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String cxtPath = request.getContextPath();
	String serverPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
	String appBasePath = serverPath+cxtPath+"/";
	String extBasePath = serverPath+"/paswork/ext-4.1.1a/";
	pageContext.setAttribute("extBasePath", extBasePath);
	pageContext.setAttribute("appBasePath", appBasePath);
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=appBasePath%>">
<title>Briglow系统登录界面</title>

<jsp:include flush="true" page="../common/include/extjs.jsp" />
<link rel="stylesheet" type="text/css" href="<%=appBasePath%>resources/css/flags.css" />
<link rel="stylesheet" type="text/css" href="<%=appBasePath%>resources/css/iconCombo.css" />
<link rel="stylesheet" type="text/css" href="<%=appBasePath%>resources/css/logindialog.css" />
<script type="text/javascript" src="<%=appBasePath%>arm/login.js"></script>
<!-- Extjs MD5加密算法-->
<script type="text/javascript" src="<%=appBasePath%>resources/ext/ux/MD5.js"></script>
</head>
<body>
	<!-- <div id="LoginDialog"></div> -->
</body>
</html>