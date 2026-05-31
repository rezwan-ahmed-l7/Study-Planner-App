# Department Based Study Planner

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
* Task Management System
* Add Study Tasks
* Mark Tasks as Completed
* Task Limit Validation
* User Input Validation
* Interactive JavaFX Interface
* Clean and User-Friendly Design

---

# Application Workflow

<table>
<tr>
<td width="45%">

## Student Registration

The application begins with a registration page where students enter their:

- Name
- Student ID
- Department

After successful validation, users are redirected to the study planner dashboard.

</td>

<td width="55%">

<img src="https://github.com/user-attachments/assets/3690a2f3-f14e-4c6f-bd59-5de40595d1d8" width="100%">

</td>
</tr>

<tr>
<td width="45%">

## Task Management & Validation

Students can select department-specific study tasks and add them to their planner.

Features demonstrated:

- Department-based task suggestions
- Dynamic task creation
- Maximum 5 task limit
- Validation warning message

</td>

<td width="55%">

<img src="https://github.com/user-attachments/assets/554403ae-2acc-4d8b-a8ca-8a79576157e7" width="100%">

</td>
</tr>

<tr>
<td width="45%">

## Task Completion

Users can mark tasks as completed.

When the **Complete** button is pressed:

- The task is removed from the planner
- The task list remains organized
- Users can add new tasks if needed

</td>

<td width="55%">

<img src="https://github.com/user-attachments/assets/f7b89aec-c635-48d6-8db4-76637c7bade4" width="100%">

</td>
</tr>
</table>

---

## 3. Task Completion

Students can mark tasks as completed. Once completed, the task is automatically removed from the planner to keep the study schedule organized.

<p align="center">
  <img width="700" alt="Task Completion" src="https://github.com/user-attachments/assets/f7b89aec-c635-48d6-8db4-76637c7bade4" />
</p>

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
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── application/
│       │           └── App.java
│       │
│       └── resources/
│           └── StudyPlanner.png
│
├── pom.xml
├── LICENSE
└── README.md
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

* Database Integration
* User Login System
* Task Priority Management
* Deadline & Reminder System
* Additional Department Support
* Dark Mode Support

---

# Author

### Rezwan Ahmed

B.Sc. Engg. in CSE Student | Aspiring Software Developer & Learner

---

# Support

If you found this project useful, consider giving it a ⭐ on GitHub.
