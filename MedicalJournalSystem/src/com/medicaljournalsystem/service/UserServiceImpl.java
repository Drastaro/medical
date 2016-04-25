package com.medicaljournalsystem.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicaljournalsystem.dao.UserDAO;
import com.medicaljournalsystem.pojo.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO dao;

	@Override
	public User findById(int id) {
		return null;
	}

	@Override
	public User findByEmail(String email) {
		return dao.getByEmail(email);
	}

}
