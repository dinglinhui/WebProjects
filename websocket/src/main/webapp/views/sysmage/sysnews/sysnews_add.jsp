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
							新闻管理 
							<small>
								<c:choose>
									<c:when test="${news.id == null}">
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
								<a href="<%=path%>/sysnews/list">新闻列表</a>
								<i class="icon-angle-right"></i>
							</li>
							<li><a href="#">添加新闻</a></li>
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
							
									<form action="<%=path%>/sysnews/add" class="form-horizontal" id="newsadd_form" method="post"
														onkeydown="if(event.keyCode==13){return false;}">

										<div class="control-group">
	
											<label class="control-label">新闻标题</label>
	
											<div class="controls">
											
												<input class="m-wrap medium" name="id" type="text" value="${news.id}" style="display:none;" readonly />
	
												<input type="text" placeholder="title" class="m-wrap large" id="title" name="title" value="${news.title}" 
														onblur="validate(this)" />
	
												<span class="help-inline">(30字以内)</span>
	
											</div>
	
										</div>
	
										<div class="control-group">
	
											<label class="control-label">发布人</label>
	
											<div class="controls">   
	
												<input class="m-wrap medium" name="user.id" type="text" value="${currentUser.id}" style="display:none;" readonly />
	
												<input class="m-wrap medium" type="text" value="${currentUser.username}" readonly />
												
											</div>
	
										</div>
	
										<div class="control-group">
	
											<label class="control-label">发布日期</label>
	
											<div class="controls">
	
												<div class="input-append date form_datetime" data-date="2015-3-12T15:25:00Z">
	
													<input size="16" type="text" readonly class="m-wrap">
	
													<span class="add-on"><i class="icon-remove"></i></span>
	
													<span class="add-on"><i class="icon-calendar"></i></span>
	
												</div>
	
											</div>
	
										</div>
										
										<div class="control-group">
	
											<label class="control-label">是否高亮</label>
	
											<div class="controls">
	
												<div class="basic-toggle-button">
												
													<input type="checkbox" name="duang" id="duang" class="toggle" value="false" ${news.duang ? 'checked' : ''}/>
	
												</div>
												
											</div>
											
										</div>
	
										<div class="control-group">
	
											<label class="control-label">新闻类别</label>
	
											<div class="controls">
	
												<select class="medium m-wrap" name="type.id" tabindex="1">
												
													<c:forEach items="${typename}" var="m">
														<option value="${m.id}" ${news.type.id == m.id ? 'selected' : ''}>${m.name}</option>
													</c:forEach>
	
												</select>
	
											</div>
	
										</div>
										
	
										<div class="control-group">
	
											<label class="control-label">新闻标签</label>
	
											<div class="controls">
	
												<select data-placeholder="Your Favorite Football Teams" class="chosen span6" multiple="multiple" tabindex="6">
	
													<option value=""></option>
	
													<optgroup label="主流">
	
														<option>感动</option>
	
														<option selected>正能量</option>
	
														<option selected>科技</option>
	
														<option>值得收藏</option>
	
													</optgroup>
	
													<optgroup label="唏嘘">
	
														<option>愤怒</option>
	
														<option>炒作</option>
	
														<option>地域攻击</option>
	
														<option>负能量</option>
														
													</optgroup>
	
													<optgroup label="非主流">
	
														<option>元芳你怎么看</option>
	
														<option selected>标题党</option>
	
														<option>小编坑爹</option>
	
													</optgroup>
	
												</select>
	
											</div>
	
										</div>
	
										<div class="control-group">
	
											<label class="control-label">图片上传</label>
	
											<div class="controls">
	
												<div class="fileupload fileupload-new" data-provides="fileupload">
	
													<div class="fileupload-new thumbnail" style="width: 200px; height: 150px;">
	
														<img src="<%=path%>/media/image/uploadimag.png" alt="" />
	
													</div>
	
													<div class="fileupload-preview fileupload-exists thumbnail" style="max-width: 200px; max-height: 150px; line-height: 20px;"></div>
	
													<div>
	
														<span class="btn btn-file"><span class="fileupload-new">Select image</span>
	
														<span class="fileupload-exists">Change</span>
	
														<input type="file" class="default" /></span>
	
														<a href="#" class="btn fileupload-exists" data-dismiss="fileupload">Remove</a>
	
													</div>
	
												</div>
	
											</div>
	
										</div>
										
										<div class="control-group">
	
											<label class="control-label">新闻内容编辑</label>
	
											<div class="controls">
	
												<textarea name="content" class="span12 wysihtml5 m-wrap" rows="6" >${news.content}</textarea>
	
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
	<script type="text/javascript">
		$("#duang").change(function(){
			if($("#duang").is(':checked')){
				$(this).val('true');
			}else{
				$(this).val('false');
			}
		});
	</script>
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