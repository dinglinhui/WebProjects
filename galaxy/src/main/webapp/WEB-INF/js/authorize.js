$(function() {
	$("#loginBtn").click(function() {
		console.log("login");
		var username = $("input[name=username]").val();
		var password = hex_md5($("input[name=password]").val());
		var user = {
			"username" : username,
			"password" : password
		};
		$.ajax({
			// url :
			// window.location.protocol+"//"+window.location.host+"/galaxy/user/login",
			url : "user/login",
			type : "post",
			dataType : "json",
			data : user,
			contentType : "application/json; charset=utf-8",
			// contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			// 同步async: false,（默认是true）;
			// 如上：false为同步，这个方法中的Ajax请求将整个浏览器锁死，
			// 只有test.jsp执行结束后，才可以执行其它操作。
			async : false,
			success : function(data) {
				console.log(data);
				if (false == data.loginResult) {
					alert("用户名或者密码错误，请重新登录！");
				} else if (true == data.loginResult) {
					$.ajax({
						url : "app/home",
						type : "POST",
						data : person,
						contentType : "application/json; charset=utf-8",
						dataType : "json",
						success : function(data) {
							console.log(data);
						}
					});
					// var indexUrl =
					// window.location.protocol+"//"+window.location.host+"/galaxy/app/home";
					// self.location = indexUrl;
					// window.location = indexUrl;
					// window.navigate(indexUrl);
				}
			},
			error : function() {
				alert("服务器发生故障，请尝试重新登录！");
			}
		});
	});
});
