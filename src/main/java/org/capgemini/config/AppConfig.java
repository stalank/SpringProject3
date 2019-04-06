package org.capgemini.config;

import org.capgemini.pojo.Employee;
import org.capgemini.service.EmployeeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //used to denote the class is configuration class.
@ComponentScan("org.capgemini")
public class AppConfig {
	@Bean(name="employee")
	public Employee createEmployeeObject(){
		Employee employee = new Employee();
		return employee;
	}
	
}
