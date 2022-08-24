package com.jpa.my_leaning.repository;

import com.jpa.my_leaning.entity.Course;
import com.jpa.my_leaning.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder()
                .name("JAVA")
                .credit(12)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("testUrl")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void getAllCourseMaterial(){
        List<CourseMaterial> courses = courseMaterialRepository.findAll();
        System.out.println("courses = " + courses);
    }



}