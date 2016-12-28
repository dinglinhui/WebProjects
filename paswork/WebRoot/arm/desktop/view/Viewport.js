Ext.define('Arm.view.Viewport', {
			extend : 'Ext.container.Viewport',
			requires : ['Arm.view.Container', 'Arm.view.Header', 'Arm.view.Navigation','Arm.view.Footer','Arm.view.Attribute'],
			layout : 'border',
			initComponent : function() {
				var me = this;
				Ext.apply(me, {
							items : [Ext.create('Arm.view.Container'),
									Ext.create('Arm.view.Header'),
									Ext.create('Arm.view.Navigation'),
									Ext.create('Arm.view.Footer'),
									Ext.create('Arm.view.Attribute')]
						});
				this.callParent(arguments);
			}
		});