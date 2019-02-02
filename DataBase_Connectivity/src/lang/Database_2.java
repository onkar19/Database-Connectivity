package lang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Database_2 {

	
		public static void main(String args[]) throws ClassNotFoundException, SQLException {
		    Scanner sc = new Scanner(System.in);
			
			//updateEmployee();

		while(true)
		{
			System.out.println();
			System.out.println("SELECT THE OPTION:");
			System.out.println("1.Add Employee \n2.Update Employee \n3.Delete Employee \n4.Display Table \n5.Exit".toUpperCase());
			int choice = sc.nextInt();
		switch(choice)
		{
		case 1:
			addEmployee(9 ,"ohan", "sanjay@gmail.com","9894561230");
			break;
		case 2:
			updateEmployee(4);
			break;
		case 3:
			deleteEmployee(6);
			break;
		case 4:
			display();
			break;
		case 5:
			System.exit(0);
			
			
			
			
		
		}
		}
		}

		public static void  addEmployee(int id,String name, String email,String mobileNo) throws SQLException, ClassNotFoundException {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employeedb", "postgres",
					"onkar@1993");
			PreparedStatement pstmt = conn.prepareStatement("insert into  employee.employee values(?,?,?,?)");
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4,mobileNo);
			pstmt.executeUpdate();
			System.out.println("Row Added sucessfully");
			conn.close();

		}

		public static void updateEmployee(int id) throws SQLException, ClassNotFoundException {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employeedb", "postgres",
					"onkar@1993");
			Statement pstmt = conn.createStatement();
		      String sql = "UPDATE employee.employee SET name  ='priya' WHERE personID  = "+id;
		      pstmt.executeUpdate(sql);
		      System.out.println("Row Updated Sucessfully.");
			

		      conn.close();

		}

		public static void deleteEmployee(int n) throws ClassNotFoundException, SQLException {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employeedb", "postgres",
					"onkar@1993");
			Statement pstmt = conn.createStatement();
			 System.out.println("Creating statement...");
		      String sql = "delete from employee.employee " +
		                    "WHERE PersonID  = "+n;
		      pstmt.executeUpdate(sql);
		      System.out.println("Row Deleted Successfully.");
			

		      conn.close();
		}

		public static void display() throws ClassNotFoundException, SQLException

		{   System.out.println("Displaying the data:-");
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employeedb", "postgres",
					"onkar@1993");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employee.employee");
			while (rs.next())
				
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3)+" "+rs.getString(4));
			conn.close();

		}}

