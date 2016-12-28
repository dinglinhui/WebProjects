Ext.define('Bri.person.user.Store', {
			extend : 'Ext.data.Store',
			model : 'Bri.person.user.Model',
			pageSize : 20,
			autoLoad : true,
			remoteSort : true
		});