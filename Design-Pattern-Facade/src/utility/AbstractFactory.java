package utility;

import model.laptop.HPLaptop;
import model.processor.Processor;

public interface AbstractFactory {
	HPLaptop getLaptop(String input);
	Processor getProcessor(String name);
}
