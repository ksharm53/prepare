package jan2024;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class ScriptingDBConnect {

	public static void main(String[] args) {

		try {
			Connection conn = DriverManager.getConnection("url", "username", "password");
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery("Select * from Student");
			// stmt.executeUpdate(null)

			while (res.next()) {
				String col1 = res.getString("col1");
				System.out.println(col1);
			}

			res.close();
			stmt.close();
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
