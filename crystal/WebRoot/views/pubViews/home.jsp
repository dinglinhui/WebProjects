<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd"> 
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" > 
	<head>
		<base href="<%=basePath%>">
		<title>See Interface</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		
		 <!-- Jquery directly from google servers--> 
		<script type="text/javascript" src="<%=basePath%>resources/js/jquery.min.js" ></script>
		
		 <!-- WYSIWYG Editor --> 
		<script type="text/javascript" src="<%=basePath%>resources/js/jquery.wysiwyg.js"></script> 
		
		<!-- Style switcher --> 
		<script type="text/javascript" src="<%=basePath%>resources/js/stylesheetToggle.js"></script>
		
		<link rel="stylesheet" type="text/css" media="all" href="<%=basePath%>resources/css/reset.css" />
		<link rel="stylesheet" type="text/css" media="all" href="<%=basePath%>resources/css/blue.css" />
		
		<!-- comment extra.css for css validation -->
		<link rel="stylesheet" type="text/css" media="all" href="<%=basePath%>resources/css/extra.css" />
		
		<link rel="alternate stylesheet" title="red" type="text/css" media="all" href="<%=basePath%>resources/css/red.css" />
		<link rel="alternate stylesheet" title="green" type="text/css" media="all" href="<%=basePath%>resources/css/green.css" />
		<link rel="alternate stylesheet" title="brown" type="text/css" media="all" href="<%=basePath%>resources/css/brown.css" />

		<!-- See Interface Configuration --> 
		<script type="text/javascript" src="<%=basePath%>resources/js/seeui.js"></script>
		
	</head>
		
	<body>
		<div id="bk">
		
		 <!-- Header  --> 
		<div id="pannelDash" class="clearfix">
			
			 <!-- Tabs--> 
			<div class="menu">
				<ul>
					<li class="selected">
						<a href="#" onclick="showOnly('tabDashboard','dashWidget')">
						<img src="<%=basePath%>resources/images/icons/home.png" alt="Dashboard" />Dashboard</a>
					</li>
					<li>
						<a href="#" onclick="showOnly('tabSettings','dashWidget')">Settings</a>
					</li>
					<li>
						<a href="#" onclick="showOnly('tabAccount','dashWidget')">Account</a>
					</li>
				</ul>
				<div class="info">
					<div><a href="#" class="icOff">Sign off</a></div>
					<div class="user">
						<img width="27" height="27" src="<%=basePath%>resources/images/user_icon.png" alt="User name" />
						<span >Nicolae Gabriel</span>
						<span class="detail">Last login : 25 Ian 2009</span>
					</div>
				</div>
				
				<div class="theme">
					<a href="#" class="styleswitch red" rel="red">&nbsp;</a>
					<a href="#" class="styleswitch green" rel="green">&nbsp;</a>
					<a href="#" class="styleswitch brown" rel="brown">&nbsp;</a>
					<a href="#" class="styleswitch blue" rel="blue">&nbsp;</a>
					<span> Theme </span>
				</div>
			</div>
			
			 <!-- Dashboard fast menu (6 items)  --> 
			<div class="dashboard">
				<ul>
					<li>
						<a href="#">
							<img src="<%=basePath%>resources/images/dash/users.png" alt="Manage users!" />
							Manage users
						</a>
					</li>
					<li>
						<a href="#">
							<img src="<%=basePath%>resources/images/dash/edit.png" alt="Edit article!" />
							Edit article
						</a>
					</li>
					<li>
						<a href="#">
							<img src="<%=basePath%>resources/images/dash/add.png" alt="Write a new article!" />
							Write article
						</a>
					</li>
					<li>
						<a href="#">
							<img src="<%=basePath%>resources/images/dash/database.png" alt="Database manager!" />
							DB manager
						</a>
					</li>
					<li>
						<a href="#">
							<img src="<%=basePath%>resources/images/dash/chat.png" alt="Recent comments!" />
							New comments
						</a>
					</li>
					<li>
						<a href="#">
							<img src="<%=basePath%>resources/images/dash/delete.png" alt="View deleted documents!" />
							Trash
						</a>
					</li>
				</ul>
			</div>
			
			 <!-- Large left widget --> 
			<!-- <div class="widget dashWidget">
				<div class="content tabContent">
					<div class="tabDashboard">&nbsp;</div>
					<div class="tabSettings">
						<div class="fields">
							<p class="sep">
								<label class="small" for="user02">User name</label>
								<input type="text" value="" class="sText" id="user02"/>
							</p>
												
							<p class="sep">
								<label class="small" for="select02">Time/Zone</label>
								<select class="sSelect" id="select02">
									<option value="ro">Romania</option>
									<option value="fr">France</option>
									<option value="ge">Germany</option>
									<option value="hu">Hungary</option>
									<option value="gr">Greece</option>
								</select>
							</p>
													
							<div class="fields">
								<p>&nbsp;   </p>
								<p> <input class="sCheck" type="checkbox" name="ts_1" value="ts_1" id="check08"/><label for="check08">Recive daily report</label> </p>
								<p> <input class="sCheck" type="checkbox" name="ts_2" value="ts_2" id="check09"/><label for="check09">Recive weekly report</label> </p>
							</div>
						</div>
						
					</div>
					<div class="tabAccount">&nbsp;</div>
				</div>
			</div> -->
		</div>
		
		 <!-- Tooltip zone --> 
		<%-- <div class="toolTip tpYellow" >
			<p class="clearfix">
				<img src="<%=basePath%>resources/images/icons/light-bulb-off.png" alt="Tip!" />
				We have some storage problems, to review problem please click here.
			</p>
			
			<a class="close" title="Close"></a>
		</div> --%>
		
		<div id="container" class="clearfix">
			 <!-- Left Menu --> 
			<%-- <div id="menu">
				<ul>
					<li>
						<a href="#" class="clearfix">
							<img src="<%=basePath%>resources/images/icons/home-network.png" class="icon" alt=""/>
							Home
							<span></span>
						</a>
						
						 <!-- Sub items --> 
						<ol class="clearfix">
							<li>
								<a href="http://www.google.ro/">
									<img src="<%=basePath%>resources/images/icons/application-small-list.png" class="icon" alt="Dashboard" />
									Dashboard
									<span class="pin"><img src="<%=basePath%>resources/images/pin-small.png" alt="" /></span>
								</a>
							</li>
							
							<li>
								<a href="http://www.google.ro/">
									<img src="<%=basePath%>resources/images/icons/mail-small.png" class="icon" alt="Contact e-mails" />
									Contact e-mails
									<span class="pin"><img src="<%=basePath%>resources/images/pin-small.png" alt="" /></span>
								</a>
							</li>
							
							<li class="pin">
								<a href="http://www.google.com/">
									<img src="<%=basePath%>resources/images/icons/plus-small.png" class="icon" alt="New page" />
									New page
									<span class="pin"><img src="<%=basePath%>resources/images/pin-small.png" alt="" /></span>
								</a>
							</li>
						</ol>
					</li>
				
					<li class="expanded">
						<a href="#" class="clearfix">
							<img src="<%=basePath%>resources/images/icons/chart-up.png" class="icon" alt="Trafic analytics"/>
							Trafic Analytics
							<span></span>
						</a>
							
						<ol class="clearfix">
							<li>
								<a href="#">
									<img src="<%=basePath%>resources/images/icons/feed-small.png" class="icon" alt="Site feeds" />
									Site feeds
									<span class="pin"><img src="<%=basePath%>resources/images/pin-small.png" alt="" /></span>
								</a>
							</li>
							
							<li class="pin">
								<a href="#">
									<img src="<%=basePath%>resources/images/icons/mouse-select.png" class="icon" alt="Feeds clicks today" />
									Feeds clicks today
									<span class="pin"><img src="<%=basePath%>resources/images/pin-small.png" alt="" /></span>
								</a>
							</li>
							
							<li>
								<a href="#" class="selected">
									<img src="<%=basePath%>resources/images/icons/edit-code.png" class="icon" alt="Tracking code" />
									Tracking code
									<span class="pin"><img src="<%=basePath%>resources/images/pin-small.png" alt="" /></span>
								</a>
							</li>
							
							<li>
								<a href="#">
									<img src="<%=basePath%>resources/images/icons/marker.png" class="icon" alt="Goals" />
									Goals
									<span class="pin"><img src="<%=basePath%>resources/images/pin-small.png" alt="" /></span>
								</a> 
							</li>
						</ol>
					</li>
					
					<li>
						<a href="#">
							<img src="<%=basePath%>resources/images/icons/feed-balloon.png" class="icon" alt="Site feeds" />
							Site feeds
						</a>
					</li>
					
					<li>
						<a href="#">
							<img src="<%=basePath%>resources/images/icons/folder-horizontal.png" class="icon" alt="Folder structure" />
							Folder structure
							<span></span>
						</a>
						
						<ol class="clearfix">
							<li>
								<a href="#">
									<img src="<%=basePath%>resources/images/icons/plus-small.png" class="icon" alt="New folder"/>
									New folder
									<span class="pin"><img src="<%=basePath%>resources/images/pin-small.png" alt="" /></span>
								</a>
							</li>
						</ol>
					</li>
					
					<li>
						<a class="icFTP" href="#">
							<img src="<%=basePath%>resources/images/icons/folder-network.png" class="icon" alt="" />
							Ftp settings
						</a>
					</li>
					
					<li class=".custom">
						<a href="#">
							<img src="<%=basePath%>resources/images/icons/puzzle.png" class="icon" alt="" />
							Add Custom widget here!
						</a>
					</li>
					
					<li class="tasks widget">
						<a href="#">
							<img src="<%=basePath%>resources/images/icons/calendar-task.png" class="icon" alt="Tasks" />
							Tasks
							<span></span>
						</a>
						<div class="content" style="background:url('./<%=basePath%>resources/images/th_green/menu_item_bk.jpg') no-repeat top left;">
							<ul>
								<li>Add analytics code</li>
								<li>Optimze contact page for mobile</li>
								<li>Add news section</li>
								<li>Remove ie6 suport</li>
								<li>Install cache script</li>
							</ul>
						</div>
					</li>
					
					 <!-- Widget --> 
					<li class="calendar widget expanded">
						<a href="#" class="expanded">
							<img src="<%=basePath%>resources/images/icons/calendar-month.png" class="icon" alt="Calendar" />
							Calendar
							<span></span>
						</a>
						<div class="content">
							<table cellpadding="0" cellspacing="2" class="ctb">
							<caption>Wednesday, 14 October</caption>
							 <tbody>
							 <tr>
								<th scope="col" title="Monday">M</th>
								<th scope="col" title="Tuesday">T</th>
								<th scope="col" title="Wednesday">W</th>
								<th scope="col" title="Thursday">T</th>
								<th scope="col" title="Friday">F</th>
								<th scope="col" title="Saturday">S</th>
								<th scope="col" title="Sunday">S</th>
							 </tr>
							 <tr>
								<td class="out">28</td>
								<td class="out">29</td>
								<td class="out">30</td>
								<td>1</td>
								<td>2</td>
								<td>3</td>
								<td>4</td>
							 </tr>
							 <tr>
								<td>5</td>
								<td>6</td>
								<td>7</td>
								<td>8</td>
								<td>9</td>
								<td>10</td>
								<td>11</td>
							 </tr>
							 <tr>
								<td>12</td>
								<td>13</td>
								<td class="today"><span>14</span></td>
								<td>15</td>
								<td>16</td>
								<td>17</td>
								<td>18</td>
							 </tr>
							 <tr>
								<td>19</td>
								<td>20</td>
								<td>21</td>
								<td>22</td>
								<td>23</td>
								<td>24</td>
								<td>25</td>
							 </tr>
							 <tr>
								<td>26</td>
								<td>27</td>
								<td>28</td>
								<td>29</td>
								<td>30</td>
								<td>31</td>
								<td class="out">1</td>
							 </tr>
							</tbody></table>
						</div>
					</li>
				</ul>
			</div> --%>
			
			<div id="page">
				<div class="menu clearfix">
					 <!-- Page Dropdown  Menu --> 
					<ul id="pgmenu">
						<li><a href="#" class="sub">Main menu<span>&nbsp;</span></a>
							<ul>
								<li><a href="#">Drop Down Menu</a></li>
								<li><a href="#">jQuery Plugin</a></li>
								<li><a href="#">Ajax Navigation</a></li>
							</ul>
						</li>
						<li><a href="#" class="sub">Import<span>&nbsp;</span></a>
							<ul>
								<li><a href="#">Slide Effect</a></li>
								<li><a href="#">Fade Effect</a></li>
								<li><a href="#">Opacity Mode</a></li>
								<li><a href="#">Drop Shadow</a></li>
								<li><a href="#">Semitransparent</a></li>
							</ul>
						</li>
						<li><a href="#">Export</a></li>
						<li><a href="#">Help</a></li>
					</ul>
					
					 <!-- Page title --> 
					<div>Product Manager</div>
					<div class="cr_pass"></div>
				</div>
				
				<div class="clearfix content">
					 <!-- Page content --> 
				
					 <!-- Tab bar component --> 
					<div class="clearfix tabbar barProds">
						<ul class="tabs">
							<li class="tab1">
								<a class="selected" onclick="showOnly('tab1','barProds')" >
									<img src="<%=basePath%>resources/images/icons/notebooks.png" alt="Search product!"/>
									Table
								</a>
							</li>
							
							<li class="tab2">
								<a  onclick="showOnly('tab2','barProds')">
									<img src="<%=basePath%>resources/images/icons/plus-small.png" alt="Add product!"/>
									Fields
								</a>
							</li>
							
							<li class="tab3" style="display:none;">
								<a onclick="showOnly('tab3','barProds')" >
									<img src="<%=basePath%>resources/images/icons/magnifier_medium.png" alt="Search product!"/>
									Search
								</a>
							</li>
							
							<li class="tab4">
								<a onclick="showOnly('tab4','barProds')" >
									Error messages
								</a>
							</li>
						</ul>
						<div class="tabContent clearfix">
							<div class="tab1">
								<table cellpadding="0" cellspacing="0" border="0" id="table" class="uiTable"> 
									<thead> 
										<tr> 
											<th class="nosort" style="width:12px;"><h3>Opt</h3></th> 
											<th><h3>Name</h3></th> 
											<th><h3>Email</h3></th> 
											<th><h3>Birthdate</h3></th> 
											<th><h3>Rating</h3></th> 
										</tr> 
									</thead> 
									<tbody> 
										<tr> 
											<td><input type="checkbox" /></td> 
											<td>Ezekiel Hart</td> 
											<td><a href="mailto:#">tortor@est.ca</a></td> 
											<td>12/02/1962</td> 
											<td>-7</td> 
										</tr> 
										<tr> 
											<td><input type="checkbox" /></td> 
											<td>Jaquelyn Pace</td> 
											<td><a href="mailto:#">in@elementum.org</a></td> 
											<td>06/03/1957</td> 
											<td>-7</td> 
										</tr> 
										<tr> 
											<td><input type="checkbox" /></td> 
											<td>Lois Pickett</td> 
											<td><a href="mailto:#">arcu.ac@disse.ca</a></td> 
											<td>10/15/1983</td> 
											<td>4</td> 
										</tr> 
										<tr> 
											<td><input type="checkbox" /></td> 
											<td>Keane Raymond</td> 
											<td><a href="mailto:#">at.risus.Nunc@ipsum.com</a></td> 
											<td>07/30/1982</td> 
											<td>5</td> 
										</tr> 
										<tr> 
											<td><input type="checkbox" /></td> 
											<td>Porter Thomas</td> 
											<td><a href="mailto:#">non@Proin.ca</a></td> 
											<td>09/27/1986</td> 
											<td>1</td> 
										</tr> 
										<tr> 
											<td><input type="checkbox" /></td> 
											<td>Imani Murphy</td> 
											<td><a href="mailto:#">Aenean.sed@elit.ca</a></td> 
											<td>10/23/1970</td> 
											<td>-1</td> 
										</tr> 
										<tr> 
											<td><input type="checkbox" /></td> 
											<td>Zachery Guthrie</td> 
											<td><a href="mailto:#">nunc.nulla@vel.com</a></td> 
											<td>12/22/1972</td> 
											<td>-5</td> 
										</tr> 
										<tr> 
											<td><input type="checkbox" /></td> 
											<td>Harper Bowen</td> 
											<td><a href="mailto:#">dis@duinec.ca</a></td> 
											<td>10/26/1973</td> 
											<td>5</td> 
										</tr> 
										<tr> 
											<td><input type="checkbox" /></td> 
											<td>Caldwell Larson</td> 
											<td><a href="mailto:#">elit@dolor.com</a></td> 
											<td>07/20/1985</td> 
											<td>-3</td> 
										</tr> 
										<tr> 
											<td><input type="checkbox" /></td> 
											<td>Baker Osborn</td> 
											<td><a href="mailto:#">turpis.Nulla@ac.edu</a></td> 
											<td>03/29/1970</td> 
											<td>-7</td> 
										</tr> 
										<tr> 
											<td><input type="checkbox" /></td> 
											<td>Yael Owens</td> 
											<td><a href="mailto:#">nunc.ac.mattis@enim.com</a></td> 
											<td>08/10/1963</td> 
											<td>10</td> 
										</tr> 
										<tr> 
											<td><input type="checkbox" /></td> 
											<td>Fletcher Briggs</td> 
											<td><a href="mailto:#">amet.ante@lentesque.edu</a></td> 
											<td>08/12/1971</td> 
											<td>7</td> 
										</tr> 
										<tr> 
											<td><input type="checkbox" /></td> 
											<td>Maggy Murphy</td> 
											<td><a href="mailto:#">eu@Integer.com</a></td> 
											<td>07/11/1968</td> 
											<td>9</td> 
										</tr> 
										<tr> 
											<td><input type="checkbox" /></td> 
											<td>Maggie Blake</td> 
											<td><a href="mailto:#">rutrum.non.hendrerit@iaculis.org</a></td> 
											<td>04/11/1970</td> 
											<td>-2</td> 
										</tr> 
										<tr> 
											<td><input type="checkbox" /></td> 
											<td>Ginger Bell</td> 
											<td><a href="mailto:#">erat.in.conetuer@pedenout.org</a></td> 
											<td>06/10/1957</td> 
											<td>-10</td> 
										</tr> 
										<tr> 
											<td><input type="checkbox" /></td> 
											<td>Iliana Ballard</td> 
											<td><a href="mailto:#">vel.sapien@mi.ca</a></td> 
											<td>02/09/1989</td> 
											<td>-6</td> 
										</tr> 
										<tr> 
											<td><input type="checkbox" /></td> 
											<td>Alisa Monroe</td> 
											<td><a href="mailto:#">adipiscing.ligula@aretraNam.edu</a></td> 
											<td>02/14/1990</td> 
											<td>6</td> 
										</tr> 
									</tbody> 
								</table>
								
								 <!-- Navigation controls --> 
								<div class="barNav clearfix">
									<a class="butNav" href="#">&laquo; First</a>
									<a class="butNav" href="#">&laquo; Previous</a>
									<a class="butNav" href="#">2</a>
									<a class="butPage" href="#">3</a>
									<a class="butNav" href="#">4</a>
									<a class="butNav" href="#">Next &raquo;</a>
									<a class="butNav" href="#">Last &raquo;</a>
								</div>
							</div>
							
							<div class="tab2" style="display:none;">
								<!--  Tab 2 content -->
								 
								 <!-- Form elements --> 
								<div class="fields clearfix">
									<h2>Search for users</h2>
									<p>
										<label class="small" for="user01">User</label> <input id="user01" type="text" value="" class="sText small"/>
										<select class="sSelect">
											<option value="1">Profile</option>
											<option value="2">Description</option>
											<option value="3">Location</option>
											<option value="4">Budget</option>
											<option value="5">Nickname</option>
										</select>
										<input type="submit" class="butDef" value="Search" />
										<span>Error, data not valid</span>
									</p>
								</div>
								
								<div class="fields">
									<h2>User information</h2>
									<p>
										<label for="name01" class="small">Name</label> <input id="name01" type="text" value="" class="sText"/>
										<span>Error, data not valid</span>
									</p>
									
									<p class="error">
										<label class="small" for="prename01">Prename</label> <input id="prename01" type="text" value="" class="sText"/>
										<span>Invalid data, please retype correct information!</span>
									</p>
									
									<p><label class="small" for="mail01">E-mail</label> <input type="text" value="" class="sText" id="mail01"/></p>
									<p><label class="small" for="phone01">Phone</label> <input type="text" value="" class="sText" id="phone01"/></p>
									
									<p class="sep">
										<label class="small" for="city01">State/City</label>
										<input type="text" value="" class="sText small" id="city01"/>
										<input type="text" value="" class="sText small"/>
									</p>
									
									<p>
										<label class="small" for="date01">Date</label>
										<input type="text" value="" id="date01" class="sText tiny"/>
										<input type="text" value="" class="sText tiny"/>
										<input type="text" value="" class="sText tiny"/>
									</p>
									
									<p class="sep">
										<label class="small" for="select01">Country</label>
										<select class="sSelect" id="select01">
											<option value="ro">Romania</option>
											<option value="fr">France</option>
											<option value="ge">Germany</option>
											<option value="hu">Hungary</option>
											<option value="gr">Greece</option>
										</select>
									</p>
									
									<div class="fields">
										<h2>Your description</h2>
										<textarea cols="78" rows="10" class="wysiwyg sTextarea">Some things about me...</textarea>
									</div>
									
									<div class="fields">
										<form action="index.html" method="post">
										<h2>Accept this information?</h2>
										<p> <input type="radio" value="Yes" tabindex="2" class="sOption" name="group" id="rad01" checked="checked"/><label for="rad01">Yes</label> </p>
										<p> <input type="radio" value="No" tabindex="3"  class="sOption" name="group" id="rad02" /><label for="rad02" >No</label> </p>
										</form>
									</div>
									
									<div class="fields">
										<h2>Current subscription</h2>
										<p> <input class="sCheck" type="checkbox" name="ts_1" value="ts_1" id="check01"/><label for="check01">Recive daily report</label> </p>
										<p> <input class="sCheck" type="checkbox" name="ts_2" value="ts_2" id="check02"/><label for="check02">Recive weekly report</label> </p>
										<p> <input class="sCheck" type="checkbox" name="ts_3" value="ts_3" id="check03"/><label for="check03">Recive monthly report</label> </p>
									</div>
										
									<div class="fields">
										<h2></h2>
										<p class="tright">
											<input type="submit" class="butDef" value="Save" />
											<a class="butSim">Cancel</a>
											&nbsp;&nbsp;&nbsp;&nbsp;
											<input type="button" class="butDef" value="&laquo; Back" />
											<input type="button" class="butDef" value="Next &raquo;" />
										</p>
									</div>
									
								</div>
							</div>
							
							<div class="tab3" style="display:none;">
								<!--  Tab 3 content -->

							</div>
							
							<div class="tab4" style="display:none;">
								<!--  Tab 4 content -->
								
								 <!-- Tooltip styles  --> 
								<div class="toolTip tpRed clearfix" >
									<p>
										<img src="<%=basePath%>resources/images/icons/light-bulb-off.png" alt="Tip!" />
										We have some storage problems, to review problem please click here.
									</p>
									
									<a class="close" title="Close"></a>
								</div>
								
								<div class="toolTip tpBlue clearfix" >
									<p>
										<img src="<%=basePath%>resources/images/icons/light-bulb-off.png" alt="Tip!" />
										We have some storage problems, to review problem please click here.
									</p>
									
									<a class="close" title="Close"></a>
								</div>
								
								<div class="toolTip tpWhite clearfix" >
									<p>
										<img src="<%=basePath%>resources/images/icons/light-bulb-off.png" alt="Tip!" />
										We have some storage problems, to review problem please click here.
									</p>
									
									<a class="close" title="Close"></a>
								</div>
								
								<div class="toolTip tpGreen clearfix" >
									<p>
										<img src="<%=basePath%>resources/images/icons/light-bulb-off.png" alt="Tip!" />
										We have some storage problems, to review problem please click here.
									</p>
									
									<a class="close" title="Close"></a>
								</div>
							</div>
							
						</div>
					</div>
									
					<!--  Page content  -->
				</div>
			</div>
		</div>
		</div>
		
		
		 <!-- Table sort initialisation --> 
		<script type="text/javascript">
			var sorter = new TINY.table.sorter('sorter','table',{
				headclass:'head',
				ascclass:'asc',
				descclass:'desc',
				evenclass:'evenrow',
				oddclass:'oddrow',
				evenselclass:'evenselected',
				oddselclass:'oddselected',
				sortcolumn:1,
				init:true
			});
		</script>
		
		<!-- Google Analytics --> 
		<script type="text/javascript">
		var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
		document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
		</script>
		<script type="text/javascript">
		try {
		var pageTracker = _gat._getTracker("UA-11944791-1");
		pageTracker._setDomainName(".logntimber.com");
		pageTracker._trackPageview();
		} catch(err) {}</script>
		
	</body>

</html>
