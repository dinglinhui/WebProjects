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

/**
 * @author chenlong（chenlongwill@163.com）
 * @version Revision: 1.0.0 Date: 2014年12月4日
 */
public class Paging implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -275489115243684724L;

	private long total;
	private int current;
	private int pageSize;

	public Paging() {

		this.current = 1;
		this.pageSize = 10;
	}

	public Paging(int current, int pageSize) {

		this.current = current;
		this.pageSize = pageSize;
	}

	public int getFirst() {
		return 1;
	}

	public int getLast() {
		return (int) ((total - 1) / pageSize + 1);
	}

	public int getCurrent() {
		if (current < getFirst()) {
			return getFirst();
		} else {
			return current;
		}
	}

	public int getPrevious() {
		if (getCurrent() - 1 < getFirst()) {
			return getFirst();
		} else {
			return getCurrent() - 1;
		}
	}

	public int getNext() {
		if (getCurrent() + 1 > getLast()) {
			return getLast();
		} else {
			return getCurrent() + 1;
		}
	}

	public int getFirstResult() {
		return (getCurrent() - 1) * pageSize;
	}

	public int getPageSize() {
		return pageSize;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
}
