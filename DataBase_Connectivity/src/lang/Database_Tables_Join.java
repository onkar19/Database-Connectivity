package lang;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Database_Tables_Join {
	public static void main(String args[]) throws IOException {
		  
		try {
			Class.forName("org.postgresql.Driver");

			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employeedb", "postgres",
					"onkar@1993");
//here sonoo is database name, root is username and password  
			Statement stmt = conn.createStatement();
			String sql = "select person.details.id,person.details.\"name\",person.place.country\r\n" + 
					"from person.place\r\n" + 
					"right join person.details on person.place.id = person.details.id order by person.details.id ; ";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("id  name  country");
			System.out.println();
			while (rs.next()) {
				 int id = rs.getInt("id");
		         String name = rs.getString("name");
		         String country = rs.getString("country");
		         System.out.println(id + "  " + name + " " +country);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}