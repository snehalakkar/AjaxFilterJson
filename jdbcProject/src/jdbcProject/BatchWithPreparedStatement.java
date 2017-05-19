

//whenever we use batch with Preparedstatement interface then single batch can contain only one particular kind of dml statements/queries
package jdbcProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchWithPreparedStatement {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;

		String qry1 = "delete from snehal_db.snehal where branch='ese'";
		String qry2 = "insert into snehal_db.snehal values (18,'riya','mech',2017)";
		String qry3 = "update snehal_db.snehal set name='sachi' where id=7";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			pstmt1=con.prepareStatement(qry1);
			pstmt1.addBatch();
			
			int[] arr = pstmt1.executeBatch();
			for (int i : arr) {
				System.out.println(i + " ");
			}
			pstmt2=con.prepareStatement(qry2);
			pstmt2.addBatch();
			int[] arr1 = pstmt2.executeBatch();

			for (int i : arr1) {
				System.out.println(i + " ");
			}
			pstmt3=con.prepareStatement(qry3);
			pstmt3.addBatch();
			int[] arr2 = pstmt3.executeBatch();
			for (int i : arr2) {
				System.out.println(i + " ");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (pstmt3 != null)
				try {
					pstmt3.close();
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
					pstmt2.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
