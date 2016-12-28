<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>搜索测试页面</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/css/styles.css">
<script type="text/javascript" language="javascript" src="<%=basePath%>resources/js/jquery.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePath%>resources/js/autopromot.js"></script>
</head>

<body>
	自动提示：
	<input type="text" name="strCondition" id="strCondition" autocomplete="off" size="100"/>
	<input type="button" id="button" name="button" value="提交" onclick="" />
	<div id="auto"></div>
</body>
</html>
