package jdbcProject;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CollableStatementDemo1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Connection con = null;
		CallableStatement cstmt = null;

		System.out.println("\n Enter the student id :");
		int id = scanner.nextInt();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
			System.out.println("Driver loaded and registerd ...");
			cstmt = con.prepareCall("{call snehal_db.getstudentName(?,?)}");
			cstmt.setInt(1, id);
			cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			cstmt.execute();

			String name1 = cstmt.getString(2);
			System.out.println(name1);
		}

		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			if (cstmt != null)
				try {
					cstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

		}
	}
}
