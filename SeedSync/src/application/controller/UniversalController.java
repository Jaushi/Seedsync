package application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UniversalController extends DatabaseQueries{
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	String userType;
	public Seller userSeller;
	public Buyer userBuyer;
	
	public void setUserSeller(Seller userSeller) {
		this.userSeller = userSeller;
	}
	
	public void setUserBuyer(Buyer userBuyer) {
		this.userBuyer = userBuyer;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//changeToRegistration
	public void changeToRegistration(ActionEvent event) throws Exception{

		root = FXMLLoader.load(getClass().getResource("/application/fxml/Registration.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/application/Application.css").toExternalForm());
		
		stage.setFullScreen(true);
		stage.setScene(scene);
	}
	
	//changeToLogin
	public void changeToLogin(ActionEvent event) throws Exception{

		root = FXMLLoader.load(getClass().getResource("/application/fxml/Login.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/application/Application.css").toExternalForm());
		
		stage.setFullScreen(true);
		stage.setScene(scene);
	}
	
	//changeToEditProfile
	public void changeToEditProfile(ActionEvent event) throws Exception{

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/fxml/EditProfile.fxml"));
		root = loader.load();
		
		EditProfileController controller = loader.getController();
		
		if(userType.equals("Farmer") || userType.equals("Middle Man")) {
			controller.setUserSeller(userSeller);
		}else if(userType.equals("Buyer")) {
			controller.setUserBuyer(userBuyer);
		}
		
		controller.setAccount();
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/application/Application.css").toExternalForm());
		
		stage.setFullScreen(true);
		stage.setScene(scene);
	}
	
	//setProfile
	
}