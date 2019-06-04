package com.hyungsuk.spring;

import java.sql.SQLException;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		logger.info("Welcome home! The client locale is {}.", locale);
		return "home";
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String home1(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		return "main";
	}

	@RequestMapping(value = "/sign", method = RequestMethod.GET)
	public String home2(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		return "sign";
	}

	@RequestMapping(value = "/db", method = RequestMethod.GET)
	public String home3(Locale locale, Model model) {
		//이안에서 기능 파일 연결해준다.
		logger.info("Welcome home! The client locale is {}.", locale);
		DataReader dataReader = new DataReader("c:\\tomcat\\tomcat.sqlite", "students");
		dataReader.open();
		try {
			model.addAttribute("query_result", dataReader.selectData());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
		} finally {
			dataReader.close();
		}
		return "result";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home4(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		ScoreData scoreData = new ScoreData("c:\\tomcat\\tomcat.sqlite", "students");
		scoreData.open();
		try {
			model.addAttribute("query_result", scoreData.selectData());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
		} finally {
			scoreData.close();
		}
		return "scoreView";
	}
	
	@RequestMapping(value = "/score", method = RequestMethod.GET)
	public String home5(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		return "done";
	}

	
//	//포스트 방식사용
//	@RequestMapping(value = "/db", method = RequestMethod.POST)
//	public String home4(Locale locale, Model model) {
//		//이안에서 기능 파일 연결해준다.
//		logger.info("Welcome home! The client locale is {}.", locale);
//		DataReader dataReader = new DataReader("c:\\tomcat\\tomcat.sqlite", "students");
//		dataReader.open();
//		try {
//			model.addAttribute("query_result", dataReader.selectData());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//		} finally {
//			dataReader.close();
//		}
//		return "result";
//	}
}
