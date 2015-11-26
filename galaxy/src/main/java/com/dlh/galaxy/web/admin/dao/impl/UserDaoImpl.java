package com.dlh.galaxy.web.admin.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.dlh.galaxy.web.admin.dao.IUserDao;
import com.dlh.galaxy.web.admin.model.UserEntity;

/**
 * @author dinglinhui
 */
@Repository("userDao")
public class UserDaoImpl implements IUserDao {
	// extends BaseDaoImpl<UserEntity, Integer>
	@Resource
	protected SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean isExist(UserEntity user) {
		Session session = this.getSession();
		String hql = "from UserEntity where email =? or username =? or cellphone =?";
		Query query = session.createQuery(hql);
		query.setString(0, user.getEmail());
		query.setString(1, user.getUsername());
		query.setString(2, user.getCellphone());
		if (query.list().size() >= 1) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isUser(UserEntity user) {
		Session session = this.getSession();
		String hql = "from UserEntity where email =? or username =? and password = ?";
		Query query = session.createQuery(hql);
		query.setString(0, user.getUsername());
		query.setString(1, user.getUsername());
		query.setString(2, user.getPassword());
		if (query.list().size() >= 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean insert(UserEntity user) {
		try {
			Session session = this.getSession();
			Transaction tx = session.beginTransaction();
			session.save(user);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
