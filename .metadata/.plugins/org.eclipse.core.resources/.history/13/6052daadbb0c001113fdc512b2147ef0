package jdbc_02_statements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertData {

	public static final String loadDriver = "com.mysql.cj.jdbc.Driver";
	public static final String url = "jdbc:mysql://localhost:3306/WD_adv_4_30";
	public static final String username = "root";
	public static final String password = "Anant@1234";

	public static final String QUERY = "insert into stud values(101, 'Aman', 20),(102, 'Lakshay', 22),(103, 'Harsh', 21)";

	public static void main(String[] args) {

		try {
			Class.forName(loadDriver);

			Connection con = DriverManager.getConnection(url, username, password);

//			Statement 
			Statement st = con.createStatement();

//			executeQuery -> 
//			executeUpdate -> 

			int k = st.executeUpdate(QUERY);

			if (k > 0) {
				System.out.println("data inserted");
			} else {
				System.out.println("Data not inserted");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
