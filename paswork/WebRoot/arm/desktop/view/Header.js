    function onButtonClick(btn){
    	//Ext.MessageBox.confirm('Confirm', 'Are you sure you want to do that?', showResult);
    }

    function onItemClick(item){
    	//Ext.MessageBox.prompt('Name', 'Please enter your name:', showResultText);
    }

    function onItemCheck(item, checked){
    	/*Ext.MessageBox.show({
            title: 'Address',
            msg: 'Please enter your address:',
            width:300,
            buttons: Ext.MessageBox.OKCANCEL,
            multiline: true,
            fn: showResultText,
            animateTarget: 'mb3'
        });*/
    }

    function onItemToggle(item, pressed){
    	/*Ext.MessageBox.show({
            title:'Save Changes?',
            msg: 'You are closing a tab that has unsaved changes. <br />Would you like to save your changes?',
            buttons: Ext.MessageBox.YESNOCANCEL,
            fn: showResult,
            animateTarget: 'mb4',
            icon: Ext.MessageBox.QUESTION
        });*/
    }
    
    function onLogOut() {
    	Ext.MessageBox.confirm("注销", "确定注销?", function(btn) {
			if (btn === "yes") {
				var form = Ext.create('Ext.form.Panel',{
					standardSubmit: true
				});
				form.getForm().submit({
					url: appBasePath + 'authorize!logout.action?reqCode=admin'
				});
			}
		});
    }
    
	Ext.QuickTips.init();

	var dateMenu = Ext.create('Ext.menu.DatePicker', {
        handler: function(dp, date){
            //Ext.example.msg('Date Selected', 'You choose {0}.', Ext.Date.format(date, 'M j, Y'));

        }
    });

	var colorMenu = Ext.create('Ext.menu.ColorPicker', {
        handler: function(cm, color){
            //Ext.example.msg('Color Selected', '<span style="color:#' + color + ';">You choose {0}.</span>', color);
        }
    });

	var store = Ext.create('Ext.data.Store', {
		fields: ['color', 'name'],
	    data : [
	        {"color":"Default|#A5C11B", "name":"默认"},
	        {"color":"Blue|#5F9AD4", "name":"蓝色"},
	        {"color":"ShareBlue|#376EA5", "name":"深蓝色"}
	    ]
    });

	var combo = Ext.create('Ext.form.field.ComboBox', {
        hideLabel: true,
        store: store,
        displayField: 'name',
        typeAhead: true,
        queryMode: 'local',
        triggerAction: 'all',
        emptyText: '选择颜色',
        selectOnFocus: true,
        width: 135,
        iconCls: 'no-icon'
    });
	
	var menu = Ext.create('Ext.menu.Menu', {
        id: 'mainMenu',
        style: {
            overflow: 'visible'
        },
        items: [
            combo,                  // A Field in a Menu
            {
                text: 'I like Ext',
                checked: true,       // when checked has a boolean value, it is assumed to be a CheckItem
                checkHandler: onItemCheck
            }, '-', {
                text: 'Radio Options',
                menu: {        // <-- submenu by nested config object
                    items: [
                        // stick any markup in a menu
                        '<b class="menu-title">Choose a Theme</b>',
                        {
                            text: 'Aero Glass',
                            checked: true,
                            group: 'theme',
                            checkHandler: onItemCheck
                        }, {
                            text: 'Vista Black',
                            checked: false,
                            group: 'theme',
                            checkHandler: onItemCheck
                        }, {
                            text: 'Gray Theme',
                            checked: false,
                            group: 'theme',
                            checkHandler: onItemCheck
                        }, {
                            text: 'Default Theme',
                            checked: false,
                            group: 'theme',
                            checkHandler: onItemCheck
                        }
                    ]
                }
           },{
               text: 'Choose a Date',
               iconCls: 'calendar',
               menu: dateMenu // <-- submenu by reference
           },{
               text: 'Choose a Color',
               menu: colorMenu // <-- submenu by reference
           }
        ]
    });

    menu.add(' ');

    // Menus have a rich api for
    // adding and removing elements dynamically
    var item = menu.add({
        text: 'Dynamically added Item'
    });
    // items support full Observable API
    item.on('click', onItemClick);

    // items can easily be looked up
    menu.add({
        text: 'Disabled Item',
        id: 'disableMe'  // <-- Items can also have an id for easy lookup
  
    });
    // access items by id or index
    menu.items.get('disableMe').disable();

    var scrollMenu = Ext.create('Ext.menu.Menu');
    for (var i = 0; i < 5; ++i){
        scrollMenu.add({
            text: 'Item ' + (i + 1),
            handler: onItemClick
        });
    }

    // add a combobox to the toolbar
    combo = Ext.create('Ext.form.field.ComboBox', {
        hideLabel: true,
        store: store,
        displayField: 'name',
        typeAhead: true,
        queryMode: 'local',
        triggerAction: 'all',
        emptyText:'选择颜色',
        selectOnFocus:true,
        width:135
    });
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

Ext.define('Arm.view.Header', {
	extend : 'Ext.panel.Panel',
	height : 80,
	//html : '系统管理平台',
	region : 'north',
	split : false,
	border : false,
	bbar : [{
        text: '管理员',
        iconCls: 'user_suit',
        menu: {
            xtype: 'menu',
            plain: true,
            items: {
                xtype: 'buttongroup',
                title: '用户选项',
                columns: 2,
                defaults: {
                    xtype: 'button',
                    scale: 'large',
                    iconAlign: 'left'
                },
                items: [{
                	colspan: 2,
                    text: '用户管理',
                    //iconCls: 'user_edit',
                    width: 120
                },{
                    colspan: 2,
                    text: 'Import',
                    //scale: 'small',
                    width: 120
                },{
                    colspan: 2,
                    text: '退出系统',
                    //scale: 'small',
                    width: 120
                }]
            }
        }
	},'-',{
		text: '下拉菜单',
		handler: onButtonClick,
		//tooltip: {text:'This is a an example QuickTip for a toolbar item', title:'Tip Title'},
		iconCls: 'blist',
        menu : {
	        items: [{
	        	text: '<b>Bold</b>', handler: onItemClick
	        }, {
	        	text: '<i>Italic</i>', handler: onItemClick
	    	}, {
	    		text: '<u>Underline</u>', handler: onItemClick
	      	}, '-', {
	      		text: 'Pick a Color',
	         	handler: onItemClick,
	        	menu: {
	        		showSeparator: false,
	        		items: [
	        		        Ext.create('Ext.ColorPalette', {
	        		        	/*listeners: {
	                            	select: function(cp, color){
	                            		 Ext.MessageBox.show({
	                            	           title:'Color Selected',
	                            	           msg: 'You chose {0}. <br />Would you like to save your changes?',
	                            	           buttons: Ext.MessageBox.YESNOCANCEL,
	                            	           icon: Ext.MessageBox.QUESTION
	                            	       });
	                              	}
	                         	}*/
	                      	}), '-',
	                      	{
	        		        	text: 'More Colors...',
	        		        	handler: onItemClick
	                      	}
	               	]
	          	}
	     	}, {
	        	text: 'Extellent!',
	          	handler: onItemClick
	    	}]
        }
	}, {
		text:'按钮菜单',
		iconCls: 'bmenu',  // <-- icon
		menu: menu  // assign menu by instance
	}/*,'-',{
    	iconCls: 'previewIcon',
        cls: 'x-btn-text-icon',
        text: '滚动菜单',
        menu: scrollMenu
    },combo*/,'->',{
		text : '注销',
		tooltip : '<span style="font-size:12px">切换用户,安全退出系统</span>',
		iconCls : 'logout',
		handler: onLogOut
	}],
	cls: 'header-logo',
    bodyStyle: 'background-color:transparent;line-height:50px;padding-left:120px;padding-top:5px;font-size:23px;color:#000000;font-family:黑体;font-weight:bolder;',
	initComponent : function(){
		this.callParent();
	}
});