package com.springboot.demo.demoApp.ThymeleafCRUD.service;

import com.springboot.demo.demoApp.ThymeleafCRUD.entity.EmployeeThymeleaf;

import java.util.List;

public interface EmployeeThymeleafService {
    List<EmployeeThymeleaf> findAll();

    EmployeeThymeleaf findById(int theId);

    void save(EmployeeThymeleaf theEmployee);

    void deleteById(int theId);
}
