package model.processor;

public class OmenProcessor extends Processor{
	private String model;
	public OmenProcessor(String model) {
		super();
		this.model = model;
	}
	@Override
	public String getModel() {
		return model;
	}
	@Override
	public void setModel(String model) {
		this.model = model;
	}
}
