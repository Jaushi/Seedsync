package application.controller;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class UniversalController extends DatabaseQueries{
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public String userTypeAccount;
	public Seller userSeller;
	public Buyer userBuyer;
	public List<Products> items;
	
	public String[] size = {"small", "medium", "large"};
	public String[] quality = {"high", "medium", "low"};
	public String[] productType = {"Livestock", "Rice", "Fruit", "Vegetable", "Fish"};
	public String[] productOrderStatus = {"To pay", "Shipping", "Delivered"};
	public String[] productStatus = {"available", "out of stock"};
	public String[] livestockType = {"cow", "chicken", "pig", "goat"};
	public String[] livestockFeedDiet = {"grain-fed", "grass-fed"};
	public String[] riceTexture = {"soft", "medium", "hard"};
	public String[] riceColor = {"white", "brown", "red"};
	public String[] fruitFlavor = {"sweet", "sour"};
	public String[] fishType = {"freshwater", "saltwater"};
	public String[] fishSource = {"farm-raised", "wild-caught"};
	public String[] regions = {"Region I", "Region II", "Region III", "Region IV", "MIMAROPA", "Region V", "Region VI", "Region VII", "Region VIII", "Region IX", "Region X", "Region XI", "Region XII", "Region XIII", "NIR", "NCR", "CAR", "BARMM"};
	
	public void setUserSeller(Seller userSeller) {
		this.userSeller = userSeller;
	}
	
	public void setUserBuyer(Buyer userBuyer) {
		this.userBuyer = userBuyer;
	}
	
	public void setProduct(List<Products> items) {
		this.items = items;
	}
	
	//Scene Controller
	public void changeToRegistration(ActionEvent event) throws Exception{

		root = FXMLLoader.load(getClass().getResource("/application/fxml/Registration.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/application/Application.css").toExternalForm());
		
		stage.setScene(scene);
	}
	
	public void changeToLogin(ActionEvent event) throws Exception{

		root = FXMLLoader.load(getClass().getResource("/application/fxml/Login.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/application/Application.css").toExternalForm());
		
		stage.setScene(scene);
	}
	
	public void changeToEditProfile(ActionEvent event) throws Exception{

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/fxml/EditProfile.fxml"));
		root = loader.load();

		EditProfileController controller = loader.getController();
		
		controller.setUserBuyer(userBuyer);
		
		controller.setAccount();
		controller.setStartupProfile();
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/application/Application.css").toExternalForm());
		
		stage.setScene(scene);
	}
	
	public void changeToEditProfile(MouseEvent event) throws Exception{

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/fxml/EditProfile.fxml"));
		root = loader.load();
		
		EditProfileController controller = loader.getController();
		
		controller.setUserBuyer(userBuyer);
		
		controller.setAccount();
		controller.setStartupProfile();
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/application/Application.css").toExternalForm());
		
		stage.setScene(scene);
	}
	
	//changeToProfile
	public void changeToProfile(MouseEvent event) throws Exception{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/fxml/UserProfile.fxml"));
		root = loader.load();
		scene = new Scene(root);
		
		UserProfileController controller = loader.getController();
		
		controller.setUserBuyer(userBuyer);
		
		controller.setAccount();

		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene.getStylesheets().add(getClass().getResource("/application/Application.css").toExternalForm());
		stage.setScene(scene);
	}
	
	public void changeToUserShopList(MouseEvent event) throws Exception{
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/fxml/UserShopList.fxml"));
		root = loader.load();
		scene = new Scene(root);
		
		UserShopListController controller = loader.getController();
		
		controller.setUserBuyer(userBuyer);
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene.getStylesheets().add(getClass().getResource("/application/Application.css").toExternalForm());
		stage.setScene(scene);
	}
	
	public void changeToShoppingCart(MouseEvent event) throws Exception{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/fxml/UserShoppingCart.fxml"));
		root = loader.load();
		scene = new Scene(root);
		
		UserShoppingCartController controller = loader.getController();
		
		controller.setUserBuyer(userBuyer);

		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene.getStylesheets().add(getClass().getResource("/application/Application.css").toExternalForm());
		stage.setScene(scene);
	}
	
	public void changeToUserCheckoutDetails(MouseEvent event) throws Exception{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/fxml/UserCheckoutDetails.fxml"));
		root = loader.load();
		scene = new Scene(root);
		
		UserCheckoutDetailsController controller = loader.getController();
		
		controller.setUserBuyer(userBuyer);	

		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene.getStylesheets().add(getClass().getResource("/application/Application.css").toExternalForm());
		stage.setScene(scene);
	}
	
	public void changeToSellerFrame(ActionEvent event) throws Exception{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/fxml/SellerFrame.fxml"));
		root = loader.load();
		scene = new Scene(root);
		
		SellerFrameController controller = loader.getController();
		
		controller.setUserSeller(userSeller);
		
		controller.setAccount();
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene.getStylesheets().add(getClass().getResource("/application/Application.css").toExternalForm());
		stage.setScene(scene);
	}
	
	
	
	
	
	
	
	
	
	
	
	


	

	
}