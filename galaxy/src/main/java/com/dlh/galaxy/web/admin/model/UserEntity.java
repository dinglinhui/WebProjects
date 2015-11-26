package com.dlh.galaxy.web.admin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author dinglinhui
 */
@Table(name = "t_user")
@Entity
public class UserEntity {
	private int id;
	private String email;
	private String username;
	private String password;
	private boolean sex; // 默认为0；0表示女，1表示男
	private String cellphone;
	private String telephone;
	private String address;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UID", nullable = false, length = 9)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "UEMAIL", nullable = false, length = 45)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "UNAME", nullable = false, length = 20)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "UPASSWORD", nullable = false, length = 32)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "USEX", nullable = true, length = 1)
	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	@Column(name = "UCELLPHONE", nullable = true, length = 45)
	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	@Column(name = "UTELEPHONE", nullable = true, length = 45)
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "UADDRESS", nullable = true, length = 200)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [ \nid : " + this.id + "\nemail : " + this.email + "\nusername : " + this.username
				+ "\npassword : " + this.password + "\nsex : " + this.sex + "\ncellphone : " + this.cellphone
				+ "\ntelephone : " + this.telephone + "\naddress : " + this.address + " ]";
	}
}
