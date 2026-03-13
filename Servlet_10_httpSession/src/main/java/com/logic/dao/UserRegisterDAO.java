package com.logic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Savepoint;

import com.logic.bean.CustomerBean;
import com.logic.bean.UserBean;
import com.logic.connection.DBConnection;

public class UserRegisterDAO {

	public static final String userRegister = "INSERT INTO userdetail VALUES (?, ?, ?, ?, ?, ?)";

	public static final String custRegister = "INSERT INTO customer VALUES (?, ?, ?)";

	public int addUser(UserBean ub, CustomerBean cb) {

		int k = 0;

		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps1 = con.prepareStatement(userRegister);
				PreparedStatement ps2 = con.prepareStatement(custRegister)) {

			con.setAutoCommit(false);
			Savepoint sp = con.setSavepoint();

			ps1.setInt(1, ub.getId());
			ps1.setString(2, ub.getFname());
			ps1.setString(3, ub.getLname());
			ps1.setString(4, ub.getMid());
			ps1.setString(5, ub.getAddr());
			ps1.setString(6, ub.getPhone());

			ps2.setString(1, cb.getUname());
			ps2.setString(2, cb.getPass());
			ps2.setInt(3, cb.getId());

			int p = ps1.executeUpdate();
			int q = ps2.executeUpdate();

			if (p > 0 && q > 0) {
				con.commit();
				k = 1;
			} else {
				con.rollback(sp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return k;
	}
}