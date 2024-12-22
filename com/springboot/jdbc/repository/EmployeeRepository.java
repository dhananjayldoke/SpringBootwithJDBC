package com.springboot.jdbc.repository;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
/*import org.springframework.stereotype.Repository;*/

import com.springboot.jdbc.model.Employee;

@Controller
public class EmployeeRepository {
	@Autowired
	JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	public int insertEmp(Employee e) {
		return jt.update("insert into EmpInfo values(?,?,?,?)",null, e.getName(),e.getDesignation(), e.getSalary());
	}

	public int deleteEmp(String nm) {
		return jt.update("delete from EmpInfo where name=?",nm);
	}

	public int updateEmp(float s, String nm) {
		return jt.update("update EmpInfo set salary=? where name=?", s, nm);
	}

	public List<Employee> fetchEmp() {
		return jt.query("select * from EmpInfo",new RowMapper<Employee>()
				{
					@Override
					public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
						Employee e=new Employee();
						e.setEmpid(rowNum);
						e.setName(rs.getString("NAME"));
						e.setDesignation(rs.getString("designation"));
						e.setSalary(rs.getFloat("salary"));
						return e;
					}
				});
	}
}
