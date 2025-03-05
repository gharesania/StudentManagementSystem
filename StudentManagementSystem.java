import java.sql.*;
import java.util.Scanner;

public class StudentManagementSystem 
{
    public static void main(String[] args) 
    {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/student_db"; // Change 'student_db' to your database name
        String user = "root";  // Change this if your MySQL username is different
        String password = "password";  // Change this to your actual MySQL password

        // Try to establish a database connection
        try (Connection conn = DriverManager.getConnection(url, user, password);
        Scanner scanner = new Scanner(System.in)) 
        {
            // Menu loop
            while (true) 
            {
                System.out.println("\nStudent Management System");
                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) 
                {
                    case 1:
                        addStudent(conn, scanner);
                        break;
                    case 2:
                        viewStudents(conn);
                        break;
                    case 3:
                        updateStudent(conn, scanner);
                        break;
                    case 4:
                        deleteStudent(conn, scanner);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        } 
        catch (SQLException e) 
        {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    // Function to add a student to the database
    private static void addStudent(Connection conn, Scanner scanner) 
    {
        try 
        {
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Course: ");
            String course = scanner.nextLine();

            // SQL query to insert student details into the database
            String sql = "INSERT INTO students (name, age, course) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) 
            {
                stmt.setString(1, name);
                stmt.setInt(2, age);
                stmt.setString(3, course);
                stmt.executeUpdate();
                System.out.println("Student added successfully.");
            }
        } 
        catch (SQLException e) 
        {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    // Function to display all students from the database
    private static void viewStudents(Connection conn) 
    {
        String sql = "SELECT * FROM students";
        try (Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) 
        {
            System.out.println("\nID | Name | Age | Course");
            while (rs.next()) 
            {
                System.out.println(rs.getInt("id") + " | " + rs.getString("name") +
                        " | " + rs.getInt("age") + " | " + rs.getString("course"));
            }
        } 
        catch (SQLException e) 
        {
            System.out.println("Error fetching students: " + e.getMessage());
        }
    }

    // Function to update a student's information
    private static void updateStudent(Connection conn, Scanner scanner) 
    {
        try 
        {
            System.out.print("Enter Student ID to update: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter new Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter new Course: ");
            String course = scanner.nextLine();

            // SQL query to update student details
            String sql = "UPDATE students SET name = ?, age = ?, course = ? WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) 
            {
                stmt.setString(1, name);
                stmt.setInt(2, age);
                stmt.setString(3, course);
                stmt.setInt(4, id);
                stmt.executeUpdate();
                System.out.println("Student updated successfully.");
            }
        } 
        catch (SQLException e) 
        {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }

    // Function to delete a student from the database
    private static void deleteStudent(Connection conn, Scanner scanner) 
    {
        try 
        {
            System.out.print("Enter Student ID to delete: ");
            int id = scanner.nextInt();

            // SQL query to delete a student by ID
            String sql = "DELETE FROM students WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) 
            {
                stmt.setInt(1, id);
                stmt.executeUpdate();
                System.out.println("Student deleted successfully.");
            }
        } 
        catch (SQLException e) 
        {
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }
}