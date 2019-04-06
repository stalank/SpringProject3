package org.capgemini.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.capgemini.pojo.Employee;
import org.springframework.stereotype.Repository;
@Repository("dao")
public class EmployeeDao {
	
	private Connection connection;
	
	
	
	public EmployeeDao(){
		System.out.println("EmployeeDao object is created by spring framework");
	}
	
	public int createEmployee(Employee e){
		System.out.println("Employee Created in Database");
		
		
		try {
			openConnetion();
		} catch (ClassNotFoundException e1) {
			System.out.println("Class Not Found Exception");
			e1.printStackTrace();
		} catch (SQLException e1) {
			System.out.println("SQL Exception");
			e1.printStackTrace();
		}

		String query = "Insert into emp (Employee_id , Employee_name , Employee_salary) Values (?,?,?)";
		try {
			// to call stored procedures and functions we'll use callable
			// functions;
			PreparedStatement ps = connection.prepareStatement(query);
			// after prepared stmt values should be provided for ? ;
			ps.setInt(1, e.getEmployee_id());
			ps.setString(2, e.getEmployee_name());
			ps.setDouble(3, e.getEmployee_salary());
			int result = ps.executeUpdate();
			return result;
		} catch (SQLException e1) {
			System.out.println("SQL Exception");
			e1.printStackTrace();
		}
		closeConnection();
		return 0;

	}
	
	public void openConnetion() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:ORCL", "system", "root");
	}

	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	}



