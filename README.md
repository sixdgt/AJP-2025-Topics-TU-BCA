# AJP-2025-Topics-TU-BCA

## Overview
This repository contains programs related to the **Advanced Java Programming** module for the **sixth semester of the BCA program at Tribhuvan University (TU)**. It serves as a resource for students to enhance their understanding of advanced Java concepts through hands-on coding.

## Repository Contents
- **Examples and Exercises:** A collection of programs aligned with the Advanced Java Programming syllabus.
- **Class and Method Flow Documentation:** The `Class And Method Flow.txt` file provides insights into the structure and logic of the implemented programs.
- **Project Management System:** A full-fledged project demonstrating practical implementation of Java concepts.

## Project: Project Management System
This repository includes a **Project Management System**, designed using:
- **MVC (Model-View-Controller)** architecture
- **DAO (Data Access Object)** pattern for efficient database interactions
- **Singleton Design Pattern** for controlled instance creation
- **JDBC (Java Database Connectivity)** for database operations
- 
## CASE STUDY: Build a web-based application where students can register, log in, view available courses, enroll in them, and manage their enrollment. Admins can manage courses and view registered students.
Modules and Features:
1. Authentication Module (Login/Signup):
Students and Admins can register and log in.
Use Sessions to maintain logged-in state.
Use Cookies to remember login details (optional “Remember Me” functionality).

2. Dashboard:
Redirect to student dashboard or admin dashboard after login based on role.
Use Page Redirection (e.g., response.sendRedirect() or <jsp:forward>).

3. Student Functionalities:
View list of available courses.
Enroll in courses (Many-to-Many relationship: Students ↔ Courses).
View enrolled courses.
Update or delete enrollment.

4. Admin Functionalities:
CRUD operations on courses:
Add new course.
Update course details.
Delete a course.
View list of all courses.
View students enrolled in each course

Feature & Concept Used
Login / Logout: Session Management
JBcryt: Hashing & Checking Password
Remember Me: Cookies Handling
Redirect after Login: Page Redirection
Course Management: CRUD using JDBC
Enroll in Courses: CRUD + Many-to-Many Relationship
Logout Functionality: Session Invalidation

Technologies Used:
Java Servlet API
JSP (Java Server Pages)
JDBC with MySQL
HTML/CSS/Bootstrap (optional for UI)
MVC Architecture (Servlet as Controller, JSP as View)

## Dependencies
The project utilizes the following external libraries:
- **MySQL Connector JAR:** Required for connecting Java applications to a MySQL database.
- **FlatLaf JAR:** A modern look-and-feel library for Java Swing applications.
- **jBCyrpt JAR:** jBCrypt is a Java™ implementation of OpenBSD's Blowfish password hashing code, as described in "A Future-Adaptable Password Scheme" by Niels Provos and David Mazières.

## How to Run the Project
1. Ensure you have **Java 8 or later** installed.
2. Install **MySQL Server** and create the necessary database schema.
3. Add the **MySQL Connector JAR** and **FlatLaf JAR** to your project's classpath.
4. Compile and run the project using your preferred IDE (e.g., IntelliJ IDEA, Eclipse, or NetBeans).

## Contributing
Feel free to contribute by adding more examples, improving existing code, or refining documentation.

## License
This project is open-source and available for educational purposes.

Follow me on:
- **Facebook:** [CodeSandes](https://www.facebook.com/codesandes)
- **Instagram:** [@codesandes](https://www.instagram.com/codesandes/)
- **LinkedIn:** [tmgsandesh](https://www.linkedin.com/in/tmgsandesh/)
- **YouTube:** [CodeSandesh](https://www.youtube.com/@codesandesh)
- **TikTok:** [@codesandesh](https://www.tiktok.com/codesandesh/)

