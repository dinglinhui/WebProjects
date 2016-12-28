Ext.define('Bri.system.role.Store', {
			extend : 'Ext.data.Store',
			model : 'Bri.system.role.Model',
			pageSize : 20,
			autoLoad : true,
			remoteSort : true
		});