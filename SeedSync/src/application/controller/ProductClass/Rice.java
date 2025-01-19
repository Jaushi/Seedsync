package application.controller.ProductClass;

public class Rice extends Products{
	private String _quality, _color;
	private float _texture;
	
	Rice(String quality, String color, float texture){
		this._quality = quality;
		this._color = color;
		this._texture = texture;
	}
}
