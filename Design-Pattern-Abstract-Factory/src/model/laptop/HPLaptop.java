package model.laptop;

import model.processor.Processor;

public abstract class HPLaptop {
	public abstract String getModel();
	public abstract String getPrice();
	public abstract String getImg();
	public abstract Processor getProcessor();
	public abstract void setModel(String model);
	public abstract void setPrice(String price);
	public abstract void setImg(String img);
	public abstract void setProcessor(Processor processor);
}