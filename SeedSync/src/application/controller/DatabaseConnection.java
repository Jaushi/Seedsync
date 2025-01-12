package application.controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	private Connection databaseLink;
	
	public Connection getConnection() 
	{
		String databaseName = new String("seedsync");
		String databaseUser = new String("root");
		String databasePassword = new String("SeedSync");
		String url = new String("jdbc:mysql://localhost:3306/" + databaseName);
		
		try 
		{
			//Register Database Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Establish Connection
			databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return databaseLink;
	}
}
