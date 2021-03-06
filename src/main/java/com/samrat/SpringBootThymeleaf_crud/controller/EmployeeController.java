package com.samrat.SpringBootThymeleaf_crud.controller;


import com.samrat.SpringBootThymeleaf_crud.model.Employee;
import com.samrat.SpringBootThymeleaf_crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Method to display list of employees
    @GetMapping("/")
    public String viewHomePage(Model model){
       return findPaginated(1,"firstName","asc", model); //calling findPaginated method to get paginated employess
        //default order of sorting
    }

    @GetMapping("/newEmployeeForm")
    public String showNewEmployeeForm(Model model){
        //Create model attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        //save employee to database
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable (value = "id") long id, Model model)
    {
        //Get employee from service
        Employee employee = employeeService.getEmployeeById(id);

        //set employee as a model attribute to pre-populate the form
        model.addAttribute("employee",employee);
        return  "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable (value="id") long id)
    {
        //call delete employee method
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/";

    }

    @GetMapping("/page/{pageNo}") //for making pageSize configurable @GetMapping("/page/{pageNo}/{pageSize}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo ,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model){
        int pageSize = 5;

        Page<Employee>  page = employeeService.findPaginated(pageNo,pageSize,sortField,sortDir);
        List<Employee> listEmployees = page.getContent();

        model.addAttribute("currentPage",pageNo);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("totalItems",page.getTotalElements());

        model.addAttribute("sortField",sortField);
        model.addAttribute("sortDirection",sortDir);
        model.addAttribute("reverseSortDir",sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listEmployees",listEmployees);
        return "index";
    }
}
