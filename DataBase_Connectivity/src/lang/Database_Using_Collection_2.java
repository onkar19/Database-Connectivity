package lang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database_Using_Collection_2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employeedb", "postgres",
				"onkar@1993");
		Statement stmt = con.createStatement();
		String sql = "select * from person.details";
		ResultSet rs = stmt.executeQuery(sql);
		/*
		 * while(rs.next()) { System.out.println(rs.getString(1) + "  " +
		 * rs.getString(2) + "  " +
		 * rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)); }
		 */

		while (rs.next()) {
			String id = rs.getString(1);
			String name = rs.getString(2);
			String email = rs.getString(3);
			String mobileno = rs.getString(4);
			String place = rs.getString(5);
			HashMap<String, String> hm = new HashMap<String, String>();
			hm.put("id", id);
			hm.put("name", name);
			hm.put("email", email);
			hm.put("mobileno", mobileno);
			hm.put("place", place);
			list.add(hm);

		}
		con.close();
		stmt.close();
		System.out.println("AVALIABLE DATA IN THE DATABASE:- ");

		for (HashMap<String, String> hashmap : list)
			for (Map.Entry<String, String> me : hashmap.entrySet()) {
				System.out.println((me.getKey() + " = " + me.getValue()).toUpperCase());

			}

	}

}
