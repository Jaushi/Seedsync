package application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

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
    private TextField birthDateFX;
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
    
    
	public void registerAccount(ActionEvent event) {
		String firstName = firstNameFX.getText();
		String lastName = lastNameFX.getText();
		String emailAccount = emailAccountFX.getText();
		String usernameAccount = usernameAccountFX.getText();
		String birthDate = birthDateFX.getText();
		String phoneNumber = phoneNumberFX.getText();
		
		String cityAddress = cityAddressFX.getText();
		String fullAddress = fullAddressFX.getText();
		String passwordAccount = passwordAccountFX.getText();
		String passwordVerificationAccount = passwordVerificationAccountFX.getText();
		
		boolean isVerified = true;
		
		if(firstName.isEmpty()) {
			firstNameFX.setStyle("-fx-border-color: red;");
			isVerified = false;
		}
		
		if(lastName.isEmpty()) {
			lastNameFX.setStyle("-fx-border-color: red;");
			isVerified = false;
		}
		
		if(!emailAccount.contains("@") && !emailAccount.contains(".")) {
			emailAccountFX.setStyle("-fx-border-color: red;");
			isVerified = false;
		}
		
		if(usernameAccount.isEmpty()) {
			usernameAccountFX.setStyle("-fx-border-color: red;");
		}
		
		if(isVerified) {
			firstNameFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
			lastNameFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
			emailAccountFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
			usernameAccountFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
		}
	}
}
