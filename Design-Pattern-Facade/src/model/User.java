package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.database.CreateTable;
import model.database.InsertTable;
import model.database.ViewTable;
import utility.DBUtility;
import utility.PrototypeFactory;

public class User implements Facade{
	private String username, password, email, confirmPassword;
	private String isUserValid, isPassValid, isConPassValid, isEmailValid;
	private String website;
	
	public User(String username, String password, String email, String confirmPassword) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.confirmPassword = confirmPassword;
	}

	public User(String username, String password) {
		super();
		confirmPassword = "";
		this.username = username;
		this.password = password;
	}

	public String getIsUserValid() {
		return isUserValid;
	}

	public void setIsUserValid(String isUserValid) {
		this.isUserValid = isUserValid;
	}

	public String getIsPassValid() {
		return isPassValid;
	}

	public void setIsPassValid(String isPassValid) {
		this.isPassValid = isPassValid;
	}

	public String getIsConPassValid() {
		return isConPassValid;
	}

	public void setIsConPassValid(String isConPassValid) {
		this.isConPassValid = isConPassValid;
	}

	public String getIsEmailValid() {
		return isEmailValid;
	}

	public void setIsEmailValid(String isEmailValid) {
		this.isEmailValid = isEmailValid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public boolean validateUsername(String username) {
		boolean isValid = true;
		
		CreateTable createTable = (CreateTable) PrototypeFactory.getPrototype("CreateTable");
		createTable.createTable(DBUtility.CREATETABLEUSER);
		
		ViewTable viewProduct = (ViewTable) PrototypeFactory.getPrototype("ViewTable");
		ResultSet result = viewProduct.getRecords(DBUtility.SELECTUSERNAME, username);
		
		try {
			if(result.next()) {
				isValid = false;
				isUserValid = "is-invalid";
			}
			result.beforeFirst();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isValid;
	}
	
	public boolean validatePassword(String password, String confirmPassword) {
		boolean isValid = true;
		if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$")) {
			isValid = false;
			isPassValid = "is-invalid";
		}
		if (!password.equals(confirmPassword)) {
			isValid = false;
			isConPassValid = "is-invalid";
		}
		return isValid;
	}
	
	public boolean validateEmail(String email) {
		boolean isValid = true;
		if (!email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")) {
			isValid = false;
			isEmailValid = "is-invalid";
		}
		return isValid;
	}
	
	@Override
	public void process() {
		if (!confirmPassword.isEmpty()) {
			if(validateEmail(email) && validatePassword(password, confirmPassword) && validateUsername(username)) {
				InsertTable insertTable = (InsertTable) PrototypeFactory.getPrototype("InsertTable");
				insertTable.insertRecord(DBUtility.INSERTUSER, username, password, email);
				website = "index.jsp";
			} else {
				website = "register.jsp";
			}
		} else {
			ViewTable viewTable = (ViewTable) PrototypeFactory.getPrototype("ViewTable");
			ResultSet result = viewTable.getRecords(DBUtility.SELECTUSER, username, password);
			website = "login.jsp";
			isUserValid = "is-invalid";
			try {
				if(result.isBeforeFirst()) {
					website = "index.jsp";
					isUserValid = "";
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
