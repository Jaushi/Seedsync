package application.controller;

import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class FxmlLoader {
private Pane view;

public Pane getPage(String fileName) {
	try {
		URL fileUrl = getClass().getResource("/application/fxml/components/" + fileName + ".fxml");
		if(fileUrl == null) {
			throw new java.io.FileNotFoundException("FXML file not found");	
		}
		
		view = new FXMLLoader().load(fileUrl);
	}
	catch(Exception ex) {
		System.out.println("No page " + fileName + "Found");
	}
	
	return view;
}


}
