package model.processor;

public class EnvyProcessor extends Processor{
	private String model;
	public EnvyProcessor(String model) {
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
