package com.kingnod.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="jcn_user")
public class JcnUser extends CommenEntity {
	
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;

	@Column(name="name",length=100,unique=true,nullable=true)
	private String name;
	
	@Column(name="email",length=100,unique=true,nullable=true)
	private String email;
	private String password="123456";
	
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY)//,mappedBy="jcnUser")
	@JoinColumn(name="jcn_user_id")
	private Set<Task> task;
	@ManyToOne(targetEntity=Classes.class,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="classes_id",referencedColumnName="id")
	private Classes classes;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="password",length=30)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Task> getTask() {
		return task;
	}
	public void setTask(Set<Task> task) {
		this.task = task;
	}
	
	
}
