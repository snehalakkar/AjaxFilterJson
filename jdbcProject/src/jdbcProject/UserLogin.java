package jdbcProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserLogin {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n Enter your username");
		String username = scanner.next();
		System.out.println("\n Enter the password ");
		String password = scanner.next();
		String qry = "insert into snehal_db.user_details values(?,?)";
		String qry1 = "select * from snehal_db.user_details where username=? and password=?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			preparedStatement = connection.prepareStatement(qry);
			System.out.println("plateform1 created ");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			preparedStatement.executeUpdate();

			preparedStatement = connection.prepareStatement(qry1);
			System.out.println("plateform2 created ");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				String name = resultSet.getString(1);
				String pass = resultSet.getString(2);
				System.out.println(name + "\t" + pass);
				System.out.println(username + " login successfull...");
			} else {
				System.out.println("invalid user credential ");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (resultSet != null)
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (preparedStatement != null)
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
