package com.firstwebapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "Welcome to home page!";
	}
	
	@GetMapping("/about")
	public String about() {
		return "Inside about Page!";
	}

}
