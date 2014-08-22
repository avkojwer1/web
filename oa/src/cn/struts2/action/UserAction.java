package cn.struts2.action;

import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.domain.Department;
import cn.domain.Post;
import cn.domain.User;
import cn.service.DepartmentService;
import cn.service.PostService;
import cn.service.UserService;
import cn.struts2.action.base.BaseAction;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User> {

	@Resource(name = "userService")
	private UserService userService;
	
	@Resource(name = "departmentService")
	private DepartmentService departmentService;
	
	@Resource(name = "postService")
	private PostService postService;
	
	public Long getDid() {
		return did;
	}

	public void setDid(Long did) {
		this.did = did;
	}

	public Long[] getPids() {
		return pids;
	}

	public void setPids(Long[] pids) {
		this.pids = pids;
	}

	private Long did;
	
	private Long[] pids;
	
	public String getAllUser() {

		ActionContext.getContext().getValueStack().push(
				this.userService.getAllUsers());

		return listAction;
	}
	
	public String addUI(){
		Collection<Department> departmentList = departmentService.getAllDepartment();
		ActionContext.getContext().put("departmentList", departmentList);
		
		Collection<Post> postList = postService.getAllPost();
		ActionContext.getContext().put("postList", postList);
		return addUI;
	}
	
	public String add(){

		Set<Post> postList = this.postService.getPostsByIds(this.pids);
		User user = new User();
		BeanUtils.copyProperties(this.model, user);
		user.setPosts(postList);
		
		//建立user与department之间的关系
		Department department = this.departmentService.getDepartmentById(this.did);
		user.setDepartment(department);
		
		this.userService.saveUser(user);
		
		return action2action;
	}
	
	public String checkUsername(){
		
		ActionContext.getContext().getValueStack().push("hello");
		User user = userService.getUserByName(this.model.getUsername());
		if(user == null){
			ActionContext.getContext().getValueStack().push("false");
		}
		else{
			ActionContext.getContext().getValueStack().push("true");
		}
		return SUCCESS;
	}
}
