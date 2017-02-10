package com.kingnod.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name="classes")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Classes extends CommenEntity {
	
	private String code;
	private String name;
	//CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
	@OneToMany(targetEntity=JcnUser.class,cascade={},fetch=FetchType.LAZY)
	@Fetch(FetchMode.SUBSELECT)
	private List<JcnUser> list;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<JcnUser> getList() {
		return list;
	}
	public void setList(List<JcnUser> list) {
		this.list = list;
	}
	
	
}
