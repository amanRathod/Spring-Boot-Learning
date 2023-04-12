package com.springboot.demo.demoApp.restDataJPA.service;

import com.springboot.demo.demoApp.restDataJPA.entity.EmployeeJPA;
import com.springboot.demo.demoApp.restDataJPA.dao.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeJPAServiceImpl implements EmployeeJPAService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeJPAServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<EmployeeJPA> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeJPA findById(int theId) {

        Optional<EmployeeJPA> result = employeeRepository.findById(theId);

        EmployeeJPA theEmployee = null;

        if (result.isPresent()) {
            theEmployee = result.get();
        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theEmployee;
    }

    @Override
    public EmployeeJPA save(EmployeeJPA theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
