package cn.service.impl;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.dao.impl.UserDaoImpl;
import cn.domain.User;
import cn.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource(name = "userDao")
	private UserDaoImpl userDao;
	
	public void deleteUserById(Serializable id) {
		userDao.deleteEntry(id);
	}

	public Collection<User> getAllUsers() {
		
		return userDao.getAllEntry();
	}

	public User getUserById(Serializable id) {
		return userDao.getEntryById(id);
	}

	public void saveUser(User user) {
		userDao.saveEntry(user);
	}

	public void updateUser(User user) {
		userDao.updateEntry(user);
	}

}
