package com.jpa.my_leaning.repository;

import com.jpa.my_leaning.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
     List<Student> findByFirstName(String firstName);

     List<Student> findByFirstNameContaining(String name);

     List<Student> findByLastNameEndingWith(String filter);

     Student findByFirstNameAndLastName(String firstName, String LastName);

}
