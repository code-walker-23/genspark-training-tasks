package com.vinay.studentenrollment.repository;

import com.vinay.studentenrollment.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
