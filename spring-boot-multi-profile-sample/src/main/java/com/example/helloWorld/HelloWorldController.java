package com.example.helloWorld;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Value("${welcome.message}")
	private String message;

	 @GetMapping("/welcome")
	 public String welcome() {
	 	return message;
	    }
}
