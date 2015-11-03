package com.dlh.galaxy.apps.logger.dao;

import java.util.List;

import com.dlh.galaxy.apps.logger.domain.DataLog;

public interface DataLogDao {

	void saveLog(DataLog dl);

	List<String> findAllUsers();

	List<DataLog> getLogData(String person);
}
