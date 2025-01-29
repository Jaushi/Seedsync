package application.controller.ProductClass;

public class Rice extends Products{
	private String _quality, _color;
	private float _texture;
	
	//getter of quality
	
	//setter of quality
	
	//getter of color
	
	//setter of color
	
	//getter of texture
	
	//setter of texture
	
	
	
	
	
	
	public Rice(String quality, 
				String color, 
				float texture, 
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
		this._color = color;
		this._texture = texture;
	}
	
	@Override
	public String[] getProduct() {
		String[] productDetails = {_pictureURL, 
								   _name, 
								   _location, 
								   String.valueOf(_weight), 
								   String.valueOf(_price), 
								   this._quality, 
								   this._color, 
								   String.valueOf(_texture)
								   };
		
		return productDetails;
	}
}
