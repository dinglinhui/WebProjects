package com.tianyu.jty.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tianyu.jty.common.persistence.HibernateDao;
import com.tianyu.jty.common.service.BaseService;
import com.tianyu.jty.shop.dao.AdverDao;
import com.tianyu.jty.shop.entity.Adver;

/**
 * 广告service
 * @author ty
 * @date 2015年1月22日
 */
@Service
@Transactional(readOnly=true)
public class AdverService extends BaseService<Adver, Integer>{
	
	@Autowired
	private AdverDao adverDao;

	@Override
	public HibernateDao<Adver, Integer> getEntityDao() {
		return adverDao;
	}

}
