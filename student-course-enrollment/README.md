Sure! Here's the complete updated README markdown with your actual URL structure and role-based access clarified:

```markdown
# Student Course Enrollment System

This project was developed as a part of a genspark-assigned technical task. It showcases a complete backend system (with optional frontend) to manage student-course enrollments. The system demonstrates proficiency in building enterprise-grade REST APIs using **Spring Boot**, along with modern authentication, relational data modeling, and deployment best practices.

---

## 📌 Features Implemented

### 👨‍🏫 Admin Functionality

* Manage students and courses (CRUD operations)
* View and filter enrollments
* Secure role-based access (ADMIN role required)

### 👨‍🎓 Student Functionality

* View available courses
* Enroll in multiple courses
* View own enrollments

---

## 🛠️ Tech Stack

| Layer    | Technology                              |
| -------- | --------------------------------------- |
| Backend  | Spring Boot, Spring Data JPA, Hibernate |
| Database | PostgreSQL (hosted on Railway/Render)   |
| Frontend | (Optional) React, Axios                 |
| Security | Spring Security, Basic Authentication   |

---

## 📐 Architecture Overview

![Architecture Diagram](https://i.imgur.com/X7U9e7j.png)

> REST APIs protected via role-based security, interacting with a hosted PostgreSQL database. Frontend can optionally consume these APIs.

---

## 📦 Backend Structure (Spring Boot)

```

student-course-enrollment/
├── controller/        # REST Controllers
├── model/             # Entity Classes (Student, Course, Enrollment, User)
├── repository/        # JPA Interfaces
├── service/           # Business Logic and Service Layer
├── config/            # Security Configurations
└── StudentCourseEnrollmentApplication.java

````

---

## 📊 Entity Relationship Diagram

![Entity Diagram](https://i.imgur.com/2JRY4nP.png)

* Many-to-Many between Students and Courses
* `Enrollment` acts as the join table connecting students and courses

---

## 🔁 API Endpoints Overview

### Authentication (Public)

| Method | Endpoint             | Description                 |
|--------|----------------------|-----------------------------|
| POST   | `/api/auth/register` | Register a new user          |
| POST   | `/api/auth/login`    | Login (using Basic Auth headers) |

### Student Management (Admin Role Required)

| Method | Endpoint           | Description                 |
|--------|--------------------|-----------------------------|
| GET    | `/students`         | Get all students             |
| POST   | `/students`         | Create a new student         |
| PUT    | `/students/{id}`    | Update student details       |
| DELETE | `/students/{id}`    | Delete a student             |

### Course Management (Admin Role Required)

| Method | Endpoint           | Description                 |
|--------|--------------------|-----------------------------|
| GET    | `/courses`          | Get all courses              |
| POST   | `/courses`          | Create a new course          |
| PUT    | `/courses/{id}`    | Update course details        |
| DELETE | `/courses/{id}`    | Delete a course              |

### Enrollment Management (Admin Role Required)

| Method | Endpoint                      | Description                  |
|--------|-------------------------------|------------------------------|
| GET    | `/enrollments`                | Get all enrollments           |
| POST   | `/enrollments`                | Create a new enrollment       |
| DELETE | `/enrollments/{id}`           | Delete an enrollment          |
| GET    | `/enrollments/student/{studentId}` | Filter enrollments by student |
| GET    | `/enrollments/course/{courseId}`   | Filter enrollments by course  |

### Student-Specific APIs (Student Role Required)

| Method | Endpoint           | Description                 |
|--------|--------------------|-----------------------------|
| GET    | `/courses`          | View all available courses   |
| POST   | `/enrollments`      | Enroll in course(s)          |
| GET    | `/enrollments`      | View own enrollments         |

---

## 🔐 Security Implementation

* Role-based access control enforced by Spring Security  
* No URL role prefixes; authorization based purely on user roles (`ADMIN` or `STUDENT`)  
* Basic Authentication with BCrypt password encoding  

---