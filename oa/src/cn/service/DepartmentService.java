package cn.service;

import java.io.Serializable;
import java.util.Collection;

import cn.domain.Department;

public interface DepartmentService {
	public void saveDepartment(Department department);
	
	public void updateDepartment(Department department);
	
	public void deleteDepartmentById(Serializable id, String devMode);
	
	public Collection<Department> getAllDepartment();
	
	public Department getDepartmentById(Serializable id);
}
