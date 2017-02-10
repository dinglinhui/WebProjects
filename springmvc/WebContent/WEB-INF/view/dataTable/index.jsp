<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Pragma" content="no-cache">
	<meta http-equiv="Cache-Control" content="no-cache">
	<meta http-equiv="Expires" content="0">
</head>
<body>
    <div>${mapkey}</div>
	<form action="${ctx }/user/login" method="post" enctype="multipart/form-data">
		<div><input name="userName" type="text" placeholder="请输入昵称" value="${sessionScope.userName }"/></div>
		<div><input name="password" type="password" placeholder="请输入密码" value="${sessionScope.password }"/></div>
		<input type="file" name="file">
		<div><input type="submit" value="登陆"/></div>
	</form>
	<c:if test="${userName!=null&& userName!=''}">
		<div>您输入的昵称是:${userName }&nbsp;&nbsp;&nbsp;密码是:${password }</div>
	</c:if>
</body>
</html>