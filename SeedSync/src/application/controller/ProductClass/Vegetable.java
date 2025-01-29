package application.controller.ProductClass;

public class Vegetable extends Products{
	private String _quality, _size;
	
	//getter of quality
	public String getQuality() {
		return _quality;
	}
	//setter of quality
	public void setQuality(String quality) {
		this._quality = quality;
	}
	//getter of size
	public String getSize() {
		return _size;
	}
	//setter of size
	public void setSize(String size) {
		this._size = size;
	}
	
	
	
	
	
	
	public Vegetable(String quality, 
				     String size, 
				     String pictureURL, 
				     String name, 
				     String location, 
				     float weight, 
				     float price){
		
		_pictureURL = pictureURL;
		_name = name;
		_location = location;
		_weight = weight;
		_price = price;
		this._quality = quality;
		this._size = size;
	}
	
	@Override
	public String[] getProduct() {
		String[] productDetails = {_pictureURL, 
								   _name, 
								   _location, 
								   String.valueOf(_weight), 
								   String.valueOf(_price), 
								   this._quality, 
								   this._size
								   };
		
		return productDetails;	
	}
}
