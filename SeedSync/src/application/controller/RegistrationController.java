package application.controller;

import java.time.LocalDate;
import java.time.Period;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class RegistrationController {
	@FXML
	private TextField firstNameFX;
	@FXML
	private TextField lastNameFX;
    @FXML
    private TextField emailAccountFX;
    @FXML
    private TextField usernameAccountFX;
    @FXML
    private DatePicker birthDateFX;
    @FXML
    private Label calculatedAge;
    @FXML
    private TextField phoneNumberFX;

    @FXML
    private TextField cityAddressFX;
    @FXML
    private TextField fullAddressFX;
    @FXML
    private TextField passwordAccountFX;
    @FXML
    private TextField passwordVerificationAccountFX;
    
    public int getAge(LocalDate birthDate) {
    	int age;
    	LocalDate currentDate = LocalDate.now();
    	
    	Period period = Period.between(birthDate, currentDate);
    	age = period.getYears();
    	
    	return age;
    }
    
   public void displayAge(ActionEvent event) {
	   LocalDate birthDate = birthDateFX.getValue();
	   
	   String strAge = String.valueOf(getAge(birthDate));
	   
	   calculatedAge.setText(strAge);
	   calculatedAge.setStyle("-fx-background-color: D9D9D9;");
   }
    
	public void registerAccount(ActionEvent event) {
		String firstName = firstNameFX.getText();
		String lastName = lastNameFX.getText();
		String emailAccount = emailAccountFX.getText();
		String usernameAccount = usernameAccountFX.getText();
		LocalDate birthDate = birthDateFX.getValue();
		String phoneNumber = phoneNumberFX.getText();
		
		String cityAddress = cityAddressFX.getText();
		String fullAddress = fullAddressFX.getText();
		String passwordAccount = passwordAccountFX.getText();
		String passwordVerificationAccount = passwordVerificationAccountFX.getText();
		
		boolean isVerified = true;
		
		if(firstName.isEmpty()) {
			firstNameFX.setStyle("-fx-border-color: red;");
			isVerified = false;
		}else {
			firstNameFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
		}
		
		if(lastName.isEmpty()) {
			lastNameFX.setStyle("-fx-border-color: red;");
			isVerified = false;
		}else {
			lastNameFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
		}
		
		if(!emailAccount.contains("@") && !emailAccount.contains(".")) {
			emailAccountFX.setStyle("-fx-border-color: red;");
			isVerified = false;
		}else {
			emailAccountFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
		}
		
		if(usernameAccount.isEmpty()) {
			usernameAccountFX.setStyle("-fx-border-color: red;");
			isVerified = false;
		}else {
			usernameAccountFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
		}
		
		if(birthDate == null || getAge(birthDate) < 18) {
			birthDateFX.setStyle("-fx-border-color: red;");
			isVerified = false;
		}else {
			birthDateFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
		}
		
		if(phoneNumber.isEmpty()) {
			phoneNumberFX.setStyle("-fx-border-color: red;");
			isVerified = false;
		}else {
			phoneNumberFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
		}
		
		if(cityAddress.isEmpty()) {
			cityAddressFX.setStyle("-fx-border-color: red;");
			isVerified = false;
		}else {
			cityAddressFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
		}
		
		if(fullAddress.isEmpty()) {
			fullAddressFX.setStyle("-fx-border-color: red;");
			isVerified = false;
		}else {
			fullAddressFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
		}
		
		if(passwordAccount.isEmpty()) {
			passwordAccountFX.setStyle("-fx-border-color: red;");
			isVerified = false;
		}else {
			passwordAccountFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
		}
		
		if(passwordVerificationAccount.isEmpty()) {
			passwordVerificationAccountFX.setStyle("-fx-border-color: red;");
			isVerified = false;
		}else {
			passwordVerificationAccountFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
		}
		
		if(isVerified) {
			System.out.println(birthDate);
		}
	}
}
