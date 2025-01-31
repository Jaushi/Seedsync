package application.controller;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SellerProductBarController extends UniversalController{
	
	 @FXML
	 private Label productCategoryFX, productPriceFX, productStatusFX, productStockFX, productNameFX;
	 @FXML
	 private ImageView productImageFX;
	 
	 
	 public void displayProduct(Products item) {
		 Image img = new Image(new File(item.getProductURL()).toURI().toString());
		 productImageFX.setImage(img);
		 productNameFX.setText(item.getName());
		 productCategoryFX.setText(item.getCategory());
		 productPriceFX.setText(String.valueOf(item.getPrice()));
		 productStatusFX.setText(item.getStatus());
		 productStockFX.setText(String.valueOf(item.getStock()));
	 }


}
