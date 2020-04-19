package com.amsidh.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amsidh.mvc.dao.EmployeeDao;
import com.amsidh.mvc.model.Employee;
import com.amsidh.mvc.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public EmployeeServiceImpl() {
		System.out.println("EmployeeServiceImpl Loading!!!");
	}
	
	@Override
	public void createEmployee(Employee employee) {
		employeeDao.createEmployee(employee);

	}

	@Override
	public Employee updateEmployee(Integer employeeId, Employee employee) {
		return employeeDao.updateEmployee(employeeId,employee);

	}

	@Override
	public Employee getEmployee(Integer employeeId) {
		return employeeDao.getEmployee(employeeId);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeDao.getAllEmployee();
	}

	@Override
	public boolean isEmployeeExists(Integer employeeId) {
		return employeeDao.isEmployeeExists(employeeId);
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		employeeDao.deleteEmployee(employeeId);

	}

	@Override
	public void deleteAllEmployee() {
		employeeDao.deleteAllEmployee();

	}

}
