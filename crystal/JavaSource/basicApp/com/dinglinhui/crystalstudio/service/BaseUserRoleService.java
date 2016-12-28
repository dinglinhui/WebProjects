package com.dinglinhui.crystalstudio.service;

import java.util.List;

import com.dinglinhui.crystalstudio.pojo.BaseUserRole;
import com.dinglinhui.crystalstudio.pojo.Criteria;

public interface BaseUserRoleService {
	int countByExample(Criteria example);

	BaseUserRole selectByPrimaryKey(String userRoleId);

	List<BaseUserRole> selectByExample(Criteria example);

}