<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
	<head>
		<script type="text/javascript" src="${ctx}/static/pushlet/ajax-pushlet-client.js"></script> 
	</head>
	<body>
	    <ul class="breadcrumb">
	        <li><a href="#">JCN</a></li>                    
	        <li class="active">任务管理</li>
	        <li class="active">${action.typeName }</li>
	    </ul>
		<form class="form-horizontal" action="${ctx }/task/create" method="post">
			<div class="form-group">
				<div class="col-xs-offset-1 col-xs-10">
					<div class="alert alert-info alert-dismissible" role="alert">
	  					<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	  					<strong>${message }</strong>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-xs-offset-1 col-xs-10" id="content" style="border:1px solid gray;">
					
				</div>
			</div>
			<div class="form-group">
			    <label for="inputEmail3" class="col-xs-1 control-label">用户名:</label>
			    <div class="col-xs-4">
			      <input type="text" class="form-control" id="name" name="name" placeholder="用户名">
			    </div>
			    <label for="inputEmail3" class="col-xs-1 control-label">邮箱:</label>
			    <div class="col-xs-4">
			      <input type="email" class="form-control" id="email" name="email" placeholder="邮箱">
			    </div>
			</div>
			<div class="form-group">
			    <label for="inputPassword3" class="col-xs-1 control-label">名称:</label>
			    <div class="col-xs-4">
			      <input type="text" class="form-control" id="taskName" name="taskName" placeholder="名称">
			    </div>
			    <label for="inputPassword3" class="col-xs-1 control-label">描述:</label>
			    <div class="col-xs-4">
			      <input type="text" class="form-control" id="descript" name="descript" placeholder="描述">
			    </div>
		   </div>
		   <div class="form-group">
			    <label for="inputPassword3" class="col-xs-1 control-label">进度:</label>
			    <div class="col-xs-4">
			      <input type="text" class="form-control" id="progress" name="progress" placeholder="名称">
			    </div>
			    <label for="inputPassword3" class="col-xs-1 control-label">紧急程度:</label>
			    <div class="col-xs-4">
			      <select class="form-control" id="dep" name="dep">
			      		<option value="">选择任务紧急程度</option>
			      	<c:forEach items="${dep}" var="de">
			      		<option value="${de}">${de.typeName}</option>
			      	</c:forEach>
			      </select>
			    </div>
		  </div>
		  <div class="form-group">
			    <div class="col-xs-offset-4 col-xs-5">
			      <button type="button" class="btn btn-lg btn-default">取消</button>&nbsp;&nbsp;&nbsp;
			      <button type="submit" class="btn btn-lg btn-info">提交</button>
			    </div>
		  </div>
		</form>	
		<script type="text/javascript">  
            PL._init();   
            PL.joinListen('/cuige/he');  
            function onData(event) {   
                alert(event.get("mess")); 
                $("#content").html(event.get("mess"));
                // 离开  
                // PL.leave();  
            }  
        </script>        
	</body>
</html>	
