package com.medicaljournalsystem.dao;

import java.util.List;

import com.medicaljournalsystem.pojo.Users;

public interface UserDAO {

	public List<Users> list();

	public Users getByID(int id);

	public Users getByEmail(String email);

	public void saveOrUpdate(Users user);

	public void delete(int id);

}
