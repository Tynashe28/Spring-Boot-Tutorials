package com.jpa.my_leaning.repository;

import com.jpa.my_leaning.entity.Course;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;
    
    @Test
    public void getAllCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses = " + courses);
    }
    

}