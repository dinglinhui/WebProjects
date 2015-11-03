package com.dlh.galaxy.apps.logger.service;

import java.util.List;

import com.dlh.galaxy.apps.logger.domain.DataLog;

public interface LoggerDataService {

	void saveLogData(DataLog dl);

	List<String> getAllUsers();

	List<DataLog> getLogData(String person);

}
