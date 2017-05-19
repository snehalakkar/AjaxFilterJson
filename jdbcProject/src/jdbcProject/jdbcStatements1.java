package jdbcProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcStatements1 {
	public static void main(String[] args) {
		System.out.println("programme started");
		Connection connection = null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet = null;
		String query = "insert into snehal_db.snehal values(?,?,?,?)";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded and registerd ...");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			preparedStatement=connection.prepareStatement(query);
			System.out.println("plateform created");
			preparedStatement.setInt(1, 6);
			preparedStatement.setString(2, "sachi");
			preparedStatement.setString(3, "CSE");
			preparedStatement.setInt(4, 2015);
			preparedStatement.execute();
			
			preparedStatement.setInt(1, 7);
			preparedStatement.setString(2, "ruhi");
			preparedStatement.setString(3, "CSE");
			preparedStatement.setInt(4, 2015);
			preparedStatement.execute();
			System.out.println("insert successfull ");
			
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
		if (preparedStatement != null)
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
