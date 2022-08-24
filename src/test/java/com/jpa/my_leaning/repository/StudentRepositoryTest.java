package com.jpa.my_leaning.repository;

import com.jpa.my_leaning.entity.Guardian;
import com.jpa.my_leaning.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//@DataJpaTest creates test and wont affect the database
@SpringBootTest
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
                .emailId("pkdkd@sd.com")
                .firstName("Tanya")
                .lastName("mab")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }
    @Test
    public void getAllStudents(){
        List<Student> allStudents = studentRepository.findAll  ();
        System.out.println("allStudents = " + allStudents);
    }
    
    @Test
    public void getStudentByFirstNameContaining(){
        List<Student> student = studentRepository.findByFirstNameContaining("t");

        System.out.println("student = " + student);
    }

    @Test
    public void getByFirstName(){
        List<Student> student = studentRepository.findByFirstName("tinashe");

        System.out.println("student = " + student);
    }
    
    @Test
    public void getStudentsByLastNameEndWith(){
        List<Student> students = studentRepository.findByLastNameEndingWith("ab");
        System.out.println("students = " + students);
    }

    @Test
    public void findByFirstAndLastName(){
        Student student = studentRepository.findByFirstNameAndLastName("Tinashe","mab");
        System.out.println("student = " + student);
    }

    @Test
    public void getByCustomEmailQuery(){
        Student student = studentRepository.findStudentByEmailAddress("p@sd.com");
        System.out.println("student = " + student);
    }

    @Test
    public void getStudentFirstNameByEmail(){
        String student = studentRepository.getStudentFirstNameByEmailAddress("p@sd.com");
        System.out.println("student = " + student);
    }

    @Test
    public void getByCustomEmailQueryNative(){
        Student student = studentRepository.nativeFindStudentByEmailAddress("p@sd.com");
        System.out.println("student = " + student);
    }

    @Test
    public void getStudentFirstNameByEmailNative(){
        String student = studentRepository.nativeGetStudentFirstNameByEmailAddress("p@sd.com");
        System.out.println("student = " + student);
    }

    @Test
    public void updateStudentNameByEmail(){
        studentRepository.updateStudentFirstNameByEmail("BlackCode","p@sd.com");
    }
}