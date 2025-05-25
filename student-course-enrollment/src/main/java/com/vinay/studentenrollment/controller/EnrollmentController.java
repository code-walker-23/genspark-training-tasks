package com.vinay.studentenrollment.controller;

import com.vinay.studentenrollment.models.Enrollment;
import com.vinay.studentenrollment.models.Course;
import com.vinay.studentenrollment.models.Student;
import com.vinay.studentenrollment.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PreAuthorize("hasRole('STUDENT')")
    @PostMapping
    public Enrollment enrollStudent(@RequestBody Enrollment enrollment) {
        return enrollmentService.enrollStudent(enrollment);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/student/{studentId}")
    public List<Enrollment> getByStudent(@PathVariable Long studentId) {
        return enrollmentService.getEnrollmentsByStudentId(studentId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/course/{courseId}")
    public List<Enrollment> getByCourse(@PathVariable Long courseId) {
        return enrollmentService.getEnrollmentsByCourseId(courseId);
    }

    // Student-only: get enrollments of logged-in student
    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping("/my")
    public List<Enrollment> getMyEnrollments(Authentication authentication) {
        String username = authentication.getName();
        return enrollmentService.getEnrollmentsForLoggedInStudent(username);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/student/{studentId}/courses")
    public List<Course> getCoursesByStudent(@PathVariable Long studentId) {
        return enrollmentService.getCoursesByStudent(studentId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/course/{courseId}/students")
    public List<Student> getStudentsByCourse(@PathVariable Long courseId) {
        return enrollmentService.getStudentsByCourse(courseId);
    }
}
