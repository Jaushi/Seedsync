package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class SellerFrameController extends UniversalController implements Initializable {
	private Parent root;
	
	@FXML
	private BorderPane mainPane;
	@FXML
    private Label displayEmailFX, displayNameFX;
    @FXML
    private ImageView displayProfileFX;
	
	public void clickedDashboard(ActionEvent event) {
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("SellerDashboard");
		
		mainPane.setCenter(view);
	}
	
	public void clickedInventory(ActionEvent event) {
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("SellerInventory");
		
		mainPane.setCenter(view);
	}
	
	public void clickedCustomers(ActionEvent event) {
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("SellerCustomerPage");
		
		mainPane.setCenter(view);
	}
	
	public void clickedAddEditProducts(ActionEvent event) throws Exception{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/fxml/components/SellerAddEditProduct.fxml"));
		root = loader.load();
		
		SellerAddEditProductController controller = loader.getController();
		
		controller.setUserSeller(userSeller);
		
		mainPane.setCenter(root);
	}
	
	public void clickedEditProfile(ActionEvent event) throws Exception{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/fxml/components/SellerEditProfile.fxml"));
		root = loader.load();
		
		SellerEditProfileController controller = loader.getController();
		
		controller.setUserSeller(userSeller);
		controller.setAccount();
		
		mainPane.setCenter(root);
	}
	
	public void setAccount() {
		displayEmailFX.setText(userSeller.getEmail());
		displayNameFX.setText(userSeller.getFullName());
	}

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("SellerDashboard");
		
		mainPane.setCenter(view);
	}
	

	
}
