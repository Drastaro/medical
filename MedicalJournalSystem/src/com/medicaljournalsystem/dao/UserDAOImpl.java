package com.medicaljournalsystem.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.medicaljournalsystem.pojo.Users;

@Repository("userDao")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl() {

	}

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<Users> list() {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Users.class);
		List results = cr.list();

		return results;
	}

	@Override
	@Transactional
	public Users getByID(int id) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Users.class);
		cr.add(Restrictions.eq("id", id)).uniqueResult();
		List results = cr.list();
		Users user = (Users) results.get(0);

		return user;
	}

	@Override
	@Transactional
	public Users getByEmail(String email) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Users.class);
		cr.add(Restrictions.eq("email", email)).uniqueResult();
		List results = cr.list();
		Users user = (Users) results.get(0);

		return user;
	}

	@Override
	@Transactional
	public void saveOrUpdate(Users user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);

	}

	@Override
	@Transactional
	public void delete(int id) {
		Users userToDelete = new Users();
		userToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(userToDelete);

	}

}
