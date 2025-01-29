package application.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class SellerHeaderController {

//    @FXML
//    private ImageView profileIcon;
//
//    @FXML
//    private void initialize() {
//        profileIcon.setOnMouseClicked(event -> openProfilePage());
//    }
//    
//    @FXML
//    private void handleProfileClick() {
//        System.out.println("Profile clicked!");
//    }

    private void openProfilePage() {
        try {
        	// Load UserProfile.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/fxml/UserProfile.fxml")); // Update with the correct path
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
