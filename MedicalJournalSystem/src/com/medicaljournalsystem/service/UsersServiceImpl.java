package com.medicaljournalsystem.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicaljournalsystem.dao.UserDAO;
import com.medicaljournalsystem.pojo.Users;

@Service("userService")
@Transactional
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UserDAO dao;

	@Override
	public Users findById(int id) {
		return null;
	}

	@Override
	public Users findByEmail(String email) {
		return dao.getByEmail(email);
	}

}
