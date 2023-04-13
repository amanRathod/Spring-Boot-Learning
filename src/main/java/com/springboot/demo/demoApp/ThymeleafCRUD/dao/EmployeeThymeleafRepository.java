package com.springboot.demo.demoApp.ThymeleafCRUD.dao;

import com.springboot.demo.demoApp.ThymeleafCRUD.entity.EmployeeThymeleaf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmployeeThymeleafRepository extends JpaRepository<EmployeeThymeleaf, Integer> {

    public List<EmployeeThymeleaf> findAllByOrderByLastNameAsc();
}