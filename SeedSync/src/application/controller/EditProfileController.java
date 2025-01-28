package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;



public class EditProfileController implements Initializable{
	
	@FXML
	private BorderPane mainPane;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("UserHeader");
		mainPane.setTop(view);
	}

}
