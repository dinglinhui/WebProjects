<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String cxtPath = request.getContextPath();
	String serverPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
	String appBasePath = serverPath+cxtPath+"/";
	String extBasePath = serverPath+"/paswork/ext-4.1.1a/";
	pageContext.setAttribute("extBasePath", extBasePath);
	pageContext.setAttribute("appBasePath", appBasePath);
%>
<html>
	<head>
		<base href="<%=appBasePath%>">
		<title>系统管理平台</title>
		<style type=”text/css”>
		
			.x-panel-ghost {
			    z-index: 1;
			}
			.x-border-layout-ct {
			    background: #DFE8F6;
			}
			.x-portal-body {
			    padding: 0 0 0 8px;
			}
			.x-portal .x-portal-column {
			    padding: 8px 8px 0 0;
			}
			.x-portal .x-panel-dd-spacer {
			    border: 2px dashed #99bbe8;
			    background: #f6f6f6;
			    border-radius: 4px;
			    -moz-border-radius: 4px;
			    margin-bottom: 10px;
			}
			.x-portlet {
			    margin-bottom:10px;
			    padding: 1px;
			}
			.x-portlet .x-panel-body {
			    background: #fff;
			}
			.portlet-content {
			    padding: 10px;
			    font-size: 11px;
			}
		</style>
	</head>
	<body>
		<div id="loading-tip" style="border-radius:3px;position: absolute;z-index: 1;border: solid 1px #ccc;background-color: #fff;padding: 10px;">
			<div class="loading-indicator" style="color: #444;font: bold 13px tahoma, arial, helvetica;padding: 10px;height: auto;">
				<img src="<%=appBasePath%>/resources/images/extanim32.gif" width="31" height="31" style="margin-right: 8px; float: left; vertical-align: top;" />
				系统管理平台
				<br />
				<span id="loading-msg" style="font: normal 10px arial, tahoma, sans-serif;">加载样式和图片...</span>
			</div>
		</div>
		<script type="text/javascript">
			var extBasePath = "${extBasePath}";
			var appBasePath = "${appBasePath}";
			var tip = document.getElementById("loading-tip");
			tip.style.top = (document.body.scrollHeight - tip.style.top - 100) / 2;
			tip.style.left = (document.body.scrollWidth - 200) / 2;
		</script>
		<link rel="stylesheet" type="text/css" href="<%=extBasePath%>resources/css/ext-all-12px.css" >
		<link rel="stylesheet" type="text/css" href="<%=appBasePath%>resources/css/icons.css" />
		<link rel="stylesheet" type="text/css" href="<%=appBasePath%>resources/css/tab-bar.css" />
		<link rel="stylesheet" type="text/css" href="<%=appBasePath%>resources/css/arm.css" />
		<script type="text/javascript">
			document.getElementById("loading-msg").innerHTML = "加载核心组件...";
		</script>
		<script type="text/javascript" src="<%=extBasePath %>ext-all.js"></script>
		<script type="text/javascript" src="<%=extBasePath %>locale/ext-lang-zh_CN.js"></script>
		<script type="text/javascript" src="<%=appBasePath %>arm/app.js"></script>
	</body>
</html>
