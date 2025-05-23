package com.vinay.studentenrollment.repository;

import com.vinay.studentenrollment.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // You can define custom queries here if needed later
}
