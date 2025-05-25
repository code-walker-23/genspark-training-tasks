package com.vinay.studentenrollment.service;

import com.vinay.studentenrollment.models.Course;
import com.vinay.studentenrollment.models.Enrollment;
import com.vinay.studentenrollment.models.Student;
import com.vinay.studentenrollment.repository.CourseRepository;
import com.vinay.studentenrollment.repository.EnrollmentRepository;
import com.vinay.studentenrollment.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    // Enroll student into a course
    public Enrollment enrollStudent(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    // Admin: Get all enrollments by student ID
    public List<Enrollment> getEnrollmentsByStudentId(Long studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }

    // Admin: Get all enrollments by course ID
    public List<Enrollment> getEnrollmentsByCourseId(Long courseId) {
        return enrollmentRepository.findByCourseId(courseId);
    }

    // Student: Get enrollments for logged-in student (by username)
    public List<Enrollment> getEnrollmentsForLoggedInStudent(String username) {
        Student student = studentRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return enrollmentRepository.findByStudentId(student.getId());
    }

    // Admin: Get courses enrolled by a student
    public List<Course> getCoursesByStudent(Long studentId) {
        return enrollmentRepository.findByStudentId(studentId)
                .stream()
                .map(Enrollment::getCourse)
                .collect(Collectors.toList());
    }

    // Admin: Get students enrolled in a course
    public List<Student> getStudentsByCourse(Long courseId) {
        return enrollmentRepository.findByCourseId(courseId)
                .stream()
                .map(Enrollment::getStudent)
                .collect(Collectors.toList());
    }
}
