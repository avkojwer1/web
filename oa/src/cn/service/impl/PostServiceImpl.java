package cn.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.dao.impl.PostDaoImpl;
import cn.domain.Post;
import cn.service.PostService;


@Service("postService")
public class PostServiceImpl implements PostService{
	
	@Resource(name="postDao")
	private PostDaoImpl postDao;
	
	@Transactional(readOnly=false)
	public void deletePostById(Serializable id) {
		this.postDao.deleteEntry(id);
	}

	public Collection<Post> getAllPost() {
		return this.postDao.getAllEntry();
	}

	public Post getPostById(Serializable id) {
		
		return this.postDao.getEntryById(id);
	}
	
	@Transactional(readOnly=false)
	public void savePost(Post post) {
		this.postDao.saveEntry(post);
	}
	
	@Transactional(readOnly=false)
	public void updatePost(Post post) {
		this.postDao.updateEntry(post);
	}

	public Set<Post> getPostsByIds(Long[] pids) {
		
		return this.postDao.getPostsByIds(pids);
	}

}
