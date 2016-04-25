package com.medicaljournalsystem.service;

import com.medicaljournalsystem.pojo.User;

public interface UserService {

	User findById(int id);

	User findByEmail(String email);

}
