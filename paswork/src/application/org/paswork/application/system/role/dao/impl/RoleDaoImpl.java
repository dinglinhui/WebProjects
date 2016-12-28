package org.paswork.application.system.role.dao.impl;

import org.paswork.application.system.role.dao.RoleDao;
import org.paswork.application.system.role.entity.Role;
import org.paswork.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import org.springframework.stereotype.Repository;


@Repository("roleDao")
public class RoleDaoImpl extends HibernateDaoSupport<Role, Integer> implements RoleDao<Role, Integer> {

	public RoleDaoImpl(){
		this.getEntityClass();
	}
}
