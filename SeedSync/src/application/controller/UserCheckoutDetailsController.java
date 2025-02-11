package application.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserCheckoutDetailsController extends UniversalController implements Initializable {
	
	public void clickedLogo(MouseEvent event) throws Exception {
		changeToProfile(event);
	}
	
	public void clickedProductShop(MouseEvent event) throws Exception{
		changeToUserShopList(event);
	}
	
	public void clickedShoppingCart(MouseEvent event) throws Exception{
		changeToShoppingCart(event);
	}
	
	public void clickedEditProfile(MouseEvent event) throws Exception{
		changeToEditProfile(event);
	}
	
	public void clickedProductOrdered(MouseEvent event) throws Exception{
		changeToUserCheckoutDetails(event);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}