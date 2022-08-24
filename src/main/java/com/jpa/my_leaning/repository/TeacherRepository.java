package com.jpa.my_leaning.repository;

import com.jpa.my_leaning.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
