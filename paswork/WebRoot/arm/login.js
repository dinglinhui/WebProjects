Ext.Loader.setConfig({
  enabled: true,
    paths: {
        'Ext.ux': extBasePath + 'examples/ux/',
        'Ext.ux.form': appBasePath + 'resources/ext/ux/form',
        'Ext.ux.window': appBasePath + 'resources/ext/ux/window'
  }
});

Ext.require([
    'Ext.form.*',
    'Ext.ux.window.LoginDialog'
]);

Ext.onReady(function() {
    Ext.tip.QuickTipManager.init();
    
    var loginDialog = Ext.create('Ext.ux.window.LoginDialog');
    
    loginDialog.show();
});