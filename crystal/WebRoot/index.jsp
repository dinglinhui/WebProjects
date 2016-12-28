<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>Crystal</title>

<!-- Ext JS Files -->
<link rel="stylesheet" type="text/css"
	href="/resources/extjs4/resources/css/ext-all.css" />
<script type="text/javascript"
	src="<%=basePath%>resources/extjs4/bootstrap.js"></script>

<!-- file upload form -->
<script src="<%=basePath%>resources/js/file-upload.js"></script>

</head>
<body>
	<div id="fi-form" style="padding:25px;">Neil Crystal&nbsp;尼尔水晶</div>
</body>
</html>