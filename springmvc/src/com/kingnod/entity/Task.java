package com.kingnod.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name="jcn_task")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Task extends CommenEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 113434L;
	
	/**
	 * 任务关联人
	 */
	@ManyToOne(cascade={CascadeType.REFRESH,CascadeType.MERGE},fetch=FetchType.LAZY)
	@JoinColumn(name="user_id",referencedColumnName="id")
	private JcnUser user;
	
	/**
	 * 任务名称
	 */
	@Column(name="task_name",length=100,nullable=true,unique=true)
	private String taskName;
	/**
	 * 任务描述
	 */
	@Column(name="descript",length=200)
	private String descript;
	/**
	 * 任务进度（0-100）
	 */
	@Column(name="progress")
	private Integer progress;
	/**
	 * 任务紧急程度
	 */
	@Enumerated(EnumType.STRING)
	@Column(name="dep")
	private DepType dep;
	
	
	public JcnUser getUser() {
		return user;
	}

	public void setUser(JcnUser user) {
		this.user = user;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public Integer getProgress() {
		return progress;
	}

	public void setProgress(Integer progress) {
		this.progress = progress;
	}

	public DepType getDep() {
		return dep;
	}

	public void setDep(DepType dep) {
		this.dep = dep;
	}

	public enum DepType{
		LOW("低"),MIDDLE("中"),HIGHT("高");
		private final String typeName;
		DepType(final String typeName){
			this.typeName=typeName;
		}
		public String getTypeName(){
			return typeName;
		}
	}
}
