package jdbc_06_transaction;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Scanner;

public class transaction {

	public static final String loadDriver = "com.mysql.cj.jdbc.Driver";
	public static final String url = "jdbc:mysql://localhost:3306/WD_adv_4_30";
	public static final String username = "root";
	public static final String password = "Anant@1234";

	// woh user exist krtha hai ya nhi
	public static final String CHECKUSER = "select * from bankcustomer where accno = ?";

	// update balance -> krne ki statement
	public static final String UpdateBalance = "update bankcustomer set balance = balance + ? where accno = ?";

	public static void main(String[] args) {

		try {
			Class.forName(loadDriver);

			Connection con = DriverManager.getConnection(url, username, password);

			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);

			Scanner s = new Scanner(System.in);

			PreparedStatement ps1 = con.prepareStatement(CHECKUSER);
			PreparedStatement ps2 = con.prepareStatement(UpdateBalance);

			System.out.println("Commit Status :" + con.getAutoCommit());
			con.setAutoCommit(false);
			System.out.println("Commit Status :" + con.getAutoCommit());

//			Transaction
			Savepoint sb = con.setSavepoint();

			System.out.println("Enter Sender Account number");
			int sender = s.nextInt();

			ps1.setInt(1, sender);

			ResultSet rs = ps1.executeQuery();

			if (rs.next()) {

				String senderName = rs.getString(3);
				int balance = rs.getInt(4);

				System.out.println("Sender's Name : " + senderName);
				System.out.println("Balance : " + balance);

//				Receiver
				System.out.println("Enter Receiver Account number");
				int recAcc = s.nextInt();

				ps1.setInt(1, recAcc);

				ResultSet rs2 = ps1.executeQuery();

				if (rs2.next()) {

					String RecAcc = rs2.getString(3);
					System.out.println("Receiver's Name : " + RecAcc);

					System.out.println("Enter your Amount to be Transfered");

					int amt = Integer.parseInt(br.readLine());

					if (amt < balance) {
						// sender ke acc se minus
						ps2.setInt(1, -amt);
						ps2.setInt(2, sender);

						// yeh query ko db se bhi update krwa diya
						int p = ps2.executeUpdate();

						// receiver credit
						ps2.setInt(1, amt);
						ps2.setInt(2, recAcc);

						// yeh query ko db se bhi update krwa diya
						int q = ps2.executeUpdate();

						if (p > 0 && q > 0) {
							System.out.println("Transaction Successfull ho chuki hai");
							con.commit();

							System.out.println("Check your Balance (Yes/No)");
							String opt = br.readLine();

							if (!opt.startsWith("Y") && !opt.startsWith("y")) {
								System.out.println("Thank you for using us!!!");
							} else {
								ps1.setInt(1, sender);
								ResultSet rs3 = ps1.executeQuery();

								if (rs3.next()) {
									System.out.println("Customer Name : " + rs3.getString(3));
									System.out.println("Current Balance : " + rs3.getInt(4));
								} else {
									System.out.println("Server Down");
								}

							}
						} else {
							System.out.println("Transaction Failed");
							con.rollback(sb);
						}
					} else {
						System.out.println("Insufficient Funds");
					}
				}

				else {
					System.out.println("Invalid Receiver Account Number");
				}

			} else {
				System.out.println("Invalid Sender Account Number");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
