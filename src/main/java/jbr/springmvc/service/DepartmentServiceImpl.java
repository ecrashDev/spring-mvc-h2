package jbr.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jbr.springmvc.dao.DepartmentDao;
import jbr.springmvc.model.Department;

public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	public DepartmentDao departmentDao;

	@Override
	public List<Department> getDepartments() {
		return departmentDao.getDepartments();
	}

}
