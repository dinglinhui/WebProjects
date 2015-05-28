/**
 * Copyright 2014 零志愿工作室 (http://www.0will.com). All rights reserved.
 * File Name: BaseEntity.java
 * Author: chenlong
 * Encoding UTF-8
 * Version: 1.0
 * Date: 2014年12月4日
 * History:	
 */
package com.Owill.web.system.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.Owill.web.base.entity.BaseEntity;
import com.Owill.web.base.tools.JsonDateSerializer;

/**
 * 用户类
 * 
 * @author chenlong（chenlongwill@163.com）
 * @version Revision: 1.0.0 Date: 2014年12月4日
 */
@Entity
@Table(name = "t_sys_user", uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }) })
public class SysUser extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4943872511511507465L;

	/** 存储逻辑唯一标识符(与业务无关) */
	private Long id;

	/** 用户名(用于登录) */
	private String username;

	/** 用户密码(用户登录) */
	private String password;

	/** 用户邮箱(用于找回密码) */
	private String email;

	/** 用户上次登录时间 */
	private Date lastLogin;

	/** 用户姓名 */
	private String name;

	/** 用户性别:男|女 */
	private boolean sexMale;

	@Id
	@GeneratedValue
	// @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="s_sys_user")
	// @SequenceGenerator(name="s_sys_user",allocationSize=1,initialValue=1,sequenceName="s_sys_user")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// 设置日期传输到前台的格式
	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSexMale() {
		return sexMale;
	}

	public void setSexMale(boolean sexMale) {
		this.sexMale = sexMale;
	}

}
