package com.springboot.demo.demoApp.restDataJPA.service;

import com.springboot.demo.demoApp.restDataJPA.entity.EmployeeJPA;

import java.util.List;

public interface EmployeeJPAService {
    List<EmployeeJPA> findAll();
    EmployeeJPA findById(int theId);
    EmployeeJPA save(EmployeeJPA theEmployee);
    void deleteById(int theId);
}
