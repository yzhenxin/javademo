package cn.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
	public static Connection getConnection() {

		// String mdriverClass = "com.mysql.jdbc.driver";
		// String murl =
		// "mysql:jdbc://localhost:3306:test?useUnicode=true&characterEncoding=utf-8&useSSL=true";
		String odriverClass = "oracle.jdbc.driver.OracleDriver";
		String ourl = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String password = "oracle";

		try {
			Class.forName(odriverClass);
			return DriverManager.getConnection(ourl, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void release(Connection con, Statement statement, ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
