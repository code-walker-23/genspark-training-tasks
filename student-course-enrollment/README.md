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

![Entity Diagram](https://i.imgur.com/2JRY4nP.png)

* Many-to-Many between Students and Courses
* `Enrollment` acts as the join table with `enrollmentDate`

---

## 🔁 API Endpoints Overview

### Authentication

```
POST /auth/register         # Register new users
POST /auth/login            # Login and receive JWT
```

### Students

```
GET /students               # View all students
POST /students              # Create a student
```

### Courses

```
GET /courses                # List all courses
POST /courses               # Create a course
```

### Enrollments

```
POST /enrollments           # Enroll a student in course(s)
GET /enrollments/student/{id} # View enrollments for a student
GET /enrollments/course/{id}  # View enrollments for a course
```

---

## 🔐 Security Implementation

* Role-based access control: Admin & Student roles
* JWT-based login with token stored in `Authorization` header
* Passwords hashed with BCrypt before storing in DB

---

## 🚀 Deployment Guide (Cloud Ready)

### Backend (Render / Railway)

1. Deploy Spring Boot project to [Render](https://render.com/) or [Railway](https://railway.app/)
2. Create PostgreSQL instance
3. Use JDBC configuration in environment variables:

```properties
SPRING_DATASOURCE_URL=jdbc:postgresql://your-host/db
SPRING_DATASOURCE_USERNAME=your-user
SPRING_DATASOURCE_PASSWORD=your-password
```

### Frontend (React - Optional)

1. Deploy on [Netlify](https://www.netlify.com/) or [Vercel](https://vercel.com/)
2. Configure Axios base URL to backend API

---

## ⚙️ Sample Properties

```properties
spring.datasource.url=jdbc:postgresql://host:5432/dbname
spring.datasource.username=dbuser
spring.datasource.password=secret
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 🧪 Validation & Exception Handling

* Entity & DTO validation using annotations
* Centralized error handling using `@ControllerAdvice`

---

## 🧾 Final Notes

* This project is production-ready with security and clean architecture
* Designed with modularity and scalability in mind
* Easily extendable with frontend, roles, reports, etc.

---

**Submitted for technical evaluation by:** *\[Vinay Chhabra]*
