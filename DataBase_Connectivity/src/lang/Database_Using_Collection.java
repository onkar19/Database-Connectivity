package lang;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database_Using_Collection {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		List<HashMap<String, String>> list = new ArrayList<>();
		/***
		 * Creating connection with the database
		 */

		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employeedb", "postgres",
				"onkar@1993");
		Statement stmt = con.createStatement();

		String sql = "select * from person.details";
		/***
		 * Finding Schemas Present in Database
		 */
		DatabaseMetaData dbms = con.getMetaData();
		ResultSet resultset = dbms.getSchemas();
		System.out.println("SCHEMA NAME IS:-");
		System.out.println();
		while (resultset.next()) {
			String Schema = resultset.getString(1);
			System.out.println(Schema);
		}
		/***
		 * Finding data present in Table
		 */
		System.out.println();
		ResultSet rs = stmt.executeQuery(sql);

		ResultSetMetaData rsmd = rs.getMetaData();
		/***
		 * Printing number of column available.
		 */
		int colcount = rsmd.getColumnCount();
		System.out.println("NUMBER OS COLUMN:-" + colcount);
		System.out.println();
		/***
		 * Printing table name.
		 */
		String tablename = rsmd.getTableName(colcount);
		System.out.println("TABLE NAME IS:-" + tablename);
		System.out.println();
		System.out.println("COLUMN NAME AND DATA TYPE:-");
		System.out.println();

		for (int i = 1; i <= colcount; i++) {

			String col_name = rsmd.getColumnName(i);

			String col_type = rsmd.getColumnTypeName(i);

			System.out.println(col_name + " = " + col_type);

		}
		System.out.println();
		while (rs.next()) {
			String id =  rs.getString(1);
			String name = rs.getString(2);
			String email =  rs.getString(3);
			String mobileno = rs.getString(4);
			HashMap<String, String> hashmap = new HashMap<>();
			hashmap.put("id", id);
			hashmap.put("name", name);
			hashmap.put("email", email);
			hashmap.put("mobileno", mobileno);
			list.add(hashmap);

		}

		con.close();
		stmt.close();
		System.out.println("DATA AVAILABLE IN TABLE:-");
		System.out.println();
		/***
		 * Printing the data available in database
		 */

		for (HashMap<String, String> kk : list) {
			for (Map.Entry<String, String> aa : kk.entrySet())
				System.out.println((aa.getKey() + " = " + aa.getValue()).toUpperCase());

		}
	}

}
