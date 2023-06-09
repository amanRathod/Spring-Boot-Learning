package com.springboot.demo.demoApp.restAPI.dao;

import com.springboot.demo.demoApp.restAPI.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int theId);
}
