package com.vinay.studentenrollment.repository;

import com.vinay.studentenrollment.models.Enrollment;
import com.vinay.studentenrollment.models.Student;
import com.vinay.studentenrollment.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByStudentId(Long studentId);
    List<Enrollment> findByCourseId(Long courseId);
    List<Enrollment> findByStudent(Student student);

    boolean existsByStudentAndCourse(Student student, Course course); // ✅ needed
}

