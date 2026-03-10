package com.logic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.logic.bean.BookBean;
import com.logic.connection.DBConnection;

public class ViewBookByDAO {
	private static final String QUERY = "select * from bookdetails where id = ?";

	public BookBean getByID(BookBean bb) {

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(QUERY);

			ps.setInt(1, bb.getId());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				bb.setId(rs.getInt(1));
				bb.setName(rs.getString(2));
				bb.setPrice(rs.getInt(3));
				bb.setAuthor(rs.getString(4));
			} else {
				bb = null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return bb;
	}
}
