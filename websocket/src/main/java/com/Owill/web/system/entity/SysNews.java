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

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.Owill.web.base.entity.BaseEntity;

/**
 * 用户类
 * 
 * @author chenlong（chenlongwill@163.com）
 * @version Revision: 1.0.0 Date: 2014年12月4日
 */
@Entity
@Table(name = "t_sys_news")
public class SysNews extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8201638794174396371L;

	/** 存储逻辑唯一标识符(与业务无关) */
	private Long id;

	/** 标题	*/
	private String title;
	
	/** 是否高亮	*/
	private boolean duang;

	/** 内容	 */
	private String content;

	/** 类别	 */
	private SysCategory type;

	/** 发布人	 */
	private SysUser user;


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

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the content
	 */
	@Lob   
	@Basic(fetch = FetchType.LAZY)   
	@Type(type="text")
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the type
	 */
	@OneToOne
	public SysCategory getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(SysCategory type) {
		this.type = type;
	}

	/**
	 * @return the user
	 */
	@OneToOne
	public SysUser getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(SysUser user) {
		this.user = user;
	}

	/**
	 * @return the duang
	 */
	public boolean isDuang() {
		return duang;
	}

	/**
	 * @param duang the duang to set
	 */
	public void setDuang(boolean duang) {
		this.duang = duang;
	}


}
