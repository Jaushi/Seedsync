package application.controller;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SellerProductsController extends UniversalController implements Initializable {
	@FXML
	private BorderPane mainPane;
    @FXML
    private Button addButtonFX, cancelButtonFX, uploadButtonFX;
    @FXML
    private ChoiceBox<String> fishSizeFX, fishSourceFX, fishTypeFX, fruitFlavorFX, fruitQualityFX, fruitSizeFX, livestockFeedDietFX, livestockTypeFX, riceColorFX, riceQualityFX, riceTextureFX, vegetableQualityFX, vegetableSizeFX, productTypeFX;
    @FXML
    private TextField livestockAgeFX, productWeightFX, productNameFX, productLocationFX, productPriceFX;
    @FXML
    private TextArea productDescriptionFX;
    
    private Stage stage;
    
    File selectedFile;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("SellerHeader");
		mainPane.setTop(view);		
		Pane navBar = object.getPage("SellerNavigation");
		mainPane.setLeft(navBar);
		
		fishSizeFX.getItems().addAll(fishSize);
		fishSourceFX.getItems().addAll(fishSource);
		fishTypeFX.getItems().addAll(fishType);
		fruitFlavorFX.getItems().addAll(fruitFlavor);
		fruitQualityFX.getItems().addAll(fruitQuality);
		fruitSizeFX.getItems().addAll(fruitSize);
		livestockTypeFX.getItems().addAll(livestockType);
		livestockFeedDietFX.getItems().addAll(livestockFeedDiet);
		riceQualityFX.getItems().addAll(riceQuality);
		riceTextureFX.getItems().addAll(riceTexture);
		riceColorFX.getItems().addAll(riceColor);
		vegetableQualityFX.getItems().addAll(vegetableQuality);
		vegetableSizeFX.getItems().addAll(vegetableSize);
		
		productTypeFX.getItems().addAll(productType);
	}
    
//	//name the file
//	String newFileName = generateFormattedNameProduct(selectedFile);
//	//set the destination of the file
//	Path destination = Paths.get("src/application/assets/images/products" + newFileName);
//	try {
//		//Paste the selectedFile to the destination
//		Files.copy(selectedFile.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);
//		System.out.println("Image saved successfully!");
//	}catch (Exception ex){
//		ex.printStackTrace();
//	}
    
//	public String generateFormattedNameProduct(File selectedFile) {
//	String extension = selectedFile.getName().substring(selectedFile.getName().lastIndexOf("."));
//	
//	String newFileName = "user_profile_" + _productID + extension;
//	
//	return newFileName;	
//}

    
    public void getSelectedFile(ActionEvent event) {
		
		//get the current stage
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			
		//Make object for FileChooser and filter with images
		FileChooser fileChooser = new FileChooser();	
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("images Files", "*.png", "*.jpg"));
			
		//display FileChooser
		selectedFile = fileChooser.showOpenDialog(stage);
		if(selectedFile == null) {
			System.out.println("No file is selected");
		}
	}
    
    public void enableProduct(ActionEvent event) {
    	System.out.println("Test");
    	livestockTypeFX.setDisable(true);
		livestockFeedDietFX.setDisable(true);
		livestockAgeFX.setDisable(true);
		riceQualityFX.setDisable(true);
		riceTextureFX.setDisable(true);
		riceColorFX.setDisable(true);
		fruitQualityFX.setDisable(true);
		fruitFlavorFX.setDisable(true);
		fruitSizeFX.setDisable(true);
		vegetableQualityFX.setDisable(true);
		vegetableSizeFX.setDisable(true);
		fishTypeFX.setDisable(true);
		fishSourceFX.setDisable(true);
		fishSizeFX.setDisable(true);

		livestockTypeFX.setValue(null);
		livestockFeedDietFX.setValue(null);
		livestockAgeFX.setText("");
		riceQualityFX.setValue(null);
		riceTextureFX.setValue(null);
		riceColorFX.setValue(null);
		fruitQualityFX.setValue(null);
		fruitFlavorFX.setValue(null);
		fruitSizeFX.setValue(null);
		vegetableQualityFX.setValue(null);
		vegetableSizeFX.setValue(null);
		fishTypeFX.setValue(null);
		fishSourceFX.setValue(null);
		fishSizeFX.setValue(null);
		
		String productType = productTypeFX.getValue();
		
		if(productType.equals("Livestock")) {
			livestockTypeFX.setDisable(false);
			livestockFeedDietFX.setDisable(false);
			livestockAgeFX.setDisable(false);
		}else if(productType.equals("Rice")) {
			riceQualityFX.setDisable(false);
			riceTextureFX.setDisable(false);
			riceColorFX.setDisable(false);
		}else if(productType.equals("Fruit")) {
			fruitQualityFX.setDisable(false);
			fruitFlavorFX.setDisable(false);
			fruitSizeFX.setDisable(false);
		}else if(productType.equals("Vegetable")) {
			vegetableQualityFX.setDisable(false);
			vegetableSizeFX.setDisable(false);
		}else if(productType.equals("Fish")) {
			fishTypeFX.setDisable(false);
			fishSourceFX.setDisable(false);
			fishSizeFX.setDisable(false);
		}
    }
    
    public void uploadProduct(ActionEvent event) {
    	
    	String productName = productNameFX.getText();
		String productDescription = productDescriptionFX.getText();
		String productLocation = productLocationFX.getText();
		Float productWeight = Float.parseFloat(productWeightFX.getText());
		Float productPrice = Float.parseFloat(productPriceFX.getText());
		String productType = productTypeFX.getValue();

		System.out.println(productName);
		System.out.println(productDescription);
		System.out.println(productLocation);
		System.out.println(productWeight);
		System.out.println(productPrice);
		System.out.println(productType);
		System.out.println(selectedFile);
		
		

		
//		boolean isVerified = true;
//		
//		if(firstName.isEmpty()) {
//			firstNameFX.setStyle("-fx-border-color: red;");
//			isVerified = false;
//		}else {
//			firstNameFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
//		}
    }
    
    
    

    
}
