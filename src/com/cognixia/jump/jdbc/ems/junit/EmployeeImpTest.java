package com.cognixia.jump.jdbc.ems.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import com.cognixia.jump.jdbc.ems.implementations.EmployeeImp;
import com.cognixia.jump.jdbc.ems.interfaces.EmployeeDAO;
import com.cognixia.jump.jdbc.ems.models.Employee;

class EmployeeImpTest {

	private EmployeeDAO eDAO = new EmployeeImp();
	
	@Test
	void listAllEmployees() {
		assertNotEquals(null, eDAO.getAllEmployees());
	}
	
	@Test
	void addEmployee() {
		Employee emp = new Employee(0, "FirstName1", "LastName1", Date.valueOf("2000-02-03"), "test@gmail.com", "555-555-5555", 50000d, 1, 1);
		assertEquals(true, eDAO.addEmployee(emp));
	}
	
	@Test
	void selectEmployeeById() {
		assertEquals(null, eDAO.getEmployeeById(1000000));
	}
	
	@Test 
	void updateEmployee() {
		Employee emp = eDAO.getEmployeeByFirstName("FirstName1").get(0);
		emp.setFirst_name("newFirstName1");
		emp.setLast_name("LastName111");
		assertEquals(true, eDAO.updateEmployee(emp));
	}
	
	@Test
	void removeEmployee() {
		int id = eDAO.getEmployeeByFirstName("newFirstName1").get(0).getEmployee_id();
		assertEquals(true, eDAO.deleteEmployee(id));
	}
}
