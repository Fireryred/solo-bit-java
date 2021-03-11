package utility;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.database.ViewTable;
import model.laptop.*;
import model.processor.Processor;

public class LaptopFactory implements AbstractFactory{
	public HPLaptop getLaptop(String input) {
		ViewTable prototype = (ViewTable) PrototypeFactory.getPrototype("ViewTable");
		ResultSet record = prototype.getRecords(DBUtility.SELECTPRODUCT, input);
		HPLaptop laptop = null;
		try {
			if (record.next()){
				if (input.contains("CHROMEBOOK")) {
					laptop = new Chromebook(record.getString("name"),"Php " + record.getDouble("price"), record.getString("img"));
				} else if (input.contains("ELITE")) {
					laptop = new EliteDragonfly(record.getString("name"),"Php " + record.getDouble("price"), record.getString("img"));
				} else if (input.contains("ENVY")) {
					laptop = new Envy(record.getString("name"),"Php " + record.getDouble("price"), record.getString("img"));
				} else if (input.contains("OMEN")) {
					laptop = new Omen(record.getString("name"),"Php " + record.getDouble("price"), record.getString("img"));
				} else if (input.contains("SPECTRE")) {
					laptop = new Spectre(record.getString("name"),"Php " + record.getDouble("price"), record.getString("img"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return laptop;
	}
	@Override
	public Processor getProcessor(String name) {
		return null;
	}
}
