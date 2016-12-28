package org.paswork.application.system.resource.dao;

import java.util.List;

import org.paswork.application.system.resource.entity.Resource;
import org.paswork.framework.support.dao.hibernate.HibernateDao;


public interface ResourceDAO<T,ID> extends HibernateDao<T,ID> {

	public List<Resource> getRootResource();
	
	public List<Resource> getChildrenByParent(Integer id);
}
