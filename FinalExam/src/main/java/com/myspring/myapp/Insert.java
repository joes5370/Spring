package com.myspring.myapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

import org.sqlite.SQLiteConfig;

public class Insert {
	public String dbFileName;
	public String dbTableName;
	public Connection connection;
	
	public void InserMethod(Student student) {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (Exception e) {
			e.printStackTrace();
		}
		SQLiteConfig config = new SQLiteConfig();
		try {
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/c:\\tomcat\\finalExam.sqlite", config.toProperties());
			
			String query = "INSERT INTO finalExam(name, middleScore, finalScore) VALUES('" + student.name + "'," + student.middleScore + "," + student.finalScore + ");";
			System.out.println(query);
			
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate(query);
			statement.close();
			connection.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
}
	
	
}
