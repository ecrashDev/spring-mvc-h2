package jbr.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jbr.springmvc.model.Department;

public class DepartmentDaoImpl implements DepartmentDao{
	
	@Autowired
	  DataSource datasource;

	  @Autowired
	  JdbcTemplate jdbcTemplate;
	
	public List<Department> getDepartments(){
		String sql = "select * from department";
		return jdbcTemplate.query(sql, new DepartmentMapper());
     
	}
}

class DepartmentMapper implements RowMapper<Department> {

	  public Department mapRow(ResultSet rs, int arg1) throws SQLException {
	    Department department = new Department();

	    department.setName(rs.getString("name"));
	    return department;
	  }
	}