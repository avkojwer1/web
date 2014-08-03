package cn.dao.impl;

import java.util.Collection;
import org.springframework.stereotype.Repository;

import cn.dao.DepartmentDao;
import cn.dao.base.impl.BaseDaoImpl;
import cn.domain.Department;

@Repository("departmentDao")
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao<Department>{

}
