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

/**
 * 用户类
 * 
 * @author chenlong（chenlongwill@163.com）
 * @version Revision: 1.0.0 Date: 2014年12月4日
 */
public class IndexNews {
	
	/** 最大限制	 */
	private int max;
	
	/** 排序	 */
	private int index;
	
	/** 加粗	 */
	private boolean light;
	
	/** 是否有图	 */
	private boolean image;
	
	/** 标题	*/
	private String title;

	/** 内容url id	 */
	private Long id;

	/** 类别	 */
	private String type;

	/**
	 * @return the max
	 */
	public int getMax() {
		return max;
	}

	/**
	 * @param max the max to set
	 */
	public void setMax(int max) {
		this.max = max;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * @return the light
	 */
	public boolean isLight() {
		return light;
	}

	/**
	 * @param light the light to set
	 */
	public void setLight(boolean light) {
		this.light = light;
	}

	/**
	 * @return the image
	 */
	public boolean isImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(boolean image) {
		this.image = image;
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
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	

}
