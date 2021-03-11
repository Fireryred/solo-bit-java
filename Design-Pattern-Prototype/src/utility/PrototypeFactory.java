package utility;

import java.util.HashMap;
import java.util.Map;

import model.*;

public class PrototypeFactory {
	private static final Map<String, DBConnection> prototype = new HashMap<String, DBConnection>();
	
	static {
		prototype.put("InsertProduct", new InsertProduct());
		prototype.put("CreateTable", new CreateTable());
		prototype.put("ViewProduct", new ViewProduct());
	}
	public static DBConnection getPrototype(String type) {
		DBConnection connection = null;
		try {
			connection = prototype.get(type).clone();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return  connection;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
	}
}
