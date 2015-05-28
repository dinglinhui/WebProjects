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
	<link rel="shortcut icon" href="<%=path%>/media/image/favicon.ico" />
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
							新闻管理  <small>新闻列表</small>
						</h3>
						<ul class="breadcrumb">
							<li>
								<i class="icon-home"></i>
								<a href="<%=path%>/sysmage/home">Home</a> 
								<i class="icon-angle-right"></i>
							</li>
							<li><a href="#">新闻列表</a></li>
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
										<button id="sample_editable_1_new" class="btn green" onclick="window.location='<%=path%>/sysnews/add'">
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
											<th class="hidden-480">标题</th>
											<th class="hidden-480">内容连接</th>
											<th class="hidden-480">所属类别</th>
											<th class="hidden-480">创建日期</th>
											<th class="hidden-480">创建人</th>
											<th class="hidden-480">是否高亮</th>
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
	<%-- <script src="<%=path%>/media/js/table-managed.js"></script> --%>
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
			"sAjaxSource" : "<%=path%>/sysnews/list",
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
					{"mData" : "title"}, 
					{"mData" : null,
						"fnRender": function(obj) {
							var herf='<%=path%>/sysnews/news?id='+obj.aData.id;
							return '<a href="'+herf+'" class="label">点击查看内容</a>';
						}
					},
					{"mData" : "type.name"}, 
					{"mData" : "created"}, 
					{"mData" : "user.username"},
					{"mData" : null,
						"fnRender" : function(obj) {
							
							return obj.aData.duang ? "高亮" : "NULL";
						}	
					}, 
					{"mData" : null,
						"fnRender" : function(obj) {
							
							var id = obj.aData.id;

							var tmpl = '<a href="<%=path%>/sysnews/update?id=' + id + '" class="label">修改</a>';
							var disable = '<a href="<%=path%>/sysnews/delete?id=' + id + '" class="label">删除</a>';
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
						
						var url = "<%=path%>/sysnews/" + method + "?id=" + id;

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
		
		jQuery('#A .group-checkable').change(function () {
            var set = jQuery(this).attr("data-set");
            var checked = jQuery(this).is(":checked");
            jQuery(set).each(function () {
                if (checked) {
                    $(this).attr("checked", true);
                } else {
                    $(this).attr("checked", false);
                }
            });
            jQuery.uniform.update(set);
        });

        jQuery('#A_wrapper .dataTables_filter input').addClass("m-wrap medium"); // modify table search input
        jQuery('#A_wrapper .dataTables_length select').addClass("m-wrap small"); // modify table per page dropdown
        //jQuery('#A_wrapper .dataTables_length select').select2(); // initialzie select2 dropdown

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