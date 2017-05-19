package jdbcProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddBatchJdbc {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		String qry = "insert into snehal_db.snehal values(?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			pstmt = connection.prepareStatement(qry);

			pstmt.setInt(1, 13);
			pstmt.setString(2, "niki");
			pstmt.setString(3, "cse");
			pstmt.setInt(4, 2016);
			pstmt.addBatch();

			pstmt.setInt(1, 15);
			pstmt.setString(2, "chitra");
			pstmt.setString(3, "cse");
			pstmt.setInt(4, 2016);
			pstmt.addBatch();

			pstmt.setInt(1, 16);
			pstmt.setString(2, "priya");
			pstmt.setString(3, "ese");
			pstmt.setInt(4, 2016);
			pstmt.addBatch();

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
