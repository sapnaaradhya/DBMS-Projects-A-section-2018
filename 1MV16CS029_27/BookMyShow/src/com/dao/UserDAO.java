package com.dao;

import java.util.List;

import com.model.User;

public interface UserDAO {
	
	public String addUser(User user);
	 
    public List<User> getAllUser(); 
 
    public void deleteUser(User use);
 
	
}
