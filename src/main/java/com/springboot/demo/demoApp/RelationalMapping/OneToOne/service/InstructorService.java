package com.springboot.demo.demoApp.RelationalMapping.OneToOne.service;

import com.springboot.demo.demoApp.RelationalMapping.OneToOne.entity.unidirectional.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {
    // this annotation is used to inject an instance of EntityManager into InstructorService
    @PersistenceContext
    private EntityManager entityManager;

    // "EntityManager" will automatically manage the session and transaction for us.
    @Transactional
    public void saveInstructorWithDetails(Instructor instructor) {
        entityManager.persist(instructor);
    }
}
