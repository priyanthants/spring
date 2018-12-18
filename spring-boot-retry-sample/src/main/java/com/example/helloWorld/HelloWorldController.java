package com.example.helloWorld;

import com.example.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class HelloWorldController {

	@Autowired
	private WelcomeService welcomeService;

	 @GetMapping("/v1/welcome")
	 public String welcome() throws SQLException {
	 	return welcomeService.welcome();
	    }

	@GetMapping("/v2/welcome")
	public String retryWelcome() throws SQLException {
		return welcomeService.retrySuccess();
	}
}
