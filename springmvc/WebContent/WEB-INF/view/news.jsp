<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<% 
  HttpSession se = request.getSession();
  se.setMaxInactiveInterval(10);
%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Pragma" content="no-cache">
	<meta http-equiv="Cache-Control" content="no-cache">
	<meta http-equiv="Expires" content="0">
	<script src="${ctx}/static/js/jquery-1.11.1.min.js" type="text/javascript"></script>
	<script src="${ctx}/static/jquery-validation/1.11.1/jquery.validate.min.js" type="text/javascript"></script>
	<script src="${ctx}/static/jquery-validation/1.11.1/messages_bs_zh.js" type="text/javascript"></script>
	<link href="${ctx}/static/jquery-validation/1.11.1/validate.css" type="text/css" rel="stylesheet" />
	
</head>
<body>
	<form action="#" method="post" enctype="multipart/form-data">
		<div>
			<input name="searchContent" id="searchContent" type="searchContent" placeholder="搜索" value=""/>
			<input type="button" value="搜索"/>
		</div>

	</form>
	<c:if test="${userName!=null&& userName!=''}">
		<div>您输入的昵称是:${userName }&nbsp;&nbsp;&nbsp;密码是:${password }</div>
	</c:if>
	<script>
	function searchData(searchContent){
		 $.ajax({
			  url:"${ctx }/es/save/new/search?searchContent="+searchContent,
			  type:"GET",
			  //dataType:"json",
			  success:function(data, type){
				  console.info(data);
			  },
			  error:function(){
				  console.info("检索失败");
			  }
		  });
	}
		$(document).ready(function() {
			$('#searchContent').bind('change', function() {
				var  searchContent = $(this).val(); 
				searchData(searchContent);
			});
			$('#searchContent').bind('focus', function() {
				var  searchContent = $(this).val();
				if(searchContent==null || searchContent==''){
				//	searchData(searchContent)
				}
			});
			$("input[type='button']").click(function(){
				var  searchContent = $('#searchContent').val(); 
				searchData(searchContent);
			});
		});
	</script>
</body>
</html>