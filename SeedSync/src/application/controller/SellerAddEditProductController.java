package application.controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SellerAddEditProductController extends UniversalController implements Initializable{
	
	Stage stage;
	File selectedFile;
	
    @FXML
    private ComboBox<String> fishSourceFX, fishTypeFX, fruitFlavorFX, fruitQualityFX, fruitSizeFX, livestockDietFX, livestockTypeFX, productCategoryFX, productStatusFX, riceColorFX, riceQualityFX, riceTextureFX, vegetableQualityFX, vegetableSizeFX;
    @FXML
    private DatePicker productConsumeBeforeFX, productDateHarvestedFX, productDeliveryDateFX;
    @FXML
    private TextArea productDescriptionFX;
    @FXML
    private TextField productNameFX, productPriceFX, productShippingFeeFX, productLocationFX, productStockFX, productWeightFX;
    @FXML
    private ImageView productImageFX;
    
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
		Image img = new Image(selectedFile.toURI().toString());
		productImageFX.setImage(img);
		System.out.println(selectedFile.toURI().toString());
	}
	
	public void enableProduct(ActionEvent event) {
    	System.out.println("Test");
    	livestockTypeFX.setDisable(true);
		livestockDietFX.setDisable(true);
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

		livestockTypeFX.setValue(null);
		livestockDietFX.setValue(null);
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
		
		String productType = productCategoryFX.getValue();
		
		if(productType.equals("Livestock")) {
			livestockTypeFX.setDisable(false);
			livestockDietFX.setDisable(false);
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
		}
    }
	
	public void addProduct(ActionEvent event) {
		boolean isVerified = true;
		
		String productName = productNameFX.getText();
		Float productPrice = Float.parseFloat(productPriceFX.getText());
		Float productShippingFee = Float.parseFloat(productShippingFeeFX.getText());
		String productDateHarvested = String.valueOf(productDateHarvestedFX.getValue());
		String productConsumeBefore = String.valueOf(productConsumeBeforeFX.getValue());
		Integer productStock = Integer.valueOf(productStockFX.getText());
		Float productWeight = Float.valueOf(productWeightFX.getText());
		String productDeliveryDate = String.valueOf(productDeliveryDateFX.getValue());
		String productLocation = productLocationFX.getText();
		String productCategory = productCategoryFX.getValue();
		String productStatus = productStatusFX.getValue();
		String productDescription = productDescriptionFX.getText();
		String livestockType = livestockTypeFX.getValue();
		String livestockDiet = livestockDietFX.getValue();
		String riceQuality = riceQualityFX.getValue();
		String riceTexture = riceTextureFX.getValue();
		String riceColor = riceColorFX.getValue();
		String fruitQuality = fruitQualityFX.getValue();
		String fruitFlavor = fruitFlavorFX.getValue();
		String fruitSize = fruitSizeFX.getValue();
		String vegetableQuality = vegetableQualityFX.getValue();
		String vegetableSize = vegetableSizeFX.getValue();
		String fishType = fishTypeFX.getValue();
		String fishSource = fishSourceFX.getValue();
		
		if(productName.isEmpty()) {
			productNameFX.setStyle("-fx-border-color: red;");
			isVerified = false;
		}else {
			productNameFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
		}
		
		if(productPrice == null) {
			productPriceFX.setStyle("-fx-border-color: red;");
			isVerified = false;
		} else {
			productPriceFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
		}
		
		if(productShippingFee == null) {
			productShippingFeeFX.setStyle("-fx-border-color: red;");
			isVerified = false;
		} else {
			productShippingFeeFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
		}
		
		if(productDateHarvested.isEmpty()) {
			productDateHarvestedFX.setStyle("-fx-border-color: red;");
			isVerified = false;
		} else {
			productDateHarvestedFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
		}
		
		if(productConsumeBefore.isEmpty()) {
			productConsumeBeforeFX.setStyle("-fx-border-color: red;");
			isVerified = false;
		} else {
			productConsumeBeforeFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
		}
		
		if(productStock == null) {
			productStockFX.setStyle("-fx-border-color: red;");
			isVerified = false;
		} else {
			productStockFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
		}
		
		if(productWeight == null) {
			productWeightFX.setStyle("-fx-border-color: red;");
			isVerified = false;
		} else {
			productWeightFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
		}
		
		if(productDeliveryDate.isEmpty()) {
			productDeliveryDateFX.setStyle("-fx-border-color: red;");
			isVerified = false;
		} else {
			productDeliveryDateFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
		}
		
		if(productLocation.isEmpty()) {
			productLocationFX.setStyle("-fx-border-color: red;");
			isVerified = false;
		} else {
			productLocationFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
		}
		
		if(productCategory.isEmpty()) {
			productCategoryFX.setStyle("-fx-border-color: red;");
			isVerified = false;
		} else {
			productCategoryFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
		}
		
		if(productStatus.isEmpty()) {
			productStatusFX.setStyle("-fx-border-color: red;");
			isVerified = false;
		} else {
			productStatusFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
		}

		if(productDescription.isEmpty()) {
			productDescriptionFX.setStyle("-fx-border-color: red;");
			isVerified = false;
		} else {
			productDescriptionFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
		}
		
		if(productCategory.equals("Livestock")) {
			if(livestockType.isEmpty() || livestockDiet.isEmpty()) {
				livestockTypeFX.setStyle("-fx-border-color: red;");
				livestockDietFX.setStyle("-fx-border-color: red;");
				isVerified = false;	
			}else {
				livestockTypeFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
				livestockDietFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
			}
			
		}else if(productCategory.equals("Rice")) {
			if(riceQuality.isEmpty() || riceTexture.isEmpty() || riceColor.isEmpty()) {
				riceTextureFX.setStyle("-fx-border-color: red;");
				riceQualityFX.setStyle("-fx-border-color: red;");
				riceColorFX.setStyle("-fx-border-color: red;");
				
				isVerified = false;	
			}else {
				riceTextureFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
				riceQualityFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
				riceColorFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
			}
			
		}else if(productCategory.equals("Fruit")) {
			if(fruitQuality.isEmpty() || fruitFlavor.isEmpty()|| fruitSize.isEmpty()) {
				fruitQualityFX.setStyle("-fx-border-color: red;");
				fruitFlavorFX.setStyle("-fx-border-color: red;");
				fruitSizeFX.setStyle("-fx-border-color: red;");
				
				isVerified = false;	
			}else {
				fruitQualityFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
				fruitFlavorFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
				fruitSizeFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
			}
			
		}else if(productCategory.equals("Vegetable")) {
			
			if(vegetableQuality.isEmpty() || vegetableSize.isEmpty()) {
				vegetableQualityFX.setStyle("-fx-border-color: red;");
				vegetableSizeFX.setStyle("-fx-border-color: red;");
				isVerified = false;	
			}else {
				vegetableQualityFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
				vegetableSizeFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
			}
		
		}else if(productCategory.equals("Fish")) {
			if(fishType.isEmpty() || fishSource.isEmpty()) {
				fishTypeFX.setStyle("-fx-border-color: red;");
				fishSourceFX.setStyle("-fx-border-color: red;");
				isVerified = false;	
			}else {
				fishTypeFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
				fishSourceFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
			}
			
		}
		
		if(isVerified) {
			addProductDBS(productName, productDescription, productPrice, productShippingFee, productDateHarvested, productConsumeBefore, productStock, productWeight, productDeliveryDate, productLocation, productCategory, productStatus, userSeller.getUserID());
			addProductPicture(selectedFile);
			if(productCategory.equals("Livestock")) {
				addLivestockDBS(livestockType, livestockDiet);
			}else if(productCategory.equals("Rice")) {
				addRiceDBS(riceQuality, riceTexture, riceColor);
			}else if(productCategory.equals("Fruit")) {
				addFruitDBS(fruitQuality, fruitFlavor, fruitSize);
			}else if(productCategory.equals("Vegetable")) {
				addVegetableDBS(vegetableQuality, vegetableSize);
			}else if(productCategory.equals("Fish")) {
				addFishDBS(fishType, fishSource);
			}
			
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		fishSourceFX.getItems().addAll(fishSource);
		fishTypeFX.getItems().addAll(fishType);
		fruitFlavorFX.getItems().addAll(fruitFlavor);
		fruitQualityFX.getItems().addAll(quality);
		fruitSizeFX.getItems().addAll(size);
		livestockTypeFX.getItems().addAll(livestockType);
		livestockDietFX.getItems().addAll(livestockFeedDiet);
		riceQualityFX.getItems().addAll(quality);
		riceTextureFX.getItems().addAll(riceTexture);
		riceColorFX.getItems().addAll(riceColor);
		vegetableQualityFX.getItems().addAll(quality);
		vegetableSizeFX.getItems().addAll(size);
		
		productStatusFX.getItems().addAll(productStatus);
		productCategoryFX.getItems().addAll(productType);
	}
}
