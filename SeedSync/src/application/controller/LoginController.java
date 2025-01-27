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
	
	private Label loginVerificationFX;
	
	public void loginAccount(ActionEvent event) {
		String loginUsernameEmail = loginUsernameEmailFX.getText();
		String loginPassword = loginPasswordFX.getText();
		String userID = searchAccountDBS(loginUsernameEmail);
		
		if(userID.isEmpty()) {
			loginUsernameEmailFX.setStyle("-fx-opacity: 1; -fx-text-fill: red");
			loginVerificationFX.setText("Account not found");
		}else {
			boolean verifyPassword = verifyPasswordDBS(userID, loginPassword);
			if(verifyPassword) {
				loginVerificationFX.setStyle("-fx-opacity: 1; -fx-text-fill: -fx-dark-primary-color");
				loginVerificationFX.setText("Login Sucessful!");
			}else {
				loginPasswordFX.setStyle("-fx-opacity: 1; -fx-text-fill: red");
				loginVerificationFX.setText("Incorrect Password");
			}
			System.out.println(userID);
		}
	}
	
	
}
