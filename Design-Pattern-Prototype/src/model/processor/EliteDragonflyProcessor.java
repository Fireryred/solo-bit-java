package model.processor;

public class EliteDragonflyProcessor extends Processor{
	private String model;
	public EliteDragonflyProcessor(String model) {
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
