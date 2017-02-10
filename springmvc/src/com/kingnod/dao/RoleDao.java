/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.kingnod.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.kingnod.entity.Role;

public interface RoleDao extends PagingAndSortingRepository<Role, Long> {

}
