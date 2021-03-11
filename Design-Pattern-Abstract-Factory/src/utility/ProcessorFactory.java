package utility;

import model.laptop.HPLaptop;
import model.processor.*;

public class ProcessorFactory implements AbstractFactory{
	@Override
	public Processor getProcessor(String name) {
		Processor processor = null;
		if (name.equalsIgnoreCase("Chromebook")) {
			processor = new ChromebookProcessor("Intel Celeron");
		} else if (name.equalsIgnoreCase("Elite")) {
			processor = new EliteDragonflyProcessor("Intel i7");
		} else if (name.equalsIgnoreCase("Envy")) {
			processor = new EnvyProcessor("Intel i5");
		} else if (name.equalsIgnoreCase("Omen")) {
			processor = new EnvyProcessor("Intel i7");
		} else if (name.equalsIgnoreCase("Spectre")) {
			processor = new EnvyProcessor("Intel i7");
		}
		return processor;
	}
	@Override
	public HPLaptop getLaptop(String input) {
		return null;
	}
}
