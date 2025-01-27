package application.controller.UserClass;

public class Buyer extends Users{
	
	//Function for setters of account
	public void setUserAccount(String _email, 
							   String _userName, 
							   String _password, 
							   String _accountType) {
		
		
		
		//setters of details
		this.email = _email;
        this.username = _userName;
        this.password = _password;
        this.accountType = _accountType;
		
	}
	
	public void setUserDetails(String _firstName, 
							   String _lastName, 
							   String _birthdate, 
							   String _phoneNumber,
							   int _age ) {
		
		this.firstName = _firstName;
		this.lastName = _lastName;
		this.birthdate = _birthdate;
		this.phoneNumber = _phoneNumber;
		this.age = _age;
	
		
	}
	 
	
}



