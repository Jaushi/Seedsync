package application.controller;

public class Fish extends Products{
	private String _type, _source;
	
	
	//getter of type
	public String getType() {
		return _type;
	}

	//setter of type
	public void setType(String type) {
		this._type = type;
	}
	
	//getter of source
	public String getSource() {
		return _source;
	}
	
	//setter of source
	public void setSource(String source) {
		this._source = source;
	}
	
	public Fish(String productID, String productURL, String name, String description, Float price, Float shippingFee, String dateHarvested, String consumeBefore, int stock, Float weight, String deliveryDate, String location, String category, String status, String userID) {
		setAllProducts(productID, productURL, name, description, price, shippingFee, dateHarvested, consumeBefore, stock, weight, deliveryDate, location, category, status, userID);
	}
	

}
