package org.capgemini.main;

import org.capgemini.config.AppConfig;
import org.capgemini.pojo.Employee;
import org.capgemini.service.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
			ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
			EmployeeService service = (EmployeeService)context.getBean("service");
			Employee employee = (Employee)context.getBean("employee");
			employee.setEmployee_id(789);
			employee.setEmployee_name("bnm");
			employee.setEmployee_salary(456123.00);
			service.addEmployee(employee);
		}

}
