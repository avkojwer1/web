package cn.test.service;

import java.util.Collection;

import org.junit.Test;

import cn.domain.Post;
import cn.service.PostService;
import cn.test.BaseSpring;

public class PostServiceTest extends BaseSpring{
	
	
	@Test
	public void testGetAll(){
		PostService service = (PostService) context.getBean("postService");
		Collection<Post> list = service.getAllPost();
		System.out.println(list.size());
	}
	
}
