<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en" class="body-full-height">
    <head>        
        <!-- META SECTION -->
        <title>姜赤那工作室</title>            
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="icon" href="${ctx}/static/img/favicon.ico" type="image/x-icon" />
        <!-- CSS INCLUDE -->        
        <link rel="stylesheet" type="text/css" id="theme" href="${ctx}/static/css/theme-default.css"/>
        <!-- EOF CSS INCLUDE -->
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Expires" content="0">
		<script type="text/javascript" src="${ctx}/static/js/plugins/jquery/jquery.min.js"></script>
    </head>
    <body>
        
        <div class="login-container">
        
            <div class="login-box animated fadeInDown">
                <div class="login-logo"></div>
                <div class="login-body">
                    <div class="login-title"><strong>登录系统</strong></div>
                    <form class="form-horizontal" action="${ctx}/login" method="post">
                    <div class="form-group">
                        <div class="col-md-12">
                            <input type="text" name="username" class="form-control" placeholder="账号"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <input type="password" name="password" class="form-control" placeholder="密码"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-6" style="color:#FFF;">
						    <label class="checkbox" style="margin-left: 80px;padding-left: 0;">
						      <input type="checkbox" name="rememberMe" id="rememberMe" value="true">自动登录
						    </label>
  						</div>
                        <div class="col-md-6">
                            <button type="submit" class="btn btn-info btn-block">登录</button>
                        </div>
                    </div>
                    </form>
                </div>
                <div class="login-footer">
                    <div class="pull-left">
                        &copy; 2016 JCN
                    </div>
                    <div class="pull-right">
                        <a href="#">姜赤那工作室</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>