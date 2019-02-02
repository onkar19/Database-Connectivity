package lang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database_Insert {

public static void main(String args[]) throws SQLException, ClassNotFoundException {
Class.forName("org.postgresql.Driver");
Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employeedb", "postgres", "onkar@1993");
PreparedStatement pstmt = conn.prepareStatement("insert into employee.employee values(?,?,?,?)");
pstmt.setInt(1, 3);
pstmt.setString(2, "priya");
pstmt.setString(3, "priya@gmail.com");
pstmt.setInt(4, 123456978);
pstmt.executeUpdate();
System.out.println("inserted");
conn.close();
pstmt.close();
}

}



