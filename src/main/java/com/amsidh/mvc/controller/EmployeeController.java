/**
 * 
 */
package com.amsidh.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.amsidh.mvc.model.Employee;
import com.amsidh.mvc.service.EmployeeService;

/**
 * @author amsidhlokhande
 *
 */
@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	public EmployeeController() {
		System.out.println("Loading EmployeeController!!!");
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> saveEmployee(@RequestBody Employee employee,
			UriComponentsBuilder uriComponentsBuilder) {
		try {
			employeeService.createEmployee(employee);
			HttpHeaders heards = new HttpHeaders();
			heards.setLocation(uriComponentsBuilder.path("/emp/employee/{employeeId}")
					.buildAndExpand(employee.getEmployeeId()).toUri());
			return new ResponseEntity<Void>(heards, HttpStatus.CREATED);

		} catch (Exception ex) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

	}

	@RequestMapping(value = "/update/{employeeId}", method = RequestMethod.PUT, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Employee> updateEmployee(@PathVariable("employeeId") Integer employeeId,
			@RequestBody Employee employee) {

		try {
			Employee emp = employeeService.updateEmployee(employeeId, employee);
			return new ResponseEntity<Employee>(emp, HttpStatus.OK);

		} catch (Exception ex) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "/employee/{employeeId}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Employee> getEmployee(@PathVariable("employeeId") Integer employeeId) {

		Employee employee = employeeService.getEmployee(employeeId);
		if (employee == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/employee", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<Employee>> allEmployees() {

		List<com.amsidh.mvc.model.Employee> employees = employeeService.getAllEmployee();
		if (employees.isEmpty()) {
			return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
		}

	}

	@RequestMapping(value = { "/delete/{employeeId}" }, method = RequestMethod.DELETE)
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("employeeId") Integer employeeId) {

		try {
			employeeService.deleteEmployee(employeeId);
			return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
		} catch (Exception ex) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = { "/delete/" }, method = RequestMethod.DELETE)
	public ResponseEntity<Employee> deleteAllEmployee() {

		employeeService.deleteAllEmployee();
		return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);

	}

}
