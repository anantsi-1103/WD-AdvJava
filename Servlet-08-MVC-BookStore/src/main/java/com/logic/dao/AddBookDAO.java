package com.logic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.logic.bean.BookBean;
import com.logic.connection.DBConnection;

public class AddBookDAO {
	private static final String QUERY = "insert into bookdetails values(?,?,?,?)";

	public int saveBook(BookBean bb) {
		int k = 0;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(QUERY);

			ps.setInt(1, bb.getId());
			ps.setString(2, bb.getName());
			ps.setInt(3, bb.getPrice());
			ps.setString(4, bb.getAuthor());

			k = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
