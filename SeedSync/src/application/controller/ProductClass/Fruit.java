package application.controller.ProductClass;

public class Fruit extends Products{
	private String _quality, _flavour, _size;
	
	public Fruit(String quality, 
				 String flavour, 
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
		this._flavour = flavour;
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
								   this._flavour, 
								   this._size
								   };
		
		return productDetails;
	}
}
