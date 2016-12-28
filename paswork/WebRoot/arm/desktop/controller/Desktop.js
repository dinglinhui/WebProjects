Ext.define('Arm.controller.Desktop', {
	extend : 'Ext.app.Controller',

	models : ['Node'],

	refs : [{
				ref : 'navigation',
				selector : 'navigation'
			}, {
				ref : 'container',
				selector : 'atscontainer'
			}],

	init : function() {
		var me = this;
		this.control({
					'viewport' : {
						render : me.onRender
					},
					scope : me
				});
	},

	onRender : function() {
		var me = this;
		Ext.get('loading-msg').update('正在加载菜单...');
		Ext.Ajax.request({
					url : appBasePath + 'resource/root',// 获取面板的地址
					method : 'GET',
					params : {
						reqCode : "list"
					},
					callback : function(options, success, response) {
						me.createTree(Ext.JSON.decode(response.responseText));
					}
				});
	},

	createTree : function(datas) {
		var me = this;
		Ext.each(datas, function(data) {
					var tree = Ext.create("Ext.tree.Panel", {
								title : data.text,
								iconCls : data.iconCls,
								useArrows : true,//useArrows设置为true，Tree Panel就会隐藏前导线使用箭头表示节点的展开
								autoScroll : true,//自动滚动条  
								animate : true,//动画效果  
								//expanded: true,
								//expandable:true,
								split: true,
								border : false,
								rootVisible : false,
								viewConfig : {
									loadingText : "正在加载..."
								},
					           	store : me.createTreeStore(data.id),				         
					           	/*tbar:[{
					            	xtype:'button',  
					            	id:'expand',  
					            	iconCls:'icon-expand-all',
					            	text:'全部展开',  
					            	scope: this,
					            	handler:function(btn){  
					            		var tr=btn.ownerCt.ownerCt;  
					            	  	tr.expandAll();  
					            	}  
					          	},{  
					            	xtype:'button',  
					            	id:'collapse',  
					            	iconCls:'icon-collapse-all',
					            	text:'全部折叠',  
					            	scope: this,
					            	handler:function(btn){  
					            		var tr=btn.ownerCt.ownerCt;  
					            		tr.collapseAll();  
					            	}  
					           	}],*/
							});
					//tree.getRootNode().expand(true,true);
					//tree.expandAll();
					tree.on('itemclick', me.onTreeItemClick, me);
					me.getNavigation().add(tree);
					
				});
		Ext.get('loading-msg').update('加载完成.');
		Ext.Function.defer(function() {
					Ext.get('loading-tip').remove();
				}, 1000);
	},

	onTreeItemClick : function(view, node) {
		var tab = this.getContainer();
		if (node.isLeaf()) { // 判断是否是根节点
			var myTabPanel = tab.getComponent(node.data.id);
            if (!myTabPanel) { //判断是否已经打开该面板
            	if (node.data.type === 'URL') { // 判断资源类型
    				var panel = Ext.create('Ext.panel.Panel', {
    					id : node.data.id,
    					title : node.data.text,
    					closable : true,
    					iconCls : node.data.iconCls,
    					html : '<iframe width="100%" height="100%" frameborder="0" src="http://www.baidu.com"></iframe>'
    				});
    				tab.add(panel);
    				tab.setActiveTab(panel);
    			} else if (node.data.type === 'COMPONENT') {
    				var panel = Ext.create(node.data.component, {
    					id : node.data.id,
    					title : node.data.text,
    					closable : true,
    					iconCls : node.data.iconCls,
    				});
    				tab.add(panel);
    				tab.setActiveTab(panel);
    			}
            } else {
            	tab.setActiveTab(myTabPanel);
            }
			
		}
	},

	createTreeStore : function(id) {

		return Ext.create("Ext.data.TreeStore", {
					defaultRootId : id, // 默认的根节点id
					model : this.getNodeModel().$className,
					proxy : {
						type : 'ajax', // 获取方式
						url : appBasePath + "resource/child" // 获取树节点的地址
					},
					clearOnLoad : true,
					nodeParam : 'id',// 设置传递给后台的参数名,值是树节点的id属性
					//expanded:true,
					//expandable:true,
				});
	}
});