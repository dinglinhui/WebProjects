<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!-- BEGIN SIDEBAR -->

<div class="page-sidebar nav-collapse collapse">
	<!-- BEGIN SIDEBAR MENU -->        
	<ul class="page-sidebar-menu">
		<li>
			<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
			<div class="sidebar-toggler hidden-phone"></div>
			<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
		</li>
		<li>
			<!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->
			<form class="sidebar-search">
				<div class="input-box">
					<a href="javascript:;" class="remove"></a>
					<input type="text" placeholder="Search..." />
					<input type="button" class="submit" value=" " />
				</div>
			</form>
			<!-- END RESPONSIVE QUICK SEARCH FORM -->
		</li>
		<li class="start active ">
			<a href="<%=path%>/main">
			<i class="icon-home"></i> 
			<span class="title">首页面板</span>
			<span class="selected"></span>
			</a>
		</li>
		<li class="last ">
			<a href="<%=path%>/chatroom/robot" target="iframecontent">
			<i class="icon-comments"></i> 
			<span class="title">聊天室</span>
			</a>
		</li>
		<li class="last ">
			<a href="<%=path%>/sysuser/list" target="iframecontent">
			<i class="icon-comments"></i> 
			<span class="title">测试面板</span>
			</a>
		</li>
		<li>
			<a class="active" href="javascript:;">
			<i class="icon-sitemap"></i> 
			<span class="title">系统管理</span>
			<span class="arrow "></span>
			</a>
			<ul class="sub-menu">
				<li>
					<a href="javascript:;">
					用户管理
					<span class="arrow"></span>
					</a>
					<ul class="sub-menu">
						<li><a href="<%=path%>/sysuser/list" target="iframecontent" onclick="onMenu(this)">用户列表</a></li>
						<li><a href="<%=path%>/sysuser/add" target="iframecontent" onclick="onMenu(this)">新建用户</a></li>
						<li><a href="<%=path%>/sysuser/list" target="iframecontent" onclick="onMenu(this)">角色列表</a></li>
					</ul>
				</li>
			</ul>
		</li>
		<li class=" ">
			<a href="<%=path%>/main">
			<i class="icon-user"></i> 
			<span class="title">个人设置</span>
			</a>
		</li>
		<li class=" ">
			<a href="<%=path%>/logout">
			<i class="icon-off"></i> 
			<span class="title">退出</span>
			</a>
		</li>
	</ul>
	<!-- END SIDEBAR MENU -->
</div>
<!-- END SIDEBAR -->
<script type="text/javascript">
	function onMenu(obj) {
		jQuery('html, body').animate({scrollTop: 0}, 200);
		$('li').removeClass("active");
		$(obj).parent().addClass("active");
	}
	try {
		ace.settings.check('sidebar', 'collapsed');
	} catch (e) {
	}
</script>