<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
	<head>
		<script type="text/javascript" src="${ctx}/static/js/plugins/jquery/jquery.min.js"></script>
		<script type="text/javascript" src="${ctx}/static/pushlet/ajax-pushlet-client.js"></script> 
		<style type="text/css">
			.content-line{background:white;font:14px;padding:6px;margin-bottom:4px;}
		</style> 
	</head>
	<body>
	    <ul class="breadcrumb">
	        <li><a href="#">JCN</a></li>                    
	        <li class="active">任务管理</li>
	        <li class="active">${action.typeName }</li>
	    </ul>
		<form id="chatForm" class="form-horizontal" method="post">
			<!--消息类型  -->
			<input type="hidden" name="chatType" id="chatType" value="allTOall"/>
			<!--接收者ID 如果进入的是房间此处是房间ID,如果是私聊此处是用户ID  -->
			<input type="hidden" name="receiveId" id="receiveId" value="0"/>
			 <div class="form-group" >
			 	<div class="col-xs-offset-3 col-xs-5" >
			 		<div id="bank" style="height:500px;padding-right:2px;border:1px solid green;overflow-y:scroll;">
			 		</div>
			    </div>
			 </div>
			 <div class="form-group">
				<div class="col-xs-offset-3 col-xs-5">
					<div class="input-group">
				        <span class="input-group-addon" id="basic-addon1">游侠${userName}:</span>
						<input type="text" class="form-control" name="content" id="content" placeholder="我想说...">
				        <span class="input-group-btn">
				        	<button class="btn btn-success" type="button" id="sendBtn">发送!</button>
				        </span>
    				</div><!-- /input-group -->
				</div>
			 </div>
			
		  <div class="form-group">
			    <!-- <div class="col-xs-offset-4 col-xs-5">
			      <button type="button" class="btn btn-lg btn-default">取消</button>&nbsp;&nbsp;&nbsp;
			      <button type="submit" class="btn btn-lg btn-info">提交</button>
			    </div> -->
		  </div>
		</form>	
		<script type="text/javascript"> 
			$("#content").focus();
			//pushlet组件
            //PL._init();
			Pl.userId="${user.id}";
            PL.joinListen('/zheng/hongwei');
            function onData(event) {
            	//event 获取的内容是 int  long  或者 String 类型的，所以如果要从控制层传回一个对象需要在控制层将对象转换为json放入event中；
            	var data =jQuery.parseJSON(decodeURIComponent(event.get("mes")));
            	var time = event.get("time");
            	var chatType = $("#chatType").val();//消息类型
            	var receiveId = $("#receiveId").val();//接收者Id
            	var sendName = "${user.name}";//发送者Id
                $.each(data,function(i,chat){
                	if(chat.sendId !=sendId){//不发送给自己
                		if(chatType !="allTOall"){//发送给指定房间的房间 或者个人
                    		if(chat.receive == receiveId){
                    			$("#bank").append("<div class='content-line'>"+"<strong>"+chat.sendName+"：</strong>"+chat.content+"</div>");
                    		}
                    	}else{
                    		$("#bank").append("<div class='content-line'>"+"<strong>"+chat.sendName+"：</strong>"+chat.content+"</div>");
                    	}
                    	
                	}
                });
               // $("#bank").append("<strong>"+time+"</strong>");
                $('#bank').scrollTop($('#bank')[0].scrollHeight );
            	//console.info(); 
                //PL.leave();  
            } 
            
            //发表消息
          $("#sendBtn").click(function(){
			  var content=$("#content").val();
		      if(content!=null && content!='') {
		    	  //点击即可将消息发送到页面
		    	  $("#bank").append("<div class='content-line'>"+"<strong>我：</strong>"+content+"</div>");
		    	  $('#bank').scrollTop($('#bank')[0].scrollHeight );
			      $.ajax({
		                url:'${ctx}/chat/create',
		                type:'POST',
		                data: $("#chatForm").serialize(),
		                dataType:"text",
		                traditional:true,
		                success:function(msg){
			                if(msg !="SUCCESS"){
			                	console.info("发送消息失败");
					        }else{
					        	$("#content").val("");
					        	$("#content").focus();
					        }
		                },error:function(){
							alert("出错了");
				        }
	            	});
	        	}else {
	        		$("#content").focus();
	            	//alert("发送的消息不能为空");
	        		return false;
	        	}
	    });
        
        //Enter键触发发送按钮
        $("#content").keydown(function(e){
      	    if(!e){
      	        e=window.event;
      	        }
      	        if((e.keyCode||e.which)===13){
     	            $("#sendBtn").focus();
      	    }
      	});
        </script>  
	</body>
</html>	
