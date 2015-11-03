package com.dlh.galaxy.apps.logger.ui.bean;

import java.util.List;

public class UserList {
	private long id;
	private List<String> users;

	public UserList() {

	}

	public long getId() {
		return id;
	}

	public List<String> getUsers() {
		return users;
	}

	public void setUsers(List<String> users) {
		this.users = users;
	}

}
