package jdbcProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddBatchNew {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Connection connection = null;
		PreparedStatement pstmt = null;
		String qry = "insert into snehal_db.snehal values(?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			pstmt = connection.prepareStatement(qry);
			while (true) {
				System.out.println("Enter the id:");
				int id = scanner.nextInt();
				System.out.println("Enter the name :");
				String name = scanner.next();
				System.out.println("enter the branch :");
				String branch = scanner.next();
				System.out.println("enter the yop :");
				int yop = scanner.nextInt();
				pstmt.setInt(1, id);
				pstmt.setString(2, name);
				pstmt.setString(3, branch);
				pstmt.setInt(4, yop);
				pstmt.addBatch();
				System.out.println("\n do you want to continue? (y/n) ");
				String ans = scanner.next();
				if (ans.equalsIgnoreCase("n")) {
					break;
				}
			}
			pstmt.executeBatch();

			System.out.println("all statements has been executed .....");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
