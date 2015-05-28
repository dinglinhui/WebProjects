<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!-- BEGIN PAGE LEVEL STYLES --> 

<link href="<%=path%>/media/css/jquery.gritter.css" rel="stylesheet" type="text/css"/>

<link href="<%=path%>/media/css/daterangepicker.css" rel="stylesheet" type="text/css" />

<link href="<%=path%>/media/css/fullcalendar.css" rel="stylesheet" type="text/css"/>

<link href="<%=path%>/media/css/jqvmap.css" rel="stylesheet" type="text/css" media="screen"/>

<link href="<%=path%>/media/css/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>

<link href="<%=path%>/media/css/error.css" rel="stylesheet" type="text/css">

<!-- END PAGE LEVEL STYLES -->

<!-- ----------------------------------------------------------------------------------------------------------- -->

<!-- BEGIN PAGE LEVEL PLUGINS -->

<script src="<%=path%>/media/js/jquery.vmap.js" type="text/javascript"></script>   
<script src="<%=path%>/media/js/jquery.vmap.russia.js" type="text/javascript"></script>
<script src="<%=path%>/media/js/jquery.vmap.world.js" type="text/javascript"></script>
<script src="<%=path%>/media/js/jquery.vmap.europe.js" type="text/javascript"></script>
<script src="<%=path%>/media/js/jquery.vmap.germany.js" type="text/javascript"></script>
<script src="<%=path%>/media/js/jquery.vmap.usa.js" type="text/javascript"></script>
<script src="<%=path%>/media/js/jquery.vmap.sampledata.js" type="text/javascript"></script>  
<script src="<%=path%>/media/js/jquery.flot.js" type="text/javascript"></script>
<script src="<%=path%>/media/js/jquery.flot.resize.js" type="text/javascript"></script>
<script src="<%=path%>/media/js/jquery.pulsate.min.js" type="text/javascript"></script>
<script src="<%=path%>/media/js/date.js" type="text/javascript"></script>
<script src="<%=path%>/media/js/daterangepicker.js" type="text/javascript"></script>     
<script src="<%=path%>/media/js/jquery.gritter.js" type="text/javascript"></script>
<script src="<%=path%>/media/js/fullcalendar.min.js" type="text/javascript"></script>
<script src="<%=path%>/media/js/jquery.easy-pie-chart.js" type="text/javascript"></script>
<script src="<%=path%>/media/js/jquery.sparkline.min.js" type="text/javascript"></script>  

<!-- END PAGE LEVEL PLUGINS -->

<!-- ----------------------------------------------------------------------------------------------------------- -->

<script>

	jQuery(document).ready(function() {    

	   App.init(); // initlayout and core plugins

	   Index.init();

	   Index.initJQVMAP(); // init index page's custom scripts 

	   Index.initCalendar(); // init index page's custom scripts

	   Index.initCharts(); // init index page's custom scripts

	   Index.initChat();

	   Index.initMiniCharts();

	   Index.initDashboardDaterange();

	   Index.initIntro();

	});

</script>