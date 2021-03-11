package model.processor;

public class SpectreProcessor extends Processor{
	private String model;
	public SpectreProcessor(String model) {
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
