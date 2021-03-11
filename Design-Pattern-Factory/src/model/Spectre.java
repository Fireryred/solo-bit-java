package model;

public class Spectre extends HPLaptop{
	private String model, price, img;
	public Spectre(String model, String price, String img) {
		super();
		this.model = model;
		this.price = price;
		this.img = img;
	}
	@Override
	public String getImg() {
		return img;
	}
	@Override
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String getModel() {
		return model;
	}
	@Override
	public void setModel(String model) {
		this.model = model;
	}
	@Override
	public String getPrice() {
		return price;
	}
	@Override
	public void setPrice(String price) {
		this.price = price;
	}
}
