package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class UserProfileController extends UniversalController implements Initializable{
	
	@FXML
    private Label displayEmailFX;
    @FXML
    private Label displayNameFX;
	
	public void setAccount() {
		displayEmailFX.setText(userSeller.getEmail());
		displayNameFX.setText(userSeller.getFullName());
	}
	
	
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
