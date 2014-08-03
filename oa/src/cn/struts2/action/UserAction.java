package cn.struts2.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.domain.User;
import cn.service.UserService;
import cn.struts2.action.base.BaseAction;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User> {

	@Resource(name = "userService")
	private UserService userService;

	public String getAllUser() {

		ActionContext.getContext().getValueStack().push(
				this.userService.getAllUsers());

		return listAction;
	}

}
