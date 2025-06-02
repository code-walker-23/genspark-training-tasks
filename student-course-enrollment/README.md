### Authentication (Public)
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