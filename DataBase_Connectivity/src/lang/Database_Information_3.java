package lang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Iterator;

public class Database_Information_3 {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employeedb", "postgres",
					"onkar@1993");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from person.details");
			ResultSetMetaData rsmd = rs.getMetaData();
			int colcount = rsmd.getColumnCount();
			System.out.println("NUMBER OF COLUMN :- " + colcount);
			System.out.println();
			String tablename = rsmd.getTableName(5); //HERE NUMBER OF COLUMN IS 5. EITHER YOU CAN WRITE "colcount" ALSO.
			System.out.println("TABLE NAME:-" + tablename);
			System.out.println();
			System.out.println("COLUMNE DETAILS :");
			System.out.println();
			for (int i = 1; i <= colcount; i++) {
				String columnname = rsmd.getColumnName(i);
				String colnametype = rsmd.getColumnTypeName(i);
				System.out.println(columnname + " is of type " + colnametype);

			}
			System.out.println();
			System.out.println("AVAILABLE DATA IN TABLE:-");

			while (rs.next())
				System.out.println(rs.getInt(1) + "     " + rs.getString(2) + "     " + rs.getString(3) + "     "
						+ rs.getString(4) + " " + rs.getString(5));

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
