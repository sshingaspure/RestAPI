package com.dao;

import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.User;

@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private SessionFactory sessionFactory;
	@Transactional(readOnly=true)
	public User validateUser(String username, String password) {
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		return (User)criteria.uniqueResult();
	}

	@Transactional
	public void registerUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

}
