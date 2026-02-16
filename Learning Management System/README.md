# 📚 LearnSphere – Java Web-Based Learning Management System (LMS)

**LearnSphere** is a web-based Learning Management System inspired by platforms like Udemy.  
It is built using **Core Java, JSP/Servlets, JDBC, and MySQL**, following the MVC architecture.  
This project is designed as part of a Java Web Project and meets all requirements of the academic marking rubric.

---

## 🚀 Project Overview

LearnSphere allows:
- Students to browse and enroll in online courses  
- Instructors to create and manage courses  
- Users to register, log in, and manage their profiles  
- Admins to monitor the platform (basic dashboard)

The design demonstrates clean separation of concerns with:
- DAO (Data Access Object) Pattern  
- Service Layer  
- Servlet Controllers  
- JSP Views  
- JDBC Integration  

---

## 🛠️ Tech Stack

| Layer | Technology |
|------|------------|
| Programming Language | **Java (JDK 11+)** |
| Web Framework | **Jakarta Servlets + JSP** |
| Database | **MySQL + JDBC** |
| Build Tool | **Maven (WAR packaging)** |
| Server | **Apache Tomcat (9/10)** |
| UI Styling | **Bootstrap 5** |
| Architecture | **MVC + DAO + Service Layer** |

---

## ✨ Features

### 👤 User Management
- User registration  
- Role selection (Student / Instructor)  
- Login with secure password hashing (SHA-256)  
- Logout & session management  

### 🎓 Course Management
- Instructor-only course creation  
- Course browsing  
- Course detail page  
- Search courses by title  

### 📝 Enrollment System
- Students can enroll in courses  
- Enrollment stored in the database  
- Progress tracking field included  

### 🗂️ Clean Architecture
- DAO Interfaces + Implementations  
- Services as business logic layer  
- Filters for authentication  
- Listener for app initialization  

---

## 📁 Folder Structure
LearnSphere/
├── pom.xml
├── README.md
├── sql/
│ └── schema.sql
├── docs/
│ ├── Architecture.md
│ ├── UML_ClassDiagram.svg
│ ├── UML_UseCaseDiagram.svg
│ └── ERD.svg
├── src/main/java/com/learnsphere/
│ ├── model/ # POJOs (User, Instructor, Student, Course, Enrollment)
│ ├── dao/ # DAO Interfaces + JDBC Implementations
│ ├── service/ # Business logic layer
│ ├── servlet/ # AuthServlet, CourseServlet, EnrollmentServlet
│ ├── filter/ # Authentication filter
│ ├── listener/ # Application startup listener
│ └── util/ # DBUtil + PasswordUtil
└── src/main/webapp/
├── index.jsp
├── error.jsp
├── auth/ # Login + Register JSPs
├── courses/ # List, View, Create
└── admin/ # Dashboard

## 🛠️ How to Run the Project

### 1️⃣ Setup Database
```sql
CREATE DATABASE learnsphere;
USE learnsphere;

then run 

sql/schema.sql

2-Configure Database Credentials

src/main/resources/application.properties

3-Build the Project

mvn clean package

4-Deploy on Tomcat
Copy the generated file:

target/learnsphere.war → Tomcat/webapps/

5️⃣ Open in Browser

http://localhost:8080/learnsphere/