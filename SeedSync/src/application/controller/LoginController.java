package application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController extends DatabaseQueries{
	
	@FXML
	private TextField loginUsernameEmailFX;
	@FXML
	private PasswordField loginPasswordFX;
	@FXML
	private Label loginVerificationFX;
	
	public void loginAccount(ActionEvent event) {
		String loginUsernameEmail = loginUsernameEmailFX.getText();
		String loginPassword = loginPasswordFX.getText();
		String userID = searchAccountDBS(loginUsernameEmail);
		
		if(userID.isEmpty()) {
			loginUsernameEmailFX.setStyle("-fx-border-color: red;");
			loginVerificationFX.setStyle("-fx-opacity: 1;");
			loginVerificationFX.setText("Account not found");
		}else {
			boolean verifyPassword = verifyPasswordDBS(userID, loginPassword);
			loginUsernameEmailFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
			if(verifyPassword) {	
				loginPasswordFX.setStyle("-fx-border-color: -fx-dark-primary-color;");
				loginVerificationFX.setStyle("-fx-opacity: 1; -fx-text-fill: -fx-light-primary-color");
				loginVerificationFX.setText("Login Sucessful!");
			}else {
				loginPasswordFX.setStyle("-fx-border-color: red;");
				loginVerificationFX.setText("-fx-opacity: 1;");
				loginVerificationFX.setText("Incorrect Password");
			}
		}
	}
	
	
}
