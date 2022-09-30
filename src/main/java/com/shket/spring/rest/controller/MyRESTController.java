package com.shket.spring.rest.controller;

import com.shket.spring.rest.entity.Employee;
import com.shket.spring.rest.exception_handling.NoSuchEmployeeException;
import com.shket.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployee();
        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);

        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = " + id + " in DataBase!");
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping ("/employees")
    public Employee saveEmployee (@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee (@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);
        if(employee==null){
            throw  new NoSuchEmployeeException("There is no employee with ID=" + id + " in DataBase");
        }
        employeeService.deleteEmployee(id);
        return "Employee with ID=" + id + " was deleted!";
    }
}
