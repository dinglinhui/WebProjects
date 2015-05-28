/**
 * Copyright 2014 零志愿工作室 (http://www.0will.com). All rights reserved.
 * File Name: BaseEntity.java
 * Author: chenlong
 * Encoding UTF-8
 * Version: 1.0
 * Date: 2014年12月4日
 * History:	
 */
package com.Owill.web.base.tools;

/**
 * @author chenlong（chenlongwill@163.com）
 * @version Revision: 1.0.0 Date: 2014年12月4日
 */
public class Log {
	
		public static final String LINE = "======================================================";
		
		public static final String USER_LOGIN = "用户登录";
		public static final String USER_LOGOUT = "用户登出";
		public static final String USER_REGISTER = "用户注册,ID=";
		
		public static final String USER_LIST = "查询用户列表";
		public static final String USER_ADD = "添加用户,ID=";
		public static final String USER_UPDATE = "修改用户,ID=";
		public static final String USER_ENABLE = "启用用户,ID=";
		public static final String USER_DISABLE = "禁用用户,ID=";
		
		public static final String ROLE_LIST = "查询角色列表";
		public static final String ROLE_ADD = "添加角色,ID=";
		public static final String ROLE_UPDATE = "修改角色,ID=";
		public static final String ROLE_DISABLE = "角色逻辑删除,ID=";
		public static final String ROLE_ENABLE = "角色逻辑恢复,ID=";
		
		public static final String URI_MENU_LIST = "查询菜单地址列表";
		public static final String URI_FUN_LIST = "查询功能地址列表";
		public static final String URI_ADD = "添加地址,ID=";
		public static final String URI_UPDATE = "修改地址,ID=";
		public static final String URI_DELETE = "地址删除,ID=";
		
		public static final String GROUP_MAIN_LIST = "查询�?级用户组列表";
		public static final String GROUP_SUB_LIST = "查询二级用户组列�?";
		public static final String GROUP_MAIN_ADD = "添加�?级用户组,ID=";
		public static final String GROUP_MAIN_UPDATE = "修改�?级用户组,ID=";
		public static final String GROUP_SUB_ADD = "添加二级用户�?,ID=";
		public static final String GROUP_SUB_UPDATE = "修改二级用户�?,ID=";
		public static final String GROUP_DELETE = "地址删除,ID=";
		
		public static final String DEPT_MAIN_LIST = "查询�?级部门列�?";
		public static final String DEPT_SUB_LIST = "查询二级部门列表";
		public static final String DEPT_MAIN_ADD = "添加�?级部�?,ID=";
		public static final String DEPT_MAIN_UPDATE = "修改�?级部�?,ID=";
		public static final String DEPT_SUB_ADD = "添加二级部门,ID=";
		public static final String DEPT_SUB_UPDATE = "修改二级部门,ID=";
		public static final String DEPT_DELETE = "部门删除,ID=";
		
		public static final String MENU_MAIN_LIST = "查询�?级菜单列�?";
		public static final String MENU_SUB_LIST = "查询二级菜单列表";
		public static final String MENU_MAIN_ADD = "添加�?级菜�?,ID=";
		public static final String MENU_MAIN_UPDATE = "修改�?级菜�?,ID=";
		public static final String MENU_SUB_ADD = "添加二级菜单,ID=";
		public static final String MENU_SUB_UPDATE = "修改二级菜单,ID=";
		public static final String MENU_DELETE = "菜单删除,ID=";
		
		public static final String FUN_LIST = "查询功能地址列表";
		public static final String FUN_ADD = "添加功能,ID=";
		public static final String FUN_UPDATE = "修改功能,ID=";
		public static final String FUN_DELETE = "功能删除,ID=";
		
		public static final String USER_ROLE_LIST = "查询角色用户关联列表";
		public static final String USER_ROLE_ADD = "添加角色用户关联(更新),ID=";
		public static final String USER_ROLE_DELETE = "角色用户关联删除,ID=";
		
		public static final String GROUP_ROLE_LIST = "查询角色用户组关联列�?";
		public static final String GROUP_ROLE_ADD = "添加角色用户组关�?(更新),ID=";
		public static final String GROUP_ROLE_DELETE = "角色用户组关联删�?,ID=";
		
		public static final String GROUP_USER_LIST = "查询用户组用户关联列�?";
		public static final String GROUP_USER_ADD = "添加用户组用户关�?(更新),ID=";
		public static final String GROUP_USER_DELETE = "用户组用户关联删�?,ID=";
		
		public static final String USER_GROUP_LIST = "查询用户用户组关联列�?";
		public static final String USER_GROUP_DELETE = "用户用户组关联删�?,ID=";
		
		public static final String CODE_MANAGER_LIST="查询编码管理列表";
		
		public static final String CODE_DETAILS_LIST="查询编码细项列表";
		public static final String CODE_DETAILS_UPDATE="修改编码细项,ID=";
		public static final String CODE_DETAILS_DETELE="删除编码细项,ID=";
		public static final String CODE_DETAILS_ADD="添加编码细项,ID=";
		
		public static final String MAT_MATANDREA_LIST="查询材料试剂列表";
		public static final String MAT_MATANDREA_DETELE="删除材料试剂,ID=";
		public static final String MAT_MATANDREA_UPDATE="修改材料试剂,ID=";
		public static final String MAT_MATANDREA_ADD="添加材料试剂,ID=";
		
		
		
		public static final String COM_CUS_LIST="查询客户管理列表";
		public static final String COM_CUS_DETELE="删除客户,ID=";
		public static final String COM_CUS_UPDATE="修改客户,ID=";
		public static final String COM_CUS_ADD="添加客户,ID=";
		
		public static final String COM_SUP_LIST="查询供应商管理列�?";
		public static final String COM_SUP_DETELE="删除供应�?,ID=";
		public static final String COM_SUP_UPDATE="修改供应�?,ID=";
		public static final String COM_SUP_ADD="添加供应�?,ID=";
		
		public static final String BUS_RLCDISPEC_LIST="查询分析�?测最后一级列�?";
		public static final String BUS_RLCDISPEC_DETELE="删除分析�?测最后一�?,ID=";
		public static final String BUS_RLCDISPEC_UPDATE="修改分析�?测最后一�?,ID=";
		public static final String BUS_RLCDISPEC_ADD="添加分析�?测最后一�?,ID=";
		
		public static final String BUS_FLOW_LIST="查询分析�?测最后一级列�?";
		public static final String BUS_FLOW_DETELE="删除分析�?测最后一�?,ID=";
		public static final String BUS_FLOW_UPDATE="修改分析�?测最后一�?,ID=";
		public static final String BUS_FLOW_ADD="添加分析�?测最后一�?,ID=";
}
