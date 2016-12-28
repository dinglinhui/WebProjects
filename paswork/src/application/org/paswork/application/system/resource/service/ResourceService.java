package org.paswork.application.system.resource.service;

import java.util.List;

import org.paswork.application.system.resource.vo.ResourceNode;


public interface ResourceService {

	public List<ResourceNode> getRoot() throws Exception;
	
	public List<ResourceNode> getChildren(Integer id) throws Exception;
}
