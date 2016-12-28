package org.paswork.application.system.simple.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.paswork.application.system.simple.dao.SimpleDao;
import org.paswork.application.system.simple.domain.Simple;
import org.paswork.application.system.simple.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("simpleServiceImpl")
public class SimpleServiceImpl implements SimpleService{
	
	private static final Log logger = LogFactory.getLog(SimpleServiceImpl.class);
	
	@Autowired
	private SimpleDao<Simple, Integer> simpleDao;

	@Override
	public void selectSimple() {
		logger.debug(simpleDao);
		simpleDao.find();
	}
}
