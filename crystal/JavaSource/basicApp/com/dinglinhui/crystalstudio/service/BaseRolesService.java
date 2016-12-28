package com.dinglinhui.crystalstudio.service;

import java.util.List;

import com.dinglinhui.crystalstudio.pojo.BaseRoles;
import com.dinglinhui.crystalstudio.pojo.Criteria;

public interface BaseRolesService {
	int countByExample(Criteria example);

	BaseRoles selectByPrimaryKey(String roleId);

	List<BaseRoles> selectByExample(Criteria example);

	/**
	 * 保存角色
	 * 
	 * @param role
	 * @return 00：失败，01：成功 ,其他情况
	 */
	String saveRole(BaseRoles role);

	/**
	 * 根据主键删除
	 * 
	 * @param criteria
	 * @return 00：失败，01：成功 ,其他情况
	 */
	String deleteByPrimaryKey(Criteria criteria);
}