package com.vinay.studentenrollment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CourseRequest {

    @NotBlank(message = "Course title is required")
    @Size(max = 100, message = "Course title must be at most 100 characters")
    private String title;

    @Size(max = 500, message = "Course description must be at most 500 characters")
    private String description;

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
