<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<title>Showcase示例:<sitemesh:title/></title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />

<link type="image/x-icon" href="${ctx}/static/img/favicon.ico" rel="shortcut icon">
<script src="${ctx}/static/js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="${ctx}/static/bootstrap-3.3.4-dist/js/bootstrap.js" type="text/javascript"></script>
<link href="${ctx}/static/bootstrap-3.3.4-dist/css/bootstrap.css" type="text/css" rel="stylesheet" />
<!-- dataTable plugin-->
<script type="text/javascript" src="${ctx}/static/DataTables-1.10.7/media/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/static/DataTables-1.10.7/media/css/jquery.dataTables.min.css"/>
<%-- <link href="${ctx}/static/styles/default.min.css" type="text/css" rel="stylesheet" /> --%>
	<script type="text/javascript">
		var rootPath ="${ctx}/";
	</script>
<sitemesh:head />

</head>
<body>
	<!-- <div class="container"> -->
		<%@ include file="/WEB-INF/layouts/header.jsp"%>
		<%-- <%@ include file="/WEB-INF/layouts/main.jsp"%> --%>
		<div class="row">
			<%-- <%@ include file="/WEB-INF/layouts/left.jsp"%> --%>
			<div id="main" class="span10">
				<%-- <sitemesh:body /> --%>
			</div>
		</div>
		<%@ include file="/WEB-INF/layouts/footer.jsp"%>
	<!-- </div> -->
	<%-- <script src="${ctx}/static/bootstrap/2.3.2/js/bootstrap.min.js" type="text/javascript"></script> --%>	
</body>
</html>