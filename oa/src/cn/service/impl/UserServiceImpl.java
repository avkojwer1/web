package cn.service.impl;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.dao.impl.UserDaoImpl;
import cn.domain.User;
import cn.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource(name = "userDao")
	private UserDaoImpl userDao;
	
	@Transactional(readOnly=false)
	public void deleteUserById(Serializable id) {
		userDao.deleteEntry(id);
	}

	public Collection<User> getAllUsers() {
		
		return userDao.getUsers();
	}

	public User getUserById(Serializable id) {
		return userDao.getEntryById(id);
	}
	
	@Transactional(readOnly=false)
	public void saveUser(User user) {
		userDao.saveEntry(user);
	}
	@Transactional(readOnly=false)
	public void updateUser(User user) {
		userDao.updateEntry(user);
	}

	public User getUserByName(String name) {
		return this.userDao.getUserByName(name);
	}

}
