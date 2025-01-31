package application.controller;

abstract class Products extends Seller{
	protected String _productID, _productURL, _name, _description, _dateHarvested, _consumeBefore, _deliveryDate, _location, _category, _status;
	protected float  _price, _shippingFee, _weight;
	protected int _stock;

	//setter of productID
	public void setProductID(String productID) {
		this._productID = productID;
	}
	//getter of productURL
	public String getProductURL() {
		return _productURL;
	}
	//setter of productURL
	public void setProductURL(String pictureURL) {
		this._productURL = pictureURL;
	}
	//getter of name
	public String getName() {
		return _name;
	}
	//setter of name
	public void setName(String name) {
		this._name = name;
	}
	//getter of description
	public String getDescription() {
		return _description;
	}
	//setter of description
	public void setDescription(String description) {
		this._description = description;
	}
	//getter of dateHarvested
	public String getDateHarvested() {
		return _dateHarvested;
	}
	//setter of dateHarvested
	public void setDateHarvested(String dateHarvested) {
		this._dateHarvested = dateHarvested;
	}
	//getter of consumeBefore
	public String getConsumeBefore() {
		return _consumeBefore;
	}
	//setter of consumeBefore
	public void setConsumeBefore(String consumeBefore) {
		this._consumeBefore = consumeBefore;
	}
	//getter of deliveryDate
	public String getDeliveryDate() {
		return _deliveryDate;
	}
	//setter of deliveryDate
	public void setDeliveryDate(String deliveryDate) {
		this._deliveryDate = deliveryDate;
	}
	//getter of location
	public String getLocation() {
		return _location;
	}
	//setter of location
	public void setLocation(String location) {
		this._location = location;
	}
	//getter of category
	public String getCategory() {
		return _category;
	}
	//setter of category
	public void setCategory(String category) {
		this._category = category;
	}
	//getter of status
	public String getStatus() {
		return _status;
	}
	//setter of status
	public void setStatus(String status) {
		this._status = status;
	}
	//getter of userID
	public String getUserID() {
		return userID;
	}
	//setter of userID
	public void setUserID(String _userID) {
		this.userID = _userID;
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
	//getter of shippingFee
	public float getShippingFee() {
		return _shippingFee;
	}
	//setter of shippingFee
	public void setShippingFee(float shippingFee) {
		this._shippingFee = shippingFee;
	}
	//getter of stock
	public int getStock() {
		return _stock;
	}
	//setter of stock
	public void setStock(int stock) {
		this._stock = stock;
	}
	
	public void setAllProducts(String productID, String productURL, String name, String description, Float price, Float shippingFee, String dateHarvested, String consumeBefore, int stock, Float weight, String deliveryDate, String location, String category, String status, String userID) {
		setProductID(productID);
		setProductURL(productURL);
		setName(name);
		setDescription(description);
		setPrice(price);
		setShippingFee(shippingFee);
		setDateHarvested(dateHarvested);
		setConsumeBefore(consumeBefore);
		setStock(stock);
		setWeight(weight);
		setDeliveryDate(deliveryDate);
		setLocation(location);
		setCategory(category);
		setStatus(status);
		setUserID(userID);
	}
	
}


