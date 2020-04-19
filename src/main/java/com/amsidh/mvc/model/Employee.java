package com.amsidh.mvc.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name="EMPLOYEE")
public class Employee {

	private Integer employeeId;
	private String employeeName;
	private String address;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer employeeId, String employeeName, String address) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.address = address;
	}

	@XmlElement(name="EMPLOYEEID")
	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	@XmlElement(name="EMPLOYEENAME")
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@XmlElement(name="ADDRESS")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
