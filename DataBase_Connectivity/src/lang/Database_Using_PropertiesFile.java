package lang;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Database_Using_PropertiesFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("Database.properties");
		Properties p = new Properties();
		p.load(fr);
		try {
			Class.forName("org.postgresql.Driver");

			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employeedb", p.getProperty("user"),
					p.getProperty("password"));
//here sonoo is database name, root is username and password  
			Statement stmt = conn.createStatement();
			String sql = "select * from person.details; ";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next())
				System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3)+" "+rs.getString(4));
			//System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			conn.close();
			System.out.println();
			System.out.println("CONNECTION CLOSED");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	}


