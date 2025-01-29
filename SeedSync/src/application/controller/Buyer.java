package application.controller;

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
	 
	
}


