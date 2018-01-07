package com.stock.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stock.model.User;

@Repository("loginDao")
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void registerUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Transactional
	public User validateUser(String uname, String password) {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("username", uname));
		criteria.add(Restrictions.eq("password", password));
		User user=(User)criteria.uniqueResult();
		return user;
	}

}
