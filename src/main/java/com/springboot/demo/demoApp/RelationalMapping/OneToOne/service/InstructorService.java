package com.springboot.demo.demoApp.RelationalMapping.OneToOne.service;

import com.springboot.demo.demoApp.RelationalMapping.OneToOne.entity.unidirectional.Instructor;
import com.springboot.demo.demoApp.RelationalMapping.OneToOne.entity.unidirectional.InstructorDetail;
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

    // since cascade attribute is set to CascadeType.ALL
    // so InstructorDetail entity will be deleted automatically when the Instructor entity is deleted.
    @Transactional
    public void deleteInstructoAndDetail(Long instructorId) {
        Instructor instructor = entityManager.find(Instructor.class, instructorId);
        if (instructor != null) {
            entityManager.remove(instructor);
        }
    }

    @Transactional
    public void deleteInstructoDetail(Long instructorId) {
        Instructor instructor = entityManager.find(Instructor.class, instructorId);
        if (instructor != null) {
            InstructorDetail instructorDetail = instructor.getInstructorDetail();
            if (instructorDetail != null) {
                instructor.setInstructorDetail(null); // disassociate detail from instructor
                entityManager.remove(instructorDetail);
            }
        }
    }

}
