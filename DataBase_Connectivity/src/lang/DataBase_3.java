package lang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DataBase_3 {

	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);

		// updateEmployee();

		while (true) {
			System.out.println();
			System.out.println("SELECT THE OPTION:");
			System.out.println(
					"1.Add Employee \n2.Update Employee \n3.Delete Employee \n4.Display Table \n5.Exit".toUpperCase());
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				addEmployee();
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

	public static void addEmployee()
			throws SQLException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		Class.forName("org.postgresql.Driver");
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employeedb", "postgres",
				"onkar@1993");
		System.out.println("enter id:");
		int id1 = sc.nextInt();
		System.out.println("Enter name:");
		String name = sc.next();
		System.out.println("Enter email:");
		String mail = sc.next(); 
		System.out.println("Enter mobile number:");
		String mbl = sc.next();
		PreparedStatement pstmt = conn.prepareStatement("insert into  employee.employee values(?,?,?,?)");
		pstmt.setInt(1, id1);
		pstmt.setString(2, name);
		pstmt.setString(3, mail);
		pstmt.setString(4, mbl);
		pstmt.executeUpdate();
		System.out.println("Row Added sucessfully");
		conn.close();

	}

	public static void updateEmployee(int id) throws SQLException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
 
		Class.forName("org.postgresql.Driver");
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employeedb", "postgres",
				"onkar@1993");
		Statement pstmt = conn.createStatement();
		System.out.println("What u want to update");
		System.out.println("\n1.personID \n 2.name \n 3.email \n 4.mobileno");
		int choice= sc.nextInt();
		System.out.println("Whice id u want to updat");
		int id5 = sc.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Enter id");
			int id2 = sc.nextInt();
		String sql = "UPDATE employee.employee SET personID  ="+id2+" WHERE personID  = " + id5;
		pstmt.executeUpdate(sql);
		System.out.println("ID Updated Sucessfully.");
		break;
		case 2:
			System.out.println("Enter name");
			String str = sc.next();
		String sql1 = "UPDATE employee.employee SET name  ='"+str+"' WHERE personID  = " + id5;
		pstmt.executeUpdate(sql1);
		System.out.println("ID Updated Sucessfully.");
        break;
		case 3 :
			System.out.println("Enter email");
			String mail = sc.next();
		String sql2 = "UPDATE employee.employee SET mail  ='"+mail+"' WHERE personID  = " + id5;
		pstmt.executeUpdate(sql2);
		System.out.println("ID Updated Sucessfully.");
        break;
		case 4:
			System.out.println("Enter mobile");
			String num = sc.next();
		String sql3 = "UPDATE employee.employee SET num  ='"+num+"' WHERE personID  = " + id5;
		pstmt.executeUpdate(sql3);
		System.out.println("ID Updated Sucessfully.");
        
		conn.close();

		}}

	public static void deleteEmployee(int n) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		Class.forName("org.postgresql.Driver");
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employeedb", "postgres",
				"onkar@1993");
		System.out.println("Which name  u want to delete: ");
		String row = sc.next();
		Statement pstmt = conn.createStatement();
		System.out.println("Creating statement...");
		String sql = "delete from employee.employee WHERE name  = '"+row+"'";
		pstmt.executeUpdate(sql);
		System.out.println("Row Deleted Successfully.");

		conn.close();
	}

	public static void display() throws ClassNotFoundException, SQLException

	{
		System.out.println("Displaying the data:-");
		Class.forName("org.postgresql.Driver");
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employeedb", "postgres",
				"onkar@1993");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from employee.employee");
		while (rs.next())

			System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + " " + rs.getString(4));
		conn.close();

	}
}
