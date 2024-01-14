package jan2024;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class ScriptiingDbToCSV {

	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("url", "user", "pass");
			Statement stmt = conn.createStatement();
			FileWriter csvWriter = new FileWriter("");

			ResultSet rs = stmt.executeQuery("Select * from Student");

			ResultSetMetaData metdata = (ResultSetMetaData) rs.getMetaData();
			int count = metdata.getColumnCount();
			for (int i = 0; i < count; i++) {
				csvWriter.append(metdata.getColumnName(i));
				if (i < count)
					csvWriter.append(",");
			}
			csvWriter.append("\n");

			while (rs.next()) {
				for (int i = 1; i <= count; i++) {
					csvWriter.append(rs.getString(i));
					if (i < count)
						csvWriter.append(",");
				}
				csvWriter.append("\n");
			}

		} catch (Exception ex) {

		}

	}

}
