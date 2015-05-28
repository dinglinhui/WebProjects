<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<html>
<head>
<jsp:include page="../layout/header.jsp" />
</head>
<body style="background-color: #FFFFFF">

	<div class="breadcrumbs" id="breadcrumbs" style="padding-top: 8px;">
		<script type="text/javascript">
			try {
				ace.settings.check('breadcrumbs', 'fixed')
			} catch (e) {
			}
		</script>

		<ul class="breadcrumb">
			<li><i class="icon-home home-icon"></i> <a href="#">首页</a></li>

			<li class="active">系统运行错误</li>
		</ul>
		<!-- .breadcrumb -->
	</div>

	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->

				<div class="error-container">
					<div class="well">
						<h1 class="grey lighter smaller">
							<span class="blue bigger-125"> <i class="icon-random"></i>
								异常
							</span> 系统运行错误
						</h1>

						<hr>
						<h3 class="lighter smaller">
							我们正在修复 <i
								class="icon-wrench icon-animated-wrench bigger-125"></i> 此问题!请您联系管理员
						</h3>

						<div class="space"></div>

						<div>
							<h4 class="lighter smaller">请尝试以下方法:</h4>

							<ul class="list-unstyled spaced inline bigger-110 margin-15">
								<li><i class="icon-hand-right blue"></i> 读取帮助文件/操作手册</li>

								<li><i class="icon-hand-right blue"></i> 告诉系统管理员相关的信息(是如何产生的这个问题呢?)</li>
							</ul>
						</div>

						<hr>
						<div class="space"></div>

						<div class="center">
							<a href="javascript:history.go(-1);" class="btn btn-grey"> <i class="icon-arrow-left"></i>
								返回
							</a> <a href="#" class="btn btn-primary"> <i
								class="icon-dashboard"></i> 首页
							</a>
						</div>
					</div>
				</div>

				<!-- PAGE CONTENT ENDS -->
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->
	</div>

</body>
<jsp:include page="../layout/footer.jsp"></jsp:include>
<jsp:include page="../layout/bottom.jsp"></jsp:include>
</html>