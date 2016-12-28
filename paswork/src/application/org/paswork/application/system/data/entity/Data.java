package org.paswork.application.system.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.paswork.framework.support.entity.BaseEntity;
import org.paswork.framework.support.matchrule.HQLParameter;
import org.paswork.framework.support.matchrule.annotation.MatchRule;
import org.paswork.framework.support.matchrule.annotation.Rule;


@Entity
@Table(name="SYS_DATA")
public class Data extends BaseEntity{
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@MatchRule({@Rule(name="code",type=HQLParameter.Type.LESSTHAN),
				@Rule(name="data_code")})
	private String code;
	
	private String text;
	
	private String value;
	
	private Integer sort;
	
	private Integer parentId;
	
	private String description;
	
	@Id 
	@GeneratedValue
	@Column(name="ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="CODE")
		public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name="TEXT")
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	@Column(name="VALUE")
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	@Column(name="PARENT_ID")
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name="SORT")
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	
}
