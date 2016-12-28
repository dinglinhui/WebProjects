package com.dinglinhui.crystalstudio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dinglinhui.crystalstudio.dao.AutoCompleteDao;
import com.dinglinhui.crystalstudio.service.AutoCompleteService;

@Service
public class AutoCompleteServiceImpl implements AutoCompleteService{
	@Autowired
	private AutoCompleteDao autoCompleteDao;

	public AutoCompleteDao getAutoCompleteDao() {
		return autoCompleteDao;
	}

	public void setAutoCompleteDao(AutoCompleteDao autoCompleteDao) {
		this.autoCompleteDao = autoCompleteDao;
	}
	
	@Override
	public List<String> auto(String name) {
		return autoCompleteDao.auto(name);
	}
}
