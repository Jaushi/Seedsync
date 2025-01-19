package application.controller.ProductClass;

public class Fish extends Products{
	private String _type, _source, _size;
	
	Fish(String type, String source, String size){
		this._type = type;
		this._source = source;
		this._size = size;
	}
}
