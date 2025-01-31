package application.controller;

public class Livestock extends Products{
	private String _type, _feedDiet;
	
	//getter of type
	public String getType() {
		return _type;
	}
	//setter of type
	public void setType(String type) {
		this._type = type;
	}
	//getter of feedDiet
	public String getFeedDiet() {
		return _feedDiet;
	}
	//setter of feedDiet
	public void setFeedDiet(String feedDiet) {
		this._feedDiet = feedDiet;
	}

	
	
	
	
	
	
	public Livestock(String productID, String productURL, String name, String description, Float price, Float shippingFee, String dateHarvested, String consumeBefore, int stock, Float weight, String deliveryDate, String location, String category, String status, String userID) {
		setAllProducts(productID, productURL, name, description, price, shippingFee, dateHarvested, consumeBefore, stock, weight, deliveryDate, location, category, status, userID);
	}
	
//	@Override
//	public String[] getProduct() {
//		String[] productDetails = {_pictureURL, 
//								   _name, 
//								   _location, 
//								   String.valueOf(_weight), 
//								   String.valueOf(_price), 
//								   String.valueOf(_age),
//								   this._type, 
//								   this._feedDiet
//								   };
//		
//		return productDetails;
//	}

	
	
}
