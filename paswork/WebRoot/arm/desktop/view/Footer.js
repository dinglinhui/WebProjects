Ext.define('Arm.view.Footer', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.footer',
	region : 'south',
	border: false,
    
	tbar : [{
		text : '登录时间: '+Ext.util.Format.date(new Date(),'Y-m-d H:i:s')
	},'->',{
		text : '日志信息'
	}],
});
