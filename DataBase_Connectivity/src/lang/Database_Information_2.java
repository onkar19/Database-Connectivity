package lang;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Database_Information_2 {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:postgresql://localhost:5432/employeedb";
		String driver = "org.postgresql.Driver";
		String user = "postgres";
		String password = "onkar@1993";

		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);

			// Get the MetaData
			DatabaseMetaData metaData = conn.getMetaData();

			// Get driver information

			System.out.println("DRIVER NAME:-" + metaData.getDriverName());
			System.out.println("DRIVER VERSION:-" + metaData.getDriverVersion());
			System.out.println("USER NAME:-" + metaData.getUserName());
			System.out.println();
			// Get schema information
			System.out.println("AVALABLE SCHEMAS:-");
			System.out.println();
			ResultSet schemas = metaData.getSchemas();
			while (schemas.next()) {
				System.out.println(schemas.getString(1));
			}
			System.out.println();
			// Get table information
			System.out.println("AVAILABLE TABLES:-");
			System.out.println();
			String table[] = { "TABLE" };
			ResultSet tables = metaData.getTables("", "", "", table);
			while (tables.next()) {
				System.out.println(tables.getString(3));
			}
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}