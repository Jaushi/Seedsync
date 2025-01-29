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
    
    //setters of all attributes

	
	
	
	
	
	
	
	
	
	
	
	
	
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