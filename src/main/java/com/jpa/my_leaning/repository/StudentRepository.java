package com.jpa.my_leaning.repository;

import com.jpa.my_leaning.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
     List<Student> findByFirstName(String firstName);

     List<Student> findByFirstNameContaining(String name);

     List<Student> findByLastNameEndingWith(String filter);

     Student findByFirstNameAndLastName(String firstName, String LastName);

     @Query("select student from Student student where student.emailId = ?1" )
     Student findStudentByEmailAddress(String email);

     @Query("select student.firstName from Student student where student.emailId = ?1")
     String getStudentFirstNameByEmailAddress(String email);

     @Query(
            value = "SELECT * FROM tbl_student s where s.email_address = :emailId",
             nativeQuery = true
     )
     Student nativeFindStudentByEmailAddress(@Param("emailId") String email);

     @Query(
             value = "select first_name from tbl_student student where student.email_address = :emailId",
             nativeQuery = true
     )
     String nativeGetStudentFirstNameByEmailAddress(@Param("emailId") String email);

     @Modifying
     @Transactional
     @Query(
             value = "update tbl_student set first_name = :name where email_address = :email",
             nativeQuery = true
     )
     int updateStudentFirstNameByEmail(@Param("name") String name, @Param("email") String email);



}
