package com.medicaljournalsystem.service;

import com.medicaljournalsystem.pojo.Users;

public interface UsersService {

	Users findById(int id);

	Users findByEmail(String email);

}
