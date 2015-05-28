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

import com.Owill.web.base.tools.DataTableVO;

/**
 * VO对象 > <font color="#FF0000">适用于jQuery.Datatables</font>
 * 
 * @author chenlong（chenlongwill@163.com）
 * @version Revision: 1.0.0 Date: 2014年12月4日
 */
public class QueryParam {

	/**
	 * 构�?�器,参数是VO对象
	 */
	public QueryParam(DataTableVO vo) {

		if (vo == null) {

			throw new RuntimeException("DataTableVO is NULL");
		}

		int page = vo.getiDisplayStart() / vo.getiDisplayLength() + 1;
		paging = new Paging(page, vo.getiDisplayLength());
		sortCol = vo.getiSortCol_0();
		sortDir = vo.getsSortDir_0();
		searchKey = vo.getsSearch();
		sEcho = vo.getsEcho();
	}

	/** 分页信息 */
	private Paging paging;

	/** 排序�? */
	private int sortCol;

	/** 排序方向 */
	private String sortDir;

	/** 搜索关键�? */
	private String searchKey;

	/** ? */
	private int sEcho;

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

	public int getSortCol() {
		return sortCol;
	}

	public void setSortCol(int sortCol) {
		this.sortCol = sortCol;
	}

	public String getSortDir() {
		return sortDir;
	}

	public void setSortDir(String sortDir) {
		this.sortDir = sortDir;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public int getsEcho() {
		return sEcho;
	}

	public void setsEcho(int sEcho) {
		this.sEcho = sEcho;
	}

}
