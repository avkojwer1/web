package cn.service;


import java.io.Serializable;
import java.util.Collection;

import cn.domain.Post;

public interface PostService {
	
	public Collection<Post> getAllPost();
	
	public void updatePost(Post post);
	
	public void savePost(Post post);
	
	public void deletePostById(Serializable id);
	
	public Post getPostById(Serializable id);
}
