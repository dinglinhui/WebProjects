package org.paswork.application.system.resource.dao.impl;

import java.util.List;

import org.paswork.application.system.resource.dao.ResourceDAO;
import org.paswork.application.system.resource.entity.Resource;
import org.paswork.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import org.springframework.stereotype.Repository;


@Repository("resourceDAO")
public class ResourceDAOImpl extends HibernateDaoSupport<Resource, Integer> implements ResourceDAO<Resource, Integer> {

	@Override
	public List<Resource> getRootResource() {
		return this.findWithWhere(" t.parent is null");
	}

	@Override
	public List<Resource> getChildrenByParent(Integer id) {
		return this.findWithWhere(" t.parent =" + id);
	}

}
