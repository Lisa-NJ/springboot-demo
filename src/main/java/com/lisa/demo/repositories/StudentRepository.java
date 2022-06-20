package com.lisa.demo.repositories;

import com.lisa.demo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Optional<Student> findStudentByEmail(String email); // Custom method to enable quering a student by email address

    void deleteStudentByEmail(String email); //Custom method to eneble deletion of a student by email address
}
