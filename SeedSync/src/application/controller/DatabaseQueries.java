package application.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseQueries {
	private DatabaseConnection connectNow = new DatabaseConnection();
	private Connection connectDatabase = connectNow.getConnection();
	
	private String query;
	
	private String userID;
	
	public int getAccountCount(String accountType) {
		int count = 0;
		
		query = "SELECT COUNT(user_id) AS count "
		+ "FROM users_account "
				+ "WHERE account_type = ?";
		
		try {
			PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
			
			preparedStatement.setString(1, accountType);
			
			ResultSet result = preparedStatement.executeQuery();
			
			if(result.next()) {
				count = result.getInt("count");
			}else {
				System.out.println("No account Found");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return count;
	}
	
	public String generateUserID(String accountType) {
		int userNumber = getAccountCount(accountType) + 1;
		String userID = "";
		
		if(accountType.equals ("Farmer"))
			userID = String.format("FA%03d", userNumber);
		else if(accountType.equals("Buyer"))
			userID = String.format("BY%03d", userNumber);
		else if (accountType.equals ("Middle Man"))
			userID = String.format("MM%03d", userNumber);
		return userID;
	}
	
	public void registerAccountDBS(String email, String username, String password, String accountType) {
		if (checkDuplicateAccountsDBS(email, username)) {
			System.out.println("Account with the given email or username already exists.");
			return;
		}
	
		userID = generateUserID(accountType);
	
		query = "INSERT INTO users_account(user_id, email, username, password, account_type) VALUES (?, ?, ?, ?, ?)";
	
		try {
			PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
			preparedStatement.setString(1, userID);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, username);
			preparedStatement.setString(4, password);
			preparedStatement.setString(5, accountType);
			preparedStatement.executeUpdate();
	
			System.out.println("Account registered successfully.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void registerAccountDetailDBS(String firstName, String lastName, String birthdate, int age, String phoneNumber) {
		query = "INSERT INTO users_detail(firstname, lastname, birthdate, age, phone_number, user_id) "
		+ "VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
			
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, birthdate);
			preparedStatement.setInt(4, age);
			preparedStatement.setString(5, phoneNumber);
			preparedStatement.setString(6, userID);
			
			preparedStatement.executeUpdate();			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void registerAccountAddressDBS(String region, String province, String city, String address) {
		query = "INSERT INTO users_address(region, province, city, address, user_id) "
		+ "VALUES (?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
			
			preparedStatement.setString(1, region);
			preparedStatement.setString(2, province);
			preparedStatement.setString(3, city);
			preparedStatement.setString(5, userID);
			
			preparedStatement.executeUpdate();			
			
			System.out.println("GOod");
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public boolean checkDuplicateAccountsDBS(String email, String username) {
		query = "SELECT COUNT(*) FROM users_account WHERE email = ? OR username = ?";
	
		try {
			PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, username);
			ResultSet resultSet = preparedStatement.executeQuery();
	
			if (resultSet.next() && resultSet.getInt(1) > 0) {
				System.out.println("Duplicate account detected.");
				return true; 
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	
		return false; 
	}
	
	public void addItemDBS(String pictureURL, String name, String location, float weight, float price, String user_id ) {
		query = "INSERT INTO products(pictureURL, name, location, weight, price, user_id)"
		+ "VALUES(?, ?, ?, ?, ?, ?)";
	
		try {
			PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
			
			preparedStatement.setString(1, pictureURL);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, location);
			preparedStatement.setFloat(4, weight);
			preparedStatement.setFloat(5, price);
			preparedStatement.setString(6, user_id);
			
			preparedStatement.executeUpdate();			
			
			System.out.println("Good");
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public void addItemLivestockDBS(String type, int age, String feed_diet, int product_count) {
		query = "INSERT INTO livestock(type, age, feed_diet, product_count)"
		+ "VALUES(?, ?, ?, ?)";
		
		try {
			PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
			
			preparedStatement.setString(1, type);
			preparedStatement.setInt(2, age);
			preparedStatement.setString(3, feed_diet);
			preparedStatement.setInt(4, product_count);
				
			preparedStatement.executeUpdate();			
				
			System.out.println("GOod");
				
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void addItemRiceDBS(String quality, String texture, String color, int product_count) {
		query = "INSERT INTO rice(quality, texture, color, product_count)"
		+ "VALUES(?, ?, ?, ?)";
		
		try {
			PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
			
			preparedStatement.setString(1, quality);
			preparedStatement.setString(2, texture);
			preparedStatement.setString(3, color);
			preparedStatement.setInt(4, product_count);
			
			preparedStatement.executeUpdate();			
				
			System.out.println("GOod");
				
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	

	
	

}
	
