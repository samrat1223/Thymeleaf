package com.samrat.SpringBootThymeleaf_crud.repository;

import com.samrat.SpringBootThymeleaf_crud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
