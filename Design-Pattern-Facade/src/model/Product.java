package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.database.CreateTable;
import model.database.InsertTable;
import model.database.ViewTable;
import utility.DBUtility;
import utility.PrototypeFactory;

public class Product implements Facade{
	String name, username, hasOrdered;
	boolean hasOrder;
	int qty, userId, orderId, productId;
	
	public Product(String name, int qty, String username) {
		super();
		this.name = name;
		this.qty = qty;
		this.username = username;
	}
	public Product(String name, String username) {
		super();
		this.name = name;
		this.username = username;
	}
	public Product(String username) {
		super();
		this.username = username;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getQty() {
		return qty;
	}
	
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public String getHasOrdered() {
		return hasOrdered;
	}

	public void setHasOrdered(String hasOrdered) {
		this.hasOrdered = hasOrdered;
	}
	
	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public void createTable() {
		CreateTable createTable = (CreateTable) PrototypeFactory.getPrototype("CreateTable");
		createTable.createTable(DBUtility.CREATETABLEORDER);
		createTable.createTable(DBUtility.CREATETABLEORDERDETAILS);
	}
	public void getUserId() {
		ViewTable viewTable = (ViewTable) PrototypeFactory.getPrototype("ViewTable");
		ResultSet record = viewTable.getRecords(DBUtility.SELECTUSERNAME, username);
		
		try {
			if(record.next()) {
				userId = record.getInt("id");
			}
			record.beforeFirst();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void getOrderNumber() {
		ViewTable viewTable = (ViewTable) PrototypeFactory.getPrototype("ViewTable");
		ResultSet record = viewTable.getRecords(DBUtility.SELECTORDERNUMBER, userId);
		
		try {
			if(record.next()) {
				orderId = record.getInt("id");
				hasOrder = record.getBoolean("has_ordered");
			}
			record.beforeFirst();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void getProductId() {
		ViewTable viewTable = (ViewTable) PrototypeFactory.getPrototype("ViewTable");
		ResultSet record = viewTable.getRecords(DBUtility.SELECTPRODUCT, name);
		
		try {
			if(record.next()) {
				productId = record.getInt("id");
			}
			record.beforeFirst();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void getOrderDetails() {
		ViewTable viewTable = (ViewTable) PrototypeFactory.getPrototype("ViewTable");
		ResultSet record = viewTable.getRecords(DBUtility.SELECTORDERDETAILS, productId, orderId);
		
		try {
			if (record.next()) {
				hasOrdered = "disabled";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void process() {
		createTable();
		if (name == null) {
			getUserId();
			getOrderNumber();
		} else if (qty == 0) {
			getUserId();
			getOrderNumber();
			if (!hasOrder) {
				getProductId();
				getOrderDetails();
			}
		} else {
			InsertTable insertTable = (InsertTable) PrototypeFactory.getPrototype("InsertTable");
			hasOrder = true;
			
			getUserId();
			getOrderNumber();
			if (hasOrder) {
				insertTable.insertRecord(DBUtility.INSERTORDER, userId);
			}
			
			getProductId();
			insertTable.insertRecord(DBUtility.INSERTORDERDETAILS, qty, orderId, productId);
		}
	}
}
