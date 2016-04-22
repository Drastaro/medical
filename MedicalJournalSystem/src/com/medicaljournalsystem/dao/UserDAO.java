package com.medicaljournalsystem.dao;

import java.util.List;

import com.medicaljournalsystem.pojo.User;

public interface UserDAO {

	public List<User> list();

	public User get(int id);

	public void saveOrUpdate(User user);

	public void delete(int id);

}
