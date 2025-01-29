package application.controller.ProductClass;

public class Fish extends Products{
	private String _type, _source, _size;
	
	
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
	//getter of size
	public String getSize() {
		return _size;
	}
	//setter of size
	public void setSize(String size) {
		this._size = size;
	}
	
	
	
	
	
	
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
