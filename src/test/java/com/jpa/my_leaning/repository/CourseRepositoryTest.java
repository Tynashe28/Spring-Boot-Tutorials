package com.jpa.my_leaning.repository;

import com.jpa.my_leaning.entity.Course;
import com.jpa.my_leaning.entity.Student;
import com.jpa.my_leaning.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;
    
    @Test
    public void getAllCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .lastName("Mabika")
                .firstName("Tanyaradzwa")
                .build();
        Course course = Course.builder()
                .name("Accounting")
                .credit(11)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }

    @Test
    public void getAllPagination(){
        Pageable pageable = PageRequest.of(6,1);
        Page page = courseRepository.findAll(pageable);
        System.out.println("page contents = " + page.getContent());
        System.out.println("page total elements = " + page.getTotalElements());
        System.out.println("page total pages = " + page.getTotalPages());
    }

    @Test
    public void getAllPaginationSort(){
        Pageable pageable = PageRequest.of(1,5,Sort.by("name"));
        Page page = courseRepository.findAll(pageable);
        System.out.println("page contents = " + page.getContent());
        System.out.println("page total elements = " + page.getTotalElements());
        System.out.println("page total pages = " + page.getTotalPages());
    }

    @Test
    public void saveCourseWithStudent(){
        Course course = Course.builder()
                .name("Stm32")
                .credit(100)
                .teacher(
                        Teacher.builder()
                                .firstName("kingMan")
                                .lastName("David")
                                .build()
                )
                .students(
                        List.of(
                                Student.builder()
                                        .firstName("Tanyaradzwa")
                                        .lastName("Mabika")
                                        .emailId("cooky@gmail.com")
                                        .build(),
                                Student.builder()
                                        .firstName("Jamal")
                                        .lastName("Tinako")
                                        .emailId("jamal@blackcode.com")
                                        .build()
                        )
                )
                .build();
        courseRepository.save(course);
    }

}