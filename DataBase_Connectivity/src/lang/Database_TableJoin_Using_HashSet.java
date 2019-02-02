package lang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Database_TableJoin_Using_HashSet {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Set<String> set = new HashSet<String>();
		Scanner sc = new Scanner(System.in);

		Class.forName("org.postgresql.Driver");
		System.out.println("Enter the id:-");
		int a = sc.nextInt();

		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employeedb", "postgres",
				"onkar@1993");
		// here sonoo is database name, root is username and password
		Statement stmt = conn.createStatement();

		String sql = "select person.details.id,person.details.\"name\",person.place.country\r\n"
				+ "from person.place\r\n"
				+ "inner join person.details on person.place.id = person.details.id where person.details.id = " + a
				+ ";";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			set.add("" + rs.getInt(1));
			set.add(rs.getString(2));
			set.add(rs.getString(3));
		}
		System.out.println(set);
	}

}
