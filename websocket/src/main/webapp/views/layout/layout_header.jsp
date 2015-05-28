<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!-- BEGIN HEADER -->
<div class="header navbar navbar-inverse navbar-fixed-top">

	<!-- BEGIN TOP NAVIGATION BAR -->

	<div class="navbar-inner">

		<div class="container-fluid">

			<!-- BEGIN LOGO -->

			<a class="brand" href="<%=path%>/sysmage/home" style="padding-top: 1px;padding-bottom: 0">

			<img src="<%=path%>/media/image/logocctv.png" alt="logo" style="margin-left: 1px;"/>
			

			</a>

			<!-- END LOGO -->

			<!-- BEGIN RESPONSIVE MENU TOGGLER -->

			<%-- <a href="<%=path%>/home" class="btn-navbar collapsed" data-toggle="collapse" data-target=".nav-collapse">

			<img src="<%=path%>/media/image/home.png" alt="" />
			<i class="icon-home">Home</i>

			</a>  --%>         

			<!-- END RESPONSIVE MENU TOGGLER -->            

			<!-- BEGIN TOP NAVIGATION MENU -->              

			<ul class="nav pull-right">

				<!-- BEGIN NOTIFICATION DROPDOWN -->
				 
				<li class="dropdown" id="header_notification_bar">

					<a href="<%=path%>/sysmage/home" class="dropdown-toggle"  style="padding-right: 10px;">
					
					<i class="icon-home"></i>Home 


					</a>

				</li>
				<li class="dropdown" id="header_notification_bar">

					<a href="#" class="dropdown-toggle" data-toggle="dropdown" style="padding-right: 10px;">
					
					<i class="icon-warning-sign"></i>

					<span id="login_error" style="color: #e02222; text-align: center;">${message}</span>

					</a>

				</li>

				<li class="dropdown" id="header_notification_bar">

					<a href="#" class="dropdown-toggle" data-toggle="dropdown">

					<i class="icon-key"></i>登录

					</a>

					<ul class="dropdown-menu extended notification">

						<li>

							<p>Login System</p>

						</li>

						<li>
							<form class="form-vertical login-form" style="margin-bottom:0px;" action="<%=path%>/sysmage/login" method="post">
								<div class="alert alert-error hide">
									<button class="close" data-dismiss="alert"></button>
									<span>Enter any username and password.</span>
								</div>
								<span id="login_error" style="color: #e02222; text-align: center;">${message}</span>
								<div class="control-group">
									<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
									<label class="control-label visible-ie8 visible-ie9">Username</label>
									<div class="controls" style="margin-left:15px;margin-top:15px">
										<div class="input-icon left">
											<i class="icon-user"></i>
											<input class="m-wrap placeholder-no-fix" style="width:160px;left:50%;" type="text" placeholder="Username" name="username"/>
										</div>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label visible-ie8 visible-ie9">Password</label>
									<div class="controls" style="margin-left:15px;">
										<div class="input-icon left">
											<i class="icon-lock"></i>
											<input class="m-wrap placeholder-no-fix" style="width:160px;" type="password" placeholder="Password" name="password"/>
										</div>
									</div>
								</div>
								<div class="form-actions" style="margin-top:5px;margin-bottom:0px;padding:5px 5px 5px">
									<button type="submit" class="btn blue pull-right">
									Login <i class="m-icon-swapright m-icon-white"></i>
									</button>            
								</div>
							</form>
						</li>


						<!-- <li class="external">

							<a href="#">登录 <i class="m-icon-swapright"></i></a>

						</li> -->

					</ul>

				</li>

				<!-- END NOTIFICATION DROPDOWN -->

				<!-- BEGIN INBOX DROPDOWN -->

				<li class="dropdown" id="header_inbox_bar">

					<a href="#" class="dropdown-toggle" data-toggle="dropdown">

					<i class="icon-plus-sign"></i>注册

					</a>

					<ul class="dropdown-menu extended inbox">

						<li>

							<p>Register Account</p>

						</li>

						<li>

							<form id="register_form" class="form-vertical register-form" style="margin-bottom:0px;" action="<%=path%>/sysmage/register" method="post" onkeydown="if(event.keyCode==13){return false;}">
								<script type="text/javascript">
									function validate(field) {  
										var span = document.getElementById("userExists");
										span.innerHTML = ""; 
										$.get("<%=path%>/check", { username : "hello"},
												  function(data){
													if(data.exist)
														span.innerHTML = "用户名已存在"; 
													else 
														span.innerHTML = ""; 
												  });
									}  
								</script>
								<span id="userExists" style="color: #e02222;"></span>
								<div class="control-group">
									<label class="control-label visible-ie8 visible-ie9">Username</label>
									<div class="controls" style="margin-left:15px;margin-top:15px">
										<div class="input-icon left">
											<i class="icon-user"></i>
											<input class="m-wrap placeholder-no-fix" type="text" style="width:160px;" placeholder="Username" id="username" name="username" onblur="validate(this)" value="${user.username}"/>
										</div>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label visible-ie8 visible-ie9">Password</label>
									<div class="controls" style="margin-left:15px;">
										<div class="input-icon left">
											<i class="icon-lock"></i>
											<input class="m-wrap placeholder-no-fix" type="password" style="width:160px;" id="register_password" placeholder="Password" name="password"/>
										</div>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label visible-ie8 visible-ie9">Re-type Your Password</label>
									<div class="controls" style="margin-left:15px;">
										<div class="input-icon left">
											<i class="icon-ok"></i>
											<input class="m-wrap placeholder-no-fix" type="password" style="width:160px;" placeholder="Re-type Your Password" name="rpassword"/>
										</div>
									</div>
								</div>
								<div class="control-group">
									<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
									<label class="control-label visible-ie8 visible-ie9">Email</label>
									<div class="controls" style="margin-left:15px;">
										<div class="input-icon left">
											<i class="icon-envelope"></i>
											<input class="m-wrap placeholder-no-fix" type="text" style="width:160px;" placeholder="Email" name="email" value="${user.email}"/>
										</div>
									</div>
								</div>
								<div class="control-group">
									<div class="controls" style="margin-left:15px;">
										<label class="checkbox">
										<input type="checkbox" name="tnc"/> I agree to the <a href="#">《共和国新闻传播法》</a>
										</label>  
										<div id="register_tnc_error"></div>
									</div>
								</div>
								<div class="form-actions" style="margin-top:5px;margin-bottom:0px;padding:5px 5px 5px">
									<button id="register-back-btn" type="button" class="btn">
									<i class="m-icon-swapleft"></i>  Back
									</button>
									<button type="submit" id="register-submit-btn" class="btn blue pull-right" onclick="validateAndSubmit()">
									注册  <i class="m-icon-swapright m-icon-white"></i>
									</button>            
								</div>
							</form>

						</li>

					</ul>

				</li>

				<!-- END INBOX DROPDOWN -->

				<!-- BEGIN TODO DROPDOWN -->


				<!-- END TODO DROPDOWN -->

				<!-- BEGIN USER LOGIN DROPDOWN -->

				<li class="dropdown user">

					<a href="#" class="dropdown-toggle" data-toggle="dropdown">

					<img alt="" src="<%=path%>/media/image/avatar1_small.jpg" />
					

					<span class="username">${currentUser.username eq  null ? "游客" : currentUser.username}</span>
					
					

					<i class="icon-angle-down"></i>

					</a>

					<ul class="dropdown-menu">

						<li><a href="<%=path%>/sysnews/list"><i class="icon-rss"></i> 新闻管理</a></li>

						<li><a href="<%=path%>/syscategory/list"><i class="icon-sort-by-alphabet"></i> 分类管理</a></li>

						<li><a href="<%=path%>/sysmage/home"><i class="icon-tags"></i> 标签管理</a></li>

						<li><a href="#"><i class="icon-comments"></i> 评论管理</a></li>

						<li class="divider"></li>

						<li><a href="<%=path%>/sysmage/logout"><i class="icon-off"></i> 退出</a></li>

					</ul>

				</li>

				<!-- END USER LOGIN DROPDOWN -->

			</ul>

			<!-- END TOP NAVIGATION MENU --> 

		</div>

	</div>

	<!-- END TOP NAVIGATION BAR -->

</div>

<!-- END HEADER -->
