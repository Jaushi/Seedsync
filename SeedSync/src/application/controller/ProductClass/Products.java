package application.controller.ProductClass;

abstract class Products {
	protected String _pictureURL, _name, _location;
	protected float _weight, _price;
	
	public abstract String[] getProduct();
	
}


