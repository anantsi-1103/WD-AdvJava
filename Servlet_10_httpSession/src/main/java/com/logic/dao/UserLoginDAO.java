package com.logic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.logic.bean.CustomerBean;
import com.logic.bean.UserBean;
import com.logic.connection.DBConnection;

public class UserLoginDAO {

	public static final String SELECTQUERY = "select * from customer where uname = ? and pass = ?";
	public static final String getUserQuery = "select * from userdetail where id = ?";

	public CustomerBean verifyUser(CustomerBean cb) {
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(SELECTQUERY);

			ps.setString(1, cb.getUname());
			ps.setString(2, cb.getPass());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				cb.setId(rs.getInt("id"));
			} else {
				cb = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cb;
	}

	public UserBean getData(CustomerBean cb) {
		UserBean ub = null;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(getUserQuery);

			ps.setInt(1, cb.getId());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				ub = new UserBean();

				ub.setId(rs.getInt("id"));
				ub.setFname(rs.getString("fname"));
				ub.setLname(rs.getString("lname"));
				ub.setMid(rs.getString("mid"));
				ub.setAddr(rs.getString("addr"));
				ub.setPhone(rs.getString("phone"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ub;
	}
}
