package com.myspring.myapp;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.sqlite.SQLiteConfig;

public class DBCommon<T> {
	private String dbFileName;
	private String tableName;
	private Connection connection;
	public DBCommon(String dbFileName, String tableNaem) {
		this.dbFileName = dbFileName;
		this.tableName = tableName;
	}
	
	//데이터 베이스 open과 close를 꼭 해야한다. 할때 이런 식으로 하자!!!!!!!!
	private void open() {
		try {
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			connection = DriverManager.getConnection("jdbc:sqlite:/"+this.dbFileName, config.toProperties());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void close() {
		if (this.connection != null) {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		this.connection = null;
	}
	
	
	public void InsertData(T t){

		try {
			Class<?> dataClass = t.getClass();
//			dataClass =Class.forName("com.myspring.myapp");
			
			Field[] dataClassFields = dataClass.getDeclaredFields();
			
			String query = "";
			for (Field field : dataClassFields) {
				if (!query.isEmpty()) {
					query = query +",";
				}
				String fieldType = field.getType().toString();
				String fieldName = field.getName();
				
				if (fieldName.matches("idx") && fieldType.matches("int")) {
					query = query + fieldName + "INTEGER PRIMARY KEY AUTOINCREMENT";
				}else if (fieldType.matches("int")) {
					query = query + fieldName + "INTEGER";
				}else if (fieldType.matches("(double|float)")) {
					query = query + fieldName + "REAL";
				}else if (fieldType.matches(".*String")) {
					query = query + fieldName + "TEXT";
				}
			}
			
			if(this.connection == null) {
				this.open();
			}
			
			query = "CREATE TABLE"+ this.tableName + "("+query + ");";
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate(query);
			statement.close();
				
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public void createTable(T t) {
		try {
			Class<?> dataClass = t.getClass();
//			dataClass =Class.forName("com.myspring.myapp");
			
			Field[] dataClassFields = dataClass.getDeclaredFields();
			
			String query = "";
			for (Field field : dataClassFields) {
				if (!query.isEmpty()) {
					query = query +",";
				}
				String fieldType = field.getType().toString();
				String fieldName = field.getName();
				
				if (fieldName.matches("idx") && fieldType.matches("int")) {
					query = query + fieldName + "INTEGER PRIMARY KEY AUTOINCREMENT";
				}else if (fieldType.matches("int")) {
					query = query + fieldName + "INTEGER";
				}else if (fieldType.matches("(double|float)")) {
					query = query + fieldName + "REAL";
				}else if (fieldType.matches(".*String")) {
					query = query + fieldName + "TEXT";
				}
			}
			
			if(this.connection == null) {
				this.open();
			}
			
			query = "CREATE TABLE"+ this.tableName + "("+query + ");";
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate(query);
			statement.close();
				
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
