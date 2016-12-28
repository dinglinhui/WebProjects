package org.paswork.application.system.data.service.impl;

import java.util.List;

import org.paswork.application.system.data.dao.DataDao;
import org.paswork.application.system.data.entity.Data;
import org.paswork.application.system.data.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("dataService")
public class DataServiceImpl implements DataService{
	
	@Autowired
	private DataDao<Data, Integer> dataDao;

	@Override
	public List<Data> list() {
		return this.dataDao.find();
	}

}
