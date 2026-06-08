# Employee Management System

## Overview

Employee Management System 

---

## Features

* Add Employee
* Remove Employee
* Search Employee by ID
* Display All Employees
* Display Employees from IT Department
* Sort Employees by Salary

---



## Project Structure

```
EmployeeManagementSystem/
│
├── Employee.java
├── EmployeeException.java
├── EmployeeManager.java
├── Main.java
└── README.md
```

---

## OOP Concepts Implemented

### Encapsulation

Employee details are encapsulated inside the Employee class using private fields and public getter methods.

### Classes and Objects

* Employee
* EmployeeManager
* EmployeeException

### Exception Handling

Custom exception handling is implemented using the EmployeeException class for invalid operations.

---

## Collections Framework Usage

### ArrayList

Used to store employee records.

```java
ArrayList<Employee> employees;
```

---

## Java 8 Features

### Optional

Used while searching for employees.

```java
Optional<Employee> employee =
        employees.stream()
                 .filter(e -> e.getEmployeeId() == employeeId)
                 .findFirst();
```

### Stream API

Used for searching, filtering, and sorting employee records.

```java
employees.stream()
         .filter(e -> e.getDepartment().equalsIgnoreCase("IT"));
```

### Lambda Expressions

Used for displaying employee records.

```java
employees.forEach(System.out::println);
```

---

## How to Compile

Open terminal inside the project folder and run:

```bash
javac *.java
```

---

## How to Run

```bash
java Main
```

---

## Sample Menu

```
===== Employee Management System =====

1. Add Employee
2. Remove Employee
3. Search Employee
4. Display Employees
5. Display IT Employees
6. Sort Employees By Salary
7. Exit
```

---

## Author

Week 1 – Assignment 2

Employee Management System developed as part of Java Basics training and internship evaluation.
