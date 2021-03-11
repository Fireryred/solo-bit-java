package model.processor;

public class ChromebookProcessor extends Processor{
	private String model;
	public ChromebookProcessor(String model) {
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
