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
	
	public void registerAccountDBS(String email, String username, String phone_number, String password, String accountType) {
		if (checkDuplicateAccountsDBS(email, username, phone_number)) {
			System.out.println("Account already exists. Please use different email, username, or phone number.");
		} else {
			System.out.println("No duplicates found. Proceeding with account creation.");
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
			preparedStatement.setString(4, address);
			preparedStatement.setString(5, userID);
			
			preparedStatement.executeUpdate();			
			
			System.out.println("GOod");
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public String searchAccountDBS(String loginUsernameEmail) {
		String userID = "";
		
		query = "SELECT user_id "
				+ "FROM users_account "
				+ "WHERE username = ? "
				+ "OR email = ?";
		
		try {
			PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
			
			preparedStatement.setString(1, loginUsernameEmail);
			preparedStatement.setString(2, loginUsernameEmail);
			
			ResultSet result = preparedStatement.executeQuery();
			
			if(result.next()) {
				userID = result.getString("user_id");
			}else {
				System.out.println("No account Found");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return userID;
	}
	
	public boolean checkDuplicateAccountsDBS(String email, String username, String phone_number) {
		query = "SELECT COUNT(*) FROM users_account WHERE email = ? OR username = ? OR phone_number = ?";
	
		try {
			PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, username);
			preparedStatement.setString(3, phone_number);
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

	public void getProfileAccountDBS(String user_id) {
		query = "SELECT ud.firstname, ud.lastname, ud.birthdate, ud.age, ud.phone_number, "
			+ "ua.region, ua.province, ua.city, ua.address "
			+ "FROM users_detail ud "
			+ "JOIN users_address ua ON ud.user_id = ua.user_id "
			+ "WHERE ud.user_id = ?";
	
		try {
			PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
			preparedStatement.setString(1, user_id);
	
			ResultSet resultSet = preparedStatement.executeQuery();
	
			if (resultSet.next()) {
				String firstname = resultSet.getString("firstname");
				String lastname = resultSet.getString("lastname");
				String birthdate = resultSet.getString("birthdate");
				int age = resultSet.getInt("age");
				String phoneNumber = resultSet.getString("phone_number");
				String region = resultSet.getString("region");
				String province = resultSet.getString("province");
				String city = resultSet.getString("city");
				String address = resultSet.getString("address");
	
				System.out.println("User Profile:");
				System.out.println("Name: " + firstname + " " + lastname);
				System.out.println("Birthdate: " + birthdate);
				System.out.println("Age: " + age);
				System.out.println("Phone Number: " + phoneNumber);
				System.out.println("Address: " + address + ", " + city + ", " + province + ", " + region);
			} else {
				System.out.println("No profile found for user_id: " + user_id);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void addItemDBS(String pictureURL, String name, String location, float weight, float price, String user_id ) {
		query = "INSERT INTO products(pictureURL, name, location, weight, price, user_id) "
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

	public void addItemFruitDBS(String quality, String flavor, String size, int product_count) {
	    query = "INSERT INTO fruit(quality, flavor, size, product_count)"
	            + "VALUES(?, ?, ?, ?)";
	    
	    try {
	        PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
	        
	        preparedStatement.setString(1, quality);
	        preparedStatement.setString(2, flavor);
	        preparedStatement.setString(3, size);
	        preparedStatement.setInt(4, product_count);
	            
	        preparedStatement.executeUpdate();			
	            
	        System.out.println("GOod");
	            
	    }catch(Exception ex) {
	        ex.printStackTrace();
	    }
	}

	public void addItemVegetableDBS(String quality, String size, int product_count) {
	    query = "INSERT INTO vegetable(quality, size, product_count)"
	            + "VALUES(?, ?, ?)";
	    
	    try {
	        PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
	        
	        preparedStatement.setString(1, quality);
	        preparedStatement.setString(2, size);
	        preparedStatement.setInt(3, product_count);
	            
	        preparedStatement.executeUpdate();			
	            
	        System.out.println("GOod");
	            
	    }catch(Exception ex) {
	        ex.printStackTrace();
	    }
	}

	public void addItemFishDBS(String type, String source, String size, int product_count) {
	    query = "INSERT INTO fish(type, source, size, product_count)"
	            + "VALUES(?, ?, ?, ?)";
	    
	    try {
	        PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
	        
	        preparedStatement.setString(1, type);
	        preparedStatement.setString(2, source);
	        preparedStatement.setString(3, size);
	        preparedStatement.setInt(4, product_count);
	            
	        preparedStatement.executeUpdate();			
	            
	        System.out.println("GOod");
	            
	    }catch(Exception ex) {
	        ex.printStackTrace();
	    }
	}
	
	public void getItemsDBS() {
		query = "SELECT pictureURL, name, location, weight, price, user_id FROM products";
	
		try {
			PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
	
			System.out.println("Items List:");
			while (resultSet.next()) {
				String pictureURL = resultSet.getString("pictureURL");
				String name = resultSet.getString("name");
				String location = resultSet.getString("location");
				float weight = resultSet.getFloat("weight");
				float price = resultSet.getFloat("price");
				String user_id = resultSet.getString("user_id");
	
				System.out.println("---------------------------------------");
				System.out.println("Name: " + name);
				System.out.println("Picture URL: " + pictureURL);
				System.out.println("Location: " + location);
				System.out.println("Weight: " + weight + " kg");
				System.out.println("Price: PHP " + price);
				System.out.println("Seller ID: " + user_id);
				System.out.println("---------------------------------------");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}