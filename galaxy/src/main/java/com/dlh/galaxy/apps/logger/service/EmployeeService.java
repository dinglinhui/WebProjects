package com.dlh.galaxy.apps.logger.service;

import java.util.List;

import com.dlh.galaxy.apps.logger.domain.Employee;

public interface EmployeeService {

	void saveEmployee(Employee employee);

	List<Employee> findAllEmployees();

	void deleteEmployeeBySsn(String ssn);
}
