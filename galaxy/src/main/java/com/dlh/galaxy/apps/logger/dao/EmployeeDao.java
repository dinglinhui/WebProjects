package com.dlh.galaxy.apps.logger.dao;

import java.util.List;

import com.dlh.galaxy.apps.logger.domain.Employee;

public interface EmployeeDao {

	void saveEmployee(Employee employee);

	List<Employee> findAllEmployees();

	void deleteEmployeeBySsn(String ssn);
}
