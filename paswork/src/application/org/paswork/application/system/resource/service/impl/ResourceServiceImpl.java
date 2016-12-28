package org.paswork.application.system.resource.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.paswork.application.system.resource.dao.ResourceDAO;
import org.paswork.application.system.resource.entity.Resource;
import org.paswork.application.system.resource.service.ResourceService;
import org.paswork.application.system.resource.vo.ResourceNode;
import org.paswork.framework.util.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {

	protected Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	protected ResourceDAO<Resource, Integer> resourceDAO;

	@Override
	public List<ResourceNode> getRoot() throws Exception {
		return ListUtils.transform(this.resourceDAO.getRootResource(),ResourceNode.class);
	}
	
	public List<ResourceNode> getChildren(Integer id) throws Exception{
		return ListUtils.transform(this.resourceDAO.getChildrenByParent(id),ResourceNode.class);
	}

}
