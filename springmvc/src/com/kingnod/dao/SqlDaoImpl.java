package com.kingnod.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.kingnod.tool.SqlDao;

@Service
public class SqlDaoImpl implements SqlDao {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findAll(String sql) {
		EntityManager target = null;
		target = em.getEntityManagerFactory().createEntityManager();
		Session session = target.unwrap(Session.class);
		List<Object[]> list = null;
		try {
			list = session.createSQLQuery(sql).list();
		}catch(Exception e){
		}finally{
			if(target!=null) {
				target.close();
			}
		}
		return list;
	}

	/*public JcnUser findOne(Long id){
		EntityManager target = null;
		target = em.getEntityManagerFactory().createEntityManager();
		JcnUser user = target.find(JcnUser.class, id);
		return user;
	}*/
}
