package com.sudhanshu.mysql.rest_api_jpa_mysql.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	private EmployeeSpringJpaRepository employeeSpringJpaRepository;

	public EmployeeController(EmployeeSpringJpaRepository employeeSpringJpaRepository) {
		super();
		this.employeeSpringJpaRepository = employeeSpringJpaRepository;
	}

	@GetMapping("/emp")
	public List<Employee> getEmployees() {
		return employeeSpringJpaRepository.findAll();
	}

	@GetMapping("/emp/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable int id) {
		return employeeSpringJpaRepository.findById(id);
	}

	@PostMapping("/emp")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeSpringJpaRepository.save(employee);
	}
}
