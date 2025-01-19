package application.controller.ProductClass;

public class Fruit extends Products{
	private String _quality, _flavour, _size;
	
	Fruit(String quality, String flavour, String size){
		this._quality = quality;
		this._flavour = flavour;
		this._size = size;
	}
}
