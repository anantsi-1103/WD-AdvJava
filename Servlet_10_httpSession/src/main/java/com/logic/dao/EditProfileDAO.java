package com.logic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.logic.bean.UserBean;
import com.logic.connection.DBConnection;

public class EditProfileDAO {
	public static final String UPDATEQUERY = "update userdetail set fname = ? , lname = ? , mid = ? , addr = ? , phone = ?  where id = ? ";

	public boolean UpdateProfile(UserBean ub) {
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(UPDATEQUERY);

			ps.setString(1, ub.getFname());
			ps.setString(2, ub.getLname());
			ps.setString(3, ub.getMid());
			ps.setString(4, ub.getAddr());
			ps.setString(5, ub.getPhone());
			ps.setInt(6, ub.getId());

			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
