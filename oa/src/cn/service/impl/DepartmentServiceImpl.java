package cn.service.impl;

import java.io.Serializable;
import java.util.Collection;

import cn.dao.DepartmentDao;
import cn.domain.Department;
import cn.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService{
	
	private DepartmentDao departmentDao;

	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	public Collection<Department> getAllDepartment() {
		return this.departmentDao.getAllDepartment();
	}

	public Department getDepartmentById(Serializable id) {
		return this.departmentDao.getDepartmentById(id);
	}

	public void saveDepartment(Department department) {
		this.departmentDao.saveDepartment(department);
	}

	public void updateDepartment(Department department) {
		this.departmentDao.updateDepartment(department);
	}

	public void deleteDepartmentById(Serializable id, String deleteMode) {
		this.departmentDao.deleteDepartmentById(id, deleteMode);
	}

	
}
