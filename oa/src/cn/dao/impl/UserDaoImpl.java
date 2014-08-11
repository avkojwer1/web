package cn.dao.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.dao.UserDao;
import cn.dao.base.impl.BaseDaoImpl;
import cn.domain.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao<User>{
	
	public Collection<User> getUsers(){
		
		List<User> list = this.hibernateTemplate.find("from User u left join fetch u.department d left join fetch u.posts p");
		
		return new HashSet<User>(list);
	}
	
}
