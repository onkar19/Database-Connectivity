package lang;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Database_Table_Information {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employeedb", "postgres", "onkar@1993");
			DatabaseMetaData dbmd=con.getMetaData(); 
			String table[]= {"TABLE"};
			ResultSet rs=dbmd.getTables(null, null, null, table);
			System.out.println("AVALIABLE TABLE IN DATABASE:-");
			System.out.println();
			while(rs.next())
			{
			System.out.println(rs.getString(3));
			}

			con.close();
			}
			catch (Exception e) {
			// TODO: handle exception
			}


	}

}
