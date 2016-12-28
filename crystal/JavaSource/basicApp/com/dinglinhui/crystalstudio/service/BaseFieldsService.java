package com.dinglinhui.crystalstudio.service;

import java.util.HashMap;
import java.util.List;

import com.dinglinhui.crystalstudio.pojo.BaseFields;
import com.dinglinhui.crystalstudio.pojo.Criteria;

public interface BaseFieldsService {
	int countByExample(Criteria example);

	BaseFields selectByPrimaryKey(String fieldId);

	List<BaseFields> selectByExample(Criteria example);

	HashMap<String, String> selectAllByExample(Criteria example);

	/**
	 * 保存系统字段设置
	 * 
	 * @param example
	 * @return 00：失败，01：成功 ,其他情况
	 */
	String saveFields(Criteria example);

	/**
	 * 删除系统字段设置
	 * 
	 * @param example
	 * @return 00：失败，01：成功 ,其他情况
	 */
	String delete(Criteria example);
}