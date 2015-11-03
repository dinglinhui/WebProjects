package com.dlh.galaxy.apps.logger.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "data_log")
public class DataLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "person", nullable = false)
	private String person;

	@Column(name = "version", nullable = false)
	private String version;

	@Column(name = "log_string", nullable = false)
	private String logString;

	@Column(name = "created_dttm", nullable = false)
	private Date createdDttm;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Date getCreatedDttm() {
		return createdDttm;
	}

	public void setCreatedDttm(Date createdDttm) {
		this.createdDttm = createdDttm;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getLogString() {
		return logString;
	}

	public void setLogString(String logString) {
		this.logString = logString;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", person=" + person + ", logString=" + logString + "]";
	}

}
