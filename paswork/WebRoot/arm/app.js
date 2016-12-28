Ext.Loader.setConfig({
			enabled : true
		});

Ext.Loader.setPath({
			'Ext.ux' : extBasePath + 'examples/ux',
			'Ext.app' : appBasePath + 'resources/ext/app',
			'Bri.msg': appBasePath + 'resources/ext/ux/msg',
			'Bri' : appBasePath + 'arm',
		});

Ext.require(['Bri.msg.MsgBox']);

Ext.Ajax.on('requestexception', function(conn, response, options) {
			var msg = '访问系统资源时发生异常<br/>' + '异常状态:' + response.status + '('
					+ response.statusText + ')<br/>' + '异常信息:'
					+ response.responseText;
			Ext.Msg.show({
						title : '系统异常',
						msg : msg,
						width : 400,
						icon : Ext.MessageBox.ERROR,
						buttonText : {
							ok : '&nbsp;&nbsp;提交错误报告&nbsp;&nbsp;'
						},
						buttons : Ext.MessageBox.OKCANCEL
					});
		});
Ext.get('loading-msg').update('加载系统组件...');
Ext.create('Bri.desktop.app');