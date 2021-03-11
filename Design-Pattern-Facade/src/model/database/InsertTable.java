package model.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class InsertTable implements DBConnection{
	@Override
	public InsertTable clone() {
		return new InsertTable();
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
	public boolean insertRecord(String sql, int id) {
		boolean success = false;
		Connection con = getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.execute();
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}
	public boolean insertRecord(String sql, String name, String img, double price) {
		boolean success = false;
		Connection con = getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, img);
			pstmt.setDouble(3, price);
			pstmt.execute();
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}
	public boolean insertRecord(String sql, int productId, String name) {
		boolean success = false;
		Connection con = getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, productId);
			pstmt.setString(2, name);
			pstmt.execute();
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}
	public boolean insertRecord(String sql, String username, String password, String email) {
		boolean success = false;
		Connection con = getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, email);
			pstmt.execute();
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}
	public boolean insertRecord(String sql, int qty, int productId, int orderId) {
		boolean success = false;
		Connection con = getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qty);
			pstmt.setInt(2, productId);
			pstmt.setInt(3, orderId);
			pstmt.execute();
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}
}
