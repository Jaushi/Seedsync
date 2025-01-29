package application.controller;

import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class EditProfileController extends UniversalController implements Initializable{
	
	@FXML
    private TextField emailFieldFX, usernameFieldFX, firstNameFieldFX, lastNameFieldFX, phoneNumberFieldFX, cityFieldFX, addressFieldFX;
    @FXML
    private Label displayNameFX, usernameFX, fullNameFX, emailFX, phoneNumberFX, birthdateFX;
    @FXML
    private DatePicker birthdateFieldFX;
    @FXML
    private ChoiceBox<String> provinceFieldFX, regionFieldFX;
    @FXML
    private BorderPane mainPane; 
    @FXML
    private ImageView userProfileFX;
	
		
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("UserHeader");
		mainPane.setTop(view);		
	}
	
	public void clickedEditPhoto(ActionEvent event) {
		if(userSeller != null) {
			userSeller.setProfile(event);
			setProfileFXML();
		}else if(userBuyer != null) {
			userBuyer.setProfile(event);
		}
	}
	
	public void setProfileFXML() {
		Image profile = new Image(getClass().getResource("/application/assets/images/user_profile_"+ userSeller.username + ".jpg").toExternalForm());
		userProfileFX.setImage(profile);
	}
	
	public void setAccount() {
		String userID = (userSeller != null) ? userSeller.userID:(userBuyer != null) ? userBuyer.userID:null;
		String email = (userSeller != null) ? userSeller.email:(userBuyer != null) ? userBuyer.email:null;
		String username = (userSeller != null) ? userSeller.username:(userBuyer != null) ? userBuyer.username:null;
		String password = (userSeller != null) ? userSeller.password:(userBuyer != null) ? userBuyer.password:null;
		String accountType = (userSeller != null) ? userSeller.accountType:(userBuyer != null) ? userBuyer.accountType :null;
		String firstName = (userSeller != null) ? userSeller.firstName:(userBuyer != null) ? userBuyer.firstName:null;
		String lastName = (userSeller != null) ? userSeller.lastName:(userBuyer != null) ? userBuyer.lastName:null;
		String birthdate = (userSeller != null) ? userSeller.birthdate:(userBuyer != null) ? userBuyer.birthdate:null;
		String age = (userSeller != null) ? String.valueOf(userSeller.age):(userBuyer != null) ? String.valueOf(userBuyer.age):null;
		String phoneNumber = (userSeller != null) ? userSeller.phoneNumber:(userBuyer != null) ? userBuyer.phoneNumber:null;
		String region = (userSeller != null) ? userSeller.region:(userBuyer != null) ? userBuyer.region:null;
		String province = (userSeller != null) ? userSeller.province:(userBuyer != null) ? userBuyer.province:null;
		String city = (userSeller != null) ? userSeller.city:(userBuyer != null) ? userBuyer.city:null;
		String address = (userSeller != null) ? userSeller.address:(userBuyer != null) ? userBuyer.address:null;
		
		//Set values to the field
		LocalDate date = LocalDate.parse(birthdate);
		birthdateFieldFX.setValue(date);
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
	
	
}