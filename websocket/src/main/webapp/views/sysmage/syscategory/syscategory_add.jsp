<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
	<jsp:include page="../../layout/header.jsp" />
	<!-- BEGIN PAGE LEVEL STYLES --> 
	<link rel="stylesheet" type="text/css" href="<%=path%>/media/css/select2_metro.css" />
	<link rel="stylesheet" href="<%=path%>/media/css/DT_bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="<%=path%>/media/css/bootstrap-fileupload.css" />

	<link rel="stylesheet" type="text/css" href="<%=path%>/media/css/jquery.gritter.css" />

	<link rel="stylesheet" type="text/css" href="<%=path%>/media/css/chosen.css" />

	<link rel="stylesheet" type="text/css" href="<%=path%>/media/css/select2_metro.css" />

	<link rel="stylesheet" type="text/css" href="<%=path%>/media/css/jquery.tagsinput.css" />

	<link rel="stylesheet" type="text/css" href="<%=path%>/media/css/clockface.css" />

	<link rel="stylesheet" type="text/css" href="<%=path%>/media/css/bootstrap-wysihtml5.css" />

	<link rel="stylesheet" type="text/css" href="<%=path%>/media/css/datepicker.css" />

	<link rel="stylesheet" type="text/css" href="<%=path%>/media/css/timepicker.css" />

	<link rel="stylesheet" type="text/css" href="<%=path%>/media/css/colorpicker.css" />

	<link rel="stylesheet" type="text/css" href="<%=path%>/media/css/bootstrap-toggle-buttons.css" />

	<link rel="stylesheet" type="text/css" href="<%=path%>/media/css/daterangepicker.css" />

	<link rel="stylesheet" type="text/css" href="<%=path%>/media/css/datetimepicker.css" />

	<link rel="stylesheet" type="text/css" href="<%=path%>/media/css/multi-select-metro.css" />

	<link href="<%=path%>/media/css/bootstrap-modal.css" rel="stylesheet" type="text/css"/>
	<!-- END PAGE LEVEL STYLES -->
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed">
	<!-- header -->
	<jsp:include page="../../layout/layout_header.jsp" />
	<!-- BEGIN CONTAINER -->
	<div class="page-container">
		<!-- BEGIN PAGE -->
		<div class="page-content" style="margin-left:0px;">
			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<!-- BEGIN PAGE CONTAINER-->
			<div class="container-fluid">
				<!-- BEGIN PAGE HEADER-->
				<div class="row-fluid">
					<div class="span12">
						<!-- BEGIN STYLE CUSTOMIZER -->
						<jsp:include page="../../layout/theme.jsp" /> 
						<!-- END BEGIN STYLE CUSTOMIZER -->   
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->
						<h3 class="page-title">
							分类管理 
							<small>
								<c:choose>
									<c:when test="${category.id == null}">
									添加
								    </c:when>
									<c:otherwise>
									更新
								    </c:otherwise>
								</c:choose>
							</small>
						</h3>
						<ul class="breadcrumb">
							<li>
								<i class="icon-home"></i>
								<a href="<%=path%>/sysmage/home">Home</a> 
								<i class="icon-angle-right"></i>
							</li>
							<li>
								<a href="<%=path%>/syscategory/list">分类列表</a>
								<i class="icon-angle-right"></i>
							</li>
							<li><a href="#">添加分类</a></li>
						</ul>
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->
				<!-- BEGIN PAGE CONTENT-->
				<div class="row-fluid">
					<div class="span12">
						<c:if test="${not empty edit_success}">
							<div class="alert alert-block alert-success">
								<button type="button" class="close" data-dismiss="alert">
									<i class="icon-remove"></i>
								</button>
								<i class="icon-ok green"></i> <strong class="green"> 成功 </strong>
								<small>${edit_success}</small>
							</div>
						</c:if>
						<c:if test="${not empty edit_failed}">
							<div class="alert alert-block alert-danger">
								<button type="button" class="close" data-dismiss="alert">
									<i class="icon-remove"></i>
								</button>
								<i class="icon-remove red"></i> <strong class="red"> 失败 </strong>
								<small>${edit_failed}</small>
							</div>
						</c:if> 
						<div class="portlet box light-grey">
							<div class="portlet-title">
								<div class="caption"><i class="icon-globe"></i>Managed Table</div>
								<div class="tools">
									<a href="javascript:;" class="collapse"></a>
									<a href="#portlet-config" data-toggle="modal" class="config"></a>
									<a href="javascript:;" class="reload"></a>
									<a href="javascript:;" class="remove"></a>
								</div>
							</div>
							<div class="portlet-body">
							
									<form action="<%=path%>/syscategory/add" class="form-horizontal" id="syscategoryadd_form" method="post"
														onkeydown="if(event.keyCode==13){return false;}">

										<div class="control-group">
	
											<label class="control-label">所属大类</label>
	
											<div class="controls">
	
												<select class="medium m-wrap" name="parentId.id" tabindex="0">
												
													<option value="0">-----请选择-----</option>
													
													<c:forEach items="${typename}" var="m">
														<option value="${m.id}" ${m.parentId == null ? 'selected' : ''}>${m.name}</option>
													</c:forEach>
	
												</select>
	
											</div>
	
										</div>
										
										<div class="control-group">
	
											<label class="control-label">名称</label>
	
											<div class="controls">
											
												<input class="m-wrap medium" name="id" type="text" value="${category.id}" style="display:none;" readonly />
	
												<input type="text" placeholder="title" class="m-wrap large" id="title" name="name" value="${category.name}" 
														onblur="validate(this)" />
	
											</div>
	
										</div>
										
										<div class="control-group">
	
											<label class="control-label">其他属性</label>
	
											<div class="controls">
											
												<input type="text" placeholder="title" class="m-wrap large" id="title" name="misc1" value="${category.misc1}" 
														onblur="validate(this)" />
	
											</div>
	
										</div>
	
										<div class="form-actions">
	
											<button type="submit" class="btn blue"><i class="icon-ok"></i> Save</button>
	
											<button type="button" class="btn">Cancel</button>
	
										</div>
	
									</form>
								
							</div>
							
						</div>
						
					</div>
					
				</div>
				
				<!-- END PAGE CONTENT-->
			</div>
			<!-- END PAGE CONTAINER-->
		</div>
		<!-- END PAGE -->
	</div>
	<!-- END CONTAINER -->
	<!-- BEGIN COPYRIGHT -->
	<jsp:include page="../../layout/footer.jsp" />
	<!-- END COPYRIGHT -->
	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
	<!-- BEGIN CORE PLUGINS -->
	<jsp:include page="../../layout/bottom.jsp" />
	<!-- END CORE PLUGINS -->
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script type="text/javascript" src="<%=path%>/media/js/ckeditor.js"></script>  

	<script type="text/javascript" src="<%=path%>/media/js/bootstrap-fileupload.js"></script>

	<script type="text/javascript" src="<%=path%>/media/js/chosen.jquery.min.js"></script>

	<script type="text/javascript" src="<%=path%>/media/js/select2.min.js"></script>

	<script type="text/javascript" src="<%=path%>/media/js/wysihtml5-0.3.0.js"></script> 

	<script type="text/javascript" src="<%=path%>/media/js/bootstrap-wysihtml5.js"></script>

	<script type="text/javascript" src="<%=path%>/media/js/jquery.tagsinput.min.js"></script>

	<script type="text/javascript" src="<%=path%>/media/js/jquery.toggle.buttons.js"></script>

	<script type="text/javascript" src="<%=path%>/media/js/bootstrap-datepicker.js"></script>

	<script type="text/javascript" src="<%=path%>/media/js/bootstrap-datetimepicker.js"></script>

	<script type="text/javascript" src="<%=path%>/media/js/clockface.js"></script>

	<script type="text/javascript" src="<%=path%>/media/js/date.js"></script>

	<script type="text/javascript" src="<%=path%>/media/js/daterangepicker.js"></script> 

	<script type="text/javascript" src="<%=path%>/media/js/bootstrap-colorpicker.js"></script>  

	<script type="text/javascript" src="<%=path%>/media/js/bootstrap-timepicker.js"></script>

	<script type="text/javascript" src="<%=path%>/media/js/jquery.inputmask.bundle.min.js"></script>   

	<script type="text/javascript" src="<%=path%>/media/js/jquery.input-ip-address-control-1.0.min.js"></script>

	<script type="text/javascript" src="<%=path%>/media/js/jquery.multi-select.js"></script>   

	<script src="<%=path%>/media/js/bootstrap-modal.js" type="text/javascript" ></script>

	<script src="<%=path%>/media/js/bootstrap-modalmanager.js" type="text/javascript" ></script> 
	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="<%=path%>/media/js/app.js" type="text/javascript"></script>
	<!-- <script src="<%=path%>/media/js/form-samples.js"></script> -->
	<script src="<%=path%>/media/js/form-components.js"></script>
	<%-- <script src="<%=path%>/media/js/table-managed.js"></script> --%>
	<!-- END PAGE LEVEL SCRIPTS -->
	<!-- <script type="text/javascript">
		$("#duang").change(function(){
			if($("#duang").is(':checked')){
				$(this).val('true');
			}else{
				$(this).val('false');
			}
		});
	</script> -->
	<script>
		jQuery(document).ready(function() {    
		   App.init(); // initlayout and core plugins
		   //FormSamples.init();
		   FormComponents.init();
		});
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>