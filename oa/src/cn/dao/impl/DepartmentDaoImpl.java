package cn.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.dao.DepartmentDao;
import cn.domain.Department;
import cn.domain.User;

public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao{

	public void deleteDepartmentById(Serializable id,String deleteMode) {
		
		Department department = this.getDepartmentById(id);
		if("del".equals(deleteMode)){
		
		}else if("del_pre_release".equals(deleteMode)){
			Set<User> users = department.getUsers();
			for (User user : users) {
				user.setDepartment(null);
			}
		}else{
			
		}
		
		this.getHibernateTemplate().delete(department);
	}

	public Collection<Department> getAllDepartment() {
		
		return this.getHibernateTemplate().find("from Department");
	}

	public void saveDepartment(Department department) {
		this.getHibernateTemplate().save(department);
	}

	public void updateDepartment(Department department) {
		this.getHibernateTemplate().update(department);
	}

	public Department getDepartmentById(Serializable id) {
		
		return (Department) this.getHibernateTemplate().get(Department.class, id);
	}


}
