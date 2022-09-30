package com.shket.spring.rest.service;

import com.shket.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployee();

    public void saveEmployee(Employee employee);

    public Employee getEmployee (int id);

    public void deleteEmployee (int id);
}
