package com.vinay.studentenrollment.repository;

import com.vinay.studentenrollment.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // For looking up the logged-in student
    Optional<Student> findByUsername(String username);
}
