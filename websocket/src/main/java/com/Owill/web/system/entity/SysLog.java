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
 * 系统日志类
 * 
 * @author chenlong（chenlongwill@163.com）
 * @version Revision: 1.0.0 Date: 2014年12月4日
 */
@Entity
@Table(name = "t_sys_log")
public class SysLog extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4127797514171700579L;

	/** 查询类方法等级为绿色 */
	public static final String GREEN = "一般";

	/** 更新添加类方法为黄色 */
	public static final String YELLOW = "警戒";

	/** 删除数据类方法为红色 */
	public static final String RED = "高危";

	/** 存储逻辑唯一标识符(与业务无关) */
	private Long id;

	/** 操作人 */
	private SysUser op;

	/** 操作信息 */
	private String info;

	/** 操作等级 */
	private String level;

	@Id
	@GeneratedValue
//	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="s_sys_log")
//    @SequenceGenerator(name="s_sys_log",allocationSize=1,initialValue=1,sequenceName="s_sys_log")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	public SysUser getOp() {
		return op;
	}

	public void setOp(SysUser op) {
		this.op = op;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

}
