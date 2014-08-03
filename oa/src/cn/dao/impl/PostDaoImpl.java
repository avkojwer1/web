package cn.dao.impl;

import org.springframework.stereotype.Repository;

import cn.dao.PostDao;
import cn.dao.base.impl.BaseDaoImpl;
import cn.domain.Post;

@Repository("postDao")
public class PostDaoImpl extends BaseDaoImpl<Post> implements PostDao{
	
}
