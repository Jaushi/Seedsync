package application.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueries {
	
	private DatabaseConnection connectNow = new DatabaseConnection();
	private Connection connectDatabase = connectNow.getConnection();
	
	private String query;
	
	private String userID;
	
	public String getUserID() {
		return userID;
	}
	
	public int getAccountCountDBS(String accountType) {
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
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return count;
	}
	
	public String generateUserIdDBS(String accountType) {
		int userNumber = getAccountCountDBS(accountType) + 1;
		String userID = "";
		
		if(accountType.equals ("Farmer"))
			userID = String.format("FA%03d", userNumber);
		else if(accountType.equals("Buyer"))
			userID = String.format("BY%03d", userNumber);
		else if (accountType.equals ("Middle Man"))
			userID = String.format("MM%03d", userNumber);
		return userID;
	}
	
	public boolean checkDuplicatePhoneNumberDBS(String phoneNumber) {
			
		query = "SELECT user_id "
			+ "FROM users_detail "
			+ "WHERE phone_number = ?";
	
		try {	
			PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
			preparedStatement.setString(1, phoneNumber);
				
			ResultSet result = preparedStatement.executeQuery();
				
			if(result.next()) {
					return true;
			}
			
		}catch (Exception ex) {
			ex.printStackTrace();
		}
            return false;
        }
        
    public boolean checkDuplicateUsernameEmailDBS(String username, String email) {
		query = "SELECT user_id "
				+ "FROM users_account "
				+ "WHERE username = ? "
				+ "OR email = ?";
	
		try {
			PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, email);
	
			ResultSet result = preparedStatement.executeQuery();
	
			if (result.next()) {
				System.out.println("Username or email already exists.");
				return true;
			} else {
				System.out.println("Username and email are available.");
				return false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public void registerAccountDBS(String email, String username, String password, String accountType) {
	
		userID = generateUserIdDBS(accountType);
	
		query = "INSERT INTO users_account(user_id, email, username, password, account_type) "
				+ "VALUES (?, ?, ?, ?, ?)";
	
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
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return userID;
	}
	
	public boolean verifyPasswordDBS(String userID, String userPassword) {
		boolean verified = false;
		
		query = "SELECT password "
				+ "FROM users_account "
				+ "WHERE user_id = ? "
				+ "AND password = ?";
		try {
			PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
			
			preparedStatement.setString(1, userID);
			preparedStatement.setString(2, userPassword);
			
			ResultSet result = preparedStatement.executeQuery();
			
			if(result.next()) {
				verified = true;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return verified;
	}
	
	
    public boolean addItemDBS(String pictureURL, String name, String location, float weight, float price, String user_id ) {
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
            return true;
        }catch(Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean addItemLivestockDBS(String type, int age, String feed_diet, int product_count) {
        query = "INSERT INTO livestock(type, age, feed_diet, product_count)"
        + "VALUES(?, ?, ?, ?)";
        
        try {
            PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
            
            preparedStatement.setString(1, type);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, feed_diet);
            preparedStatement.setInt(4, product_count);
                
            preparedStatement.executeUpdate();            
            return true;
        }catch(Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean addItemRiceDBS(String quality, String texture, String color, int product_count) {
        query = "INSERT INTO rice(quality, texture, color, product_count)"
        + "VALUES(?, ?, ?, ?)";
        
        try {
            PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
            
            preparedStatement.setString(1, quality);
            preparedStatement.setString(2, texture);
            preparedStatement.setString(3, color);
            preparedStatement.setInt(4, product_count);
            
            preparedStatement.executeUpdate();            
            return true;
        }catch(Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean addItemFruitDBS(String quality, String flavor, String size, int product_count) {
        query = "INSERT INTO fruit(quality, flavor, size, product_count)"
                + "VALUES(?, ?, ?, ?)";
        
        try {
            PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
            
            preparedStatement.setString(1, quality);
            preparedStatement.setString(2, flavor);
            preparedStatement.setString(3, size);
            preparedStatement.setInt(4, product_count);
                
            preparedStatement.executeUpdate();            
            return true;
        }catch(Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean addItemVegetableDBS(String quality, String size, int product_count) {
        query = "INSERT INTO vegetable(quality, size, product_count)"
                + "VALUES(?, ?, ?)";
        
        try {
            PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
            
            preparedStatement.setString(1, quality);
            preparedStatement.setString(2, size);
            preparedStatement.setInt(3, product_count);
                
            preparedStatement.executeUpdate();            
            return true;
        }catch(Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean addItemFishDBS(String type, String source, String size, int product_count) {
        query = "INSERT INTO fish(type, source, size, product_count)"
                + "VALUES(?, ?, ?, ?)";
        
        try {
            PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
            
            preparedStatement.setString(1, type);
            preparedStatement.setString(2, source);
            preparedStatement.setString(3, size);
            preparedStatement.setInt(4, product_count);
                
            preparedStatement.executeUpdate();            
            return true;
        }catch(Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    
    public boolean checkDuplicateDBS(String email, String username, String phone_number) {
        String query = "SELECT COUNT(*) FROM users WHERE email = ? AND username = ? AND phone_number = ?";
    
        try {
            PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, phone_number);
            ResultSet resultSet = preparedStatement.executeQuery();
    
            if (resultSet.next() && resultSet.getInt(1) > 0) {
                return true; 
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    
        return false;
    } 
    
    public String getUserTypeDBS(String userID) {
    	String userType = "";
    	query = "SELECT account_type "
        		+ "FROM users_account "
        		+ "WHERE user_id = ?";
    
        try {
            PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
            preparedStatement.setString(1, userID);
    
            ResultSet result = preparedStatement.executeQuery();
    
            if (result.next()) {
                userType = result.getString("account_type");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return userType;
    }

    public String[] getUserAccountDBS(String userID) {	
    	String[] userAccount = new String[4];
        query = "SELECT email, username, password, account_type "
        		+ "FROM users_account "
        		+ "WHERE user_id = ?";
    
        try {
            PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
            preparedStatement.setString(1, userID);
    
            ResultSet result = preparedStatement.executeQuery();
    
            if (result.next()) {
            	userAccount[0] = result.getString("email");
            	userAccount[1] = result.getString("username");
            	userAccount[2] = result.getString("password");
            	userAccount[3] = result.getString("account_type");
            	
                return userAccount;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public String[] getUserDetailDBS(String userID) {	
    	String[] userDetail = new String[5];
        query = "SELECT firstname, lastname, birthdate, age, phone_number "
        		+ "FROM users_detail "
        		+ "WHERE user_id = ?";
    
        try {
            PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
            preparedStatement.setString(1, userID);
    
            ResultSet result = preparedStatement.executeQuery();
    
            if (result.next()) {
            	userDetail[0] = result.getString("firstname");
            	userDetail[1] = result.getString("lastname");
            	userDetail[2] = result.getString("birthdate");
            	userDetail[3] = String.valueOf(result.getInt("age"));
            	userDetail[4] = result.getString("phone_number");
            	
                return userDetail;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public String[] getUserAddressDBS(String userID) {	
    	String[] userAddress = new String[4];
        query = "SELECT region, province, city, address "
        		+ "FROM users_address "
        		+ "WHERE user_id = ?";
    
        try {
            PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
            preparedStatement.setString(1, userID);
    
            ResultSet result = preparedStatement.executeQuery();
    
            if (result.next()) {
            	userAddress[0] = result.getString("region");
            	userAddress[1] = result.getString("province");
            	userAddress[2] = result.getString("city");
            	userAddress[3] = result.getString("address");
            	
                return userAddress;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    
    
    public List<Product> getItemsDBS() {
        List<Product> items = new ArrayList<>();
        query = "SELECT pictureURL, name, location, weight, price, user_id FROM products";
    
        try {
            PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
    
            while (resultSet.next()) {
                String pictureURL = resultSet.getString("pictureURL");
                String name = resultSet.getString("name");
                String location = resultSet.getString("location");
                float weight = resultSet.getFloat("weight");
                float price = resultSet.getFloat("price");
                String user_id = resultSet.getString("user_id");
    
                items.add(new Product(pictureURL, name, location, weight, price, user_id));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return items;
    }
    
    public List<Product> getMatchItemDBS(String criteria, String value) {
        List<Product> matchedItems = new ArrayList<>();
        query = "SELECT * FROM products WHERE " + criteria + " = ?";
    
        try {
            PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
            preparedStatement.setString(1, value);
            ResultSet resultSet = preparedStatement.executeQuery();
    
            while (resultSet.next()) {
                String pictureURL = resultSet.getString("pictureURL");
                String name = resultSet.getString("name");
                String location = resultSet.getString("location");
                float weight = resultSet.getFloat("weight");
                float price = resultSet.getFloat("price");
                String user_id = resultSet.getString("user_id");
    
                matchedItems.add(new Product(pictureURL, name, location, weight, price, user_id));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return matchedItems;
    }

    public boolean removeItemDBS(int itemID) {
        query = "DELETE FROM products WHERE item_id = ?";
    
        try {
            PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
            preparedStatement.setInt(1, itemID);
    
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

        public List<Product> sortProductsByPriceAscDBS() {
            List<Product> sortedProducts = new ArrayList<>();
            query = "SELECT * FROM products ORDER BY price ASC";
            
            try {
                PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
                
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    float price = resultSet.getFloat("price");
                    sortedProducts.add(new Product(name, price));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
            return sortedProducts;
        }
        
        public List<Product> sortProductsByPriceDescDBS() {
            List<Product> sortedProducts = new ArrayList<>();
            query = "SELECT * FROM products ORDER BY price DESC";
            
            try {
                PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
                
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    float price = resultSet.getFloat("price");
                    sortedProducts.add(new Product(name, price));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
            return sortedProducts;
        }

        public List<Product> sortProductsByPopularityRatingDBS() {
            List<Product> sortedProducts = new ArrayList<>();
            query = "SELECT * FROM products ORDER BY popularity_rating DESC"; 
            
            try {
                PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
                
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    float price = resultSet.getFloat("price");

                    sortedProducts.add(new Product(name, price));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
            return sortedProducts;
        }

        public List<Product> sortProductsByAttributesDBS(String attribute) {
            List<Product> sortedProducts = new ArrayList<>();
            query = "SELECT * FROM products ORDER BY " + attribute + " ASC"; 
            
            try {
                PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
                
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    float price = resultSet.getFloat("price");

                    sortedProducts.add(new Product(name, price));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
            return sortedProducts;
        }

        public List<Product> sortProductsByDateAddedDBS() {
            List<Product> sortedProducts = new ArrayList<>();
            query = "SELECT * FROM products ORDER BY date_added DESC"; 
            
            try {
                PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
                
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    float price = resultSet.getFloat("price");

                    sortedProducts.add(new Product(name, price));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
            return sortedProducts;
        }
}