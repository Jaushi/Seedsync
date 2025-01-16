package application.controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistrationController implements Initializable {
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
    private ChoiceBox<String> regionAddressFX;
    @FXML
    private ChoiceBox<String> provinceAddressFX;
    @FXML
    private TextField cityAddressFX;
    @FXML
    private TextField fullAddressFX;
    @FXML
    private PasswordField passwordAccountFX;
    @FXML
    private PasswordField passwordVerificationAccountFX;
    
    private String[] regions = {"Region I", "Region II", "Region III", "Region IV", "MIMAROPA", "Region V", "Region VI", "Region VII", "Region VIII", "Region IX", "Region X", "Region XI", "Region XII", "Region XIII", "NIR", "NCR", "CAR", "BARMM"};
    
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		regionAddressFX.getItems().addAll(regions);
		
	}
    
    public void getCorrespondingProvince(ActionEvent event) {
    	String regionAddress = regionAddressFX.getValue();
    	
    	String[] provinces;
    	
    	switch(regionAddress) {
	   		case "Region I":
	   			provinces = new String[] {"Ilocos Norte", "Ilocos Sur", "La Union", "Pangasinan"};
	   			break;
	    	case "Region II":
	    		provinces = new String[] {"Batanes", "Cagayan", "Isabela", "Nueva Vizcaya", "Quirino"};
	   			break;
	    	case "Region III":
	    		provinces = new String[] {"Aurora", "Bataan", "Bulacan", "Nueva Ecija", "Pampanga", "Tarlac", "Zambales"};
	    		break;
	   		case "Region IV":
	   			provinces = new String[] {"Batangas", "Cavite", "Laguna", "Quezon", "Rizal"};
	   			break;
	   		case "MIMAROPA":
	    		provinces = new String[] {"Marinduque", "Occidental Mindoro", "Oriental Mindoro", "Palawan", "Romblon"};
	    		break;
	    	case "Region V":
	   			provinces = new String[] {"Albay", "Camarines Norte", "Camarines Sur", "Catanduanes", "Masbate", "Sorsogon"};
	   			break;
	   		case "Region VI":
	   			provinces = new String[] {"Aklan", "Antique", "Capiz", "Guimaras", "Iloilo"};
    			break;
	    	case "Region VII":
	    		provinces = new String[] {"Bohol", "Cebu"};
	   			break;
	   		case "Region VIII":
	   			provinces = new String[] {"Biliran", "Eastern Samar", "Leyte", "Northern Samar", "Samar", "Southern Leyte"};
	   			break;
    		case "Region IX":
	    		provinces = new String[] {"Zamboana del Norte", "Zamboanga del Sur", "Zamboanga Sibugay"};
	    		break;
	    	case "Region X":
	   			provinces = new String[] {"Bukidnon", "Camiguin", "Lanao del Norte", "Misamis Occidental", "Misamis Oriental"};
	   			break;
	   		case "Region XI":
	   			provinces = new String[] {"Davao de Oro", "Davao del Norte", "Davao del Sur", "Davao Occidental", "Davao Oriental"};
    			break;
	    	case "Region XII":
	    		provinces = new String[] {"Cotabato", "Sarangani", "South Cotabato", "Sultan Kudarat"};
	   			break;
	   		case "Region XIII":
	   			provinces = new String[] {"Agusan del Norte", "Agusan del Sur", "Dinagat Islands", "Surigao del Norte", "Surigao del Sur"};
	   			break;
    		case "NIR":
	    		provinces = new String[] {"Negros Occidental", "Negros Oriental", "Siquijor"};
	    		break;
	    	case "NCR":
	   			provinces = new String[] {"Metro Manila"};
	   			break;
	   		case "CAR":
	   			provinces = new String[] {"Abra", "Apayao", "Benguet", "Ifugao", "Kalinga", "Mountain Province"};
    			break;
	    	case "BARMM":
	    		provinces = new String[] {"Sulu", "Basilan", "Lanao del Sur", "Maguindanao del Norte", "Maguindanao del Sur", "Tawi-Tawi"};
	   			break;
	   		default:
	   			provinces = new String[] {"Region must be filled"};
	   			break;
	    }
    	
    	provinceAddressFX.getItems().clear();
    	provinceAddressFX.getItems().addAll(provinces);
    	
    }
    
    public int getAge(LocalDate birthDate) {
    	int age;
    	LocalDate currentDate = LocalDate.now();
    	
    	Period period = Period.between(birthDate, currentDate);
    	age = period.getYears();
    	
    	return age;
    }
    
   public void displayAge(ActionEvent event) {
	   LocalDate birthDate = birthDateFX.getValue();
	   
	   if(birthDate == null) {
		   calculatedAge.setText("0");
		   return;
	   }
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
		String regionAddress = regionAddressFX.getValue();
		String provinceAddress = provinceAddressFX.getValue();
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
		
		if(phoneNumber.isEmpty() || !phoneNumber.startsWith("09") || phoneNumber.length() != 11) {
			phoneNumberFX.setStyle("-fx-border-color: red;");
			isVerified = false;
		}else {
			phoneNumberFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
		}
		
		if(regionAddress == null) {
			regionAddressFX.setStyle("-fx-border-color: red;");
			isVerified = false;
		}else {
			regionAddressFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
		}
		
		if(provinceAddress == null) {
			provinceAddressFX.setStyle("-fx-border-color: red;");
			isVerified = false;
		}else {
			provinceAddressFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
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
		
		if(passwordVerificationAccount.isEmpty() || !passwordAccount.equals(passwordVerificationAccount)) {
			passwordAccountFX.setStyle("-fx-border-color: red;");
			passwordVerificationAccountFX.setStyle("-fx-border-color: red;");
			isVerified = false;
		}else {
			passwordVerificationAccountFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
		}
		
		if(isVerified) {
			System.out.println(regionAddress + provinceAddress);
		}
	}

	
}
