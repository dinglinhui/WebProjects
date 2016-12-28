package org.paswork.application.system.role.service.impl;

import java.util.List;

import org.paswork.application.system.role.dao.RoleDao;
import org.paswork.application.system.role.entity.Role;
import org.paswork.application.system.role.service.RoleService;
import org.paswork.application.system.role.vo.RoleVo;
import org.paswork.framework.support.matchrule.HQLParameter;
import org.paswork.framework.util.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("roleServiceImpl")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao<Role, Integer> roleDao;

	public List<RoleVo> list() {
		//HQLParameter p = new HQLParameter(Role.class);
		//System.out.println(p);
		return ListUtils.transform(roleDao.findPageByHql(" from Role"),
				RoleVo.class);
	}

	@Override
	public void update(Role role) throws Exception {
		roleDao.update(role);
	}

	@Override
	public Integer save(Role role) throws Exception {
		return roleDao.save(role);
	}

	@Override
	public void delete(Role role) throws Exception {
		roleDao.delete(role);
	}
}
