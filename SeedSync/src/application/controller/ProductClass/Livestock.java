package application.controller.ProductClass;

public class Livestock extends Products{
	private String _type, _feedDiet;
	private int _age;
	
	//getter of type
	
	//setter of type
	
	//getter of feedDiet
	
	//setter of feedDiet
	
	//getter of age
	
	//setter of age
	
	
	
	
	
	
	
	
	
	public Livestock(String type, 
					 String feedDiet, 
					 String pictureURL, 
					 String name, 
					 String location, 
					 int age,
					 float weight, 
					 float price){
		
		_pictureURL = pictureURL;
		_name = name;
		_location = location;
		_weight = weight;
		_price = price;
		this._type = type;
		this._feedDiet = feedDiet;
		this._age = age;
	}
	
	@Override
	public String[] getProduct() {
		String[] productDetails = {_pictureURL, 
								   _name, 
								   _location, 
								   String.valueOf(_weight), 
								   String.valueOf(_price), 
								   String.valueOf(_age),
								   this._type, 
								   this._feedDiet
								   };
		
		return productDetails;
	}

	
	
}
