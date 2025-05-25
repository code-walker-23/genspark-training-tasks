package com.vinay.studentenrollment.service;

import com.vinay.studentenrollment.exception.CourseNotFoundException;
import com.vinay.studentenrollment.exception.EnrollmentAlreadyExistsException;
import com.vinay.studentenrollment.exception.StudentNotFoundException;
import com.vinay.studentenrollment.exception.UserNotFoundException;
import com.vinay.studentenrollment.models.Course;
import com.vinay.studentenrollment.models.Enrollment;
import com.vinay.studentenrollment.models.Student;
import com.vinay.studentenrollment.models.User;
import com.vinay.studentenrollment.repository.CourseRepository;
import com.vinay.studentenrollment.repository.EnrollmentRepository;
import com.vinay.studentenrollment.repository.StudentRepository;
import com.vinay.studentenrollment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnrollmentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private UserRepository userRepository;

    public Enrollment enrollStudentByUsername(String username, Long courseId) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found: " + username));

        Student student = studentRepository.findByUser(user)
                .orElseThrow(() -> new StudentNotFoundException("Student profile not found for user: " + username));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with ID: " + courseId));

        if (enrollmentRepository.existsByStudentAndCourse(student, course)) {
            throw new EnrollmentAlreadyExistsException("Already enrolled in course ID: " + courseId);
        }

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);

        return enrollmentRepository.save(enrollment);
    }

    public Enrollment enrollStudent(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + studentId));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with ID: " + courseId));

        if (enrollmentRepository.existsByStudentAndCourse(student, course)) {
            throw new EnrollmentAlreadyExistsException("Student already enrolled in course ID: " + courseId);
        }

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);

        return enrollmentRepository.save(enrollment);
    }

    public List<Enrollment> getEnrollmentsByStudentId(Long studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }

    public List<Enrollment> getEnrollmentsByCourseId(Long courseId) {
        return enrollmentRepository.findByCourseId(courseId);
    }

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    public List<Enrollment> getEnrollmentsForLoggedInStudent(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found: " + username));

        Student student = studentRepository.findByUser(user)
                .orElseThrow(() -> new StudentNotFoundException("Student not found for user: " + username));

        return enrollmentRepository.findByStudent(student);
    }

    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteById(id);
    }

    public List<Course> getCoursesByStudent(Long studentId) {
        return enrollmentRepository.findByStudentId(studentId)
                .stream()
                .map(Enrollment::getCourse)
                .collect(Collectors.toList());
    }

    public List<Student> getStudentsByCourse(Long courseId) {
        return enrollmentRepository.findByCourseId(courseId)
                .stream()
                .map(Enrollment::getStudent)
                .collect(Collectors.toList());
    }
}
