package cn.service.impl;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.dao.DepartmentDao;
import cn.domain.Department;
import cn.service.DepartmentService;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService{
	@Resource(name="departmentDao")
	private DepartmentDao<Department> departmentDao;


	public Collection<Department> getAllDepartment() {
		return this.departmentDao.getAllEntry();
	}

	@Transactional(readOnly=false)
	public void deleteDepartmentById(Serializable id, String devMode) {
		this.departmentDao.deleteEntry(id);
	}


	public Department getDepartmentById(Serializable id) {
		return this.departmentDao.getEntryById(id);
	}
	
	@Transactional(readOnly=false)
	public void saveDepartment(Department department) {
		this.departmentDao.saveEntry(department);
	}

	@Transactional(readOnly=false)
	public void updateDepartment(Department department) {
		this.departmentDao.updateEntry(department);
	}

	
}
