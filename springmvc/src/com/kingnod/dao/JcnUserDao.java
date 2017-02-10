package com.kingnod.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.kingnod.entity.Chat;
import com.kingnod.entity.JcnUser;

/**
 * @author zhenghongwei
 */

public interface JcnUserDao extends PagingAndSortingRepository<JcnUser,Long>, JpaSpecificationExecutor<JcnUser> {
	
	@Query("select a from com.kingnod.entity.JcnUser a where a.id<:id")
	public List<JcnUser> findAllJcnUser(@Param(value="id")Long id);
}
