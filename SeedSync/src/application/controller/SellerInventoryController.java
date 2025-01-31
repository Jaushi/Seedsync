package application.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SellerInventoryController extends UniversalController implements Initializable{
	private Parent root;
	
	@FXML
	private VBox vBoxInventoryContainerFX;
	@FXML
	private Label displayFullnameFX;
	
	public void setInventory() throws Exception{
		
		items = getInventoryDBS(userSeller.getUserID());
		int count = getProductCountUserDBS(userSeller.getUserID());
		
		System.out.println(count);
		for(int i = 0; i < count; i++) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/fxml/components/SellerProductBar.fxml"));
			root = loader.load();
			
			SellerProductBarController controller = loader.getController();
			
			Products individualItem = items.get(i); 
			
			controller.setUserSeller(userSeller);
			controller.setProduct(items);
			controller.displayProduct(individualItem);
			
			vBoxInventoryContainerFX.getChildren().add(root);
		}
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	

}
