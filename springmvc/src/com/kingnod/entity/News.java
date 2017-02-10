package com.kingnod.entity;

import java.util.Date;

import io.searchbox.annotations.JestId;

/**
 * 虚拟news 搜索文章
 * 
 * @author zhenghongwei
 * 
 *         2013-1-12 下午11:38:29
 */
public class News {

    @JestId
    private Long id;
    private String title;
    private String content;
    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}