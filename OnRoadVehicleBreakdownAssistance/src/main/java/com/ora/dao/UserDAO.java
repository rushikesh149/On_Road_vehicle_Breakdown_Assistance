package com.ora.dao;

import java.util.List;

import com.ora.entity.User;

public interface UserDAO {
	public boolean addUser(User user);
	public boolean updateUser(User user);
	public List<User> viewUserDetails();
	

}
