package com.politech.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.sqlite.SQLiteConfig;

public class SelectData {
	ArrayList<Student> students = new ArrayList<Student>();
	public void selectStudent() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (Exception e) {
			e.printStackTrace();
		}
		SQLiteConfig config = new SQLiteConfig();
		try {
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/c:\\tomcat\\student190527.sqlite", config.toProperties());
			String query = "SELECT * FROM student190527 WHERE ?;";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, 1);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
//				if(resultSet.getString("address").contains("서울") || resultSet.getString("address").contains("경기도")) {
//					this.students.add(new Student(resultSet.getInt("idx"), resultSet.getString("name"), resultSet.getString("address"), resultSet.getString("birthday")));
//				}
				this.students.add(new Student(resultSet.getInt("idx"), resultSet.getString("name"), resultSet.getString("address"), resultSet.getString("birthday")));

			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public String getHtmlString() {
		String htmlString = "";
		for (int i = 0; i < this.students.size(); i++) {
			htmlString = htmlString + "<tr>";
			htmlString = htmlString + "<td>";
			htmlString = htmlString + this.students.get(i).idx;
			htmlString = htmlString + "</td>";
			htmlString = htmlString + "<td>";
			htmlString = htmlString + this.students.get(i).name;
			htmlString = htmlString + "</td>";
			htmlString = htmlString + "<td>";
			htmlString = htmlString + this.students.get(i).address;
			htmlString = htmlString + "</td>";
			htmlString = htmlString + "<td>";
			htmlString = htmlString + this.students.get(i).birthday;
			htmlString = htmlString + "</td>";
			htmlString = htmlString + "</tr>";
		}

		return htmlString ;
	}
	public String addressNumber() {
		int seoulCount = 0;
		int GyunggiCount = 0;
		for(int i =0; i< this.students.size(); i++) {
			if(this.students.get(i).address.contains("서울")) {
				seoulCount++;
			}
			if(this.students.get(i).address.contains("경기")) {
				GyunggiCount++;
			}
		}
		return " 서울사는 사람은 : "+ seoulCount+" 경기사는 사람은 : "+ GyunggiCount;
	}
}
