package org.capgemini.service;

import org.capgemini.dao.EmployeeDao;
import org.capgemini.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
@Service("service")

public class EmployeeService {
	// EmployeeDao dao = new EmployeeDao();// EmployeeDao is dependency for
	// EmployeeService.......this dependency
	// will not be created if new keyword is
	// not used.Spring Framework should provide this dependency/..
	
	
	
	public EmployeeService(){
		System.out.println("EmployeeService object is created by spring framework");
	}
	@Autowired
	private EmployeeDao dao = null;

	public void addEmployee(Employee e) {
		System.out.println("Employee Service is Called");
		dao.createEmployee(e);
	}
	
	public void setDao(EmployeeDao dao) {
		System.out.println("setDao is called by spring Framework to set dependency.");
		this.dao = dao;
	}
}
