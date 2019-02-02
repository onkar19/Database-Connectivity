package lang;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.xml.validation.Schema;

public class Database_Information {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url = "jdbc:postgresql://localhost:5432/employeedb";
		String driver = "org.postgresql.Driver";
		String user = "postgres";
		String password = "onkar@1993";
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from person.language;");
			ResultSetMetaData rsmd = rs.getMetaData();

			/***
			 * GET THE METADATA
			 */
			DatabaseMetaData dbms = con.getMetaData();
			/***
			 * GET DRIVER INFORMATION
			 */
			System.out.println("Driver information:-");
			System.out.println();
			System.out.println("DRIVER NAME:-" + dbms.getDriverName());
			System.out.println("DRIVER VERSION:-" + dbms.getDriverVersion());
			System.out.println("USER NAME:-" + dbms.getUserName());
			System.out.println("DATABASE URL:-" + dbms.getURL());

			/***
			 * GET SCHEMA INFORMATION
			 */
			System.out.println();
			System.out.println("SCHEMAS NAME OR AVAILABLE SCHEMA:-");
			System.out.println();
			ResultSet schemas = dbms.getSchemas();
			while (schemas.next()) {
				System.out.println(schemas.getString(1));
			}
			System.out.println();

			/***
			 * COLUMN INFO.
			 */
			System.out.println("NUMBER OF COLUMN:-");

			int count = rsmd.getColumnCount();
			System.out.println(count);
			System.out.println();
			System.out.println("COLUMN NAME AND THERE DATATYPE:-");
			for(int i = 1; i<count; i++)
			{
			String columnName = rsmd.getColumnName(i);
			String columnType  = rsmd.getColumnTypeName(i);
			System.out.println(columnName+ " = " +columnType);
			}

			/***
			 * GET TABLE INFO.
			 * 
			 */
			System.out.println();
			System.out.println("Table information:-");
			System.out.println();
			String tableName = rsmd.getTableName(count);
			System.out.println("NAME OF TABLE IS:-" + tableName);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
