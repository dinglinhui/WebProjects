<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<div class="row-fluid">
	<div class="span12">
		<!-- BEGIN STYLE CUSTOMIZER -->
		<jsp:include page="../layout/theme.jsp" /> 
		<!-- END BEGIN STYLE CUSTOMIZER -->   
		<!-- BEGIN PAGE TITLE & BREADCRUMB-->
		<h3 class="page-title">
			Dashboard <small>statistics and more</small>
		</h3>
		<ul class="breadcrumb">
			<li>
				<i class="icon-home"></i>
				<a href="<%=path%>/main">Home</a> 
				<i class="icon-angle-right"></i>
			</li>
			<li><a href="#">Dashboard</a></li>
		</ul>
		<!-- END PAGE TITLE & BREADCRUMB-->
	</div>
</div>
	
