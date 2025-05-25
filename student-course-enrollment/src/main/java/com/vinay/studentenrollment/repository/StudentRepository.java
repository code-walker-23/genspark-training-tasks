package com.vinay.studentenrollment.repository;

import com.vinay.studentenrollment.models.Student;
import com.vinay.studentenrollment.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByUser(User user);
}
