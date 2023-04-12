package com.springboot.demo.demoApp.restDataJPA.rest;

import com.springboot.demo.demoApp.restDataJPA.entity.EmployeeJPA;
import com.springboot.demo.demoApp.restDataJPA.service.EmployeeJPAService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jpa")
public class EmployeeJPARestController {
    private EmployeeJPAService employeeService;

    @Autowired
    public EmployeeJPARestController(EmployeeJPAService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<EmployeeJPA> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public EmployeeJPA getEmployee(@PathVariable int employeeId) {

        EmployeeJPA theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return theEmployee;
    }

    @PostMapping("/employees")
    public EmployeeJPA addEmployee(@RequestBody EmployeeJPA theEmployee) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theEmployee.setId(0);

        EmployeeJPA dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    @PutMapping("/employees")
    public EmployeeJPA updateEmployee(@RequestBody EmployeeJPA theEmployee) {

        EmployeeJPA dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    // add mapping for DELETE /employees/{employeeId} - delete employee

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        EmployeeJPA tempEmployee = employeeService.findById(employeeId);

        // throw exception if null

        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }
}
