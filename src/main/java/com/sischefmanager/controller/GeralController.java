package com.sischefmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeralController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}

}
