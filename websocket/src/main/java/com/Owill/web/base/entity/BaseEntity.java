/**
 * Copyright 2014 零志愿工作室 (http://www.0will.com). All rights reserved.
 * File Name: BaseEntity.java
 * Author: chenlong
 * Encoding UTF-8
 * Version: 1.0
 * Date: 2014年12月4日
 * History:	
 */
package com.Owill.web.base.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.Owill.web.base.tools.JsonDateSerializer;

/**
 * @author chenlong（chenlongwill@163.com）
 * @version Revision: 1.0.0 Date: 2014年12月4日
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7438126736625600429L;

	/** 生成日期 */
	private Date created = new Date();

	/** 是否可用:逻辑删除 */
	private boolean enable = true;

	/** 修改日期 */
	private Date changed = new Date();

	/** 使用频率 */
	private int count = 0;

	/** 预留1 */
	private String misc1;

	/** 预留2 */
	private String misc2;

	/** 备注 */
	private String remark;

	// 设置日期传输到前台的格式
	@JsonSerialize(using = JsonDateSerializer.class)
	@Column(updatable = false)
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	/**
	 * @return the changed
	 */
	// 设置日期传输到前台的格式
	@JsonSerialize(using = JsonDateSerializer.class)
	@Column(updatable = false)
	public Date getChanged() {
		return changed;
	}

	/**
	 * @param changed
	 *            the changed to set
	 */
	public void setChanged(Date changed) {
		this.changed = changed;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return the misc1
	 */
	public String getMisc1() {
		return misc1;
	}

	/**
	 * @param misc1
	 *            the misc1 to set
	 */
	public void setMisc1(String misc1) {
		this.misc1 = misc1;
	}

	/**
	 * @return the misc2
	 */
	public String getMisc2() {
		return misc2;
	}

	/**
	 * @param misc2
	 *            the misc2 to set
	 */
	public void setMisc2(String misc2) {
		this.misc2 = misc2;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark
	 *            the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
