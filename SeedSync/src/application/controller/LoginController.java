package application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController extends DatabaseQueries{
	
	@FXML
	private TextField loginUsernameEmailFX;
	@FXML
	private PasswordField loginPasswordFX;
	
	public void loginAccount(ActionEvent event) {
		String loginUsernameEmail = loginUsernameEmailFX.getText();
		
		String userID = searchAccountDBS(loginUsernameEmail);
		
		if(userID.isEmpty()) {
			//no account found
		}else {
			System.out.println(userID);
		}
	}
	
	
}
