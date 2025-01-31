package application.controller;

public class Fruit extends Products{
	private String _quality, _flavor, _size;
	
	//getter of quality
	public String getQuality() {
		return _quality;
	}
	
	//setter of quality
	public void setQuality(String quality) {
		this._quality = quality;
	}
	
	//getter of flavor
	public String getFlavor() {
		return _flavor;
	}
	//setter of flavor
	public void setFlavor(String flavor) {
		this._flavor = flavor;
	}
	//getter of size
	public String getSize() {
		return _size;
	}
	
	//setter of size
	public void setSize(String size) {
		this._size = size;
	}
	
	public Fruit(String productID, String productURL, String name, String description, Float price, Float shippingFee, String dateHarvested, String consumeBefore, int stock, Float weight, String deliveryDate, String location, String category, String status, String userID) {
		setAllProducts(productID, productURL, name, description, price, shippingFee, dateHarvested, consumeBefore, stock, weight, deliveryDate, location, category, status, userID);
	}
}
