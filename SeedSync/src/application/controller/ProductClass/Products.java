package application.controller.ProductClass;

abstract class Products {
	protected String _productID, _pictureURL, _name, _location;
	protected float _weight, _price;
	
	public abstract String[] getProduct();
	
	//getter of pictureURL
	public String getPictureURL() {
		return _pictureURL;
	}
	//setter of pictureURL
	public void setPictureURL(String pictureURL) {
		this._pictureURL = pictureURL;
	}
	//getter of name
	public String getName() {
		return _name;
	}
	//setter of name
	public void setName(String name) {
		this._name = name;
	}
	//getter of location
	public String getLocation() {
		return _location;
	}
	//setter of location
	public void setLocation(String location) {
		this._location = location;
	}
	//getter of weight
	public float getWeight() {
		return _weight;
	}
	//setter of weight
	public void setWeight(float weight) {
		this._weight = weight;
	}
	//getter of price
	public float getPrice() {
		return _price;
	}
	//setter of price
	public void setPrice(float price) {
		this._price = price;
	}
	
	
}


