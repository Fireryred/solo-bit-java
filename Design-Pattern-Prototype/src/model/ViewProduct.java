package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ViewProduct implements DBConnection{
	@Override
	public ViewProduct clone() {
		return new ViewProduct();
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
	public ResultSet getRecords(String sql) {
		ResultSet record = null;
		Connection con = getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.execute();
			record = pstmt.getResultSet();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return record;
	}
	public ResultSet getRecords(String sql, String name) {
		name = "%" + name + "%";
		ResultSet record = null;
		Connection con = getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.execute();
			record = pstmt.getResultSet();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return record;
	}
}
