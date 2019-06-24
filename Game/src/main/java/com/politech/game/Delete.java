package com.politech.game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;

import org.sqlite.SQLiteConfig;

public class Delete {
	public void method2(int idx) {
		try {
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/c:\\tomcat\\gameDB.sqlite", config.toProperties());
			
			String query = "DELETE FROM Player WHERE idx=" + idx + ";";
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate(query);
			statement.close();
			
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
