package lang;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.validation.Schema;

public class Display_Database {
	public static void main(String args[])  {
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employeedb", "postgres",
					"onkar@1993");
//here sonoo is database name, root is username and password  
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from person.details");
			
			DatabaseMetaData dbms = conn.getMetaData();
			/***
			 * COLUMN INFO.
			 */
			ResultSetMetaData rsdm = rs.getMetaData();
			int numberOfColumn = rsdm.getColumnCount();
			System.out.println("NUMBER OF COLUMN :"+numberOfColumn);
			System.out.println();
			System.out.println("COLUMN NAME AND DATA TYPE:-");
			for(int i = 1; i<numberOfColumn; i++)
			{
				String colName = rsdm.getColumnName(i);
				String colType = rsdm.getColumnTypeName(i);
				System.out.println(colName+ " = " +colType);
				
			}
			System.out.println();
			/***
			 * TABLE INFO.
			 */
			String table = rsdm.getTableName(numberOfColumn);
			System.out.println("TABLE NAME IS:-");
			System.out.println(table);
			/***
			 * USER NAME
			 */
			System.out.println();
			System.out.println("USER NAME:-");
			System.out.println(dbms.getUserName());
			/***
			 * DISPLAYING DATA
			 */
			System.out.println();
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