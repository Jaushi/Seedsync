package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class SellerProductsController implements Initializable {
	@FXML
	private BorderPane mainPane;
	
    @FXML
    private HBox headerContainer;  // The container to load the header
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("SellerHeader");
		Pane navBar = object.getPage("SellerNavigation");
		mainPane.setLeft(navBar);
		mainPane.setTop(view);		
	}
    
    
}
