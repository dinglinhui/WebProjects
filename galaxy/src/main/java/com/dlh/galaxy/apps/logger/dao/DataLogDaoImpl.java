package com.dlh.galaxy.apps.logger.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.dlh.galaxy.apps.logger.domain.DataLog;

@Repository("DataLogDao")
public class DataLogDaoImpl extends AbstractDao implements DataLogDao {

	@Override
	public void saveLog(DataLog dl) {
		dl.setCreatedDttm(new Date());
		persist(dl);
	}

	@Override
	public List<String> findAllUsers() {
		Query query = getSession().createSQLQuery("select distinct person from data_log");
		List<?> li = query.list();
		ArrayList<String> al = new ArrayList<String>();
		if (li != null && li.size() > 0) {
			for (Object o : li) {
				al.add(o.toString());
				System.out.println(o.toString());
			}
		}
		return al;
	}

	@Override
	public List<DataLog> getLogData(String person) {
		Criteria criteria = getSession().createCriteria(DataLog.class);
		criteria.add(Restrictions.eq("person", person));
		return (List<DataLog>) criteria.list();
	}

}
