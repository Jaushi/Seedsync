package application.controller.ProductClass;

public class Livestock extends Products{
	private String _type, _feedDiet;
	private int _age;
	
	Livestock(String type, String feedDiet, int age, String _pictureURL, String _name, String _location, float _weight, float _price){
		this._type = type;
		this._feedDiet = feedDiet;
		this._age = age;
	}

	public String get_type() {
		return _type;
	}

	
	
}
