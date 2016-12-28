Ext.define('Arm.view.Navigation', {
	   	    alias: 'widget.navigation',
			extend : 'Ext.panel.Panel',
			region : 'west',
			title : '系统导航',
			width : 250,
			iconCls : "icon-accordion",
			autoScroll : false,
			layout : 'accordion',
			margins: '0 0 0 0',
			collapsible : true,
			layoutConfig : {
				animate : true
			},
			id : 'navigation',
			split : true,
			initComponent : function(){
				this.callParent();
			}
		});