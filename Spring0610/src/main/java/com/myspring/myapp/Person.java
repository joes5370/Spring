package com.myspring.myapp;

public class Person {

		public int idx;
		public String name;
		public String favoriteColor;
		public String address;
		public String birthday;
		public String ID;
		public String passwd;
		
		Person() {
		}
		Person(String name, String favoriteColor, String address, String birthday, String ID, String passwd) {
			this.name = name;
			this.favoriteColor = favoriteColor;
			this.address = address;
			this.birthday = birthday;
			this.ID = ID;
			this.passwd = passwd;
		}
		public String toTableTagString() {
			String tagString = "";
			tagString = tagString + "<tr>";
			tagString = tagString + "<td>";
			tagString = tagString + this.idx;
			tagString = tagString + "</td>";
			tagString = tagString + "<td>";
			tagString = tagString + this.ID;
			tagString = tagString + "</td>";
			tagString = tagString + "<td>";
			tagString = tagString + this.name;
			tagString = tagString + "</td>";
			tagString = tagString + "<td>";
			tagString = tagString + this.address;
			tagString = tagString + "</td>";
			tagString = tagString + "<td>";
			tagString = tagString + this.birthday;
			tagString = tagString + "</td>";
			tagString = tagString + "<td>";
			tagString = tagString + this.favoriteColor;
			tagString = tagString + "</td>";
			tagString = tagString + "<td>";
			tagString = tagString + "<a href='modify?idx="+this.idx+"'>수정하기</a>";
			tagString = tagString + "</td>";
			tagString = tagString + "<td>";
			tagString = tagString + "<a href='delete?idx="+this.idx+"'>삭제하기</a>";
			tagString = tagString + "</td>";
			tagString = tagString + "</tr>";
			return tagString;
		}
	}


