package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

public class UserShopListController extends UniversalController implements Initializable {
	
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

//	@FXML
//	private VBox resultsContainer;
//
//	@FXML
//	private void handleSearch() {
//	    resultsContainer.getChildren().clear();
//
//	    
//	    String query = searchField.getText().trim();
//	    String category = categoryBox.getValue();
//	    float minPrice = parsePrice(minPriceField.getText(), 0);
//	    float maxPrice = parsePrice(maxPriceField.getText(), Double.MAX_VALUE);
//
//	    
//	    List<ProductData> products = fetchSearchResults(query, category, minPrice, maxPrice);
//
//
//	    for (ProductData product : products) {
//	        HBox productRow = new HBox(10);
//	        Label nameLabel = new Label(product.getProdName());
//	        Label priceLabel = new Label("$" + product.getPrice());
//
//	        productRow.getChildren().addAll(nameLabel, priceLabel);
//	        resultsContainer.getChildren().add(productRow);
//	    }
//	}
}
