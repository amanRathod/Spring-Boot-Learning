package com.springboot.demo.demoApp.HibernateJPA;

import com.springboot.demo.demoApp.HibernateJPA.dao.StudentDAO;
import com.springboot.demo.demoApp.HibernateJPA.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {
    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

        return runner -> {
            createStudent(studentDAO);
            createMultipleStudents(studentDAO);
        };
    }

    private void createMultipleStudents(StudentDAO studentDAO) {

        // create multiple students
        System.out.println("Creating 3 student objects ...");
        Student tempStudent1 = new Student("Ashish", "Jordan", "jordan@gmail.com");
        Student tempStudent2 = new Student("Ankesh", "Kumar", "ankesh@gamil.com");
        Student tempStudent3 = new Student("Ranjeet", "Yadav", "ranjeet@gamil.com");

        // save the student objects
        System.out.println("Saving the students ...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
    }

    private void createStudent(StudentDAO studentDAO) {
        // create the student object
        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Aman", "Rathod", "me@amanrathod.pro");

        // save the student object
        System.out.println("Saving the student ...");
        studentDAO.save(tempStudent);

        // display id of the saved student
        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }
}
