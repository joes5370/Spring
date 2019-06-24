package com.myspring.myapp;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		DBCommon<Person> dbCommon = new DBCommon<Person>("C:\\tomcat\\student190527.sqlite","studentdata");
		model.addAttribute("select_result", dbCommon.selectDataTableTag(new Person()));
		return "list";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modify(Locale locale, Model model, @RequestParam("idx") int idx) {
		DBCommon<Person> dbCommon = new DBCommon<Person>("C:\\tomcat\\student190527.sqlite","studentdata");
		model.addAllAttributes(dbCommon.detailsData(new Person(), idx));
		return "modify";
	}
	
	@RequestMapping(value = "/update_data", method = RequestMethod.GET)
	public String updateData(@RequestParam("idx") int idx ,@RequestParam("name") String name,@RequestParam("ID") String ID, @RequestParam("passwd") String passwd, @RequestParam("address") String address, @RequestParam("birthday") String birthday, @RequestParam("favoriteColor") String favoriteColor) {
		DBCommon<Person> dbCommon = new DBCommon<Person>("C:\\tomcat\\student190527.sqlite","studentdata");
		
		//비밀번호 해쉬하기
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
		    md.update(passwd.getBytes());
		    StringBuilder sb = new StringBuilder();
		    for(byte b : md.digest()) {
		        sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
		    }
		    passwd = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}


		dbCommon.updateData(new Person(name, favoriteColor, address, birthday, ID, passwd), idx);
		return "done";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Locale locale, Model model,@RequestParam("idx") int idx) {
		DBCommon<Person> dbCommon = new DBCommon<Person>("c:\\tomcat\\student190527.sqlite", "studentdata");
		dbCommon.deleteData(new Person(), idx);
		return "done";	
}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		return "login";
	}
	
}
