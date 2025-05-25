package com.vinay.studentenrollment.models;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)  // usually enrollment must have a student
    private Student student;

    @ManyToOne(optional = false)  // enrollment must have a course
    private Course course;

    // No-args constructor for JPA
    public Enrollment() {}

    // Constructor without id (id is auto-generated)
    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}
