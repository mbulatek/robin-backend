package com.robin.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLAccess {
	private static final Logger LOGGER = Logger.getLogger( MySQLAccess.class.getName() );
	
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	
	public MySQLAccess() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/robin?" + "user=robin&password=robin");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateResult(TopItem result) {
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from robin.all_players where mail='" + result.getPlayerMail() + "'");
			
			while (resultSet.next()) {
				int userID = resultSet.getInt("id");			
	            String userName = resultSet.getString("name");
	            String userMail = resultSet.getString("mail");
	            String levelReached = resultSet.getString("level");
	            String lastHash = resultSet.getString("last_hash");
	            
	            LOGGER.log(Level.INFO, "User ID: " + userID);
	            LOGGER.log(Level.INFO, "User name: " + userName);
	            LOGGER.log(Level.INFO, "User mail: " + userMail);
	            LOGGER.log(Level.INFO, "Level: " + levelReached);
	            LOGGER.log(Level.INFO, "Hash: " + lastHash);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
