package jdbcProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TransactionJdbc {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection connection = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		Scanner scanner = new Scanner(System.in);
		String qry1 = "insert into snehal_db.student values(?,?,?)";
		String qry2 = "insert into snehal_db.user_details values(?,?)";

		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
		pstmt1 = connection.prepareStatement(qry1);
		connection.setAutoCommit(false);
		pstmt1.setInt(1, 6);
		pstmt1.setString(2, "archi");
		pstmt1.setString(3, "etx");
		pstmt1.execute();
		System.out.println("student ka table inserted succesfully .......");

		pstmt2 = connection.prepareStatement(qry2);
		pstmt2.setString(1, "siya");
		pstmt2.setString(2, "ram");
		pstmt2.execute();
		connection.commit();
		System.out.println("user ka table inserted succesfully .......");

		connection = null;
		pstmt1 = null;
		pstmt2 = null;
	}

}
