package model.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ViewTable implements DBConnection{
	@Override
	public ViewTable clone() {
		return new ViewTable();
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
		if (sql.contains("LIKE")) {
			name = "%" + name + "%";
		}
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
	public ResultSet getRecords(String sql, int id) {
		ResultSet record = null;
		Connection con = getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.execute();
			record = pstmt.getResultSet();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return record;
	}
	public ResultSet getRecords(String sql, int productId, int orderId) {
		ResultSet record = null;
		Connection con = getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, productId);
			pstmt.setInt(2, orderId);
			pstmt.execute();
			record = pstmt.getResultSet();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return record;
	}
	public ResultSet getRecords(String sql, String username, String password) {
		ResultSet record = null;
		Connection con = getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.execute();
			record = pstmt.getResultSet();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return record;
	}
}
