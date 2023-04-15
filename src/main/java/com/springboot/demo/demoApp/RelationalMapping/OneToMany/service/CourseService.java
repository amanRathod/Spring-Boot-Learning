package com.springboot.demo.demoApp.RelationalMapping.OneToMany.service;

import com.springboot.demo.demoApp.RelationalMapping.OneToMany.entity.Course;
import com.springboot.demo.demoApp.RelationalMapping.OneToMany.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void createCourse(Long instructorId, Course course) {
        Instructor instructor = entityManager.find(Instructor.class, instructorId);
        if (instructor != null) {
            instructor.getCourses().add(course);
            course.setInstructor(instructor);
            entityManager.persist(course);
        }
    }

    public Instructor getInstructorWithCourses(Long instructorId) {
        Instructor instructor = entityManager.find(Instructor.class, instructorId);
        if (instructor != null) {
            // by default, JPA uses lazy loading for @OneToMany and @ManyToMany associations
            instructor.getCourses().size(); // fetch courses eagerly
        }
        return instructor;
    }

    @Transactional
    public void deleteCourse(Long courseId) {
        Course course = entityManager.find(Course.class, courseId);
        if (course != null) {
            Instructor instructor = course.getInstructor();
            instructor.getCourses().remove(course);
            course.setInstructor(null);
            entityManager.remove(course);
        }
    }

}
