package com.myspring.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

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
	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String input(Locale locale, Model model) {

		return "input";
	}
	
	@RequestMapping(value = "/create_table", method = RequestMethod.GET)
	public String createTable(Locale locale, Model model) {
		DBCommon<Student> dbCommon = new DBCommon<Student>("c:\\tomcat\\finalExam.sqlite", "finalExam");
		dbCommon.createTable(new Student());
		return "done";
	}
	
	@RequestMapping(value = "/do_insert", method = RequestMethod.GET)
	public String doinsert(@RequestParam("name") String name, @RequestParam("middleScore") int middleScore, @RequestParam("finalScore") int finalScore) {
		Student student = new Student(name, middleScore,finalScore);
		Insert insertData = new Insert();
		insertData.InserMethod(student);
		return "done";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(Locale locale, Model model, @RequestParam("idx") int idx) {
		DBCommon<Student> dbCommon = new DBCommon<Student>("C:\\tomcat\\finalExam.sqlite","finalExam");
		model.addAllAttributes(dbCommon.detailsData(new Student(), idx));
		return "update";
	}
	
	@RequestMapping(value = "/do_update", method = RequestMethod.GET)
	public String doUpdate(@RequestParam("idx") int idx ,@RequestParam("name") String name,@RequestParam("middleScore") int middleScore, @RequestParam("finalScore") int finalScore) {
		DBCommon<Student> dbCommon = new DBCommon<Student>("C:\\tomcat\\finalExam.sqlite","finalExam");
		dbCommon.updateData(new Student(name, middleScore, finalScore), idx);
		return "done";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String list(Locale locale, Model model) {
		DBCommon<Student> dbCommon = new DBCommon<Student>("C:\\tomcat\\finalExam.sqlite","finalExam");
		model.addAttribute("select_result", dbCommon.selectDataTableTag(new Student()));
		return "list";
	}
	
	@RequestMapping(value = "/do_search", method = RequestMethod.GET)
	public String doSearch(Locale locale, Model model,@RequestParam("name") String name) {
		DBCommon<Student> dbCommon = new DBCommon<Student>("C:\\tomcat\\finalExam.sqlite","finalExam");
		model.addAttribute("select_result", dbCommon.searchDataTableTag(new Student(), "name", name));
		System.out.println(name);
		return "list";
	}
	
	
}
