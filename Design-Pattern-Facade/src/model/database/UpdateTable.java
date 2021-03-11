package model.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UpdateTable implements DBConnection{
	@Override
	public UpdateTable clone() {
		return new UpdateTable();
	}
	@Override
	public Connection getConnection() {
		Connection con = null;
		try {
			con = ((DataSource) InitialContext.doLookup("java:/comp/env/jdbc/SEG32_DS")).getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public boolean updateTable(String sql, boolean hasOrdered, int id) {
		boolean success = false;
		Connection con = getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setBoolean(1, hasOrdered);
			pstmt.setInt(2, id);
			pstmt.execute();
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}
}
