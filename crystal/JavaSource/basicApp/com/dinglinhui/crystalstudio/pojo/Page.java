package com.dinglinhui.crystalstudio.pojo;

import java.util.List;

public class Page {

	/** 是否有前一页 **/
	private Boolean hasPrePage;

	/** 是否有后一页 **/
	private Boolean hasNextPage;

	/** 每页显示多少条:默认20条 **/
	private int everyPage = 20;

	/** 总记录数 */
	private int totalProperty;

	/** 当前第多少页:默认第1页 */
	private int curpage = 1;

	/** 总分页数 */
	private int totalPages;

	/** 分页结果 */
	private List root;

	/** 开始页码 */
	private int start;

	/** 每页多少 */
	private int limit;

	/** 成功与否 */
	private boolean success;

	/** 查询条件List */
	private List conditions;

	private String strCondition;

	private String strOneCondition;

	private Object objCondition;

	private int selectType;

	public Boolean getHasNextPage() {
		this.hasNextPage = (curpage != totalPages) && (totalPages != 0);
		return this.hasNextPage;
	}

	public void setHasNextPage(Boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public Boolean getHasPrePage() {
		this.hasPrePage = (curpage != 1);
		return this.hasPrePage;
	}

	public void setHasPrePage(Boolean hasPrePage) {
		this.hasPrePage = hasPrePage;
	}

	/**
	 * 取得第一页
	 */
	public int getTopPageNo() {
		return 1;
	}

	/**
	 * 取得上一页
	 */
	public int getPreviousPageNo() {
		if (curpage <= 1) {
			return 1;
		}
		return curpage - 1;
	}

	/**
	 * 取得下一页
	 */
	public int getNextPageNo() {
		if (curpage >= getTotalPages()) {
			return getTotalPages() == 0 ? 1 : getTotalPages();
		}
		return curpage + 1;
	}

	/**
	 * 取得最后一页
	 */
	public int getBottomPageNo() {
		return getTotalPages() == 0 ? 1 : getTotalPages();
	}

	/**
	 * 转页
	 * */
	/*
	 * public int getTurnPageNo() { return getTotalPages() == 0 ? 1 :
	 * getTotalPages(); }
	 */

	public Object getObjCondition() {
		return objCondition;
	}

	public void setObjCondition(Object objCondition) {
		this.objCondition = objCondition;
	}

	public String getStrCondition() {
		return strCondition;
	}

	public void setStrCondition(String strCondition) {
		this.strCondition = strCondition;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getCurpage() {
		return curpage;
	}

	public void setCurpage(int curpage) {
		this.curpage = curpage;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public List getRoot() {
		return root;
	}

	public void setRoot(List root) {
		this.root = root;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {

		this.start = start;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getTotalProperty() {
		return totalProperty;
	}

	public void setTotalProperty(int totalProperty) {
		this.totalProperty = totalProperty;
	}

	public List getConditions() {
		return conditions;
	}

	public void setConditions(List conditions) {
		this.conditions = conditions;
	}

	public int getSelectType() {
		return selectType;
	}

	public void setSelectType(int selectType) {
		this.selectType = selectType;
	}

	public String getStrOneCondition() {
		return strOneCondition;
	}

	public void setStrOneCondition(String strOneCondition) {
		this.strOneCondition = strOneCondition;
	}

}
