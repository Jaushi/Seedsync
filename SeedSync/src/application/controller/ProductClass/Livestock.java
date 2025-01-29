package application.controller.ProductClass;

public class Livestock extends Products{
	private String _type, _feedDiet;
	private int _age;
	
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
	//getter of age
	public int getAge() {
		return _age;
	}
	//setter of age
	public void setAge(int age) {
		this._age = age;
	}
	
	
	
	
	
	
	
	
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
