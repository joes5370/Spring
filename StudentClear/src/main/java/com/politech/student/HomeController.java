package com.politech.student;

import java.util.ArrayList;
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
		DBCommon<People> dbCommon = new DBCommon<People>("c:\\tomcat\\people.sqlite", "people");
//		ArrayList<People> studentList = dbCommon.selectArrayList(new People());
		model.addAttribute("select_result", dbCommon.selectDataTableTag(new People()));
		return "list";
	}
	@RequestMapping(value = "/create_table", method = RequestMethod.GET)
	public String createTable(Locale locale, Model model) {
		DBCommon<People> dbCommon = new DBCommon<People>("c:\\tomcat\\people.sqlite", "people");
		dbCommon.createTable(new People());
		return "done";
	}
	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String input(Locale locale, Model model) {
		return "input";
	}
	@RequestMapping(value = "/input_data", method = RequestMethod.GET)
	public String inputData(@RequestParam("name") String name, @RequestParam("favoriteColor") String favoriteColor) {
		DBCommon<People> dbCommon = new DBCommon<People>("c:\\tomcat\\people.sqlite", "people");
		dbCommon.insertData(new People(name, favoriteColor));
		return "done";
	}
}
