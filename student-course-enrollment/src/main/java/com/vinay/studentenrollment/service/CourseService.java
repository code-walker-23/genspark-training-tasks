package com.vinay.studentenrollment.service;

import com.vinay.studentenrollment.exception.CourseNotFoundException;
import com.vinay.studentenrollment.models.Course;
import com.vinay.studentenrollment.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with ID: " + id));
    }

    public void deleteCourse(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new CourseNotFoundException("Course not found with ID: " + id);
        }
        courseRepository.deleteById(id);
    }

    public Course updateCourse(Long id, Course updatedCourse) {
        Course existing = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with ID: " + id));

        existing.setTitle(updatedCourse.getTitle());
        existing.setDescription(updatedCourse.getDescription());

        return courseRepository.save(existing);
    }
}
