package com.vinay.studentenrollment.service;

import com.vinay.studentenrollment.dto.StudentRequest;
import com.vinay.studentenrollment.exception.StudentNotFoundException;
import com.vinay.studentenrollment.exception.UserNotFoundException;
import com.vinay.studentenrollment.exception.InvalidRequestException; // optional new exception
import com.vinay.studentenrollment.models.Student;
import com.vinay.studentenrollment.models.User;
import com.vinay.studentenrollment.repository.StudentRepository;
import com.vinay.studentenrollment.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final UserRepository userRepository;

    public StudentService(StudentRepository studentRepository, UserRepository userRepository) {
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
    }

    // Create a new student
    public Student createStudent(StudentRequest request) {
        if (request.getUserId() == null) {
            throw new InvalidRequestException("User ID is required");
        }

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + request.getUserId()));

        Student student = new Student();
        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setUser(user);

        return studentRepository.save(student);
    }

    // Update student by ID
    public Student updateStudent(Long id, Student updatedStudent) {
        Student existing = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + id));

        existing.setName(updatedStudent.getName());
        existing.setEmail(updatedStudent.getEmail());

        return studentRepository.save(existing);
    }

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get student by ID
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with ID " + id + " not found"));
    }

    // Delete student by ID
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException("Student not found with ID: " + id);
        }
        studentRepository.deleteById(id);
    }
}
