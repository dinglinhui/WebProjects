/**
* Ext.ux.LoginDialog Class
*
* @extends Ext.window.Window
* @version 1.2
*
* @author Sumit Madan (c) 2011 License: MIT
* (http://www.opensource.org/licenses/mit-license.php)
*/

Ext.define('Ext.ux.window.LoginDialog', {
    extend: 'Ext.window.Window',
    requires: ['Ext.layout.container.Border', 'Ext.form.Panel', 'Ext.form.field.Checkbox', 'Ext.ux.form.IconCombo'],
    alias: 'widget.logindialog',

    cls: 'form-login-dialog',
    iconCls: 'form-login-icon-title',
    width: 420,
    height: 280,
    resizable: false,
    closable: false,
    draggable: true,
    modal: true,
    closeAction: 'hide',
    layout: 'border',
    title: '登录',

    messages: undefined,
    qtips: undefined,

    headerPanel: undefined,
    formPanel: undefined,

    accountField: undefined,
    passwordField: undefined,
    languageField: undefined,
    rememberMeField: undefined,

    forgotPasswordLink: '<a href="about:blank" target="_blank">忘记密码？</a>',

    loginAction: undefined,
    cancelAction: undefined,

    initComponent: function() {
        var config = {};
        Ext.applyIf(this, Ext.apply(this.initialConfig, config));

        this.messages = this.messages || {};
        this.messages = Ext.Object.merge({
            loginfailed: '登录异常',
            wait: '请稍等...',
            header: 'ATStudio业务基础平台仅限于授权用户登录！<br />' +
                '<br />请输入您的帐号与密码！'
        }, this.messages);

        this.qtips = this.qtips || {};
        this.qtips = Ext.Object.merge({
            rememberme: 'This is not recommended for shared computers.',
            capslockwarning: '<div class="form-login-warning">Caps Lock is On</div><br />' +
                '<div>Having Caps Lock on may cause you to enter your password incorrectly.</div><br />' +
                '<div>You should press Caps Lock to turn it off before entering your password.</div>'
        }, this.qtips);


        this.headerPanel = this.headerPanel || {};
        this.headerPanel = Ext.create('Ext.panel.Panel', Ext.Object.merge({
            cls: 'form-login-header',
            baseCls: 'x-plain',
            html: this.messages.header,
            region: 'north',
            height: 60
        }, this.headerPanel));

        this.accountField = this.accountField || {};
        this.accountField = Ext.Object.merge({
            xtype: 'textfield',
            ref: 'accountField',
            name: 'account',
            id: 'account',
            cls : 'user',
			blankText : '帐号不能为空,请输入!',
            fieldLabel: '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;账&nbsp;户',
            validateOnBlur: false,
            allowBlank: false,
            listeners: {
                specialKey: function (field, e) {
                    if (e.getKey() == Ext.EventObject.ENTER) {
                        Ext.getCmp("loginButton").handler();
                    }
                }
            }
        }, this.accountField);

        this.passwordField = this.passwordField || {};
        this.passwordField = Ext.Object.merge({
            xtype: 'textfield',
            ref: 'passwordField',
            inputType: 'password',
            id: 'password',
            name: 'password',
            cls : 'key',
			blankText : '密码不能为空,请输入!',
            fieldLabel: '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;密&nbsp;码',
            width: 300,
            validateOnBlur: false,
            allowBlank: false,
            enableKeyEvents: true,
            listeners: {
                render: {
                    fn:function(field, eOpts) {
                        field.capsWarningTooltip = Ext.create('Ext.tip.ToolTip', {
                            target: field.bodyEl,
                            anchor: 'top',
                            width: 305,
                            html: this.qtips.capslockwarning
                        });
              
                        field.capsWarningTooltip.disable();
                    },
                    scope:this
                },

                keypress: {
                    fn: function(field, e, eOpts) {
                        var charCode = e.getCharCode();
                        if((e.shiftKey && charCode >= 97 && charCode <= 122) ||
                            (!e.shiftKey && charCode >= 65 && charCode <= 90)) {

                            field.capsWarningTooltip.enable();
                            field.capsWarningTooltip.show();
                        }
                        else {
                            if(field.capsWarningTooltip.hidden === false) {
                                field.capsWarningTooltip.disable();
                                field.capsWarningTooltip.hide();
                            }
                        }
                    },
                    scope: this
                },

                blur: function(field) {
                    if(field.capsWarningTooltip.hidden === false) {
                        field.capsWarningTooltip.hide();
                    }
                },
                
                specialKey: function (field, e) {
                    if (e.getKey() == Ext.EventObject.ENTER) {
                        Ext.getCmp("loginButton").handler();
                    }
                }
            }
        }, this.passwordField);

        this.forgotPassword = {
            xtype: 'box',
            autoEl: {
                html: '<div style="font-size:11px; text-align: right; width: 388px;">' + this.forgotPasswordLink + '</div>'
            }
        };

        this.languageField = this.languageField || {};
        this.languageField = Ext.Object.merge({
            xtype: 'iconcombo',
            name: 'lang',
            fieldLabel: '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;语&nbsp;言',
            valueField: 'languageCode',
            value: 'zh-cn',
            displayField: 'languageName',
            iconClsField: 'countryFlag',
            triggerAction: 'all',
            editable: false,
            mode: 'local'
        }, this.languageField);

        this.languageField.store = this.languageField.store || {};
        this.languageField.store = Ext.create('Ext.data.ArrayStore', Ext.applyIf(this.languageField.store, {
            fields: ['languageCode', 'languageName', 'countryFlag'],
            data: [
                ['zh-cn', '简体中文 - 中国大陆', 'flag-cn'],
                ['en-us', 'English - United States', 'flag-us'],
            ]
        }));

        this.rememberMeField = this.rememberMeField || {};
        this.rememberMeField = Ext.Object.merge({
            xtype: 'checkbox',
            itemId: 'rememberMe',
            name: 'rememberme',
            padding: '0 0 0 80',
            boxLabel: '&#160;' + '记住我',
            listeners: {
                render: function(checkbox) {
                    checkbox.bodyEl.child('input').set({
                        'data-qtip': this.qtips.rememberme
                    });
                },
                scope: this
            }
        }, this.rememberMeField);

        this.formPanel = this.formPanel || {};
        this.formPanel = Ext.create('Ext.form.Panel', Ext.Object.merge({
            bodyPadding: 10,
            id : 'loginForm',
            header: false,
            region: 'center',
            border: false,
            waitMsgTarget: true,
            layout: {
                type: 'vbox',
                align: 'stretch'
            },
            defaults: {
                labelWidth: 75,
                labelSeparator : '：',
            },
            items: [
                this.accountField,
                this.passwordField,
                this.forgotPassword, {
                    xtype: 'box',
                    autoEl: 'div',
                    height: 10
                }, this.languageField,
                this.rememberMeField
            ]
        }, this.formPanel));

        this.loginAction = this.loginAction || {};
        this.loginAction = Ext.Object.merge({
        	id: 'loginButton',
            text: '登录',
            iconCls: 'form-login-icon-login',
            scale: 'medium',
            width: 90,
            handler: this.submit,
            scope: this
        }, this.loginAction);

        this.cancelAction = this.cancelAction || {};
        this.cancelAction = Ext.Object.merge({
            text: '取消',
            iconCls: 'form-login-icon-cancel',
            scale: 'medium',
            width: 90,
            handler: this.cancel,
            scope: this
        }, this.cancelAction);

        this.buttons = this.buttons || [];
        this.buttons = this.buttons.concat([this.loginAction, this.cancelAction]);

        this.items = this.items || [];
        this.items = this.items.concat([this.headerPanel, this.formPanel]);

        this.keys = this.keys || [];
        this.keys = this.keys.concat([{
            key: [10,13],
            handler: this.submit,
            scope: this
        }]);

        if(this.cancelAction && (this.cancelAction.hidden === undefined || this.cancelAction.hidden === false)) {
            this.keys = this.keys.concat([{
                key: [27],
                handler: this.cancel,
                scope: this
            }]);
        }

        this.callParent(arguments);

        this.addEvents ('success', 'failure');
    },

    onShow: function() {
        this.callParent(arguments);
        Ext.getCmp('account').focus(true, 300);
    },

    onRender: function() {
        this.callParent(arguments);
    },

    setMessage : function (msg) {
        this.headerPanel.update(msg);
    },

    setErrorMessage : function (msg) {
        var errorNode = Ext.DomQuery.selectNode('span[class=error]', this.headerPanel.getEl().dom);
        if(!errorNode) {
            Ext.DomHelper.insertHtml('beforeEnd',
                Ext.DomQuery.selectNode('div[id^=panel-]:last', this.headerPanel.getEl().dom),
                '<br /><span class="error"></span>');
            errorNode = Ext.DomQuery.selectNode('span[class=error]', this.headerPanel.getEl().dom);
        }
        Ext.get(errorNode).update(msg);
    	
    },

    submit: function () {
        
        var account = Ext.getCmp('account').getValue();
        var password = Ext.getCmp('password').getValue();       
        if (account == "") {
            
        	Ext.getCmp('account').setValue(" ");
            Ext.getCmp('account').setValue("");
            Ext.getCmp('account').focus(true, 300);
            
        } else if(password == ""){
        	
        	Ext.getCmp('password').setValue(" ");
            Ext.getCmp('password').setValue("");
        	Ext.getCmp('password').focus(true, 300);
        	
        } else {
        
        	Ext.getCmp('password').setValue(Ext.util.MD5(password));
        	var form = this.formPanel.getForm();
            if (form.isValid())
            {
                this.loginAction.disabled;
                if(this.cancelAction instanceof Ext.Button) {
                    this.cancelAction.disabled;
                }
                this.setErrorMessage('');
                form.submit({
                    url: appBasePath + 'authorize!login.action?reqCode=admin',
                    method: 'post',
                    waitTitle : '系统提示',
    				waitMsg : '正在验证您的身份,请稍候.....',
                    success: this.onSuccess,
                    failure: this.onFailure,
                    scope: this
                });
            } else {
            	Ext.Msg.alert('系统提示','form invalid');
            }
        }
    },

    cancel: function() {

    	this.formPanel.getForm().reset();
    	Ext.getCmp('account').focus(true, 300);
    },

    onSuccess: function (form, action) {

        this.loginAction.enabled;
        if(this.cancelAction instanceof Ext.Button) {
            this.cancelAction.enable();
        }
        this.hide();
        this.fireEvent('success', this, form, action);

		//跳转到主页面
        window.location.href = 'system!initIndex.action?reqCode=welcome';
    },

    onFailure: function (form, action) {
        this.loginAction.enabled;
        if(this.cancelAction instanceof Ext.Button) {
            this.cancelAction.enabled;
        }

        Ext.getCmp('password').setValue('');
        Ext.getCmp('password').focus(true, 300);

        var msg = this.messages.loginfailed;
        if (action.result && action.result.message) {
            msg = action.result.message;
        }
        this.setErrorMessage(msg);
        this.fireEvent('failure', this, form, action);
        
        Ext.Msg.alert('系统提示',msg);
    }
});
//窗口大小改变时，从新设置窗口位置
/*window.onresize = function () {
    var left = (Ext.get(window).width - logindialog.getWidth()) / 2;
    login.loginWindow.setPosition(left);
};*/

//监听事件
/*var events = "beforecopy beforepaste beforedrag contextmenu selectstart drag paste copy cut dragenter";
Ext.getCmp('account').on(events, function(e) {
	return false;
});
Ext.getCmp('password').on(events, function(e) {
	return false;
});*/
