package jdbcProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcStatements {
	public static void main(String[] args) {

		System.out.println("programme started");
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String query = "insert into snehal_db.snehal values(5,'savu','ETX',2016)";
		String query1 = "select * from snehal_db.snehal ";
		String query2 = "update snehal_db.snehal set Name='snehu'";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded and registerd ...");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			statement = connection.createStatement();
			System.out.println("plateform created");
			statement.execute(query1);
			resultSet = statement.getResultSet();

			while (resultSet.next()) {
				int Id = resultSet.getInt(1);
				String Name = resultSet.getString(2);
				String Branch = resultSet.getString(3);
				int YOP = resultSet.getInt(4);
				System.out.println(Id + "\t" + Name + "\t" + Branch + "\t" + YOP);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		if (statement != null)
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (resultSet != null)
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
