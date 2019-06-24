package com.myspring.myapp;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
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
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		DBCommon dbCommon = new DBCommon<Player>("c:\\tomcat\\gameDB.sqlite", "player");
		model.addAttribute("list", dbCommon.selectDataTableTag(new Player()));
		
		return "list";
	}
	
	@RequestMapping(value = "/do_battle", method = RequestMethod.GET)
	public String dobattle(Locale locale, Model model, HttpServletRequest request,@RequestParam("select1") String select1,@RequestParam("select2") String select2) {
		DBCommon dbCommon = new DBCommon<Player>("c:\\tomcat\\gameDB.sqlite", "player");
		
		model.addAllAttributes(dbCommon.detailsData(new Player(), Integer.parseInt(select1)));
		HashMap<String, String>info = dbCommon.detailsData(new Player(), Integer.parseInt(select2));
		HashMap<String, String>user = new HashMap<String, String>();
//		System.out.println(info);
		
		for(String key : info.keySet()) {
//			System.out.println(String.format("키 : %s, 값 : %s", key,info.get(key)));
			user.put("select2_"+key, info.get(key));
//			model.addAttribute("select2_idx",info.get(key));
		}
		model.addAllAttributes(user);
		
		HttpSession session = request.getSession();
		
		
//		System.out.println(user);
		
//		model.addAllAttributes(dbCommon.detailsData(new Player(), Integer.parseInt(select2)));
//		System.out.println("select1"+dbCommon.detailsData(new Player(), Integer.parseInt(select1)));
//		System.out.println("select2"+dbCommon.detailsData(new Player(), Integer.parseInt(select2)));

		return "battle";
	}
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(Locale locale, Model model) {
		return "join";
	}
	
	@RequestMapping(value = "/battle", method = RequestMethod.GET)
	public String battle(Locale locale, Model model) {
		return "battle";
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		return "sign_in";
	}
	
	@RequestMapping(value = "/do_login", method = RequestMethod.POST)
	public String dologin(Locale locale, Model model, HttpServletRequest request,@RequestParam("id") String id,@RequestParam("password") String password) {
		DBCommon dbCommon = new DBCommon<Player>("c:\\tomcat\\gameDB.sqlite", "player");
		dbCommon.signIn(id, password);
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
		    md.update(password.getBytes());
		    StringBuilder sb = new StringBuilder();
		    for(byte b : md.digest()) {
		        sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
		    }
		    password = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		int userIdx = dbCommon.signIn(id, password);
		if (userIdx > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("user_idx", userIdx);
			return "redirect:/";
		}
			return "redirect:/login";
	}

	@RequestMapping(value = "/my_account", method = RequestMethod.GET)
	public String myAccount(Locale locale, Model model,HttpServletRequest request) {
		DBCommon dbCommon = new DBCommon<Player>("c:\\tomcat\\gameDB.sqlite", "player");
		HttpSession session = request.getSession();
		if (session != null && session.getAttribute("user_idx") != null) {
			model.addAllAttributes(dbCommon.detailsData(new Player(), (Integer)session.getAttribute("user_idx")));
		}

		return "my_card";
	}
	
	@RequestMapping(value = "/do_join", method = RequestMethod.POST)
	public String doJoin(Locale locale, Model model,@RequestParam("id") String id,@RequestParam("password") String password,@RequestParam("name") String name) {
		DBCommon dbCommon = new DBCommon<Player>("c:\\tomcat\\gameDB.sqlite", "player");
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
		    md.update(password.getBytes());
		    StringBuilder sb = new StringBuilder();
		    for(byte b : md.digest()) {
		        sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
		    }
		    password = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		dbCommon.insertData(new Player(id, password, name));
		model.addAttribute("message","가입되었습니다.");
		return "done";
	}
	
	@RequestMapping(value = "/change_card", method = RequestMethod.GET)
	public String changeCard(Locale locale, Model model,HttpServletRequest request) {
		DBCommon dbCommon = new DBCommon<Player>("c:\\tomcat\\gameDB.sqlite", "player");
		HttpSession session = request.getSession();
		HashMap<String, String>userData = dbCommon.detailsData(new Player(), (Integer)session.getAttribute("user_idx"));
		//세션 null체크 하기
		int idx = Integer.parseInt(userData.get("idx"));
		String id = userData.get("id");
		String password = userData.get("password");
		String name = userData.get("name");
		dbCommon.updateData(new Player(id,password,name), idx);
		return "redirect:/my_account";
	}
	
}
