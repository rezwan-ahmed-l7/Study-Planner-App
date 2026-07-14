# Department-Based Study Planner

<p align="center">

  <img src="https://img.shields.io/badge/Software%20Development%20Project-000000?style=for-the-badge" />

  <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white" />

  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" />

  <img src="https://img.shields.io/badge/JavaFX-007ACC?style=for-the-badge&logo=java&logoColor=white" />

</p>

<p align="center">
  A Department-Based Study Planner Desktop Application built using <b>Java</b> and <b>JavaFX</b> for my Software Development Project (SDP) course.
</p>

---

# About The Project

Department-Based Study Planner is a JavaFX desktop application developed as part of my Software Development Project (SDP) course.

The application allows students to register, select their department, and receive department-specific study task suggestions. Users can manage and track their study activities through a clean and interactive graphical interface.

The project was designed to apply Object-Oriented Programming principles, event-driven programming, user input validation, and JavaFX GUI development while addressing a practical academic productivity problem.

---

# Features

* Student Registration System
* Department Selection (CSE, BBA, English)
* Department-Specific Study Suggestions
* Create own tasks
* Task Management System
* Add Study Tasks
* Mark Tasks as Completed
* Task Limit Validation
* User Input Validation
* Interactive JavaFX Interface
* Clean and User-Friendly Design

---

# System Structure & Workflow

<table>
<tr>
<td width="50%">

## Structure

<img width="900" height="200" alt="Screenshot 2026-06-05 191609" src="https://github.com/user-attachments/assets/a845ef01-8c8f-4b6d-8935-0bfecc6fdf73" />

</td>

<td width="45%">

## Workflow

<img width="500" height="500" alt="Screenshot 2026-06-06 201856" src="https://github.com/user-attachments/assets/2d6a8848-c65f-4fca-8400-f3766edf1e2a" />

</td>
</tr>
</table>

---

# Application Workflow

<table>
<tr>
<td width="45%">

## 1. Student Registration

The application begins with a registration page where students enter their:

- Name
- Student ID
- Select Department
- Submit

After successful submission, users are redirected to the study planner dashboard.

</td>

<td width="55%">

<img src="https://github.com/user-attachments/assets/dc880739-15e8-458f-9c86-d6718e57a10a" width="100%">

</td>
</tr>

<tr>
<td width="45%">

## 2. Task Management & Validation

Students can select department-specific study tasks or create their own tasks and add them to their planner.

Features demonstrated:

- Department-based task suggestions
- Create your own task
- Maximum 5 task limit
- Validation warning message

</td>

<td width="55%">

<img src="https://github.com/user-attachments/assets/237116a2-119c-4f00-a64e-c74a42fa95c6" width="100%">

</td>
</tr>

<tr>
<td width="45%">

## 3. Task Completion

Users can mark tasks as completed and add new tasks.

When the **Complete** button is pressed:

- The task is removed from the planner
- The task list remains organized
- Users can add new tasks if needed

</td>

<td width="55%">

<img src="https://github.com/user-attachments/assets/3a5f52c2-75c7-40f3-b39f-e8255e4c4315" width="100%">

</td>
</tr>
</table>

---

# Concepts Used

* Object-Oriented Programming (OOP)
* Event-Driven Programming
* JavaFX GUI Development
* Scene Management
* User Input Validation
* Dynamic Task Management
* Java Collections Framework
* Package-Based Project Structure
* Application UI Design
* Software Development Fundamentals

---

# Challenges Faced

* Designing a department-specific task recommendation system
* Managing dynamic task creation and removal
* Validating user input effectively
* Handling scene transitions between registration and planner pages
* Creating a responsive and intuitive user interface
* Organizing application logic using OOP principles

---

# Language & Tools

| Technology | Purpose                       |
| ---------- | ----------------------------- |
| Java       | Core Programming Language     |
| JavaFX     | GUI Development               |
| Maven      | Build & Dependency Management |
| VS Code    | Development Environment       |

---

# Getting Started

## Prerequisites

Before running this project, make sure you have installed:

* Java JDK 25 or later
* Maven
* JavaFX 25 SDK
* VS Code or any Java-supported IDE

---

# Installation & Run

## 1. Clone the Repository

```bash
git clone https://github.com/your-username/department-based-study-planner.git
```

## 2. Open the Project

Open the project folder using VS Code or your preferred IDE.

## 3. Install Dependencies

```bash
mvn clean install
```

## 4. Run the Application

```bash
mvn javafx:run
```

---

# Project Structure

```bash
Department-Based-Study-Planner/
│
├── .github/
│
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   ├── com/
│   │       │   │   └── application/
│   │       │   │       └── App.java
│   │       │   │
│   │       │   └── module-info.java
│   │       │
│   │       └── resources/
│   │           └── com/
│   │               └── application/
│   │                   ├── primary.fxml
│   │                   ├── secondary.fxml
│   │                   └── StudyPlanner.png
│   │
│   └── target/
│       ├── classes/
│       └── test-classes/
│
└── pom.xml
```

---

# Learning Outcomes

This project helped me improve my understanding of:

* JavaFX Application Development
* Event Handling & User Interaction
* Object-Oriented Programming Principles
* Scene Navigation & GUI Design
* Input Validation Techniques
* Application Structure & Organization
* Debugging & Problem Solving

---

# Future Improvements

* Back Button
* Additional Department Support
* Dark Mode Support
* Database Integration
* Calendar Integration
* Timer Integration
* Task Priority Management
* Deadline & Reminder System

---

# Author

### Rezwan Ahmed

B.Sc. Engg. in CSE Student | Aspiring Software Developer & Learner

---

# Support

🌱 This repository is part of my learning journey as a CSE student. 
The codes, assignments, and reports are shared for educational purposes and may be useful for students who are learning similar concepts.

If you found this repository useful, consider giving it a ⭐ on GitHub. Thank you.
