<<<<<<< HEAD
### Authentication (Public)
=======
# Student Course Enrollment System

This project was developed as a part of a genspark-assigned technical task. It showcases a complete backend system (with optional frontend) to manage student-course enrollments. The system demonstrates proficiency in building enterprise-grade REST APIs using **Spring Boot**, along with modern authentication, relational data modeling, and deployment best practices.

---

## 📌 Features Implemented

### 👨‍🏫 Admin Functionality

* Manage students and courses (CRUD operations)
* View and filter enrollments
* Secure role-based access

### 👨‍🎓 Student Functionality

* View available courses
* Enroll in multiple courses
* Check own enrollments

---

## 🛠️ Tech Stack

| Layer    | Technology                              |
| -------- | --------------------------------------- |
| Backend  | Spring Boot, Spring Data JPA, Hibernate |
| Database | PostgreSQL (hosted on Railway/Render)   |
| Frontend | (Optional) React, Axios                 |
| Security | Spring Security, JWT Authentication     |

---

## 📐 Architecture Overview

![Architecture Diagram](https://i.imgur.com/X7U9e7j.png)

> REST APIs protected via JWT, interacting with a hosted PostgreSQL database. Frontend can optionally consume these APIs.

---

## 📦 Backend Structure (Spring Boot)

```
student-course-enrollment/
├── controller/        # REST Controllers
├── model/             # Entity Classes (Student, Course, Enrollment)
├── repository/        # JPA Interfaces
├── service/           # Business Logic and Service Layer
├── config/            # Security Configurations
└── EnrollmentApplication.java
```

---

## 📊 Entity Relationship Diagram

![Entity Diagram](https://github.com/code-walker-23/genspark-training-tasks/blob/main/student-course-enrollment/database-design.png)

* Many-to-Many between Students and Courses
* `Enrollment` acts as the join table with `enrollmentDate`

---

## 🔁 API Endpoints Overview

>>>>>>> f14d39e7915c0a4f7f5c0a6af4242352dc1ce67b
### Authentication

| Method | Endpoint             | Description                 |
|--------|----------------------|-----------------------------|
| POST   | `/api/auth/register` | Register a new user          |
| POST   | `/api/auth/login`    | Login (using Basic Auth headers) |
```
POST /auth/register         # Register new users
POST /auth/login            # Login and receive JWT
```

### Students

### Student Management (Admin Role Required)
```
GET /students               # View all students
POST /students              # Create a student
```

| Method | Endpoint           | Description                 |
|--------|--------------------|-----------------------------|
| GET    | `/students`         | Get all students             |
| POST   | `/students`         | Create a new student         |
| PUT    | `/students/{id}`    | Update student details       |
| DELETE | `/students/{id}`    | Delete a student             |
### Courses

### Course Management (Admin Role Required)
```
GET /courses                # List all courses
POST /courses               # Create a course
```

| Method | Endpoint           | Description                 |
|--------|--------------------|-----------------------------|
| GET    | `/courses`          | Get all courses              |
| POST   | `/courses`          | Create a new course          |
| PUT    | `/courses/{id}`    | Update course details        |
| DELETE | `/courses/{id}`    | Delete a course              |
### Enrollments

### Enrollment Management (Admin Role Required)
```
POST /enrollments           # Enroll a student in course(s)
GET /enrollments/student/{id} # View enrollments for a student
GET /enrollments/course/{id}  # View enrollments for a course
```

| Method | Endpoint                      | Description                  |
|--------|-------------------------------|------------------------------|
| GET    | `/enrollments`                | Get all enrollments           |
| POST   | `/enrollments`                | Create a new enrollment       |
| DELETE | `/enrollments/{id}`           | Delete an enrollment          |
| GET    | `/enrollments/student/{studentId}` | Filter enrollments by student |
| GET    | `/enrollments/course/{courseId}`   | Filter enrollments by course  |
---

### Student-Specific APIs (Student Role Required)
## 🔐 Security Implementation

| Method | Endpoint           | Description                 |
|--------|--------------------|-----------------------------|
| GET    | `/courses`          | View all available courses   |
| POST   | `/enrollments`      | Enroll in course(s)          |
| GET    | `/enrollments`      | View own enrollments         |