package jdbcProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Scanner;

public class TransactionWithSavePoint {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		Scanner scanner = new Scanner(System.in);
		String qry1 = "insert into snehal_db.student values(?,?,?)";
		String qry2 = "insert into snehal_db.user_details values(?,?)";
		Savepoint savepoint = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			pstmt1 = connection.prepareStatement(qry1);
			connection.setAutoCommit(false);
			pstmt1.setInt(1, 8);
			pstmt1.setString(2, "aruhi");
			pstmt1.setString(3, "etx");
			pstmt1.executeUpdate();
			System.out.println("student ka table inserted succesfully .......");
			savepoint = connection.setSavepoint();//to save upto this

			pstmt2 = connection.prepareStatement(qry2);
			pstmt2.setString(1, "sitag");
			pstmt2.setString(2, "gita");
			pstmt2.executeUpdate();
			System.out.println("user ka table inserted succesfully .......");
			connection.commit();//if both statements are executed then only commit the changes of both the table
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback(savepoint);//if in second query any error occurs then rollback after savepoint
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			if (pstmt1 != null)
				try {
					pstmt1.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (pstmt2 != null)
				try {
					pstmt1.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
