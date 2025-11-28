# Employee Management System

A comprehensive Java-based application for managing employee records. This system allows you to add, view, update, and remove employee details, featuring a secure login system and a user-friendly interface.

## Features

-   **User Authentication**: Secure login screen.
-   **Dashboard**: Central hub for all operations.
-   **Add Employee**: Form to register new employees with personal and professional details.
-   **View Employees**: List view of all employees with search functionality.
-   **Update Details**: Edit existing employee information.
-   **Remove Employee**: Delete employee records from the system.
-   **Secure Configuration**: Database credentials are stored safely in a configuration file.

## Prerequisites

Before you begin, ensure you have the following installed:

-   **Java Development Kit (JDK)**: Version 8 or higher (JDK 21 recommended).
-   **MySQL Server**: For the database.
-   **Visual Studio Code** (or any Java IDE).
-   **Git**: To clone the repository.

## Getting Started

Follow these steps to set up and run the project on your local machine.

### 1. Clone the Repository

Open your terminal or command prompt and run:

```bash
git clone https://github.com/robiul-islam-ridoy/EmployeeManagementSystem.git
cd EmployeeManagementSystem
```

### 2. Database Setup

You need to create the database and tables in MySQL.

1.  Open your MySQL command line client or a GUI tool like MySQL Workbench.
2.  Run the following SQL commands:

```sql
-- Create the database
CREATE DATABASE employeeManagementSystem;
USE employeeManagementSystem;

-- Create the login table
CREATE TABLE login (
    username VARCHAR(20),
    password VARCHAR(20)
);

-- Insert a default admin user
INSERT INTO login VALUES ('admin', '12345');

-- Create the employee table
CREATE TABLE employee (
    name VARCHAR(50),
    fname VARCHAR(50),
    dob VARCHAR(30),
    salary VARCHAR(20),
    address VARCHAR(100),
    phone VARCHAR(20),
    email VARCHAR(50),
    education VARCHAR(20),
    designation VARCHAR(30),
    aadhar VARCHAR(20),
    empId VARCHAR(20)
);
```

### 3. Configure Database Connection

1.  Navigate to the `src` folder in the project directory.
2.  Locate the `config.properties` file.
3.  Open it and update the database credentials if yours are different from the defaults:

```properties
db.url=jdbc:mysql://localhost:3306/employeeManagementSystem
db.username=root
db.password=YOUR_MYSQL_PASSWORD
```

> **Note**: If you don't have a password for your root user, leave `db.password` empty.

### 4. Running the Application

**Using Visual Studio Code:**

1.  Open the project folder in VS Code.
2.  Wait for the Java project to load.
3.  Navigate to `src/employee/management/system/splash.java`.
4.  Click the **Run** button or press `F5`.

**Using Command Line:**

Compile and run the project using the following commands (ensure you are in the project root):

```bash
# Compile
javac -cp "lib/*;src" src/employee/management/system/*.java

# Run
java -cp "lib/*;src" employee.management.system.splash
```

## Project Structure

-   `src/`: Source code files.
-   `lib/`: External libraries (MySQL Connector, JCalendar, rs2xml).
-   `src/icons/`: Image assets used in the UI.
-   `src/config.properties`: Database configuration file.

## Technologies Used

-   **Java Swing**: For the Graphical User Interface (GUI).
-   **JDBC**: For Java Database Connectivity.
-   **MySQL**: Relational Database Management System.

## Developer

Developed by **Robiul Islam Ridoy**.

## License

This project is open-source and available for educational purposes.
