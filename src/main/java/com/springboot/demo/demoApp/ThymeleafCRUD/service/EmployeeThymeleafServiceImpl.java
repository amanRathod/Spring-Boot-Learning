package com.springboot.demo.demoApp.ThymeleafCRUD.service;

import com.springboot.demo.demoApp.ThymeleafCRUD.dao.EmployeeThymeleafRepository;
import com.springboot.demo.demoApp.ThymeleafCRUD.entity.EmployeeThymeleaf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeThymeleafServiceImpl implements EmployeeThymeleafService{
    private EmployeeThymeleafRepository employeeRepository;

    @Autowired
    public EmployeeThymeleafServiceImpl(EmployeeThymeleafRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<EmployeeThymeleaf> findAll() {

        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public EmployeeThymeleaf findById(int theId) {
        Optional<EmployeeThymeleaf> result = employeeRepository.findById(theId);

        EmployeeThymeleaf theEmployee = null;

        if (result.isPresent()) {
            theEmployee = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theEmployee;
    }

    @Override
    public void save(EmployeeThymeleaf theEmployee) {
        employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
