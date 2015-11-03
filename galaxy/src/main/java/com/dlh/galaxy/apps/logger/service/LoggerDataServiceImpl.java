package com.dlh.galaxy.apps.logger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dlh.galaxy.apps.logger.dao.DataLogDao;
import com.dlh.galaxy.apps.logger.domain.DataLog;

@Service("loggerDataService")
@Transactional
public class LoggerDataServiceImpl implements LoggerDataService {

	@Autowired
	private DataLogDao dao;

	public void saveLogData(DataLog dt) {
		dao.saveLog(dt);
	}

	@Override
	public List<String> getAllUsers() {
		return dao.findAllUsers();
	}

	@Override
	public List<DataLog> getLogData(String person) {
		// TODO Auto-generated method stub
		return dao.getLogData(person);
	}

}
