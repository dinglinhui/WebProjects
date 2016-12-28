var userSearchStore = Ext.create('Ext.data.Store', {
		fields: ['selectStr', 'name'],
	    data : [
	        {"selectStr":"account", "name":"帐号"},
	        {"selectStr":"realName", "name":"用户名"},
	        {"selectStr":"email", "name":"邮箱"},
	    ]
});

var combo = Ext.create('Ext.form.field.ComboBox', {
    hideLabel: true,
    id : 'selectStr',
    store: userSearchStore,
    displayField: 'name',
    valueField: 'selectStr',
    typeAhead: true,
    queryMode: 'local',
    triggerAction: 'all',
    editable : false,
    //emptyText: '请选择',
    selectOnFocus: true,
    width: 100,
    iconCls: 'no-icon'
});

Ext.define('Bri.person.user.List', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.userlist',
	requires: ['Ext.grid.RowNumberer'],
	title : '用户列表',
	iconCls : 'icon-grid-list',
	rowLines : true,
	columnLines : true,
	multiSelect : true,
	simpleSelect : true,
	viewConfig : {
		loadingText : '正在加载用户列表'
	},
	columns : [/* Ext.create('Ext.grid.RowNumberer', {
		text : '序号',
		width : 35
	})*/{
		xtype : 'rownumberer'
	}, {
		text : '名称',
		width : 250,
		sortable : true,
		dataIndex : 'name',
		field : {
			xtype : 'textfield',
			required : true
		}
	}, {
		header : '代码',
		width : 100,
		sortable : true,
		dataIndex : 'code',
		field : {
			xtype : 'textfield'
		}
	}, {
		text : '级别',
		width : 100,
		sortable : true,
		dataIndex : 'roleLevel',
		field : {
			xtype : 'numberfield'
		}
	}, {
		text : '描述',
		flex : 1,
		sortable : true,
		dataIndex : 'description',
		field : {
			xtype : 'textarea'
		}
	}],

	//store : [Ext.create('Bri.person.user.Store')],
	initComponent : function() {
		this.createStore();
		this.rowEditor = Ext.create('Ext.grid.plugin.RowEditing', {
			listeners : {
				edit : function(editor, e) {
					e.record.save({
								success : function(user, options) {
									var data = Ext.decode(options.response.responseText);
									if (data.extra) {
										user.set('id', data.extra);
									}
									user.commit();
								}
							});

				}
			}
		});
		this.plugins = [this.rowEditor], this.tbar = this.createToolbar();
		this.bbar = {
			xtype : 'pagingtoolbar',
			store : this.store,
			displayInfo : true
		};
		this.callParent();
	},

	createStore : function() {
		var me = this;
		me.store = Ext.create('Bri.person.user.Store');
	},

	addRecord : function() {
		var record = new Bri.person.user.Model({
					name : '新建用户'
				});
		this.getStore().add(record);
		this.rowEditor.startEdit(record, 1);
	},

	deleteRecord : function() {
		var me = this;
		var records = this.getSelectionModel().getSelection();
		if (records.length > 0) {
			Bri.msg.MsgBox.confirm('确定删除这' + records.length + '个用户?',
					function(btn) {
						Ext.each(records, function(record) {
									if (Ext.Array.contains(me.getStore().getNewRecords(), record)) {
										me.getStore().remove(record);
									} else {
										record.destroy({
													success : function() {
														me.store.remove(record);
													}
												});
									}
								});
					});
		}

	},

	createToolbar : function() {
		var me = this;
		return Ext.create('Ext.toolbar.Toolbar', {
					items : [{
						        xtype: 'label',
						        text: '检索条件：',
						        margin: '0 0 0 10'
						    },combo, '-',{
								xtype : 'textfield',
								//emptyText: '请输入关键字！',
								width:300,
								id : 'searchStr'
							}, '-', {
								xtype : 'button',
								text : '查询',
								iconCls : 'icon-search',
								handler : function() {
									me.getStore().load({
										params : {
											searchStr : encodeURI(Ext.getCmp('searchStr').getValue()),
											selectStr : encodeURI(Ext.getCmp('selectStr').getValue()),
										}
									});
								}
							}, '->',Ext.create('Ext.Button', {
								text : '添加',
								iconCls : 'page_addIcon',
								handler : me.addRecord,
								scope : me
							}), '-', {
								xtype : 'button',
								text : '删除',
								iconCls : 'page_delIcon',
								handler : me.deleteRecord,
								scope : me
							},]
				});
	}
});