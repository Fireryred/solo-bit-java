package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CreateTable implements DBConnection{
	@Override
	public CreateTable clone() {
		return new CreateTable();
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
	public boolean createTable(String sql) {
		boolean success = false;
		Connection con = getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.execute();
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}
}
