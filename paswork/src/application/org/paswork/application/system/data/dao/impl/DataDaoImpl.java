package org.paswork.application.system.data.dao.impl;

import org.paswork.application.system.data.dao.DataDao;
import org.paswork.application.system.data.entity.Data;
import org.paswork.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import org.springframework.stereotype.Repository;


@Repository("dataDao")
public class DataDaoImpl extends HibernateDaoSupport<Data, Integer> implements DataDao<Data, Integer>{

}
