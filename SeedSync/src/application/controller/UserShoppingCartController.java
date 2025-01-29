package application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserShoppingCartController {
    @FXML
    private Button checkoutButton, continueShoppingButton;

    private List<Product> items = new ArrayList<>();
    private static final double BASE_DELIVERY_FEE = 50.0;

    public void addItem(String name, float price) {
        items.add(new Product(name, price));
    }

    public double computeSubtotal() {
        double subtotal = 0;
        for (Product item : items) {
            subtotal += item.getPrice();
        }
        return subtotal;
    }

    public double computeDeliveryFee() {
        return BASE_DELIVERY_FEE;
    }

    public double computeTotal() {
        double subtotal = computeSubtotal();
        double deliveryFee = computeDeliveryFee();
        double total = subtotal + deliveryFee;
        return total;
    }

    @FXML
    private void handleCheckout(ActionEvent event) {
        if (items.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Checkout Error");
            alert.setHeaderText("No items in cart");
            alert.setContentText("Please add items to your cart before checking out.");
            alert.showAndWait();
            return;
        }

        double total = computeTotal();

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Checkout");
        alert.setHeaderText("Checkout Successful!");
        alert.setContentText("Total: " + total);
        alert.showAndWait();

        items.clear();
    }

    @FXML
    private void handleContinueShopping(ActionEvent event) {
        try {
            Stage stage = (Stage) continueShoppingButton.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/path/to/homepage.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
