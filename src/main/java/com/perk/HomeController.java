package com.perk;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	private static final String PAGE_TITLE="title";
	
	@RequestMapping("/")
	public String getHomepage(Model m) {
		m.addAttribute(PAGE_TITLE, "Home");
		return "home";
	}

	@GetMapping("/signin")
	public String getLoginpage(Model m) {
		m.addAttribute(PAGE_TITLE, "Log In");
		return "login";
	}

}
