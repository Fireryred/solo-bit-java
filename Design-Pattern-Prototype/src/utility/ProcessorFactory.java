package utility;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.ViewProduct;
import model.laptop.HPLaptop;
import model.processor.*;

public class ProcessorFactory implements AbstractFactory{
	@Override
	public Processor getProcessor(String name) {
		ViewProduct prototype = (ViewProduct) PrototypeFactory.getPrototype("ViewProduct");
		ResultSet record = prototype.getRecords(DBUtility.SELECTPRODUCT, name);
		Processor processor = null;
		try {
			if (record.next()) {
				if (name.contains("CHROMEBOOK")) {
					processor = new ChromebookProcessor(record.getString("processor"));
				} else if (name.contains("ELITE")) {
					processor = new EliteDragonflyProcessor(record.getString("processor"));
				} else if (name.contains("ENVY")) {
					processor = new EnvyProcessor(record.getString("processor"));
				} else if (name.contains("OMEN")) {
					processor = new EnvyProcessor(record.getString("processor"));
				} else if (name.contains("SPECTRE")) {
					processor = new EnvyProcessor(record.getString("processor"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return processor;
	}
	@Override
	public HPLaptop getLaptop(String input) {
		return null;
	}
}
