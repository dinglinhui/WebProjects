<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String cxtPath = request.getContextPath();
	String serverPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
	String appBasePath = serverPath+cxtPath+"/";
	String extBasePath = serverPath+"/paswork/ext-4.1.1a/";
	pageContext.setAttribute("extBasePath", extBasePath);
	pageContext.setAttribute("appBasePath", appBasePath);
%>
<!-- 样式区 （开始） -->
<!-- Extjs 核心样式库 -->
<link rel="stylesheet" type="text/css" href="<%=extBasePath%>resources/css/ext-all-12px.css" />
<!-- Extjs 中文字体显示效果补丁 -->
<%-- <link rel="stylesheet" type="text/css" href="<%=appBasePath%>resources/css/ext_css_patch.css" /> --%>
<!-- 小图标样式 -->
<link rel="stylesheet" type="text/css" href="<%=appBasePath%>resources/css/icons.css" />
<!-- 样式区 （结束） -->

<!-- JavaScript （开始） -->
<!-- 定义Extjs常量 -->
<script type="text/javascript">
	//域路径
	var appBasePath = '<%=appBasePath%>';
	//域名访问路径
	var extBasePath = '<%=extBasePath%>';
	//默认后台分页数据量
	var defaultPageRecordNum = 10;
	
</script>
<!-- Extjs 核心脚本 -->
<script type="text/javascript" src="<%=extBasePath %>bootstrap.js"></script>
<!-- Extjs 中文脚本 -->
<script type="text/javascript" src="<%=extBasePath %>locale/ext-lang-zh_CN.js"></script>

<!-- JavaScript （结束） -->
