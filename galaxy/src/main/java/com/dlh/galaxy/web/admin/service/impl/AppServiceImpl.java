/**
 * 
 */
package com.dlh.galaxy.web.admin.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dlh.galaxy.web.admin.dao.IAppDao;
import com.dlh.galaxy.web.admin.service.IAppService;

/**
 * @author dinglinhui
 */
@Transactional
@Service("appService")
public class AppServiceImpl implements IAppService {
	@Resource
	private IAppDao appDao;
}
