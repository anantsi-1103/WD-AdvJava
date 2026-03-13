package com.logic.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static final String loadDriver = "com.mysql.cj.jdbc.Driver";
	public static final String url = "jdbc:mysql://localhost:3306/WD_adv_4_30";
	public static final String username = "root";
	public static final String password = "Anant@1234";

	public static Connection getConnection() {
		Connection con = null;

		try {
			Class.forName(loadDriver);
			con = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
