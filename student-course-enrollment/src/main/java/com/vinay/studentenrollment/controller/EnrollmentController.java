package com.vinay.studentenrollment.controller;

import com.vinay.studentenrollment.dto.EnrollmentRequest;
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
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("/self")
    @PreAuthorize("hasRole('STUDENT')")
    public Enrollment enrollSelf(@RequestBody EnrollmentRequest request, Authentication authentication) {
        String username = authentication.getName();
        return enrollmentService.enrollStudentByUsername(username, request.getCourseId());
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Enrollment enrollByAdmin(@RequestBody EnrollmentRequest request) {
        return enrollmentService.enrollStudent(request.getStudentId(), request.getCourseId());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteEnrollment(@PathVariable Long id) {
        enrollmentService.deleteEnrollment(id);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<Enrollment> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }

    @GetMapping("/student/{studentId}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Enrollment> getByStudent(@PathVariable Long studentId) {
        return enrollmentService.getEnrollmentsByStudentId(studentId);
    }

    @GetMapping("/course/{courseId}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Enrollment> getByCourse(@PathVariable Long courseId) {
        return enrollmentService.getEnrollmentsByCourseId(courseId);
    }

    @GetMapping("/me")
    @PreAuthorize("hasRole('STUDENT')")
    public List<Enrollment> getMyEnrollments(Authentication authentication) {
        String username = authentication.getName();
        return enrollmentService.getEnrollmentsForLoggedInStudent(username);
    }

    @GetMapping("/student/{studentId}/courses")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Course> getCoursesByStudent(@PathVariable Long studentId) {
        return enrollmentService.getCoursesByStudent(studentId);
    }

    @GetMapping("/course/{courseId}/students")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Student> getStudentsByCourse(@PathVariable Long courseId) {
        return enrollmentService.getStudentsByCourse(courseId);
    }
}
