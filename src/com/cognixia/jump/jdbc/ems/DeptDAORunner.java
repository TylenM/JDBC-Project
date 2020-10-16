package com.cognixia.jump.jdbc.ems;

import java.sql.SQLException;

public class DeptDAORunner {
	
	public static void main(String[] args) {
		
		DepartmentDAO deptDAO = new DepartmentDAOImpl();
		//DepartmentDAOFile deptDAO = new DepartmentDAOFile();
		
		// getting all the departments in table
		System.out.println("DEPARTMENTS:");
		System.out.println("----------------");
		
		for(Department dept : deptDAO.getAllDepartments()) {
			System.out.println(dept);
		}
		
		
		// get a single department
		System.out.println("\n\nGet single Department by ID");
		System.out.println( deptDAO.getDepartmentById(10003) );
		System.out.println( deptDAO.getDepartmentById(1) );
		
		Department dept = deptDAO.getDepartmentById(1);
		//dept.setName("hello");
		
		System.out.println("\n\nGet single Department by name");
		try {
			System.out.println(deptDAO.getDepartmentByName("Astrohnomy"));
		} catch (DepartmentNotFoundException e1) {
			System.out.println("Department wasn't found");;
		}
		
		
		System.out.println("\n\nInsert new department");
		Department newDept = new Department(0, "Astrology", "1111111111");
		boolean b = deptDAO.addDepartment(newDept);
		System.out.println("Was department added? " + b);
		
		System.out.println("\n\nDelete department");
		boolean c = deptDAO.deleteDepartment(10003);
		System.out.println("Was department deleted? " + c);
		
		System.out.println("\n\nUpdate department");
		Department dept2 = deptDAO.getDepartmentById(10000);
		boolean d = deptDAO.updateDepartment(dept2);
		System.out.println("Was department updated? " + d);
		
		DepartmentDAOImpl tmp = (DepartmentDAOImpl) deptDAO;
		try {
			tmp.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		try {
//			deptDAO.closeConnection();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

}
