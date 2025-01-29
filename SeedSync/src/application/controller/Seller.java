package application.controller;

public class Seller extends Users{
	
	Seller(){}
	
	Seller(String _userID, String _email, String _userName, String _password, String _accountType, String _firstName, String _lastName, String _birthdate, int _age, String _phoneNumber, String _region, String _province, String _city, String _address){
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
//
//    public void recordSale(Product product) {
//        soldItems.add(product);
//        calculateIncome(product);
//    }
//
//    public void recordSales(List<Product> products) {
//        soldItems.addAll(products);
//        for (Product product : products) {
//            calculateIncome(product);
//        }
//    }
//
//    private void calculateIncome(Product product) {
//        totalIncome += product.getPrice();
//    }
//
//    public double getTotalIncome() {
//        return totalIncome;
//    }
//
//    public int getTotalItemsSold() {
//        return soldItems.size();
//    }
//
//    public List<Product> getSoldItems() {
//        return new ArrayList<>(soldItems);
//    }
//
//    public void resetIncome() {
//        soldItems.clear();
//        totalIncome = 0.0;
//    }
}