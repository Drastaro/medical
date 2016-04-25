package com.medicaljournalsystem.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.medicaljournalsystem.pojo.User;

@Repository("userDao")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public UserDAOImpl() {

	}

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<User> list() {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(User.class);
		List results = cr.list();

		return results;
	}

	@Override
	@Transactional
	public User getByID(int id) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(User.class);
		cr.add(Restrictions.eq("id", id)).uniqueResult();
		List results = cr.list();
		User user = (User) results.get(0);

		return user;
	}

	@Override
	@Transactional
	public User getByEmail(String email) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(User.class);
		cr.add(Restrictions.eq("email", email)).uniqueResult();
		List results = cr.list();
		User user = (User) results.get(0);

		return user;
	}

	@Override
	@Transactional
	public void saveOrUpdate(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		sessionFactory.getCurrentSession().saveOrUpdate(user);

	}

	@Override
	@Transactional
	public void delete(int id) {
		User userToDelete = new User();
		userToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(userToDelete);

	}

}
