package application.controller;

import javafx.scene.input.MouseEvent;
import application.controller.UserClass.Buyer;
import application.controller.UserClass.Seller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LoginController extends UniversalController{
	
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
				
				userType = getUserTypeDBS(userID);
				String[] userAccount = getUserAccountDBS(userID);
				String[] userDetail = getUserDetailDBS(userID);
				String[] userAddress = getUserAddressDBS(userID);
				
				if(userType.equals("Farmer") || userType.equals("Middle Man")) {
					userSeller = new Seller(userID, userAccount[0], userAccount[1], userAccount[2], userAccount[3], userDetail[0], userDetail[1], userDetail[2], Integer.parseInt(userDetail[3]), userDetail[4], userAddress[0], userAddress[1], userAddress[2], userAddress[3]);
				}else if(userType.equals("Buyer")) {
					userBuyer = new Buyer(userID, userAccount[0], userAccount[1], userAccount[2], userAccount[3], userDetail[0], userDetail[1], userDetail[2], Integer.parseInt(userDetail[3]), userDetail[4], userAddress[0], userAddress[1], userAddress[2], userAddress[3]);
					System.out.println(userBuyer.firstName);
				}
				
				try {
					changeToEditProfile(event);
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}else {
				loginPasswordFX.setStyle("-fx-border-color: red;");
				loginVerificationFX.setText("-fx-opacity: 1;");
				loginVerificationFX.setText("Incorrect Password");
			}
		}
	}
	
	public void clickedRegistration(ActionEvent event) throws Exception {
		changeToRegistration(event);
	}
	
	
}