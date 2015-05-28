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


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.Owill.web.base.entity.BaseEntity;

/**
 * 用户类
 * 
 * @author chenlong（chenlongwill@163.com）
 * @version Revision: 1.0.0 Date: 2014年12月4日
 */
@Entity
@Table(name = "t_sys_tag")
public class SysTag extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3703117936107390125L;

	/** 存储逻辑唯一标识符(与业务无关) */
	private Long id;
	
	/** 标签内容	*/
	private String tagInfo;

	/** 新闻ID	 */
	private SysNews newsId;

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
	 * @return the tagInfo
	 */
	public String getTagInfo() {
		return tagInfo;
	}

	/**
	 * @param tagInfo the tagInfo to set
	 */
	public void setTagInfo(String tagInfo) {
		this.tagInfo = tagInfo;
	}

	/**
	 * @return the newsId
	 */
	@ManyToOne
	public SysNews getNewsId() {
		return newsId;
	}

	/**
	 * @param newsId the newsId to set
	 */
	public void setNewsId(SysNews newsId) {
		this.newsId = newsId;
	}



}
