package org.paswork.application.system.simple.dao.impl;

import org.paswork.application.system.simple.dao.SimpleDao;
import org.paswork.application.system.simple.domain.Simple;
import org.paswork.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import org.springframework.stereotype.Repository;


@Repository("simpleDaoImpl")
public class SimpleDaoImpl extends HibernateDaoSupport<Simple,Integer> implements SimpleDao<Simple,Integer> {


}
