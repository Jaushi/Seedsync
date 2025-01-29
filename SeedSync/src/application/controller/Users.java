package application.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

abstract class Users {
	protected String userProfile, userID, email, username, password, accountType, firstName, lastName, birthdate, phoneNumber, region, province, city, address;
	protected int age;
	
	private Stage stage;
	
    //getters of all attributes
	public String getUserProfile() {
		return userProfile;
	}
	public String getUserID() {
		return userID;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getAccountType() {
		return accountType;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getBirthdate() {
		return birthdate;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getRegion() {
		return region;
	}
	
	public String getProvince() {
		return province;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getAddress() {
		return address;
	}
	
	public int getAge() {
		return age;
	}
	
	public Stage getStage() {
		return stage;
	}
	
	//setters of all attributes
	public void setUserProfile(String userProfile) {
		this.userProfile = userProfile;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	public void setProfile(ActionEvent event) {
			
		//get the current stage
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			
		//Make object for FileChooser and filter with images
		FileChooser fileChooser = new FileChooser();	
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("images Files", "*.png", "*.jpg"));
			
		//display FileChooser
		File selectedFile = fileChooser.showOpenDialog(stage);
			
		if(selectedFile == null) {
			System.out.println("No file is selected");
		}else {
			//name the file
			String newFileName = generateFormattedNameProfile(selectedFile);
			//set the destination of the file
			Path destination = Paths.get("src/application/assets/images/" + newFileName);
			try {
				//Paste the selectedFile to the destination
				Files.copy(selectedFile.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);
				System.out.println("Image saved successfully!");
			}catch (Exception ex){
				ex.printStackTrace();
			}
			
		}
		
	}
	
	public String generateFormattedNameProfile(File selectedFile) {
		String extension = selectedFile.getName().substring(selectedFile.getName().lastIndexOf("."));
		
		String newFileName = "user_profile_" + username + extension;
		
		return newFileName;	
	}

}