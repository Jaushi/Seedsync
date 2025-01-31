package application.controller;

public class Rice extends Products{
	private String _quality, _texture, _color;
	
	//getter of quality
	public String getQuality() {
		return _quality;
	}
	//setter of quality
	public void setQuality(String quality) {
		this._quality = quality;
	}
	//getter of color
	public String getColor() {
		return _color;
	}
	//setter of color
	public void setColor(String color) {
		this._color = color;
	}
	//getter of texture
	public String getTexture() {
		return _texture;
	}
	//setter of texture
	public void setTexture(String texture) {
		this._texture = texture;
	}
	
	public Rice(String productID, String productURL, String name, String description, Float price, Float shippingFee, String dateHarvested, String consumeBefore, int stock, Float weight, String deliveryDate, String location, String category, String status, String userID) {
		setAllProducts(productID, productURL, name, description, price, shippingFee, dateHarvested, consumeBefore, stock, weight, deliveryDate, location, category, status, userID);
	}
}
