package com.hunqin.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class insertJDBC {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getconn();
			String sql = "insert into longin values(null,'XXX','422977930')";
			stat = conn.prepareStatement(sql);
			stat.executeUpdate();
			System.out.println("导入信息成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
