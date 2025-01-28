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
	
	//changeToProfile
}