package cn.dao.impl;

import org.springframework.stereotype.Repository;

import cn.dao.UserDao;
import cn.dao.base.impl.BaseDaoImpl;
import cn.domain.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao<User>{
	
}
