package com.springboot.demo.demoApp.ThymeleafCRUD.controller;

import com.springboot.demo.demoApp.ThymeleafCRUD.service.EmployeeThymeleafService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.springboot.demo.demoApp.ThymeleafCRUD.entity.EmployeeThymeleaf;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeThymeleafService employeeService;

    public EmployeeController(EmployeeThymeleafService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        // get the employees from db
        List<EmployeeThymeleaf> theEmployees = employeeService.findAll();

        // add to the spring model
        theModel.addAttribute("employees", theEmployees);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        EmployeeThymeleaf theEmployee = new EmployeeThymeleaf();

        theModel.addAttribute("employee", theEmployee);

        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") EmployeeThymeleaf theEmployee) {

        // save the employee
        employeeService.save(theEmployee);

        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }
}
