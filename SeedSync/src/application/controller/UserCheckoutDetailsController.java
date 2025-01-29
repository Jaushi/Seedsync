package application.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserCheckoutDetailsController extends UniversalController implements Initializable {
	
	@FXML
	private BorderPane mainPane; 
	
    @FXML
    private HBox headerContainer;  // The container to load the header
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("UserHeader");
		mainPane.setTop(view);		
	}
}