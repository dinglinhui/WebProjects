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
import javax.persistence.Table;

import com.Owill.web.base.entity.BaseEntity;

/**
 * 用户类
 * 
 * @author chenlong（chenlongwill@163.com）
 * @version Revision: 1.0.0 Date: 2014年12月4日
 */
@Entity
@Table(name = "t_sys_comment")
public class SysComment extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -561344241214652914L;

	/** 存储逻辑唯一标识符(与业务无关) */
	private Long id;

	/** 评论内容	*/
	private String comment;

	/** 上级评论ID	 */
	private Long parentId;

	/** 下级评论ID	 */
	private Long childId;
	
	/** 支持	 */
	private Long support;
	
	/** 反对	 */
	private Long against;



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
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the parentId
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return the childId
	 */
	public Long getChildId() {
		return childId;
	}

	/**
	 * @param childId the childId to set
	 */
	public void setChildId(Long childId) {
		this.childId = childId;
	}

	/**
	 * @return the support
	 */
	public Long getSupport() {
		return support;
	}

	/**
	 * @param support the support to set
	 */
	public void setSupport(Long support) {
		this.support = support;
	}

	/**
	 * @return the against
	 */
	public Long getAgainst() {
		return against;
	}

	/**
	 * @param against the against to set
	 */
	public void setAgainst(Long against) {
		this.against = against;
	}


}
