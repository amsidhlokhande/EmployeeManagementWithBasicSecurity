package com.amsidh.mvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.amsidh.mvc.dao.EmployeeDao;
import com.amsidh.mvc.exception.InvalidEmployeeException;
import com.amsidh.mvc.model.Employee;
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	public EmployeeDaoImpl() {
		System.out.println("EmployeeDaoImpl Loading!!!");
	}
	@Override
	public void createEmployee(Employee employee) {
		if(!isEmployeeExists(employee.getEmployeeId()))
		{
			employees.add(employee);
		}else
		{
			throw new InvalidEmployeeException("Duplicate employee or invalid employee data");
		}

	}

	@Override
	public Employee updateEmployee(Integer employeeId,Employee employee) {
		if(isEmployeeExists(employeeId))
		{
			Employee emp=getEmployee(employeeId);
			emp.setEmployeeName(employee.getEmployeeName());
			emp.setAddress(employee.getAddress());
			return emp;
		}else
		{
			throw new InvalidEmployeeException("No such employee present");
		}

	}

	@Override
	public Employee getEmployee(Integer employeeId) {
		for(Employee employee:employees){
			if(employee.getEmployeeId()==employeeId){
				return employee;
			}
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employees;
	}

	@Override
	public boolean isEmployeeExists(Integer employeeId) {
		for(Employee employee:employees){
			if(employee.getEmployeeId()==employeeId){
				return true;
			}
		}
		return false;
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
      if(isEmployeeExists(employeeId)){
    	  for(Employee emp:employees){
    		  if(emp.getEmployeeId()==employeeId){
    			  employees.remove(emp);
    			  break;
    		  }
    	  }
      }else
      {
    	  throw new InvalidEmployeeException("No such employee present");
      }

	}

	@Override
	public void deleteAllEmployee() {
		employees.clear();

	}

	private static List<Employee> employees=new ArrayList<Employee>();
	static {
		
		employees.add(new Employee(1, "Amsidh Lokhande", "Pune"));
		employees.add(new Employee(2, "Raju Lokhande", "Bijapur"));
		employees.add(new Employee(3, "Anjali Lokhande", "Lohegaon"));
	}
}
