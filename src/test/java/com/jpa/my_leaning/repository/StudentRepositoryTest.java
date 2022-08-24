package com.jpa.my_leaning.repository;

import com.jpa.my_leaning.entity.Guardian;
import com.jpa.my_leaning.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@DataJpaTest creates test and wont affect the database
@SpringBootTest @Slf4j
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudentwithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("tana")
                .mobile("003838")
                .email("asd@g.com")
                .build();


        Student student = Student.builder()
                .emailId("po@sd.com")
                .firName("Tanya")
                .lastName("mab")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }
    @Test
    public void getAllStudents(){
        List<Student> allStudents = studentRepository.findAll();
        System.out.println("allStudents = " + allStudents);
    }
}