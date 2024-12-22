package com.springboot.jdbc.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jdbc.model.Employee;
import com.springboot.jdbc.repository.EmployeeRepository;

@RestController
@RequestMapping(path = "/")
public class EmployeeController {
	@Autowired
	private EmployeeRepository er;

	public void setEr(EmployeeRepository er) {
		this.er = er;
	}
	
	@GetMapping(path = "/ok")
	public void show()
	{
		System.out.println("OK");
	}
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	@GetMapping(path = "/insert")
	public String insert() throws  IOException
	{
		System.out.println("Enter the name, designation, and salary of Employee: ");
		Employee e= new Employee();
		e.setName(br.readLine());
		e.setDesignation(br.readLine());
		e.setSalary(Float.parseFloat(br.readLine()));
		int i=er.insertEmp(e);
		if(i>0) {
			return "Inserted";
		}
		else
		{
			return "Try again";
		}
	}
	@GetMapping(path = "/delete")
	public String delete() throws  IOException
	{
		System.out.println("Enter the Employee's name to delete the record: ");
		
		String nm=br.readLine();
		int i=er.deleteEmp(nm);
		if(i>0) {
			return "Deleted";
		}
		else
		{
			return "Try again";
		}
	}
	@GetMapping(path = "/update")
	public String update() throws  IOException
	{
		System.out.println("Enter the Employee's name and updated salary ");
		String nm=br.readLine();
		float s=Float.parseFloat(br.readLine());
		
		int i=er.updateEmp(s,nm);
		if(i>0) {
			return "Updated";
		}
		else
		{
			return "Try again";
		}
	}
	
	@GetMapping(path = "/fetch")
	public List<Employee> fetchEmpDetails()
	{
		return er.fetchEmp();
	}
	
}
