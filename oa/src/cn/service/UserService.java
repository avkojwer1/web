package cn.service;

import java.io.Serializable;
import java.util.Collection;

import cn.domain.User;

public interface UserService {
	
	public void saveUser(User user);
	public void updateUser(User user);
	public Collection<User> getAllUsers();
	public User getUserById(Serializable id);
	public void deleteUserById(Serializable id);
	public User getUserByName(String name);
	
}
