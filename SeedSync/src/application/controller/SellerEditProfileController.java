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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class SellerEditProfileController extends UniversalController implements Initializable {
	
	@FXML
    private TextField emailFieldFX, usernameFieldFX, firstNameFieldFX, lastNameFieldFX, phoneNumberFieldFX, cityFieldFX, addressFieldFX, passwordFieldFX, passwordVerificationFieldFX, oldPasswordFieldFX;
    @FXML
    private Label displayNameFX, usernameFX, fullNameFX, emailFX, phoneNumberFX, birthdateFX, calculatedAgeFX, statusTextFX;
    @FXML
    private DatePicker birthdateFieldFX;
    @FXML
    private ChoiceBox<String> provinceFieldFX, regionFieldFX;
    @FXML
    private ImageView userProfileFX;
    @FXML
    private Circle circle;
    
    public void setStartupProfile() {
    	String username = userSeller.getUsername();
		Image img = new Image("/application/assets/images/"+"user_profile_"+username+".jpg",false);
		circle.setFill(new ImagePattern(img));
    }
    
	public void clickedEditPhoto(ActionEvent event) {
			userSeller.setProfile(event);
			setProfileFXML();

	}
	
	public void setProfileFXML() {
		Image profile = new Image(getClass().getResource("/application/assets/images/user_profile_"+ userSeller.getUsername() + ".jpg").toExternalForm());
		userProfileFX.setImage(profile);
	}
    
    public void getCorrespondingProvince(ActionEvent event) {
    	String regionAddress = regionFieldFX.getValue();
    	
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
    	
    	provinceFieldFX.getItems().clear();
    	provinceFieldFX.getItems().addAll(provinces);
    	
    }
    
    public int getAge(LocalDate birthDate) {
    	int age;
    	LocalDate currentDate = LocalDate.now();
    	
    	Period period = Period.between(birthDate, currentDate);
    	age = period.getYears();
    	
    	return age;
    }
    
   public void displayAge(ActionEvent event) {
	   LocalDate birthDate = birthdateFieldFX.getValue();
	   
	   if(birthDate == null) {
		   calculatedAgeFX.setText("0");
		   return;
	   }
	   String strAge = String.valueOf(getAge(birthDate));
	   
	   calculatedAgeFX.setText(strAge);
	   calculatedAgeFX.setStyle("-fx-background-color: D9D9D9;");
   }
	
	public void setAccount() {
		//String userID = userSeller.getUserID();
		//String password = userSeller.getPassword();
		//String accountType = userSeller.getAccountType();
		String email = userSeller.getEmail();
		String username = userSeller.getUsername();
		String firstName = userSeller.getFirstName();
		String lastName = userSeller.getLastName();
		String birthdate = userSeller.getBirthdate();
		String age = String.valueOf(userSeller.getAge());
		String phoneNumber = userSeller.getPhoneNumber();
		String region = userSeller.getRegion();
		String province = userSeller.getProvince();
		String city = userSeller.getCity();
		String address = userSeller.getAddress();
		
		//Set values to the field
		LocalDate date = LocalDate.parse(birthdate);
		birthdateFieldFX.setValue(date);
		calculatedAgeFX.setText(age);
		emailFieldFX.setText(email);
		usernameFieldFX.setText(username);
		firstNameFieldFX.setText(firstName);
		lastNameFieldFX.setText(lastName);
		phoneNumberFieldFX.setText(phoneNumber);
		cityFieldFX.setText(city);
		addressFieldFX.setText(address);
		provinceFieldFX.setValue(province);
		regionFieldFX.setValue(region);
		
		displayNameFX.setText(username);
		fullNameFX.setText(firstName + " " + lastName);
		usernameFX.setText(username);
		emailFX.setText(email);
		phoneNumberFX.setText(phoneNumber);
		birthdateFX.setText(birthdate);
	}
	
	public void clickedCancel(ActionEvent event) {
		
	}
	
	public void clickedSave(ActionEvent event) {
		String firstName = firstNameFieldFX.getText();
		String lastName = lastNameFieldFX.getText();
		String email = emailFieldFX.getText();
		String username= usernameFieldFX.getText();
		LocalDate birthDate = birthdateFieldFX.getValue();
		String phoneNumber = phoneNumberFieldFX.getText();
		String region = regionFieldFX.getValue();
		String province = provinceFieldFX.getValue();
		String city = cityFieldFX.getText();
		String address = addressFieldFX.getText();
		String oldPassword = oldPasswordFieldFX.getText();
		String password = passwordFieldFX.getText();
		String passwordVerification = passwordVerificationFieldFX.getText();
		
		boolean isVerified = true;
		boolean changePassword = true;
		
		if(firstName.isEmpty()) {
			firstNameFieldFX.setStyle("-fx-border-color: red;");
			isVerified = false;
		}else {
			firstNameFieldFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
		}
		
		if(lastName.isEmpty()) {
			lastNameFieldFX.setStyle("-fx-border-color: red;");
			isVerified = false;
		}else {
			lastNameFieldFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
		}
		
		if(birthDate == null || getAge(birthDate) < 18) {
			birthdateFieldFX.setStyle("-fx-border-color: red;");
			isVerified = false;
		}else {
			birthdateFieldFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
		}
		
		if(phoneNumber.isEmpty() || !phoneNumber.startsWith("09") || phoneNumber.length() != 11) {
			phoneNumberFieldFX.setStyle("-fx-border-color: red;");
			isVerified = false;
		}else {
			phoneNumberFieldFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
		}
		
		if(region == null) {
			regionFieldFX.setStyle("-fx-border-color: red;");
			isVerified = false;
		}else {
			regionFieldFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
		}
		
		if(province == null) {
			provinceFieldFX.setStyle("-fx-border-color: red;");
			isVerified = false;
		}else {
			provinceFieldFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
		}
		
		if(city.isEmpty()) {
			cityFieldFX.setStyle("-fx-border-color: red;");
			isVerified = false;
		}else {
			cityFieldFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
		}
		
		if(address.isEmpty()) {
			addressFieldFX.setStyle("-fx-border-color: red;");
			isVerified = false;
		}else {
			addressFieldFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
		}
		
		if (oldPassword.isEmpty()) {
		    if (!password.isEmpty() || !passwordVerification.isEmpty()) {
		        passwordFieldFX.setStyle("-fx-border-color: red;");
		        passwordVerificationFieldFX.setStyle("-fx-border-color: red;");
		        isVerified = false;
		    } else {
		        isVerified = true;
		    }
		} else {
			if(!oldPassword.equals(userSeller.getPassword()) || password.isEmpty() || !password.equals(passwordVerification)) {
				oldPasswordFieldFX.setStyle("-fx-border-color: red;");
				passwordFieldFX.setStyle("-fx-border-color: red;");
				passwordVerificationFieldFX.setStyle("-fx-border-color: red;");
				isVerified = false;
			} else {
				oldPasswordFieldFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
				passwordFieldFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
				passwordVerificationFieldFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
				isVerified = true;
			}
		}
		if(isVerified) {
			statusTextFX.setStyle("-fx-opacity: 1; -fx-text-fill: -fx-dark-primary-color;");
			
			int age = Integer.parseInt(calculatedAgeFX.getText());
			boolean duplicateAccount;
			
			//database processing
			duplicateAccount = checkDuplicatePhoneNumberDBS(phoneNumber);
			
			if (duplicateAccount && phoneNumber != userSeller.getPhoneNumber()) {
				statusTextFX.setStyle("-fx-opacity: 1; -fx-text-fill: red;");
				statusTextFX.setText("Oops! There was an issue. Please verify your input and ensure it’s not a duplicate account.");
				return;
			}else {
				//pass to database
				statusTextFX.setText("You are now registered. Proceed to login.");
			}
		}else {
			statusTextFX.setStyle("-fx-opacity: 1; -fx-text-fill: red;");
			statusTextFX.setText("Oops! There was an issue. Make sure everything is correct.");
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		regionFieldFX.getItems().addAll(regions);
		
	}
}
