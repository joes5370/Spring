package com.politech.game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;

import org.sqlite.SQLiteConfig;

public class Update {
	public void method2(int idx) {
		try {
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/c:\\tomcat\\gameDB.sqlite", config.toProperties());
			
			
			Random rand = new Random();
			int attactPower = rand.nextInt(101);
			int attackRate = rand.nextInt(101);
			int defensePower = rand.nextInt(101);
			int defenseRate = rand.nextInt(101);
			
			String query = "UPDATE Player SET attackPower="+attactPower+", attackRate="+attackRate+",defensePower="+defensePower+",defenseRate="+defenseRate+" WHERE idx="+idx;
			
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate(query);
			statement.close();
			
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
