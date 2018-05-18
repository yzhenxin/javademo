package cn.example.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCDemo {
	public static void main(String[] args) {
		String sql = "SELECT empno, ename, job, mgr, hiredate, sal FROM emp";
		String isql = "INSERT INTO emp(empno, ename, job, mgr, hiredate, sal FROM emp)";
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			connection = JDBCUtils.getConnection();
			System.out.println(connection);

			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getInt("empno") + " : " + rs.getString("ename") + " : " + rs.getString("job")
						+ " : " + rs.getString("mgr") + " : " + rs.getDate("hiredate") + " : "
						+ rs.getDouble("sal"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(connection, ps, rs);
		}
	}
}
