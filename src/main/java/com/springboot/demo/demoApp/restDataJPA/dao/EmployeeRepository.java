package com.springboot.demo.demoApp.restDataJPA.dao;

import com.springboot.demo.demoApp.restDataJPA.entity.EmployeeJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeJPA, Integer> {
    // that's it ... no need to write any code LOL!
}
