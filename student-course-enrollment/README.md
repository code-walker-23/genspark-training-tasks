# Student Course Enrollment System
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


| Method | Endpoint             | Description                 |
|--------|----------------------|-----------------------------|
| POST   | `/api/auth/signup` | Register a new user          |
| POST   | `/api/auth/signin`    | Login (using Basic Auth headers) |

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