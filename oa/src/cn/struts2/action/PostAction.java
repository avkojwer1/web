package cn.struts2.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.domain.Post;
import cn.service.PostService;
import cn.struts2.action.base.BaseAction;

@Controller("postAction")
@Scope("prototype")
public class PostAction extends BaseAction<Post>{
	
	@Resource(name="postService")
	private PostService postService;
	
	
	public String getAllPost(){
		Collection<Post> postList = postService.getAllPost();
		
		ActionContext.getContext().put("postList", postList);
		
		return listAction;
	}
	
	public String addUI(){
		
		return addUI;
	}
	
	public String updateUI(){
		Post post = this.postService.getPostById(this.model.getPid());
		BeanUtils.copyProperties(post, this.model);
		
		return updateUI;
	}
	
	public String add(){
		Post post = new Post();
		BeanUtils.copyProperties(this.getModel(), post);
		this.postService.savePost(post);		
		return action2action;
	}
	
	public String update(){
		Post post = new Post();
		BeanUtils.copyProperties(this.getModel(), post);
		
		this.postService.updatePost(post);
		return action2action;
	}
	
	public String delete(){
		
		this.postService.deletePostById(this.model.getPid());
		return action2action;
	}
}
