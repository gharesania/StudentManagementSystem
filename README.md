# StudentManagementSystem
Student Management System (Java + MySQL)

A simple Java-based Student Management System using JDBC to perform CRUD (Create, Read, Update, Delete) operations on a MySQL database.

📌 Features
- Add new students
- View all students
- Update student details
- Delete students
- Menu-driven console interface

🛠️ Setup Instructions

1️⃣ Install Required Software
- Java JDK (Version 8 or later)
- MySQL Database (Ensure MySQL server is running)
- JDBC Driver (Download MySQL Connector/J from MySQL official site)

2️⃣ Create Database
- Open MySQL and create a new database using:

      CREATE DATABASE student_db;
      USE student_db;
  
- Then, create a students table:

      CREATE TABLE students(
      id INT PRIMARY KEY AUTO_INCREMENT,
      name VARCHAR(100),
      age INT,
      course VARCHAR(100)
      );

3️⃣ Configure Database Connection
- Update the url, user, and password variables in StudentManagementSystem.java:

      String url = "jdbc:mysql://localhost:3306/student_db";
      String user = "root";  // Change this if needed
      String password = "password";  // Change to your MySQL password

4️⃣ Compile & Run the Program
🔹 Using Command Line
1) Compile the program:

       javac StudentManagementSystem.java
3) Run the program:

       java StudentManagementSystem

🔹 Using an IDE (Eclipse/IntelliJ)
- Open the project in an IDE.
- Make sure the JDBC Driver (mysql-connector-java.jar) is added to the project.
- Run the StudentManagementSystem.java file.

📌 Usage

1️⃣ Run the program

2️⃣ Choose an option from the menu:

1 → Add a Student

2 → View Students

3 → Update a Student

4 → Delete a Student

5 → Exit


📌 Troubleshooting
- MySQL Connection Error?
- Ensure MySQL is running.
- Check your database username/password.
- Verify that the student_db exists.

- JDBC Driver Not Found?
- Download and add mysql-connector-java.jar to the classpath.


📌 Author

Sania Ghare 🚀
