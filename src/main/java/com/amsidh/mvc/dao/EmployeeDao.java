package com.amsidh.mvc.dao;

import java.util.List;

import com.amsidh.mvc.model.Employee;

public interface EmployeeDao {

	public void createEmployee(Employee employee);

	public Employee updateEmployee(Integer employeeId,Employee employee);

	public Employee getEmployee(Integer employeeId);

	public List<Employee> getAllEmployee();

	public boolean isEmployeeExists(Integer employeeId);

	public void deleteEmployee(Integer employeeId);

	public void deleteAllEmployee();

}
