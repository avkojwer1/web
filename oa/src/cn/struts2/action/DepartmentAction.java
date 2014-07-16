package cn.struts2.action;

import java.util.Collection;

import cn.domain.Department;
import cn.service.DepartmentService;
import cn.struts2.action.base.BaseAction;
import cn.utils.DeleteMode;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DepartmentAction extends BaseAction implements ModelDriven<Department>{
	Department model = new Department();
	
	public Department getModel() {
		return this.model;
	}
	
	private DepartmentService departmentService;

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	public String getAllDepartment(){
		Collection<Department> departmentList = this.departmentService.getAllDepartment();
		ActionContext.getContext().put("departmentList", departmentList);

		return listAction;
	}
	
	public String deleteDepartment(){
		
		this.departmentService.deleteDepartmentById(this.model.getDid(), DeleteMode.DEL_PRE_RELEASE);
		return action2action;
	}


}
