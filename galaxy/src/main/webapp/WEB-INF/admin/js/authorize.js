$(function() {
	$("#loginBtn").click(function() {
		var username = $("input[name=username]").val().toLowerCase();
		var password = hex_md5($("input[name=password]").val());
		var user = {
			"username" : username,
			"password" : password
		};
		$.ajax({
			url : "user/login",
			type : "post",
			dataType : "json",
			data : user,
			// contentType : "application/json; charset=utf-8",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			// 同步async: false,（默认是true）;
			// 如上：false为同步，这个方法中的Ajax请求将整个浏览器锁死，
			// 只有test.jsp执行结束后，才可以执行其它操作。
			async : true,
			success : function(data) {
				console.log(data);
				if (false == data.loginResult) {
					alert("用户名或者密码错误，请重新登录！");
				} else if (true == data.loginResult) {
//					$.ajax({
//						url : "app/home",
//						type : "POST",
//						data : person,
//						contentType : "application/x-www-form-urlencoded;charset=UTF-8",
////						contentType : "application/json; charset=utf-8",
//						dataType : "json",
//						success : function(data) {
//							console.log(data);
//						}
//					});
					 var indexUrl =
					 window.location.protocol+"//"+window.location.host+"/galaxy/app/home";
					 self.location = indexUrl;
					 window.location = indexUrl;
					 window.navigate(indexUrl);
				}
			},
			error : function() {
				alert("服务器发生故障，请尝试重新登录！");
			}
		});
	});
	
	$("#registerBtn").click(function() {
		var email = $("input[name=reg_email]").val().toLowerCase();
		var email_reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
		if (true == email_reg.test(email)) {
			var password = $("input[name=reg_password]").val();
			var repassword = $("input[name=reg_repassword]").val();
			if(password == "" || repassword ==""){
				alert("Password can not be empty!");
			} else if (password != repassword){
				alert("Twice input password are not consistent!");
			} else {
				var username = $("input[name=reg_username]").val().toLowerCase();
				password = hex_md5($("input[name=reg_password]").val());
				repassword = hex_md5($("input[name=reg_repassword]").val());
				var user = {
						"email" : email,
						"username" : username,
						"password" : password
				};
				$.ajax({
					url : "user/register",
					type : "post",
					dataType : "json",
					data : user,
					contentType : "application/x-www-form-urlencoded;charset=UTF-8",
					// 同步async: false,（默认是true）;
					// 如上：false为同步，这个方法中的Ajax请求将整个浏览器锁死，
					// 只有test.jsp执行结束后，才可以执行其它操作。
					async : false,
					success : function(data) {
						console.log(data);
						if (true == data.registerResult) {
							var indexUrl =
								window.location.protocol+"//"+window.location.host+"/galaxy/app/home";
							self.location = indexUrl;
							window.location = indexUrl;
							window.navigate(indexUrl);
						} else {
							alert("Username " + username + " has exist already, please try another username!");
						}
					},
					error : function() {
						alert("There're some errors in server, please try to register again!");
					}
				});
			}
		} else {
			alert("Email format error, please input correct email format!");
		}
	});
	
//	$("#resetBtn").click(function() {
//
//
//	});

});


