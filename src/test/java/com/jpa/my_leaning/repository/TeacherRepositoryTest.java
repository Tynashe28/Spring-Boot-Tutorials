package com.jpa.my_leaning.repository;

import com.jpa.my_leaning.entity.Course;
import com.jpa.my_leaning.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        List<Course> courses = List.of(Course.builder()
                        .credit(12)
                        .name("C++")
                .build(),
                Course.builder()
                        .credit(12)
                        .name("javascript")
                        .build()
        );

        Teacher teacher = Teacher.builder()
                .firstName("Chibaba")
                .lastName("Changu")
                //.courses(courses)
                .build();
        teacherRepository.save(teacher);
        System.out.println("save teacher {}");
    }

}