package lang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database_update {
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employeedb", "postgres",
				"onkar@1993");
		Statement pstmt = conn.prepareStatement("update employee.employee");
		 System.out.println("Creating statement...");
	      pstmt = conn.createStatement();
	      String sql = "UPDATE employee.employee " +
	                   "SET PersonID = '3' WHERE name  = 'priya' ";
	      pstmt.executeUpdate(sql);
	      System.out.println("Updated");
		

	      conn.close();

	}}