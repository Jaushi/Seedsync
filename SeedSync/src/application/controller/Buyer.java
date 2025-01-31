package application.controller;

import java.util.ArrayList;
import java.util.List;

public class Buyer extends Users{
	
	Buyer(){}
	Buyer(String _userID, String _email, String _userName, String _password, String _accountType, String _firstName, String _lastName, String _birthdate, int _age, String _phoneNumber, String _region, String _province, String _city, String _address){
		this.userID = _userID;
		this.email = _email;
        this.username = _userName;
        this.password = _password;
        this.accountType = _accountType;	
        this.firstName = _firstName;
		this.lastName = _lastName;
		this.birthdate = _birthdate;
		this.phoneNumber = _phoneNumber;
		this.age = _age;
		this.region = _region;
		this.province = _province;
		this.city = _city;
		this.address = _address;
	}
	
//	private List<Product> items = new ArrayList<>();
//	private static final double BASE_DELIVERY_FEE = 50.0;
//
//	public void addItem(String name, float price) {
//		items.add(new Product(name, price));
//	}
//
//	public double computeSubtotal() {
//		double subtotal = 0;
//		for (Product item : items) {
//			subtotal += item.getPrice();
//		}
//		return subtotal;
//	}
//
//	public double computeDeliveryFee() {
//        return BASE_DELIVERY_FEE;
//	}
//
//    public double computeTotal() {
//    double subtotal = computeSubtotal();
//    double deliveryFee = computeDeliveryFee();
//    double total = subtotal + deliveryFee;
//    return total;
//    }
	
}

