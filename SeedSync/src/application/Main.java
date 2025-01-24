package application;
	
import java.util.Arrays;

import application.controller.ProductClass.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("fxml/Registration.fxml"));
			
			Image logo = new Image(getClass().getResource("assets/images/logo.png").toExternalForm());
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("Application.css").toExternalForm());
			
			primaryStage.setResizable(false);
			primaryStage.getIcons().add(logo);
			primaryStage.setTitle("SeedSync");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Fish item1 = new Fish("Salmon", "Ocean", "Large", "http://example.com/salmon.jpg", "Wild Salmon", "Pacific Coast", 5.5f, 20.0f);
		
		String[] data = item1.getProduct();
		
		System.out.println(Arrays.toString(data));
		//launch(args);
	}
}
