
//whenever we use batch with statement interface then single batch can contain any kind of dml statements/queries
package jdbcProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchWithStatementInterface {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		String qry1 = "delete from snehal_db.snehal where branch='ece'";
		String qry2 = "insert into snehal_db.snehal values (28,'pritam','mech',2017)";
		String qry3 = "update snehal_db.snehal set name='sachi' where id=5";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			stmt=con.createStatement();
			stmt.addBatch(qry1);
			stmt.addBatch(qry2);
			stmt.addBatch(qry3);
			int[] arr = stmt.executeBatch();
			for (int i : arr) {
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
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
