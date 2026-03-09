package com.logic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.logic.bean.BookBean;
import com.logic.connection.DBConnection;

public class viewBookDAO {
	private static final String QUERY = "select * from bookdetails";

	public ArrayList<BookBean> getAllBook() {
		ArrayList<BookBean> al = new ArrayList<BookBean>();

		try {
			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement(QUERY);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
//				fresh book bean
				BookBean bb = new BookBean();

				bb.setId(rs.getInt(1));
				bb.setName(rs.getString(2));
				bb.setPrice(rs.getInt(3));
				bb.setAuthor(rs.getString(4));
				
				
				al.add(bb);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}
}
