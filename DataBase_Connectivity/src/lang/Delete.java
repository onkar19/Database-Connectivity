package lang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employeedb", "postgres",
				"onkar@1993");
		Statement pstmt = conn.prepareStatement("delete from employee.employee");
		 System.out.println("Creating statement...");
	      pstmt = conn.createStatement();
	      String sql = "delete from employee.employee " +
	                    "WHERE name  = 'vijay'";
	      pstmt.executeUpdate(sql);
	      System.out.println("Updated");
		

	      conn.close();
}
}