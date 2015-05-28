<%@ page language="java" pageEncoding="UTF-8"%>
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
							分类类别  <small>列别管理列表</small>
						</h3>
						<ul class="breadcrumb">
							<li>
								<i class="icon-home"></i>
								<a href="<%=path%>/sysmage/home">Home</a> 
								<i class="icon-angle-right"></i>
							</li>
							<li><a href="#">分类列表</a></li>
						</ul>
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->
				<!-- BEGIN PAGE CONTENT-->
				<div class="row-fluid">
					<div class="span12">
						<!-- BEGIN EXAMPLE TABLE PORTLET-->
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
								<div class="clearfix">
									<div class="btn-group">
										<button id="sample_editable_1_new" class="btn green" onclick="window.location='<%=path%>/syscategory/add'">
										Add New <i class="icon-plus"></i>
										</button>
									</div>
									<div class="btn-group pull-right">
										<button class="btn dropdown-toggle" data-toggle="dropdown">Tools <i class="icon-angle-down"></i>
										</button>
										<ul class="dropdown-menu pull-right">
											<li><a href="#">Print</a></li>
											<li><a href="#">Save as PDF</a></li>
											<li><a href="#">Export to Excel</a></li>
										</ul>
									</div>
								</div>
								<table class="table table-striped table-bordered table-hover" id="A">
									<thead>
										<tr>
											<th style="width:8px;"><input type="checkbox" class="group-checkable" data-set=".checkboxes" /></th>
											<th class="center">ID</th>
											<th class="hidden-480">上级ID</th>
											<th class="hidden-480">分类名称</th>
											<th class="hidden-480">创建日期</th>
											<th class="hidden-480">窗体背景</th>
											<th class="hidden-480">操作</th>
										</tr>
									</thead>
								</table>
							</div>
						</div>
						<!-- END EXAMPLE TABLE PORTLET-->
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
	<script type="text/javascript" src="<%=path%>/media/js/select2.min.js"></script>
	<script type="text/javascript" src="<%=path%>/media/js/jquery.dataTables.js"></script>
	<script type="text/javascript" src="<%=path%>/media/js/DT_bootstrap.js"></script>
	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="<%=path%>/media/js/app.js" type="text/javascript"></script>
	<!-- END PAGE LEVEL SCRIPTS -->
	<script type="text/javascript">
	jQuery(function($) {
		var oTable1 = $('#A').dataTable({
			"aLengthMenu": [
                [5, 15, 20, -1],
                [5, 15, 20, "All"] // change per page values here
            ],
            // set the initial value
            "iDisplayLength": 5,
            "sDom": "<'row-fluid'<'span6'l><'span6'f>r>t<'row-fluid'<'span6'i><'span6'p>>",
            "sPaginationType": "bootstrap",
            "oLanguage": {
                "sLengthMenu": "_MENU_ records per page",
                "oPaginate": {
                    "sPrevious": "Prev",
                    "sNext": "Next"
                }
            },
			"sServerMethod" : "POST",
			"bServerSide" : true,
			"bAutoWidth" : true,
			"sAjaxSource" : "<%=path%>/syscategory/list",
			"aoColumnDefs" : [ 
								{ 'bSortable': false,
								    'aTargets': [0]},
								{sDefaultContent: '',
								 aTargets: [ '_all' ]}
			                 ],
			"aoColumns" : [ 
					{"mData" : null,
						"fnRender": function(obj) {
							return '<div class="checker hover"><span><input type="checkbox" class="checkboxes" value="1"></span></div>';
						}
					},
					{"mData" : "id"}, 
					{"mData" : "parentId.id"}, 
					{"mData" : "name"}, 
					{"mData" : "created"}, 
					{"mData" : "misc1"}, 
					{"mData" : null,
						"fnRender" : function(obj) {
							
							var id = obj.aData.id;

							var tmpl = '<a href="<%=path%>/syscategory/update?id=' + id + '" class="label">修改</a>';
							var disable = '<a href="javascript:void(0)" data-method="delete" data-id="' + id + '" class="label label-danger">删除</a>';
							tmpl = tmpl + disable;
							
							return tmpl;
						}
					}, 
				],
			"fnDrawCallback" : function(setting) {
				
				//重新计算高度
				//calcIframeSize();
				
				$(".label").click(function() {
					
					var method = $(this).data("method");
					
					if (undefined == method) {
						
						return;
					}
					
					var id = $(this).data("id");
					
					var url = "<%=path%>/syscategory/" + method + "?id=" + id;

					var hint = method == "disable" ? "确认禁用该用户？":"确认启用该用户？";
					
					bootbox.confirm(hint, function(result) {
						
						if (result) {
							$.ajax({
								"dataType" : 'json',
								"type" : "POST",
								"url" : url,
								"success" : function(data) {

									bootbox.dialog({
										message : data.message,
										title : "消息",
										buttons : {
											success : {
												label : "我知道了",
												className : "btn-primary",
												callback : function() {
													
													oTable1.fnDraw();
												}
											},
										}
									});
								}
							});
						}
					});
				});
			}
		});
	});
</script> 
	<script>
		jQuery(document).ready(function() {    
		   App.init(); // initlayout and core plugins
		});
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>