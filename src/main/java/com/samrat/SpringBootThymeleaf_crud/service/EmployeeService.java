package com.samrat.SpringBootThymeleaf_crud.service;

import com.samrat.SpringBootThymeleaf_crud.model.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
    void deleteEmployeeById(long id);
    //For pagination and sorting
    Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
