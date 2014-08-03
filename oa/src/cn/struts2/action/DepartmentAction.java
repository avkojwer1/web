package cn.struts2.action;

import java.util.Collection;

import javax.annotation.Resource;

import cn.domain.Department;
import cn.service.DepartmentService;
import cn.struts2.action.base.BaseAction;
import cn.utils.DeleteMode;

import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department> {

	@Resource(name="departmentService")
	private DepartmentService departmentService;

	
	public String getAllDepartment(){
		Collection<Department> departmentList = this.departmentService.getAllDepartment();
		ActionContext.getContext().put("departmentList", departmentList);

		return listAction;
	}
	
	public String deleteDepartment(){
		
		this.departmentService.deleteDepartmentById(this.model.getDid(), DeleteMode.DEL_PRE_RELEASE);
		return action2action;
	}
	
	public String addUI(){
		return ADDUI;
	}
	
	public String add(){
		Department department = new Department();
		try {
			BeanUtils.copyProperties(this.model, department);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		this.departmentService.saveDepartment(department);		
		return action2action;
	}
	
	public String updateUI(){
		Department department = departmentService.getDepartmentById(this.model.getDid());
		//ActionContext.getContext().getValueStack().getRoot().add(0, department);
		BeanUtils.copyProperties(department, this.model);
		return UPDATEUI;
	}
	
	public String update(){
		Department department = new Department();
		BeanUtils.copyProperties(this.getModel(), department);
		departmentService.updateDepartment(department);
		return action2action;
	}
}
