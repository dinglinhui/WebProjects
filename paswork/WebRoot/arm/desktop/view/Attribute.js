var propsGrid = Ext.create('Ext.grid.property.Grid', {
        //width: 300,

		border:false,
        propertyNames: {
            tested: 'QA',
            borderWidth: 'Border Width'
        },
        source: {
            "(name)": "Properties Grid",
            "grouping": false,
            "autoFitColumns": true,
            "productionQuality": false,
            "created": Ext.Date.parse('10/15/2006', 'm/d/Y'),
            "tested": false,
            "version": 0.01,
            "borderWidth": 1
        }
    });

Ext.define('Arm.view.Attribute', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.attribute',
	region : 'east',
	title: '属性',
	animCollapse: true,
	collapsible: true,
	collapsed: true,
	split: true,
	width: 250, 
	//minSize: 175,
	//maxSize: 400,
	margins: '0 0 0 0',
	dockedItems : [ {
		xtype : 'toolbar',
		items : [/* {
			xtype : 'button',
			text : '添加',
			iconCls : 'add',
			id : 'attribute_add'
		},'-', {
			xtype : 'button',
			text : '删除',
			iconCls : 'delete',
			id : 'attribute_delete'
		} ,'-',*/ {
			xtype : 'button',
			text : '刷新',
			iconCls : 'icon-refresh',
			id : 'attribute_refresh',
			handler: function(){
	            propsGrid.setSource({
	                '(name)': 'Property Grid',
	                grouping: false,
	                autoFitColumns: true,
	                productionQuality: true,
	                created: new Date(),
	                tested: false,
	                version: 0.8,
	                borderWidth: 2
	            });
	        }
		} ]
	} ],
	layout : 'fit',
	items : [propsGrid],
});
