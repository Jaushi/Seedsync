package application.controller.ProductClass;

public class Fish extends Products{
	private String _type, _source, _size;
	
	
	//getter of type
	
	//setter of type
	
	//getter of source
	
	//setter of source
	
	//getter of size
	
	//setter of size
	
	
	
	
	
	
	public Fish(String type, 
			    String source, 
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
		this._type = type;
		this._source = source;
		this._size = size;
	}
	
	public String[] getProduct() {
		String[] productDetails = {_pictureURL, 
								   _name, 
								   _location, 
								   String.valueOf(_weight), 
								   String.valueOf(_price), 
								   this._type, 
								   this._source, 
								   this._size
								   };
		
		return productDetails;
	}
}
