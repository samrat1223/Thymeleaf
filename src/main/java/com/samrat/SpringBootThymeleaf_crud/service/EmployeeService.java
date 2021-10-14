package com.samrat.SpringBootThymeleaf_crud.service;

import com.samrat.SpringBootThymeleaf_crud.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
}
