package com.dinglinhui.crystalstudio.service;

import java.util.List;

import com.dinglinhui.crystalstudio.pojo.BaseRoleModule;
import com.dinglinhui.crystalstudio.pojo.Criteria;

public interface BaseRoleModuleService {
	int countByExample(Criteria example);

	BaseRoleModule selectByPrimaryKey(String roleModuleId);

	List<BaseRoleModule> selectByExample(Criteria example);
}